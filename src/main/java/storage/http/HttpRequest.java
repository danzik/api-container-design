package storage.http;

import storage.http.container.HttpMethod;
import storage.http.container.HttpSession;

import java.util.Map;

public class HttpRequest {
    private String requestURI;
    private HttpMethod httpMethod;
    private Map<String, String> headers;
    private Map<String, String> params;

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getRequestURI() {
        return this.requestURI;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getParam(String paramName) {
        return params.get(paramName);
    }

    public Map<String, String> getParams() {
        return params;
    }

    public HttpSession getSession() {
        return new HttpSession();
    }
}