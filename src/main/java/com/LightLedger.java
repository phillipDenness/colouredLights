package com;

import java.util.ArrayList;

public class LightLedger {

    private ArrayList<String> colourSequence = new ArrayList();
    private Integer totalLightsCreated = 0;
    private Integer currentSequenceCount = 0;
    private ArrayList<Light> lights = new ArrayList();


    public void addColourToSequence(String colour) {
        colourSequence.add(colour.toLowerCase());
    }

    private Integer getSequenceLength() {
        return colourSequence.size();
    }

    public void addLights(Integer requiredLights, LightFactory lightFactory) {
        for (int n=0 ; n < requiredLights ; n++) {
            addLight(lightFactory);
        }
    }

    private void addLight(LightFactory lightFactory) {
        Integer sequenceLength = getSequenceLength();

        if (currentSequenceCount >= sequenceLength) {
            currentSequenceCount=0;
        }

        Light light = lightFactory.getLight(colourSequence.get(currentSequenceCount));
        light.setPosition(totalLightsCreated+1);
        lights.add(light);

        currentSequenceCount++;
        totalLightsCreated++;
    }

    public ArrayList<Light> getLights() {
        return lights;
    }
}
