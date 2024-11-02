package org.example.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

public class HotelManagementSystem {
    Map<String, Room> rooms;
    Map<String, Reservation> reservations;

    Map<String, Guest> guests;



    private HotelManagementSystem() {

    }
    static HotelManagementSystem instance;

    public static synchronized HotelManagementSystem getInstance() {
        if(instance == null) {
            instance = new HotelManagementSystem();
        }
        return instance;
    }

    public void addRoom(Double price, RoomType roomType) {
        Room room = new Room();
        rooms.put(room.id, room);
    }

    public synchronized double cancelReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null) {
            double amount = reservation.room.price * ChronoUnit.DAYS.between(reservation.checkInTime, reservation.checkOutTime);
            reservation.cancel();
            reservations.remove(reservationId);
            return amount;
        }
        return 0.0;
    }

    public void addGuest(Guest guest) {
        guests.put(guest.name, guest);
    }

    public synchronized String createReservation(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate, Payment payment) {
        if(room.status == RoomStatus.AVAILABLE) {
            Long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
            if(payment.processPayment(room.price * days)) {
                room.book();
                Reservation reservation = new Reservation(room, guest, checkInDate, checkOutDate);
                reservations.put(reservation.reservationId, reservation);
                return reservation.reservationId;
            }
        }
        return null;
    }

    public synchronized void checkOut(String resevationId) {
        Reservation reservation = reservations.get(resevationId);
        if(reservation != null && reservation.status == ReservationStatus.CONFIRMED) {
            reservation.room.checkOut();
            reservation.status = ReservationStatus.CANCEL;
        }
    }
}
