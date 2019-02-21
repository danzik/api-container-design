package storage.http.container;

import java.util.HashMap;
import java.util.Map;

public enum HttpMethod {
    GET, POST, PUT, DELETE, HEAD, TRACE, OPTIONS, PATCH, UNSUPPORTED, BEFORE, AFTER;

    private static Map<String, HttpMethod> methods = new HashMap<>();

    static {
        for (HttpMethod method : values()) {
            methods.put(method.toString(), method);
        }
    }

    public static HttpMethod get(String methodCandidate) {
        HttpMethod method = methods.get(methodCandidate);
        return method != null ? method : UNSUPPORTED;
    }
}
