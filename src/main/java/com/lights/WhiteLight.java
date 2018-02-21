package com.lights;

import com.Light;

public class WhiteLight implements Light {

    private Boolean power;
    private Integer position;
    private String colour;

    public WhiteLight(String colour) {
        setColour(colour);
        setOff();
    }

    private void setColour(String colour) {
        this.colour = colour;
    }
    public void setOn() {
        this.power = true;
    }

    public void setOff() {
        this.power = false;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getColour() {
        return colour;
    }

    public Integer getPosition() {
        return position;
    }

    public Boolean getPower() {
        return power;
    }
}
