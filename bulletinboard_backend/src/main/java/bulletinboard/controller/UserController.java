package bulletinboard.bulletinboard_be.controller;

import bulletinboard.bulletinboard_be.api.request.UsernewRequest;
import bulletinboard.bulletinboard_be.api.response.UserResponse;
import bulletinboard.bulletinboard_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user/{tk}")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<UserResponse> getAllusers(@PathVariable String tk){

    System.out.println("The token is:");
    System.out.println(tk);

//    @GetMapping("/user")
////    @Secured({"ROLE_USER", "ROLE_ADMIN"})
//    public List<UserResponse> getAllusers(){

        return userService.getAllusers();
    }

    @PostMapping("/user")
    public void doPostnew(@RequestBody UsernewRequest usernewRequest){
        System.out.println("Add new user");

        userService.setNewUser(usernewRequest);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteonepost(@PathVariable String userId){

        System.out.println("In user delete method "+userId);
        userService.deleteUser(Integer.parseInt(userId));
    }


}
