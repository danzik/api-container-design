package storage.http;

import storage.exceptions.HttpServiceException;
import storage.http.container.Body;
import storage.http.container.FilterBefore;
import storage.http.container.Patches;
import storage.http.container.RequestContext;
import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;
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
                .withBody(body)
                .withUri(request.getRequestURI())
                .withRequests(requests)
                .withResponseWrapper(responseWrapper)
                .withRequestWrapper(requestWrapper)
                .withParams(request.getParams())
                .withHttpMethod(request.getHttpMethod());
        try {
            FilterBefore.doFilter(requestContext);
            Patches.execute(requestContext);
        } catch (Exception serviceException) {
            throw serviceException;
        }

        if (filterChain != null) {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}
