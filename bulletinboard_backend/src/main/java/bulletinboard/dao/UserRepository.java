package bulletinboard.bulletinboard_be.dao;

import bulletinboard.bulletinboard_be.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findUserByusername(String username);

}
