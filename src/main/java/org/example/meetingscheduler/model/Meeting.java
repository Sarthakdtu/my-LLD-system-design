package org.example.meetingscheduler.model;

import javafx.util.Pair;

import java.util.List;
import java.util.Random;

public class Meeting {
    Time start;

    Time end;
    String id;

    String roomId;

    List<Person> attendees;

    boolean isCancelled;

    public Meeting(Time start, Time end, String roomid, List<Person> people) {
        id = getSaltString();
        isCancelled = false;
        this.roomId = roomid;
        attendees = people;
        this.start = start;
        this.end = end;
        this.notifyAttendees("Meeting created for " + start.time + " " + end.time + " at room " + roomId);
    }

    public Pair<Time, Time> getInterval() {
        return new Pair<>(start, end);
    }

    private void notifyAttendees(String message) {
        attendees.forEach(it -> it.email(message));
    }

    public void updateMeetingRoom(String roomId) {
        this.roomId = roomId;
        this.notifyAttendees("Meeting updated Roomid " + roomId);
//        return false;
    }

    public String getId() {
        return id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void updateMeetingTime(Time start, Time end) {
        this.start = start;
        this.end = end;
        this.notifyAttendees("Meeting Time updated");
//        return false;
    }


    public void cancelMeeting() {
        this.isCancelled = true;
        notifyAttendees("Meeting cancelled");
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
