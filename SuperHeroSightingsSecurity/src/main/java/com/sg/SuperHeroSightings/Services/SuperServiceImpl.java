/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dao.SuperDao;
import com.sg.SuperHeroSightings.Dto.Super;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinyeung
 */
@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    SuperDao superDao;

    @Override
    public Super create(Super s) {
        return superDao.addNewSuper(s);
    }

    @Override
    public List<Super> readAll() {
        return superDao.getAllSupers();
    }

    @Override
    public Super readByID(int superID) {
        return superDao.getSuperByID(superID);
    }

    @Override
    public List<Super> readSupersByOrganization(int organizationID) {
        return superDao.getAllSupersByOrganization(organizationID);
    }

    @Override
    public List<Super> readSupersByLocation(int locationID) {
        return superDao.getSupersByLocation(locationID);
    }

    @Override
    public void update(Super s) {
        superDao.updateSuper(s);
    }

    @Override
    public void delete(int superID) {
        superDao.deleteSuper(superID);
    }

}
