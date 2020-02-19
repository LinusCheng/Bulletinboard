package bulletinboard.bulletinboard_be.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Usertable")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 4245100093102651923L;

    @Id
    @Column(name="user_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_ID;

    @Column(name="pw" , nullable=false)
    private String pw;

    @Column(name="username_i" , nullable=false , unique = true)
    private String username;

    @Column(name="authorization" , nullable=false)
    private Integer authorization;

    @OneToOne
    @JoinColumn(name="avatar_id")
    private AvatarEntity avatarEntity;


    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Integer authorization) {
        this.authorization = authorization;
    }

    public AvatarEntity getAvatarEntity() { return avatarEntity; }

    public void setAvatarEntity(AvatarEntity avatarEntity) { this.avatarEntity = avatarEntity; }

}
