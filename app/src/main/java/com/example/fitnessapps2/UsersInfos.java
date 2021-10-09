package com.example.fitnessapps2;

public class UsersInfos {

    // string variable for
    // storing employee name.
    private String stepCounter;

    // string variable for storing
    // employee contact number
    private String calorie;

    // string variable for storing
    // employee address.
    private String distance;

    private String datetime;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public UsersInfos() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getStepCount() {
        return stepCounter;
    }

    public void setStepCount(String stepCounter) {
        this.stepCounter = stepCounter;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}