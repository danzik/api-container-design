package storage;

import storage.http.FilterUtils;
import storage.http.container.HttpMethod;

public class PatchEntry {
    String path;
    Object target;
    String acceptType;
    HttpMethod httpMethod;

    public PatchEntry() {}

    public PatchEntry(PatchEntry entry) {
        this.path = entry.path;
        this.target = entry.target;
        this.httpMethod = entry.httpMethod;
    }

    public String getPath() {
        return path;
    }

    public Object getTarget() {
        return target;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    // DUMMY checks
    public boolean matches(HttpMethod httpMethod, String path) {
        if (this.httpMethod == httpMethod && this.path.equals(FilterUtils.ALL_MATCHES)) {
            return true;
        }
        return this.httpMethod == httpMethod;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void acceptType(String acceptType) {
        this.acceptType = acceptType;
    }
}
