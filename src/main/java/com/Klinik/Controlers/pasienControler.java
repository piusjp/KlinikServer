/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controlers;

import com.Klinik.Entities.pasienEntity;
import com.Klinik.Repositories.pasienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping(value = "/pasien")
public class pasienControler {
    
    @Autowired
    public pasienRepository pasRepo;
    
    @RequestMapping(value = "/newpasien", method = RequestMethod.POST)
    public ResponseEntity<pasienEntity> updatePasien(@RequestBody pasienEntity pasienEnt ){
        pasienEntity allPasien=pasRepo.saveAndFlush(pasienEnt);
        return new ResponseEntity<>(allPasien,HttpStatus.CREATED);
    }
}
