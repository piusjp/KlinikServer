/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controlers;

import com.Klinik.Entities.penangananEntity;
import com.Klinik.Repositories.penangananRepository;
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
@RequestMapping(value = "/penanganan")
public class penangananControler {
    
    @Autowired
    public penangananRepository penangananRepo;
    
    @RequestMapping(value = "/newpenanganan",method = RequestMethod.POST)
    public ResponseEntity<penangananEntity> updatePenanganan(@RequestBody penangananEntity penangananEnt){
        penangananEntity allPenanganan=penangananRepo.saveAndFlush(penangananEnt);
        return new ResponseEntity<>(allPenanganan,HttpStatus.CREATED);
    }
}
