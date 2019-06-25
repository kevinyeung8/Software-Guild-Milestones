/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dao.SightingDao;
import com.sg.SuperHeroSightings.Dto.Sighting;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinyeung
 */
@Service
public class SightingServiceImpl implements SightingService {

    @Autowired
    SightingDao sightingDao;

    @Override
   public Sighting create(Sighting sighting) {
       return sightingDao.addNewSighting(sighting);
   }
 
   @Override
   public List<Sighting> readAll() {
       return sightingDao.getAllSightings();
   }
 
   @Override
   public Sighting readByID(int sightingID) {
       return sightingDao.getSightingByID(sightingID);
   }
 
   @Override
   public List<Sighting> readSightingsByDate(LocalDate date) {
       return sightingDao.getSightingsByDate(date);
   }
 
   @Override
   public void update(Sighting sighting) {
       sightingDao.updateSighting(sighting);
   }
 
   @Override
   public void delete(int sightingID) {
       sightingDao.deleteSighting(sightingID);
   }
 
}