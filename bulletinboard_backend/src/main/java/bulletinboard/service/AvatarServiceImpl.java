package bulletinboard.bulletinboard_be.service;

import bulletinboard.bulletinboard_be.api.response.AvatarResponse;
import bulletinboard.bulletinboard_be.dao.AvatarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AvatarServiceImpl implements AvatarService{

    @Autowired
    private AvatarDAO avatarDAO;

    @Override
    public List<AvatarResponse> getAllavatars() {


        return avatarDAO.findAll().stream().map(e -> {
            AvatarResponse resp = new AvatarResponse();
            resp.setAvatar_id(e.getAvatar_id());
            resp.setAvatar_url(e.getAvatar_url());
            return resp;
        }).collect(Collectors.toList());



    }
}
