package bulletinboard.bulletinboard_be.controller;


import bulletinboard.bulletinboard_be.api.response.AvatarResponse;
import bulletinboard.bulletinboard_be.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;


    @GetMapping("/avatar")
    public List<AvatarResponse> getAllavatars(){
        return avatarService.getAllavatars();
    }



}
