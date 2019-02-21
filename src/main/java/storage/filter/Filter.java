package storage.filter;

import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;

@FunctionalInterface
public interface Filter<T> {
    void handle(RequestWrapper request, ResponseWrapper<T> response) throws Exception;
}
