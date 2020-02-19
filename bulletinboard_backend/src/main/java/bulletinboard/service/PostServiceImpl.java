package bulletinboard.bulletinboard_be.service;

import bulletinboard.bulletinboard_be.api.request.PostnewRequest;
import bulletinboard.bulletinboard_be.api.response.PostResponse;
import bulletinboard.bulletinboard_be.dao.ArticleDAO;
import bulletinboard.bulletinboard_be.domain.ArticleEntity;
import bulletinboard.bulletinboard_be.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    private ArticleDAO articleDAO;

    @Override
    public List<PostResponse> getAllposts() {
        return articleDAO.findAll().stream().map(e->{
            PostResponse resp = new PostResponse();
            resp.setArticle_ID(e.getArticle_ID());
            resp.setAvatar_url(e.getUserEntity().getAvatarEntity().getAvatar_url());
            resp.setContent(e.getContent());
            resp.setTime(e.getTime());
            resp.setTitle(e.getTitle());
            resp.setUsername(e.getUserEntity().getUsername());
            return resp;
        }).collect(Collectors.toList());
    }


    @Override
    public void setPost(PostnewRequest postnewRequest) {

        ArticleEntity articleEntity = new ArticleEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setUser_ID(postnewRequest.getUser_ID());

//        User user = userDAO.findById(postnewRequest.getUser_ID()).orElse(null);

        articleEntity.setTime(postnewRequest.getTime());
        articleEntity.setContent(postnewRequest.getContent());
        articleEntity.setTitle(postnewRequest.getTitle());
        articleEntity.setUserEntity(userEntity);

        articleDAO.save(articleEntity);


    }


    @Override
    public void deleteArticle(int postId) {
        articleDAO.delete(articleDAO.findById(postId).get());
    }


}
