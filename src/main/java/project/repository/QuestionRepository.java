package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.QuestionAnswer;

/**
 * Created by Punjasin on 5/15/2015.
 */
public interface QuestionRepository extends JpaRepository<QuestionAnswer,Long> {

}
