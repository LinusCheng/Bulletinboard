package bulletinboard.bulletinboard_be.api.response;

public class PostResponse {

    private Integer article_ID;

    private String username;

    private String title;

    private String time;

    private String content;

    private String avatar_url;

    public Integer getArticle_ID() {
        return article_ID;
    }

    public void setArticle_ID(Integer article_ID) {
        this.article_ID = article_ID;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }


}
