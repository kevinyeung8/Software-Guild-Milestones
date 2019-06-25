/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dao.OrganizationDao;
import com.sg.SuperHeroSightings.Dto.Organization;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinyeung
 */

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationDao organizationDao;

    @Override
    public Organization create(Organization organization) {
        return organizationDao.addNewOrganization(organization);
    }

    @Override
    public List<Organization> readAll() {
        return organizationDao.getAllOrganizations();
    }

    @Override
    public Organization readByID(int organizationID) {
        return organizationDao.getOrganizationByID(organizationID);
    }

    @Override
    public List<Organization> readAllBySuper(int superID) {
        return organizationDao.getOrganizationsBySuper(superID);
    }

    @Override
    public void update(Organization organization) {
        organizationDao.updateOrganization(organization);
    }

    @Override
    public void delete(int organizationID) {
        organizationDao.deleteOrganization(organizationID);
    }

}
