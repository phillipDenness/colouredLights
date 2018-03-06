package com;

import org.apache.log4j.BasicConfigurator;

import java.io.Console;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

/*
        The number of lights should be configurable on the command line with a default value of 20.
        The set of lights will be made up of a repeating set of colours in a fixed order (e.g red, green, white)
        When you run the program, it should turn each light in the set on for 1 second and then turn it off.
        The output of the program should be formatted as follows: {HH:MM:SS} {light no / postion} {colour} Light {light state}
        12:00:01: 1 Red Light On 12:00:02: 1 Red Light Off 12:00:02: 2 Green Light On 12:00:03: 2 Green Light Off 12:00:03: 3 White Light On 12:00:04: 3 White Light Off etc. etc.
        The sequence should continue in a loop until the program is interrupted.
        Design the program so that it would be easy to modify the colours and the number of colours that make up the set of lights using object oriented techniques. (e.g. blue, red, yellow, white).
*/

        ReadUserInput readUserInput = new ReadUserInput();
        readUserInput.getUserInput();

        LightFactory lightFactory = new LightFactory();


        LightLedger lightLedger = new LightLedger();
        lightLedger.addColourToSequence("Red");
        lightLedger.addColourToSequence("Green");
        lightLedger.addColourToSequence("White");

        lightLedger.addLights(readUserInput.getNumberOfLights(), lightFactory);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

        for (Light light : lightLedger.getLights()) {
            HandlePower handleLightPower = new HandlePower(light);
            executor.scheduleAtFixedRate(handleLightPower, 0, 1, TimeUnit.SECONDS);
        }

        ScheduledExecutorService publisher = Executors.newScheduledThreadPool(1);

        HandleOutput handleOutput = new HandleOutput(lightLedger.getLights());
        publisher.scheduleAtFixedRate(handleOutput, 0, 1, TimeUnit.SECONDS);

    }

}
