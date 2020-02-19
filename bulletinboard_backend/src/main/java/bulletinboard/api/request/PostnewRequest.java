package bulletinboard.bulletinboard_be.api.request;

public class PostnewRequest {

    private Integer user_ID;

    private String username;

    private String title;

    private String content;

    private Integer avatar_id;

    private String time;


    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAvatar_id() {
        return avatar_id;
    }

    public void setAvatar_id(Integer avatar_id) {
        this.avatar_id = avatar_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
