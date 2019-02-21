package storage.http.container;


import storage.filter.FilterImpl;

import java.util.List;

// DUMMY
public class FilterBefore {
    public static void doFilter(RequestContext requestContext) throws Exception {
        List<PatchMatcher> filters = requestContext.getRequests().findFilters(HttpMethod.BEFORE, requestContext.getUri());

        for (PatchMatcher filter : filters) {
            FilterImpl filterImpl = (FilterImpl)filter.getTarget();
            filterImpl.handle(requestContext.getRequestWrapper(), requestContext.getResponseWrapper());
        }
    }
}