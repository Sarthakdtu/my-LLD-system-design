package org.example.meetingscheduler.model;

public class Time {

    String time;

    public Time (Integer hour, Integer minute, boolean isPostNoon) {
        String hourString = "", minuteString = "";
        if(minute < 10){
            minuteString = "0" + minute;
        }
        else
            minuteString = minute.toString();
        if(isPostNoon) {
            hour = 12 + hour;
            hourString = hour.toString();
        }
        else{
            hourString = "0" + hour.toString();
        }
        time = hourString+minuteString;
    }

    public String getTime() {
        return time;
    }
}
