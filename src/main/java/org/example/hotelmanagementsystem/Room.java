package org.example.hotelmanagementsystem;

public class Room {
    RoomType type;
    String id;
    Double price;
    RoomStatus status;

    public Room () {
        this.status = RoomStatus.AVAILABLE;
    }

    public synchronized void checkIn() {
        if(status == RoomStatus.BOOKED) {
            status = RoomStatus.OCCUPIED;
        }
        else {
            throw new IllegalStateException("Room is not booked");
        }
    }

    public synchronized void checkOut() {
        if(status == RoomStatus.OCCUPIED) {
            status = RoomStatus.AVAILABLE;
        }
        else {
            throw new IllegalStateException("Room is not occupied");
        }
    }

    public synchronized void book() {
        if(status == RoomStatus.AVAILABLE) {
            status = RoomStatus.BOOKED;
        }
        else {
            throw new IllegalStateException("Room is not available");
        }
    }
}
