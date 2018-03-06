package com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;

public class HandleOutput implements Runnable{
    private ArrayList<Light> lights;
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private Integer lightIndex = 0;
    private Long iterations = 0L;
    private Date date;
    private static final Logger log = Logger.getLogger(HandleOutput.class.getName());

    HandleOutput(ArrayList<Light> lights) {
        this.lights = lights;
    }

    private void updateLightIndex(){
        this.iterations++;

        if (iterations%2==0){
            this.lightIndex++;
            if (lightIndex >= lights.size()){
                this.lightIndex = 0;
            }
        }
        log.debug("Light Index: "+ lightIndex);
    }

    public void run() {
            updateLightIndex();

            Light light = lights.get(lightIndex);
            date = new Date();

            //{HH:MM:SS} {light no / postion} {colour} Light {light state}
            System.out.println(dateFormat.format(date) + ": " + light.getPosition() + " " + toCamelCase(light.getColour())+" Light "+ toVerbosePower(light.getPower()));
    }

    private static String toVerbosePower(Boolean power){
        if (power){
            return "On";
        }else{
            return "Off";
        }
    }

    private static String toCamelCase(String s){
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    private static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }
}
