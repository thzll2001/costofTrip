package com.david.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Route implements Serializable {

    private int toId;
    private double distance;
    private boolean exit ;
    private boolean enter;
    private String startDate;
    public void setToId(int toId) {
         this.toId = toId;
     }
     public int getToId() {
         return toId;
     }

    public void setDistance(double distance) {
         this.distance = distance;
     }
     public double getDistance() {
         return distance;
     }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}