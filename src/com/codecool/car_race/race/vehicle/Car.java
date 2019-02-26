package com.codecool.car_race.race.vehicle;


import com.codecool.car_race.race.Race;

public class Car extends Vehicle {

    public Car(Race race, NameGenerator generator) {
        setSpeedLimits(80, 110);
        setName(generateName(race, generator));
    }


    private void isThereABrokenTruck(Race race) {
        if(race.getBrokenTruck()) {
            setCurrentSpeed(80);
        } else {
            setCurrentSpeed(getMinSpeed(), getMaxSpeed());
        }
    }


    @Override
    public void prepForLap(Race race) {
        isThereABrokenTruck(race);
    }

    @Override
    public String generateName(Race race, NameGenerator generator) {

        String carName1 = generator.getNthName(race.getCars().size(), generator.carNameFirst);
        String carName2 = generator.getNthName(race.getCars().size(), generator.carNameSecond);
        String fullName = carName1 + " " + carName2;
        return fullName;
    }

}
