package storage.http;

public enum HttpStatusCode {
    CREATED(201), UNAUTHORIZED(401), INTERNAL_ERROR(500), OK(200), FORBIDDEN(403);

    private final int statusCode;

    HttpStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
