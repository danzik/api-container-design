package storage.exceptions;

import storage.http.HttpStatusCode;

public class HttpServiceException extends RuntimeException {

    public HttpServiceException(HttpStatusCode statusCode, String body) {
        super(body + " http status code: " + statusCode);
    }
}
