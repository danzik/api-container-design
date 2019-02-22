package storage.http.container;

import java.util.HashMap;
import java.util.Map;

public class HttpSession {
    private Map<String, Object> attributes;

    public HttpSession() {
        this.attributes = new HashMap<>();
    }

    public Object getAttribute(String attributeName) {
        return attributes.get(attributeName);
    }

    public String getRequestedSessionId() {
        return null;
    }

    public void setAttribute(String attributeName, Object attributeValue) {
        this.attributes.put(attributeName, attributeValue);
    }
}
