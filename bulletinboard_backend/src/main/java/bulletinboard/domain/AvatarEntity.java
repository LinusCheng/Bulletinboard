package bulletinboard.bulletinboard_be.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="Avatar")
public class AvatarEntity {

    @Id
    @Column(name="avatar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer avatar_id;

    @JsonProperty("avatar_url")
    @Column(name="avatar_url")
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
