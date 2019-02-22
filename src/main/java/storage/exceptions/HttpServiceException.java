package storage.exceptions;

import storage.http.HttpStatusCode;

public class HttpServiceException extends RuntimeException {
    private String body;
    private HttpStatusCode status;

    public HttpServiceException(HttpStatusCode statusCode, String body) {
        super(body + " http status code: " + statusCode.name());
        this.body = body;
        this.status = statusCode;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }
}
