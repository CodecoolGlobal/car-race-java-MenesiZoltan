package com.codecool.car_race.race.vehicle;

import com.codecool.car_race.race.Race;

import java.util.Random;

public class Truck extends Vehicle {

    private boolean isBroken;
    private int breakdownCounter;

    public Truck(Race race, NameGenerator generator) {
        setSpeedLimits(100, 100);
        breakdownCounter = 0;
        isBroken = false;
        setName(generateName(race, generator));
    }


    private void breakDownChance() {
        Random rand = new Random();
        int breakdownMeter = rand.nextInt(101);
        if (breakdownMeter > 95) {
            isBroken = true;
            breakdownCounter = 2;
            setCurrentSpeed(0);
        } else {
            setCurrentSpeed(100);
            isBroken = false;
        }
    }

    public boolean engineStatus() {
        return isBroken;
    }


    @Override
    public void prepForLap(Race race) {
        if (isBroken && breakdownCounter == 1 || breakdownCounter == 2) {
            breakdownCounter -= 1;
        } else {
            breakDownChance();
        }
    }

    @Override
    public String generateName(Race race, NameGenerator generator) {
        return generator.createTruckName();
    }
}
