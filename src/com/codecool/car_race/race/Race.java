package com.codecool.car_race.race;

import com.codecool.car_race.race.vehicle.Bike;
import com.codecool.car_race.race.vehicle.Car;
import com.codecool.car_race.race.vehicle.NameGenerator;
import com.codecool.car_race.race.vehicle.Truck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Race {

    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Bike> bikes = new ArrayList<>();
    private ArrayList<Truck> trucks = new ArrayList<>();
    private boolean rain;
    private boolean brokenTruck;
    private int currentLap;
    private int maxLaps;
    private HashMap<String, Integer> raceResult = new HashMap<String, Integer>();

    public Race() {
        rain = false;
        brokenTruck = false;
        currentLap = 0;
        maxLaps = 50;
    }


    public void generateCars(Race race, NameGenerator generator) {
        for (int i = 0; i < 10; i++) {
            Car car = new Car(race, generator);
            cars.add(car);
        }
    }


    public void generateBikes(Race race, NameGenerator generator) {
        for (int i = 0; i < 10; i++) {
            Bike bike = new Bike(race, generator);
            bikes.add(bike);
        }
    }


    public void generateTrucks(Race race, NameGenerator generator) {
        for (int i = 0; i < 10; i++) {
            Truck truck = new Truck(race, generator);
            trucks.add(truck);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Bike> getBikes() {
        return bikes;
    }

    private void nextLap() {
        currentLap += 1;
        setWeather();
    }

    private void setWeather() {
        Random rand = new Random();
        int rainChance = rand.nextInt(101);

        if (rainChance >= 70) {
            rain = true;
        } else {
            rain = false;
        }
    }


    private void setBrokenTruckStatus() {
        for (Truck truck : trucks) {
            if (truck.engineStatus()) {
                brokenTruck = true;
                break;
            }
        }
    }

    public boolean getWeather() {
        return rain;
    }

    public boolean getBrokenTruck() {
        return brokenTruck;
    }

    private void startNextLap(Race race) {
        for (Truck truck : trucks) {
            truck.prepForLap(race);
            truck.travelForAnHour();
        }
        for (Car car : cars) {
            car.prepForLap(race);
            car.travelForAnHour();
        }
        for (Bike bike : bikes) {
            bike.prepForLap(race);
            bike.travelForAnHour();
        }
    }

    public void simulateRace() {

        while (currentLap < maxLaps) {
            nextLap();
            setWeather();
            setBrokenTruckStatus();
            startNextLap(this);
        }
        setResults();
    }


    private void setResults() {
        for (Car car: cars) {
            Integer distance = car.getDistanceTraveled();
            raceResult.put(car.getName(), distance);
        }

        for (Bike bike: bikes) {
            Integer distance = bike.getDistanceTraveled();
            raceResult.put(bike.getName(), distance);
        }

        for (Truck truck: trucks) {
            Integer distance = truck.getDistanceTraveled();
            raceResult.put(truck.getName(), distance);
        }
    }


    public void printRaceResults() {
        for (Map.Entry<String, Integer> entry : raceResult.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Distance travelled by " + key + ": " + value.toString());
        }
    }

}
