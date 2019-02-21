package storage.http.container;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RequestWrapper {
    private String body;
    private HttpSession session;
    private InputStream bodyAsStream;
    private Map<String, String> params;
    private Map<String, String> headers;
    private ContainerRequest baseRequest;

    public static RequestWrapper create() {
        return new RequestWrapper();
    }

    protected RequestWrapper() {
        params = new HashMap<>();
        headers = new HashMap<>();
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

    public ContainerRequest getBaseRequest() {
        return baseRequest;
    }

    public String getParam(String param) {
        return params.get(param);
    }

    public InputStream getBodyAsStream() {
        return bodyAsStream;
    }

    public String getUri() {
        return "";
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
}
