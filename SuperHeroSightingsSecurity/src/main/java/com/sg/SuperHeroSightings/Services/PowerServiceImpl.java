/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dao.PowerDao;
import com.sg.SuperHeroSightings.Dto.Power;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinyeung
 */
@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    PowerDao powerDao;

    @Override
    public Power create(Power power) {
        return powerDao.addNewPower(power);
    }

    @Override
    public List<Power> readAll() {
        return powerDao.getAllPowers();
    }

    @Override
    public Power readByID(int powerID) {
        return powerDao.getPowerByID(powerID);
    }

    @Override
    public void update(Power power) {
        powerDao.updatePower(power);
    }

    @Override
    public void delete(int powerID) {
        powerDao.deletePower(powerID);
    }

}
