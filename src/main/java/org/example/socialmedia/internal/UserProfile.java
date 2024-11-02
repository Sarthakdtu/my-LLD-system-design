package org.example.socialmedia.internal;

public class UserProfile {
    String profilePicUrl;
    String bio;

    public UserProfile() {
        bio = "";
        profilePicUrl = "";
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }
}
