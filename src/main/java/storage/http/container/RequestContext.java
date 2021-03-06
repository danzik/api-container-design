package storage.http.container;

import storage.http.Requests;

import java.util.Map;

public class RequestContext {
    private Body body;
    private String uri;
    private String acceptType;
    private Requests requests;
    private HttpSession session;
    private HttpMethod httpMethod;
    private Map<String, String> params;
    private Map<String, String> headers;
    private RequestWrapper requestWrapper;
    private ResponseWrapper responseWrapper;

    public static RequestContext create() {
        return new RequestContext();
    }

    public RequestContext withRequests(Requests requests) {
        this.requests = requests;
        return this;
    }

    public RequestContext withBody(Body body) {
        this.body = body;
        return this;
    }

    public RequestContext withResponse(ResponseWrapper response) {
        this.responseWrapper = response;
        return this;
    }

    public RequestContext withHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public String getAcceptType() {
        return acceptType;
    }

    public Body getBody() {
        return body;
    }

    public RequestWrapper getRequestWrapper() {
        return requestWrapper;
    }

    public ResponseWrapper getResponseWrapper() {
        return responseWrapper;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public Requests getRequests() {
        return requests;
    }

    public RequestContext withUri(String requestURI) {
        this.uri = requestURI;
        return this;
    }

    public RequestContext withRequestWrapper(RequestWrapper requestWrapper) {
        this.requestWrapper = requestWrapper;
        return this;
    }

    public RequestContext withResponseWrapper(ResponseWrapper responseWrapper) {
        this.responseWrapper = responseWrapper;
        return this;
    }

    public RequestContext withParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public RequestContext withHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public RequestContext withSession(HttpSession session) {
        this.session = session;
        return this;
    }

    public HttpSession getSession() {
        return session;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
