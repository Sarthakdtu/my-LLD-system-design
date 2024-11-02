package org.example.socialmedia.internal;

public class FriendRequest {
    String source;
    String destination;
    FriendRequestStatus status;
    String id;

    public FriendRequest(String source, String destination) {
        this.source = source;
        this.destination = destination;
        status = FriendRequestStatus.PENDING_RECV;
        id = getKey();
    }

    private String getKey() {
        if(source.compareTo(destination) > 0) {
            return destination.concat("#").concat(source);
        }
        return source.concat("#").concat(destination);
    }

    void accept() {
        if(status == FriendRequestStatus.PENDING_RECV) {
            status = FriendRequestStatus.ACCEPTED;
        }
        else {
            throw new IllegalStateException();
        }
    }

    void decilne() {
        if(status == FriendRequestStatus.PENDING_RECV) {
            status = FriendRequestStatus.DECLINED;
        }
        else {
            throw new IllegalStateException();
        }
    }
}
