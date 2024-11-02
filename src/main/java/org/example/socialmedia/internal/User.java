package org.example.socialmedia.internal;


public class User {
    String username;
    String name;
    String password;
    String email;
    UserProfile userProfile;

    public User(String username, String email, String password, String name) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.username = username;
        userProfile = new UserProfile();
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
