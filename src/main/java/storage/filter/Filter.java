package storage.filter;

import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;

@FunctionalInterface
public interface Filter {
    void handle(RequestWrapper request, ResponseWrapper response) throws Exception;
}
