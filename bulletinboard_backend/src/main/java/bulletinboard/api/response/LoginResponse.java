package bulletinboard.bulletinboard_be.api.response;

public class LoginResponse {

    private String username;

    private Integer expirationIn;

    private String token;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getExpirationIn() {
        return expirationIn;
    }

    public void setExpirationIn(Integer expirationIn) {
        this.expirationIn = expirationIn;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
