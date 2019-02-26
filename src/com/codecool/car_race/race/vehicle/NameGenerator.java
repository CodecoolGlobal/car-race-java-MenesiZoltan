package com.codecool.car_race.race.vehicle;

import java.util.*;


public class NameGenerator {

    public ArrayList<String> carNameFirst = new ArrayList<>();
    public ArrayList<String> carNameSecond = new ArrayList<>();
    public ArrayList<Integer> truckNumbers = new ArrayList<>();

    public NameGenerator() {
        carNameFirst.add("Apex");
        carNameFirst.add("Deadly");
        carNameFirst.add("Shocking");
        carNameFirst.add("Freezing");
        carNameFirst.add("Burning");
        carNameFirst.add("Dirty");
        carNameFirst.add("Brooding");
        carNameFirst.add("Lurking");
        carNameFirst.add("Vivid");
        carNameFirst.add("Bloody");

        carNameSecond.add("Hunter");
        carNameSecond.add("Killer");
        carNameSecond.add("Striker");
        carNameSecond.add("Mirage");
        carNameSecond.add("Gibraltar");
        carNameSecond.add("Lifeline");
        carNameSecond.add("Bangalore");
        carNameSecond.add("Wraith");
        carNameSecond.add("Wanderer");
        carNameSecond.add("Champion");

        Collections.shuffle(carNameFirst);
        Collections.shuffle(carNameSecond);

    }

    public String getNthName(int index, ArrayList<String> nameList) {
        return nameList.get(index);
    }

    public String createTruckName() {
        Random rand = new Random();
        Integer truckNumber = rand.nextInt(1001);
        while (truckNumbers.contains(truckNumber)) {
            truckNumber = rand.nextInt(1001);
        }
        truckNumbers.add(truckNumber);
        return truckNumber.toString();
    }

}
