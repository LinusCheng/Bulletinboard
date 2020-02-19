package bulletinboard.bulletinboard_be.service;

import bulletinboard.bulletinboard_be.api.request.UsernewRequest;
import bulletinboard.bulletinboard_be.api.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public void setNewUser(UsernewRequest usernewRequest);

    public List<UserResponse> getAllusers();

    public void deleteUser(int userId);


}
