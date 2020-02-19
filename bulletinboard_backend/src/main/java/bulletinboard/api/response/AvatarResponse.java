package bulletinboard.bulletinboard_be.api.response;

public class AvatarResponse {

    private Integer avatar_id;
    private String avatar_url;

    public Integer getAvatar_id() {
        return avatar_id;
    }

    public void setAvatar_id(Integer avatar_id) {
        this.avatar_id = avatar_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
