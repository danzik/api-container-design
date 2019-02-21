package storage.http.container.filter;

import storage.http.HttpRequest;
import storage.http.HttpResponse;

public interface Filter {
    void init(FilterConfig config);

    void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain) throws Exception;

    void destroy();
}
