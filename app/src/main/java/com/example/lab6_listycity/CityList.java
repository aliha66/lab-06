package com.example.lab6_listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
This class holds our City type objects
 **/
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param c
     * This is a candidate city to add
     **/

    public void add(City c) {
        if (cities.contains(c)) {
            throw new IllegalArgumentException();
        }
        cities.add(c);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if a given city is already in the list
     * @param c
     * @return
     * Return true if the city is in the list
     */
    public boolean hasCity(City c) { // check if the city is in the list
        return cities.contains(c); // return true if the city is in the list
    }

    /**
     * This removes a city from the list if it doesn't already exist
     * @param c
     * This is the city to remove
     */
    public void remove(City c) {
        if (!cities.contains(c)) { // check if the city is in the list
            throw new IllegalArgumentException(); // if the city is NOT in the list throw an exception
        }
        cities.remove(c); // remove the city from the list
    }

    /**
     * This returns the total number of cities in the list
     * @return
     * Return the number of cities in the list
     */
    public int countCities() {
        return cities.size(); // return the number of cities in the list
    }

}
