package project.service;

import project.dao.UserDao;
import project.entity.User;
import project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
                     return userRepository.findAll();
                 }

    @Override
    public User findByUserName(String username) {
            return userRepository.findByUsername(username);
        }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }
}
