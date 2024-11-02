package org.example.socialmedia;

import org.example.socialmedia.internal.FriendRequest;
import org.example.socialmedia.internal.SocialMediaService;
import org.example.socialmedia.internal.User;

public class SocialMediaDemo {
    /*
User Registration and Authentication:
    Users should be able to create an account with their personal information, such as name, email, and password.
    Users should be able to log in and log out of their accounts securely.
    -----
    User, UserProfile, FriendRequest, FriendsManager, Post, NewsFeed, Like, Comment,
    -----
User Profiles:
    Each user should have a profile with their information, such as profile picture, bio, and interests.
    Users should be able to update their profile information.
Friend Connections:
    Users should be able to send friend requests to other users.
    Users should be able to accept or decline friend requests.
    Users should be able to view their list of friends.
Posts and Newsfeed:
    Users should be able to create posts with text, images, or videos.
    Users should be able to view a newsfeed consisting of posts from their friends and their own posts.
    The newsfeed should be sorted in reverse chronological order.
Likes and Comments:
    Users should be able to like and comment on posts.
    Users should be able to view the list of likes and comments on a post.
Notifications:
    Users should receive notifications for events such as friend requests, likes, comments, and mentions.
    Notifications should be delivered in real-time.
    ---------------------------------------------------------------------------------
Privacy and Security:
    Users should be able to control the visibility of their posts and profile information.
    The system should enforce secure access control to ensure data privacy.

Scalability and Performance:
    The system should be designed to handle a large number of concurrent users and high traffic load.
    The system should be scalable and efficient in terms of resource utilization.
     */

    public static void main(String[] args) {

        SocialMediaService socialMediaService = SocialMediaService.getInstance();
        User user1 = new User("sarthak", "sarthak", "12345", "sarthak@gmail.com");
        User user2 = new User("sanyam", "sarthak", "12345", "sarthak@gmail.com");
        socialMediaService.addUser(user1);
        socialMediaService.addUser(user2);
//        FriendRequest friendRequest = new FriendRequest("sarthak", "sanyam");
        socialMediaService.createFriendRequest("sarthak", "sanyam");
        socialMediaService.getFriendRequests("sanyam").forEach(it -> System.out.println(it) );

    }


}
