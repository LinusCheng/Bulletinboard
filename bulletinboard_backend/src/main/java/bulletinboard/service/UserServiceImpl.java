package bulletinboard.bulletinboard_be.service;

import bulletinboard.bulletinboard_be.api.request.UsernewRequest;
import bulletinboard.bulletinboard_be.api.response.UserResponse;
import bulletinboard.bulletinboard_be.dao.UserDAO;
import bulletinboard.bulletinboard_be.dao.UserRepository;

import bulletinboard.bulletinboard_be.domain.AvatarEntity;
import bulletinboard.bulletinboard_be.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserResponse> getAllusers() {
        return userDAO.findAll().stream().map(e-> {
            UserResponse resp = new UserResponse();
            resp.setUser_ID(e.getUser_ID());
            resp.setUsername(e.getUsername());
            resp.setAuthorization(e.getAuthorization());
            resp.setAvatar_url(e.getAvatarEntity().getAvatar_url());
            return resp;
        }).collect(Collectors.toList());

    }

    @Override
    public void setNewUser(UsernewRequest usernewRequest) {

        UserEntity userEntity = new UserEntity();

        AvatarEntity avatarEntity = new AvatarEntity();

        avatarEntity.setAvatar_id(usernewRequest.getAvatar());

//        user.setPw(usernewRequest.getPw());

        userEntity.setPw( bCryptPasswordEncoder.encode(usernewRequest.getPw()) );


        userEntity.setUsername(usernewRequest.getUsername());
        userEntity.setAuthorization(usernewRequest.getAuthorization());
        userEntity.setAvatarEntity(avatarEntity);

        userDAO.save(userEntity);

    }

    @Override
    public void deleteUser(int userId) { userDAO.delete(userDAO.findById(userId).get()); }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findUserByusername(username);

        if(userEntity==null) throw new UsernameNotFoundException(username);

        return new User( userEntity.getUsername(), userEntity.getPw(), new ArrayList<>() ) ;

    }
}
