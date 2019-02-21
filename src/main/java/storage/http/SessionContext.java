package storage.http;

import storage.model.UserType;

public class SessionContext {
    private Token token;
    private String name;
    private String userId;
    private String lastName;
    private UserType userType;

    public String getUserId() {
        return userId;
    }

    public Token getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public UserType getUserType() {
        return userType;
    }
}
