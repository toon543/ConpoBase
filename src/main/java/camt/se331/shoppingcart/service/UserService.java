package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.ShoppingCart;
import camt.se331.shoppingcart.entity.User;

import java.util.List;

/**
 * Created by Dto on 4/19/2015.
 */
public interface UserService {
    List<User> findAll();
    User findByUserName(String username);
    User findUserByEmail(String username);
    User login(String email, String password);
    ShoppingCart addShoppingCart(User user, ShoppingCart shoppingCart);
}
