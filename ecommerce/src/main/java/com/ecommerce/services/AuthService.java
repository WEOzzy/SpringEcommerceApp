package com.ecommerce.services;

import com.ecommerce.daos.UserDAO;
import com.ecommerce.models.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public User register(User user) {
        return userDAO.save(user);
    }
}
