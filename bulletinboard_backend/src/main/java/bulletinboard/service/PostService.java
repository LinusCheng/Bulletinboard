package bulletinboard.bulletinboard_be.service;

import bulletinboard.bulletinboard_be.api.request.PostnewRequest;
import bulletinboard.bulletinboard_be.api.response.PostResponse;

import java.util.List;

public interface PostService {

    List<PostResponse> getAllposts();

    void setPost(PostnewRequest postnewRequest);

    void deleteArticle(int postId);


}
