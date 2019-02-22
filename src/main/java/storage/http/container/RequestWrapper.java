package storage.http.container;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RequestWrapper {
    private String body;
    private String uri;
    private HttpSession session;
    private InputStream bodyAsStream;
    private Map<String, String> params;
    private Map<String, String> headers;

    public static RequestWrapper create() {
        return new RequestWrapper();
    }

    protected RequestWrapper() {
        params = new HashMap<>();
        headers = new HashMap<>();
    }

    public RequestWrapper(String uri, String body, Map<String, String> params, Map<String, String> headers, HttpSession session) {
        this.uri = uri;
        this.body = body;
        this.params = params;
        this.headers = headers;
        this.session = session;
    }

    public String getBody() {
        return body;
    }

    public HttpSession getSession() {
        return session;
    }

    public String getHeaders(String headerName) {
        return headers.get(headerName);
    }

    public String getParam(String param) {
        return params.get(param);
    }

    public InputStream getBodyAsStream() {
        return bodyAsStream;
    }

    public String getUri() {
        return uri;
    }

    // DUMMY
    public String getRequestedSessionId() {
        return "sessionID";
    }

    public void setAttribute(String attributeName, Object attributeValue) {
        this.session.setAttribute(attributeName, attributeValue);
    }

    public Object getAttribute(String attributeName) {
        return this.session.getAttribute(attributeName);
    }

    public void setParam(String paramName, String paramValue) {
        params.put(paramName, paramValue);
    }

    // DUMMY
    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void setBodyAsStream(InputStream bodyAsStream) {
        this.bodyAsStream = bodyAsStream;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

}