package com;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class ReadUserInput {
    private Integer numberOfLights = null;
    private Scanner reader;
    private static final Logger log = Logger.getLogger(ReadUserInput.class.getName());

    private void validateInput() {
        if (this.numberOfLights!=null){
            if (this.numberOfLights<1){
                System.out.println("Please enter a number greater than 0");
                log.error("Number of lights must be above 1");
                promptUser();

            }
        }else{
            this.numberOfLights = 20;
            log.info("No input detected. Setting default value-"+this.numberOfLights);
        }
    }

    public void getUserInput() {

        reader = new Scanner(System.in);  // Reading from System.in

        promptUser();

        reader.close();
    }

    private void promptUser(){
        System.out.println("Enter number of lights (Default 20): ");
        this.numberOfLights = reader.nextInt();
        validateInput();
    }

    public Integer getNumberOfLights() {
        return numberOfLights;
    }
}
