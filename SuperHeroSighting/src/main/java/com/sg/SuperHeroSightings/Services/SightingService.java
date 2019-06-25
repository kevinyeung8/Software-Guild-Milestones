/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dto.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public interface SightingService {

   //Create
   public Sighting create(Sighting sighting);
 
   //Read All
   public List<Sighting> readAll();
 
   //Read By ID
   public Sighting readByID(int sightingID);
 
   
   public List<Sighting> readSightingsByDate(LocalDate date);
 
   //Update
   public void update(Sighting sighting);
 
   //Delete
   public void delete(int sightingID);
}