package com.ecommerce.services;

import com.ecommerce.daos.UserDAO;
import com.ecommerce.exceptions.InvalidLoginException;
import com.ecommerce.models.AuthUser;
import com.ecommerce.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public User register(User user) {
        // TODO: prevent duplicate email registration
        return userDAO.save(user);
    }

    public User login(AuthUser authUser) {
        Optional<User> user;
        user = userDAO.findByEmail(authUser.getEmail());
        if (!user.isPresent()) {
            //throw username not found exception
            System.out.println("user not found");
            throw new InvalidLoginException("Invalid login credentials");
        } else {
            if (authUser.getPassword().equals(user.get().getPassword())) {
                return user.get();
            }
        }
        throw new InvalidLoginException("Invalid login credentials");
    }
}
