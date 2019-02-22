package storage.http;

public class HttpResponse {
    private int status;

    public void setStatus(HttpStatusCode status) {
        this.status = status.getStatusCode();
    }

    public int getStatus() {
        return status;
    }
}
