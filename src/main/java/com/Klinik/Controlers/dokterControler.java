/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controlers;

import com.Klinik.Entities.dokterEntity;
import com.Klinik.Repositories.dokterRepository;
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
@RequestMapping(value="/dokter")
public class dokterControler {
    
    @Autowired
    private dokterRepository dokRepo;
    
    @RequestMapping(value = "/newdokter",method =RequestMethod.POST )
    public ResponseEntity<dokterEntity> updateDokter(@RequestBody dokterEntity dokterEnt){
        dokterEntity allDok=dokRepo.saveAndFlush(dokterEnt);
        return new ResponseEntity<>(allDok,HttpStatus.CREATED);
    }
}
