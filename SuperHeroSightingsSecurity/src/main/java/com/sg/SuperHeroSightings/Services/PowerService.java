/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SuperHeroSightings.Services;

import com.sg.SuperHeroSightings.Dto.Power;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public interface PowerService {
    
   //Create
   public Power create(Power power);
 
   //ReadAll
   public List<Power> readAll();
 
   //ReadByID
   public Power readByID(int powerID);
 
   //Update
   public void update(Power power);
 
   //Delete
   public void delete(int powerID);
 
}
