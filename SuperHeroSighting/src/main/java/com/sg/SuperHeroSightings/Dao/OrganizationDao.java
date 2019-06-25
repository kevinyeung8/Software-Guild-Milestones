/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Dao;

import com.sg.SuperHeroSightings.Dto.Organization;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public interface OrganizationDao {

    //CRUD
    
    //Create
    public Organization addNewOrganization(Organization organization);

    //Read All
    public List<Organization> getAllOrganizations();

    //Read By ID
    public Organization getOrganizationByID(int organizationID);

    //Update
    public Boolean updateOrganization(Organization organization);

    //Delete
    public Boolean deleteOrganization(int organizationID);

    //Returns a List of Organizations that a Super belongs to
    public List<Organization> getOrganizationsBySuper(int superID);

}
