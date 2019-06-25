/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dto.Location;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public interface LocationService {
    
   //Create
   public Location create(Location location);
 
   //Read All
   public List<Location> readAll();
 
   //Read By ID
   public Location readByID(int locationID);
   
   //Returns a List of Locations that a specific Super has been spotted in
   public List<Location> readLocationsBySuper(int superID);
 
   //Update
   public void update(Location location);
 
   //Delete
   public void delete(int locationID);
   
}
