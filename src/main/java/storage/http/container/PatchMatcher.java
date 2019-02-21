package storage.http.container;

public class PatchMatcher {
    private Object target;
    private String matchUri;
    private String requestURI;

    public PatchMatcher(Object target, String matchUri, String request) {
        this.target = target;
        this.matchUri = matchUri;
        this.requestURI = request;
    }

    public Object getTarget() {
        return target;
    }

    public String getMatchUri() {
        return matchUri;
    }

    public String getRequestURI() {
        return requestURI;
    }
}
