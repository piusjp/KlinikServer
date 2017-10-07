/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controllers;

import com.Klinik.Entities.PenangananEntity;
import com.Klinik.Repositories.PenangananRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
public class PenangananController {
    
    @Autowired
    public PenangananRepository penangananRepo;
    
    @RequestMapping(value = "/newpenanganan",method = RequestMethod.POST)
    public ResponseEntity<PenangananEntity> updatePenanganan(@RequestBody PenangananEntity penangananEnt){
        PenangananEntity allPenanganan=penangananRepo.saveAndFlush(penangananEnt);
        return new ResponseEntity<>(allPenanganan,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/allpenanganan",method = RequestMethod.GET)
    public ResponseEntity<List<PenangananEntity>> allpenanganan(){
        List<PenangananEntity> allpenanganan=penangananRepo.findAll();
        return new ResponseEntity<>(allpenanganan,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/id/{idPenanganan}",method = RequestMethod.GET)
    public ResponseEntity<PenangananEntity> cariPenangananById(@PathVariable Long idPenanganan){
        PenangananEntity penanganan=penangananRepo.findOne(idPenanganan);
        return new ResponseEntity<>(penanganan,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/waktu/{waktuPenanganan}",method = RequestMethod.GET)
    public ResponseEntity<List<PenangananEntity>> cariPenangananByNama(@PathVariable String waktuPenanganan){
        List<PenangananEntity> penanganans=penangananRepo.findPenangananEntitiesByWaktuPenanganan(waktuPenanganan);
        return new ResponseEntity<>(penanganans,HttpStatus.OK);
    }
}
