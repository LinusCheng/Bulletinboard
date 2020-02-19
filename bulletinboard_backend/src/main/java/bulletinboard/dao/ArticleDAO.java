package bulletinboard.bulletinboard_be.dao;

import bulletinboard.bulletinboard_be.domain.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDAO extends JpaRepository<ArticleEntity,Integer> {

}
