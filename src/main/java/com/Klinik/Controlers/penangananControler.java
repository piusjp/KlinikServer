/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controlers;

import com.Klinik.Entities.penangananEntity;
import com.Klinik.Repositories.penangananRepository;
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
public class penangananControler {
    
    @Autowired
    public penangananRepository penangananRepo;
    
    @RequestMapping(value = "/newpenanganan",method = RequestMethod.POST)
    public ResponseEntity<penangananEntity> updatePenanganan(@RequestBody penangananEntity penangananEnt){
        penangananEntity allPenanganan=penangananRepo.saveAndFlush(penangananEnt);
        return new ResponseEntity<>(allPenanganan,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/allpenanganan",method = RequestMethod.GET)
    public ResponseEntity<List<penangananEntity>> allpenanganan(){
        List<penangananEntity> allpenanganan=penangananRepo.findAll();
        return new ResponseEntity<>(allpenanganan,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/id/{idPenanganan}",method = RequestMethod.GET)
    public ResponseEntity<penangananEntity> cariPenangananById(@PathVariable Long idPenanganan){
        penangananEntity penanganan=penangananRepo.findOne(idPenanganan);
        return new ResponseEntity<>(penanganan,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/nama/{namaPenanganan}",method = RequestMethod.GET)
    public ResponseEntity<List<penangananEntity>> cariPenangananByNama(@PathVariable String namaPenanganan){
        List<penangananEntity> penanganans=penangananRepo.findPenangananEntitiesByNamaPenanganan(namaPenanganan);
        return new ResponseEntity<>(penanganans,HttpStatus.OK);
    }
}
