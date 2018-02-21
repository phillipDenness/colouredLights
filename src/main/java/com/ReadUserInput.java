package com;

import java.io.Console;
import java.util.Scanner;

public class ReadUserInput {
    private Integer numberOfLights = null;
    private Scanner reader;

    private void validateInput() {
        if (this.numberOfLights!=null){
            if (this.numberOfLights<1){
                System.out.println("Please enter a number greater than 0");
                promptUser();
            }
        }else{
            this.numberOfLights = 20;
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
