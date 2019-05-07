package com.sanestreet.dronebyapp.model;

public class Drone implements DroneState {

    private int id;
    private Location location;
    private NovoSample sample;
    private boolean isFlying;

    public Drone(int id, Location location){
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isFlying(){
        return true;
    }
}
