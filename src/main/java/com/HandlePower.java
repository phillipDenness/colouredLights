package com;

import org.apache.log4j.Logger;

public class HandlePower implements Runnable {
    private static final Logger log = Logger.getLogger(HandlePower.class.getName());

    private Boolean previousState = false;
    private Light light;

    public HandlePower(Light light) {
        this.light = light;
        log.debug("Light added to light handler-" + light);
    }

    public void run() {
        if(previousState){

            light.setOff();
            this.previousState = false;
            log.debug(light + "-is Off");
        }else {

            light.setOn();
            this.previousState = true;
            log.debug(light + "-is On");
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
