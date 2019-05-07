package com.sanestreet.dronebyapp.model;

public enum Location {
    HOME(1234,4321,1),
    WAYPOINT_ONE(5678, 8765, 2);

    private double x, y;
    private int missionID;

    private Location(double x, double y, int mID){
        this.x = x;
        this.y =y;
        this.missionID = mID;
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public int getMissionID() {
        return missionID;
    }
}
