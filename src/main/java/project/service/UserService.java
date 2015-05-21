package project.service;

import project.entity.User;

import java.util.List;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
public interface UserService {
    public List<User> findAll();
    
    public User findByUserName(String username);

    User addUser(User user);
}
