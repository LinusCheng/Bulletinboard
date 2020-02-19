package bulletinboard.bulletinboard_be.domain;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
@Entity
@Table(name="Article")
public class ArticleEntity {

    @Id
    @Column(name="article_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer article_ID;

    @ManyToOne
    @JoinColumn(name="user_ID")
    private UserEntity userEntity;

    @Column(name="title_i")
    private String title;

    @Column(name="time_i")
    private String time;

    @Column(name="content")
    private String content;


    public Integer getArticle_ID() {
        return article_ID;
    }

    public void setArticle_ID(Integer article_ID) {
        this.article_ID = article_ID;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
}
