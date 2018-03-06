package com;

import com.lights.GreenLight;
import com.lights.RedLight;
import com.lights.WhiteLight;
import org.apache.log4j.Logger;

public class LightFactory {
    private static final Logger log = Logger.getLogger(LightFactory.class.getName());

    public Light getLight(String colour) {
        if (colour.toLowerCase().contains("red")){
            log.debug("Return red " + colour +" light");
            return new RedLight(colour);

        }else if(colour.toLowerCase().contains("green")){
            log.debug("Return red " + colour +" light");
            return new GreenLight(colour);

        }else if(colour.toLowerCase().contains("white")){
            log.debug("Return red " + colour +" light");
            return new WhiteLight(colour);

        }

        log.error("Light colour does not exist");
        return null;
    }

}
