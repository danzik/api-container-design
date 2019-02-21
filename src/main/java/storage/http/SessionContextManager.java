package storage.http;

import storage.GsonConverter;

import java.util.HashMap;
import java.util.Map;

public class SessionContextManager {
    private final Map<String, String> attributes;
    private static final SessionContextManager manager = new SessionContextManager(new HashMap<>());

    public static SessionContextManager getSessionManager() {
        return manager;
    }

    public SessionContextManager(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public SessionContext get(String token) {
        SessionContext sessionContext = null;
        String sessionTokenAsString = attributes.get(token);
        if (sessionTokenAsString != null) {
            sessionContext = new GsonConverter().fromJson(sessionTokenAsString, SessionContext.class);
        }
        return sessionContext;
    }

    public void put() {}

    public void updateExpireTime(Token token, Long currentTime) {}
}
