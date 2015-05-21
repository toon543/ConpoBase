package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.Image;

/**
 * Created by Punjasin on 5/15/2015.
 */
public interface ImageRepository extends JpaRepository<Image,Long> {



}
