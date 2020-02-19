package bulletinboard.bulletinboard_be.dao;

import bulletinboard.bulletinboard_be.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity,Integer> {

}
