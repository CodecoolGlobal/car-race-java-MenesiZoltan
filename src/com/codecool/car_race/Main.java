package com.codecool.car_race;


import com.codecool.car_race.race.Race;
import com.codecool.car_race.race.vehicle.Car;
import com.codecool.car_race.race.vehicle.NameGenerator;

public class Main {


    private static void createVehicles(Race race) {
        NameGenerator generator = new NameGenerator();
        race.generateCars(race, generator);
        race.generateBikes(race, generator);
        race.generateTrucks(race, generator);
    }

    public static void main(String[] args) {
        Race race = new Race();
        createVehicles(race);

        race.simulateRace();
        race.printRaceResults();
    }
}
