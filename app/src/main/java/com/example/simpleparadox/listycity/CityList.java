package com.example.simpleparadox.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityList {

    private List<City> cities = new ArrayList<>();


    public void add(City city) {
        if (this.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    public boolean hasCity(City city) {
        return this.contains(city);
    }

    public void delete(City city) {
        if (!this.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    public int countCities() {
        return cities.size();
    }

    public boolean contains(City city) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).compareTo(city) == 0) {
                return true;
            }
        }
        return false;
    }
}
