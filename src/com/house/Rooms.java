package com.house;


public class Rooms {
    //FIELDS
    private String roomName;
    private String roomDescription;
    private Items item;

    //CONSTRUCTOR
    public Rooms(String roomName, String roomDescription, Items item) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.item = item;
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

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }
}
