package bulletinboard.bulletinboard_be.api.request;


import javax.validation.constraints.NotBlank;

//@Data //???
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String pw;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
