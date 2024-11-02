package org.example.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    Room room;
    String reservationId;
    Guest guest;
    LocalDate checkInTime;
    LocalDate checkOutTime;
    ReservationStatus status;

    public Reservation(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        this.room = room;
        this.guest = guest;
        this.checkInTime = checkInDate;
        this.checkOutTime = checkOutDate;
    }


    public synchronized void cancel() {
        if(status == ReservationStatus.CONFIRMED) {
            room.checkOut();
            status = ReservationStatus.CANCEL;
        }
        else {
            throw new IllegalStateException();
        }
    }

}
