/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dao.LocationDao;
import com.sg.SuperHeroSightings.Dto.Location;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinyeung
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationDao locationDao;

    @Override
    public Location create(Location location) {
        return locationDao.addNewLocation(location);
    }

    @Override
    public List<Location> readAll() {
        return locationDao.getAllLocations();
    }

    @Override
    public Location readByID(int locationID) {
        return locationDao.getLocationByID(locationID);
    }

    @Override
    public List<Location> readLocationsBySuper(int superID) {
        return locationDao.getLocationsBySuper(superID);
    }

    @Override
    public void update(Location location) {
        locationDao.updateLocation(location);
    }

    @Override
    public void delete(int locationID) {
        locationDao.deleteLocation(locationID);
    }

}
