package storage.http;

import storage.exceptions.HttpServiceException;
import storage.http.container.Body;
import storage.http.container.FilterBefore;
import storage.http.container.Patches;
import storage.http.container.RequestContext;
import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;
import storage.http.container.ServiceExceptionUtils;
import storage.http.container.filter.Filter;
import storage.http.container.filter.FilterChain;
import storage.http.container.filter.FilterConfig;

public class ContainerFilter implements Filter {
    private Requests requests;

    public ContainerFilter(Requests requests) {
        this.requests = requests;
    }

    @Override
    public void init(FilterConfig config) {}

    @Override
    public void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain) throws Exception {
        Body body = Body.create();

        RequestWrapper requestWrapper = RequestWrapper.create();
        ResponseWrapper responseWrapper = ResponseWrapper.create();

        RequestContext requestContext = RequestContext.create()
                .withRequestWrapper(requestWrapper)
                .withResponseWrapper(responseWrapper)
                .withBody(body)
                .withRequests(requests)
                .withParams(request.getParams())
                .withUri(request.getRequestURI())
                .withHttpMethod(request.getHttpMethod())
                .withSession(request.getSession())
                .withHeaders(request.getHeaders());
        try {
            FilterBefore.doFilter(requestContext);
            Patches.execute(requestContext);
        } catch (HttpServiceException serviceException) {
            ServiceExceptionUtils.modifyResponse(response, serviceException);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        if (filterChain != null) {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}
