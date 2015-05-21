package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.entity.User;
import project.repository.RoleRepository;
import project.repository.UserRepository;

/**
 * Created by P-OniSawa on 14/5/2558.
 */

@Repository
public class DbUserDao implements UserDao {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public User addUser(User user) {
        user.getRoles().add(roleRepository.findOne(2L));
        return userRepository.save(user);
    }
}
