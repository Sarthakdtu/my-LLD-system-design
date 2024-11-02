package org.example.ecommerce.internal.service;

import org.example.ecommerce.internal.model.User;

import java.util.Map;

public class UserService {

    private Map<String, User> users;

    private UserService() { }

    private static UserService instance;

    public static UserService getInstance() {
        if(instance == null)
            instance = new UserService();
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(User user) {
        return users.get(user.getUsername());
    }
}
