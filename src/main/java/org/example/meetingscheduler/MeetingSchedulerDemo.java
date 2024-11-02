package org.example.meetingscheduler;

import javafx.util.Pair;
import org.example.meetingscheduler.model.MeetingRoom;
import org.example.meetingscheduler.model.Person;
import org.example.meetingscheduler.model.Time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingSchedulerDemo {
    public static void main(String[] args) {

        MeetingRoomScheduler meetingRoomScheduler = MeetingRoomScheduler.getInstance();
        Person sarthak = new Person("Sarthak");
        Person sanyam = new Person("Sanyam");
        Person shrey = new Person("Shreyansh");
        Person ram = new Person("Ram");

        meetingRoomScheduler.addMeetingRoom("delhi", 5);
        meetingRoomScheduler.addMeetingRoom("rampur", 2);
        meetingRoomScheduler.addMeetingRoom("ayodhya", 4);
        meetingRoomScheduler.addMeetingRoom("banaras", 1);
        meetingRoomScheduler.addMeetingRoom("mathura", 6);
        meetingRoomScheduler.addMeetingRoom("vrindavan", 1);
        meetingRoomScheduler.addMeetingRoom("ujjain", 2);

        List<Person> meeting1 = Arrays.asList(sanyam, sarthak, shrey);
        List<Person> meeting2 = Arrays.asList(sanyam, sarthak, ram);
        List<Person> meeting3 = Arrays.asList(ram, sarthak);
        List<Person> meeting4 = Arrays.asList(ram, sarthak, sanyam, shrey, sanyam, sanyam, sarthak, sarthak);

        String meetingId1 = meetingRoomScheduler.bookRoom(new Time(1, 30, true),
                new Time(2, 30, true),
                "delhi",
                meeting1);
        printHistory(meetingRoomScheduler.getHistoryForRoom("delhi"));
        meetingRoomScheduler.cancelMeeting(meetingId1);

        meetingRoomScheduler.bookRoom(new Time(2, 0, true),
                new Time(3, 30, true),
                "delhi",
                meeting2);

        printHistory(meetingRoomScheduler.getHistoryForRoom("delhi"));
        for(String id : meetingRoomScheduler.getAvailable(
                new Time(2, 0, false),
                new Time(3, 30, false)
        )){
            System.out.println(id + " ");
        }
    }


    public static void printHistory(List<Pair<Time, Time>> intervals) {
        for(Pair<Time, Time> interval : intervals) {
            System.out.println(interval.getKey().getTime() + " : " + interval.getValue().getTime());
        }
    }
}
