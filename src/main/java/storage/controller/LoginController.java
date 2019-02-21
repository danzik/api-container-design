package storage.controller;

import storage.http.HttpStatusCode;
import storage.http.container.HttpService;
import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;
import storage.model.LoginResponse;
import storage.service.LoginService;

public class LoginController {
    private LoginService loginService;

    public LoginController(HttpService http, LoginService loginService) {
        this.loginService = loginService;
        http.post("/login", this::login);
    }

    private ResponseWrapper<LoginResponse> login(RequestWrapper request, ResponseWrapper<LoginResponse> response) {
        String username = request.getParam("username");
        String password = request.getParam(("password"));
        LoginResponse loginResponse = loginService.login(username, password);
        if (loginResponse.isSuccess()) {
            response.body(loginResponse);
            return response;
        }
        response.setStatus(HttpStatusCode.UNAUTHORIZED);
        return response;
    }
}