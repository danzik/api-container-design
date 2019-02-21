package storage.http.container;

import com.sun.deploy.net.HttpResponse;
import storage.http.HttpStatusCode;

import java.util.Map;

public class ResponseWrapper<T> {
    private T body;
    private String type;
    private HttpResponse response;
    private HttpStatusCode status;

    public static ResponseWrapper create() {
        return new ResponseWrapper();
    }

    public void body(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public HttpStatusCode getStatus() {
        return status != null ? status : HttpStatusCode.OK;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HttpResponse getResponse() {
        return response;
    }

    public void setResponse(HttpResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (body != null) {
            sb.append(this.body);
        }

        sb.append(this.status);

        return sb.toString();
    }
}
