/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Dao;

import com.sg.SuperHeroSightings.Dto.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public interface SightingDao {

    //Create
    public Sighting addNewSighting(Sighting sighting);

    //Read All
    public List<Sighting> getAllSightings();

    //Read By ID
    public Sighting getSightingByID(int sightingID);

    //Update
    public void updateSighting(Sighting sighting);

    //Delete
    public void deleteSighting(int sightingID);

    //Returns a List of Sightings for a specific Date
    public List<Sighting> getSightingsByDate(LocalDate date);

}
