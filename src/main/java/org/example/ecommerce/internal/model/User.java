package org.example.ecommerce.internal.model;

public class User {
    private String username;
    private UserProfile profile;

    public User(String name) {
        username = name;
        profile = new UserProfile();
    }

    public void addOrder(Order order) {
        profile.addOrder(order);
    }

    UserProfile getProfile() {
        return profile;
    }

    public String getUsername() {
        return username;
    }
}
