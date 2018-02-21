package com;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HandlePower implements Runnable {

    private Boolean previousState = false;
    private Light light;

    public HandlePower(Light light) {
        this.light = light;
    }

    public void run() {
        if(previousState){

            light.setOff();
            this.previousState = false;

        }else {

            light.setOn();
            this.previousState = true;

        }
    }

   /* public void run() {
        for (Light light : lights){
            if(previousState){

                light.setOff();
                this.previousState = false;

                    }else {

                light.setOn();
                this.previousState = true;

            }
        }
        Light light = lights.get(0);
        Date date = new Date();
        System.out.println(dateFormat.format(date) + ": " + light.getPosition() + " " + light.getColour()+" Light "+ light.getPower().toString());

    }*/
}
