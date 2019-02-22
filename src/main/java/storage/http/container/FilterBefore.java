package storage.http.container;

import storage.filter.FilterImpl;

import java.util.List;

// DUMMY
public class FilterBefore {
    public static void doFilter(RequestContext requestContext) throws Exception {
        List<PatchMatcher> filters = requestContext.getRequests().findFilters(HttpMethod.BEFORE, requestContext.getUri());

        for (PatchMatcher filter : filters) {
            Object target = filter.getTarget();
            if (target instanceof FilterImpl) {
                FilterImpl filterImpl = (FilterImpl) target;

                RequestWrapper requestWrapper = requestContext.getRequestWrapper();
                requestWrapper.setUri(filter.getRequestURI());
                requestWrapper.setParams(requestContext.getParams());
                requestWrapper.setSession(requestContext.getSession());
                requestWrapper.setHeaders(requestContext.getHeaders());

                filterImpl.handle(requestContext.getRequestWrapper(), requestContext.getResponseWrapper());
            }
        }

    }
}