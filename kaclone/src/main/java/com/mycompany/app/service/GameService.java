package com.mycompany.app.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.mycompany.app.model.City;
import com.mycompany.app.repository.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private CityRepository cityRepository;

    public City buildCity(String name, UUID owner) {
        City city = new City(name, owner);
        city = cityRepository.save(city);
        return city;
    }

    public List<City> listCitiesForOwner(UUID owner) {
        return cityRepository.findByOwnerUuid(owner);
    }

    public City getCity(UUID uuid) {
        return cityRepository.findById(uuid).get();
    }

    public City buildFood(UUID uuid) {
        Date now = new Date();

        City city = getCity(uuid);

        int production = city.getFood();
        int stored = city.getFoodStored();
        Date lastUpdate = city.getFoodLastSaved();

        int newStored = calculateNewStorage(stored, production, (now.getTime() - lastUpdate.getTime()));

        city.setFood(production + 1);
        city.setFoodStored(newStored);
        city.setFoodLastSaved(now);

        city = cityRepository.save(city);
        return city;
    }

    public City buildWood(UUID uuid) {
        Date now = new Date();

        City city = getCity(uuid);

        int production = city.getWood();
        int stored = city.getWoodStored();
        Date lastUpdate = city.getWoodLastSaved();

        int newStored = calculateNewStorage(stored, production, (now.getTime() - lastUpdate.getTime()));

        city.setWood(production + 1);
        city.setWoodStored(newStored);
        city.setWoodLastSaved(now);

        city = cityRepository.save(city);
        return city;
    }

    public City buildMetal(UUID uuid) {
        Date now = new Date();

        City city = getCity(uuid);

        int production = city.getMetal();
        int stored = city.getMetalStored();
        Date lastUpdate = city.getMetalLastSaved();

        int newStored = calculateNewStorage(stored, production, (now.getTime() - lastUpdate.getTime()));

        city.setMetal(production + 1);
        city.setMetalStored(newStored);
        city.setMetalLastSaved(now);

        city = cityRepository.save(city);
        return city;
    }

    private int calculateNewStorage(int current, int production, long timeDifferenceMs)
    {
        // plus 1 for free
        return (int)(timeDifferenceMs / 1000.0 * production + current) + 1;
    }
}