package com.codecool.car_race.race.vehicle;

import com.codecool.car_race.race.Race;

public class Bike extends Vehicle {

    public Bike(Race race, NameGenerator generator) {
        setSpeedLimits(100, 100);
        setName(generateName(race, generator));
    }

    private void checkWeather(Race race) {
        if (race.getWeather()) {
            setCurrentSpeed(5, 50);
        } else {
            setCurrentSpeed(100);
        }
    }


    @Override
    public void prepForLap(Race race) {
        checkWeather(race);
    }

    @Override
    public String generateName(Race race, NameGenerator generator) {
        String temp = "Bike number: ";
        String temp2 = String.valueOf(race.getBikes().size() + 1);
        return temp + temp2;
    }
}
