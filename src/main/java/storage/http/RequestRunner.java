package storage.http;

import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;

@FunctionalInterface
public interface RequestRunner {
    Object run(RequestWrapper request, ResponseWrapper response) throws Exception;
}
