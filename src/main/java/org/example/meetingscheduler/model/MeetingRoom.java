package org.example.meetingscheduler.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoom {

    PriorityQueue<Meeting> meetings;
    String roomId;
    Integer capacity;

    public String getRoomId() {
        return roomId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public MeetingRoom(String id, Integer capacity) {
        this.roomId = id;
        this.capacity = capacity;
        this.meetings = new PriorityQueue<>(new TimeComparator());
    }

    public boolean isAvailableWithCapacity(Time start, Time end, Integer num) {
        if(this.getCapacity() < num)
            return false;
        return isAvailableForInterval(start, end);
    }

    public boolean isAvailableForInterval(Time start, Time end) {
        if(meetings.isEmpty())
            return true;
        for (Meeting meeting: meetings) {
            if(end.time.compareTo(meeting.start.time) <= 0){
                return true;
            }
            else{
                if(start.time.compareTo(meeting.start.time) == 0)
                    return false;

                if(start.time.compareTo(meeting.start.time) < 0){
                    if(end.time.compareTo(meeting.start.time) > 0){
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public List<Pair<Time, Time>> getMeetings() {
        List<Pair<Time, Time>> intervals = new ArrayList<>();
         meetings.forEach(it -> {intervals.add(it.getInterval());});
         return intervals;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    private static class TimeComparator implements Comparator<Meeting> {

        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.getInterval().getKey().time.compareTo(o2.getInterval().getKey().time);
        }
    }
}
