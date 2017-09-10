/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controlers;

import com.Klinik.Entities.pasienEntity;
import com.Klinik.Repositories.pasienRepository;
import java.util.List;
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
    public pasienRepository pasienRepo;
    
    @RequestMapping(value = "/newpasien", method = RequestMethod.POST)
    public ResponseEntity<pasienEntity> updatePasien(@RequestBody pasienEntity pasienEnt ){
        pasienEntity allPasien=pasienRepo.saveAndFlush(pasienEnt);
        return new ResponseEntity<>(allPasien,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/allpasien",method = RequestMethod.GET)
    public ResponseEntity<List<pasienEntity>> allpasien(){
        List<pasienEntity> allpasien=pasienRepo.findAll();
        return new ResponseEntity<>(allpasien,HttpStatus.OK);
    }
}
