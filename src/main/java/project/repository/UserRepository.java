package project.repository;

import project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
public interface UserRepository extends JpaRepository<User,Long> {

        User findByEmail(String email);
    User findByUsername(String username);
    User findByEmailAndPassword(String email, String password);


}