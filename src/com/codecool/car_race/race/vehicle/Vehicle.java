package com.codecool.car_race.race.vehicle;

import com.codecool.car_race.race.Race;

import java.util.Random;

public abstract class Vehicle {
    private int minSpeed;
    private int maxSpeed;
    private int currentSpeed;
    private String name;
    private int distanceTraveled;

    public abstract void prepForLap(Race race);

    public abstract String generateName(Race race, NameGenerator generator);

    void setSpeedLimits(int a, int b) {
        minSpeed = a;
        maxSpeed = b;
    }

    private int generateSpeed(int minSpeed, int maxSpeed) {
        Random rand = new Random();
        int speed = rand.nextInt(maxSpeed - minSpeed + 1);
        return speed;
    }

    void setCurrentSpeed(int minSpeed, int maxSpeed) {
        currentSpeed = (generateSpeed(minSpeed, maxSpeed) + minSpeed);
    }

    void setCurrentSpeed(int speed) {
        currentSpeed = speed;
    }

    public void travelForAnHour() {
        distanceTraveled += currentSpeed;
    }

    void setName (String vehicleName) {
        name = vehicleName;
    }

    public String getName() {
        return name;
    }

    int getMinSpeed() {
        return minSpeed;
    }

    int getMaxSpeed() {
        return maxSpeed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

}
