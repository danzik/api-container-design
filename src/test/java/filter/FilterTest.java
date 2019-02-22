package filter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import storage.http.FilterUtils;
import storage.http.Requests;
import storage.http.SessionContext;
import storage.http.SessionContextManager;
import storage.http.Token;
import storage.controller.UserController;
import storage.filter.Filter;
import storage.http.ContainerFilter;
import storage.http.HttpRequest;
import storage.http.HttpResponse;
import storage.http.HttpStatusCode;
import storage.http.container.HttpMethod;
import storage.http.container.HttpService;
import storage.http.container.filter.FilterChain;
import storage.model.LoginResponse;
import storage.model.User;
import storage.model.UserType;
import storage.service.LoginService;
import storage.service.UserService;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FilterTest {

    public final String SECURED_PATH = "/users/:email";

    @Mock
    public UserService userService;
    @Mock
    public LoginService loginService;
    @Mock
    public HttpRequest request;

    @Test
    public void authFilterTest() throws Exception {
        HttpService httpService = HttpService.getInstance();

        Filter<LoginResponse> loginFilter = (request, response) -> {
            String userName = request.getParam("userName");
            String password = request.getParam("password");
            if (!userName.isEmpty() && !password.isEmpty()) {
                LoginResponse loginResponse = loginService.login(userName, password);
                if (loginResponse.isSuccess()) {
                    response.setBody(loginResponse);
                    return;
                }
            }
            HttpService.finish(HttpStatusCode.UNAUTHORIZED, "You entered incorrect email or password");
        };

        httpService.filterBefore("/login", loginFilter);

        Map<String, String> params = new HashMap<>();
        params.put("userName", "user");
        params.put("password", "password");
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setSuccess(true);

        when(request.getParams()).thenReturn(params);
        when(request.getRequestURI()).thenReturn("/login");
        when(request.getHttpMethod()).thenReturn(HttpMethod.POST);
        when(loginService.login(anyString(), anyString())).thenReturn(loginResponse);

        ContainerFilter containerFilter = new ContainerFilter(httpService.getRequests());
        containerFilter.doFilter(request, new HttpResponse(), new FilterChain());
    }

    @Test
    @Disabled
    public void authorizationFilterTest() throws Exception {
        HttpService httpService = HttpService.getInstance();

        SessionContextManager sessionManager = SessionContextManager.getSessionManager();

        httpService.filterBefore((request, response) -> {
            SessionContext sessionContext = sessionManager.get(request.getRequestedSessionId());
            boolean isLoginUri = request.getUri().equals("/login");
            if (sessionContext == null && isLoginUri) {
                HttpService.finish(HttpStatusCode.FORBIDDEN, "Access is denied");
            }
        });

        Filter<Void> authFilter = (request, response) -> {
            String authorizationValue = request.getHeaders("Authorization");

            if (authorizationValue == null || !authorizationValue.startsWith("Bearer ")) {
                HttpService.finish(HttpStatusCode.FORBIDDEN, "Invalid token");
            }

            String authToken = authorizationValue.substring(7);

            SessionContext sessionContext = sessionManager.get(authToken);
            Token token = sessionContext != null ? sessionContext.getToken() : null;

            if (token == null) {
                HttpService.finish(HttpStatusCode.FORBIDDEN, "Access is denied");
            }

            Long currentTime = System.currentTimeMillis() / 1000L;

            if (currentTime > token.getExpireTime()) {
                HttpService.finish(HttpStatusCode.FORBIDDEN, "Your token is expired");
            }

            sessionManager.updateExpireTime(token, currentTime);
            request.setAttribute("context", sessionContext);
        };

        httpService.filterBefore(SECURED_PATH, (request, response) -> {
            SessionContext sessionContext = sessionManager.get("context");
            UserType userType = sessionContext.getUserType();
            if (userType != UserType.PRO) {
                HttpService.finish(HttpStatusCode.FORBIDDEN, "Access is denied");
            }
        });

        ContainerFilter containerFilter = new ContainerFilter(httpService.getRequests());

        UserController userController = new UserController(userService, httpService);
        User createdUser = new User();

        when(request.getRequestURI()).thenReturn("/user/1");
        when(request.getHttpMethod()).thenReturn(HttpMethod.POST);
        when(userService.createUser(any())).thenReturn(createdUser);

        containerFilter.doFilter(request, new HttpResponse(), new FilterChain());

    }
}
