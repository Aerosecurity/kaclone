package com.mycompany.app.repository;

import java.util.List;
import java.util.UUID;

import com.mycompany.app.model.City;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, UUID>
{
    List<City> findByOwnerUuid(UUID ownerUuid);
}