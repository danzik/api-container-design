package storage.http;

import storage.model.UserType;

public class SessionContext {
    private Token token;
    private String userId;
    private String userName;
    private String userEmail;
    private UserType userType;

    public SessionContext() {}

    public SessionContext(Token token, String userId, String userName, String userEmail, UserType userType) {
        this.token = token;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public Token getToken() {
        return token;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
