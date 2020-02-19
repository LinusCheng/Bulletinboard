package bulletinboard.bulletinboard_be.controller;

import bulletinboard.bulletinboard_be.api.request.PostnewRequest;
import bulletinboard.bulletinboard_be.api.response.PostResponse;
import bulletinboard.bulletinboard_be.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;


//    @GetMapping("/post/{tk}")
//    public List<PostResponse> getAllpost(@PathVariable String tk){
//        System.out.println("The token is:");
//        System.out.println(tk);
    @GetMapping("/post")
    public List<PostResponse> getAllpost(){

        return postService.getAllposts();
    }

    @PostMapping("/post")
    public void doPostnew(@RequestBody PostnewRequest newPost){

//        System.out.println(newPost.getUser_ID());
//        System.out.println(newPost.getTitle());
//        System.out.println(newPost.getUsername());
//        System.out.println(newPost.getContent());

        PostnewRequest postnewRequest = new PostnewRequest();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        postnewRequest.setTime(dtf.format(now));
        postnewRequest.setUser_ID(newPost.getUser_ID());
        postnewRequest.setContent(newPost.getContent());
//        postnewRequest.setUsername(newPost.getUsername());
        postnewRequest.setTitle(newPost.getTitle());
//        postnewRequest.setAvatar_id(newPost.getAvatar_id());

        postService.setPost(postnewRequest);

    }


    @DeleteMapping("/post/{postId}")
    public void deleteonepost(@PathVariable String postId){
        System.out.println("In delete method "+postId);
//        System.out.println(postId.getClass().getName());
        postService.deleteArticle(Integer.parseInt(postId));
    }




}
