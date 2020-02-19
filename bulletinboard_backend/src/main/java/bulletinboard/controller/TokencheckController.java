package bulletinboard.bulletinboard_be.controller;

import bulletinboard.bulletinboard_be.api.response.PostResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TokencheckController {

//    @GetMapping("/tokencheck")
//    public String getAllpost(){
//        String tk = "test tk";

    @GetMapping("/tokencheck/{tk}")
    public String getAllpost(@PathVariable String tk){
        System.out.println("The token is:");
        System.out.println(tk);

        return "From Server "+ tk;
    }


}
