/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dto.Organization;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public interface OrganizationService {

    //Create
    public Organization create(Organization organization);

    //Real All
    public List<Organization> readAll();

    //Read By ID
    public Organization readByID(int organizationID);

    //Returns a List of Organizations that a Super belongs to
    public List<Organization> readAllBySuper(int superID);

    //Update
    public void update(Organization organization);

    //Delete
    public void delete(int organizationID);
}

