package storage.http;

public class Token {
    private Long expireTime;
    private String accessToken;
    private String refreshToken;

    public Token() {}

    public Token(Long expireTime, String accessToken, String refreshToken) {
        this.expireTime = expireTime;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
