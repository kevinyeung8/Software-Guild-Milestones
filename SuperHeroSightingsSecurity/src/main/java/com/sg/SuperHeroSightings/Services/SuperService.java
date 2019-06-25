/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dto.Super;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public interface SuperService {

    //Create
    public Super create(Super s);

    //Read All
    public List<Super> readAll();

    //Read By ID
    public Super readByID(int superID);

    //Returns a List of Supers for a particular Organization
    public List<Super> readSupersByOrganization(int organizationID);

    //Returns a List of Supers spotted in a specific Location
    public List<Super> readSupersByLocation(int locationID);

    //Update
    public void update(Super s);

    //Delete
    public void delete(int superID);

}
