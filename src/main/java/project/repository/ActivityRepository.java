package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.Activity;


/**
 * Created by Punjasin on 5/13/2015.
 */
public interface ActivityRepository extends JpaRepository<Activity,Long> {

}
