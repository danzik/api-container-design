package storage.http.container;

import storage.exceptions.HttpServiceException;
import storage.http.HttpResponse;

public class ServiceExceptionUtils {
    public static void modifyResponse(HttpResponse response, HttpServiceException serviceException) {
        response.setStatus(serviceException.getStatus());
    }
}
