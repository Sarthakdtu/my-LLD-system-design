package org.example.socialmedia.internal;

import java.util.*;
import java.util.stream.Collectors;

public class SocialMediaService {
    private Map<String, Set<String>> friends;
    private Map<String, User> users;
    private Map<String, Set<FriendRequest>> friendRequests;
    private static SocialMediaService instance;
    private SocialMediaService() {
        this.friendRequests = new HashMap<>();
        this.friends = new HashMap<>();
        this.users = new HashMap<>();
    }

    public static SocialMediaService getInstance() {
        if(instance == null)
                instance = new SocialMediaService();
        return instance;
    }

    public User getUser(String username) {
        return users.getOrDefault(username, null);
    }

    public void addUser(User user) {
        users.put(user.username, user);
    }


    public List<String> getFriendRequests(String username) {
        return friendRequests.get(username).stream().map(it-> it.source).collect(Collectors.toList());
    }

    public void createFriendRequest(String source, String destination) {
        FriendRequest friendRequest = new FriendRequest(source, destination);
        if(!friendRequests.containsKey(friendRequest.source)) {
            friendRequests.put(friendRequest.source, new HashSet<>());
        }
        if(!friendRequests.containsKey(friendRequest.destination)) {
            friendRequests.put(friendRequest.destination, new HashSet<>());
        }
        friendRequests.get(source).add(friendRequest);
        friendRequests.get(destination).add(friendRequest);
    }

    public void acceptFriendRequest(FriendRequest request) {
        if(friendRequests.containsKey(request.destination)){
            if(friendRequests.get(request.destination).contains(request))
                request.accept();
        }
    }

    public void declineFriendRequest(FriendRequest request) {
        if(friendRequests.containsKey(request.destination)){
            if(friendRequests.get(request.destination).contains(request))
                request.decilne();
        }
    }

}
