package com.house;


public class Rooms {
    //FIELDS
    private String roomName;
    private String roomDescription;


    //CONSTRUCTOR
    public Rooms(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;

    }

    //GETTERS & SETTERS

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }


}
