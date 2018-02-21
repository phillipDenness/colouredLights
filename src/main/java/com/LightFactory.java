package com;

import com.lights.GreenLight;
import com.lights.RedLight;
import com.lights.WhiteLight;

public class LightFactory {

    public Light getLight(String colour) {
        if (colour.toLowerCase().contains("red")){
            return new RedLight(colour);

        }else if(colour.toLowerCase().contains("green")){
            return new GreenLight(colour);

        }else if(colour.toLowerCase().contains("white")){
            return new WhiteLight(colour);

        }
        return null;
    }

}
