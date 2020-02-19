package bulletinboard.bulletinboard_be.dao;

import bulletinboard.bulletinboard_be.domain.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarDAO extends JpaRepository<AvatarEntity,Integer> {

}
