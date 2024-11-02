package org.example.meetingscheduler;

import javafx.util.Pair;
import org.example.meetingscheduler.model.Meeting;
import org.example.meetingscheduler.model.MeetingRoom;
import org.example.meetingscheduler.model.Person;
import org.example.meetingscheduler.model.Time;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeetingRoomScheduler {


    Map<String, Meeting> meetingMap;

    private MeetingRoomScheduler(){
        meetingRooms = new HashMap<>();
        meetingMap = new HashMap<>();
    }

    private static MeetingRoomScheduler instance;

    public static MeetingRoomScheduler getInstance() {
        if(instance == null)
            instance = new MeetingRoomScheduler();

        return instance;
    }

    public Map<String, MeetingRoom> meetingRooms;

    public String bookRoom(Time start, Time end, String roomId, List<Person> persons){
        if(!meetingRooms.containsKey(roomId)) {
            System.out.println("Invalid room");
            return "";
        }
        MeetingRoom meetingRoom = meetingRooms.get(roomId);
        if(!meetingRoom.isAvailableWithCapacity(start, end, persons.size())) {
            System.out.println("Room not avaialble");
            return "";
        }
        Meeting meeting = new Meeting(start, end, meetingRoom.getRoomId(), persons);
        meetingMap.put(meeting.getId(), meeting);
        meetingRoom.addMeeting(meeting);
        return meeting.getId();
    }

    public List<Pair<Time, Time>> getHistoryForRoom(String room){
        if(meetingRooms.containsKey(room)) {
          return  meetingRooms.get(room).getMeetings();
        }
        return null;
    }

    public List<String> getAvailable(Time start, Time end){
        return meetingRooms.values().stream().filter(it -> it.isAvailableForInterval(start, end)).map(MeetingRoom::getRoomId).collect(Collectors.toList());
    }

    public void cancelMeeting(String meetingId) {
        if(meetingMap.containsKey(meetingId)) {
            Meeting meeting = meetingMap.get(meetingId);
            meeting.cancelMeeting();
            meetingRooms.get(meeting.getRoomId()).removeMeeting(meeting);
        }
    }

    public void addMeetingRoom(String roomId, Integer cap) {
        MeetingRoom meetingRoom = new MeetingRoom(roomId, cap);
        meetingRooms.put(roomId, meetingRoom);
    }
}
