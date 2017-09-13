/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controlers;

import com.Klinik.Entities.dokterEntity;
import com.Klinik.Repositories.dokterRepository;
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
@RequestMapping(value="/dokter")
public class dokterControler {
    
    @Autowired
    private dokterRepository dokterRepo;
    
    @RequestMapping(value = "/newdokter",method =RequestMethod.POST )
    public ResponseEntity<dokterEntity> updateDokter(@RequestBody dokterEntity dokterEnt){
        dokterEntity newDok=dokterRepo.saveAndFlush(dokterEnt);
        return new ResponseEntity<>(newDok,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/alldokter",method = RequestMethod.GET)
    public ResponseEntity<List<dokterEntity>> allPasien(){
        List<dokterEntity> allDok=dokterRepo.findAll();
        return new ResponseEntity<>(allDok,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/id/{iddokter}", method = RequestMethod.GET)
    public ResponseEntity<dokterEntity> cariDokterById(@PathVariable long idDokter){
        dokterEntity dokter=dokterRepo.findOne(idDokter);
        return new ResponseEntity<>(dokter,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/nama/{namadokter}", method = RequestMethod.GET)
    public ResponseEntity<List<dokterEntity>> cariDokterByNama(@PathVariable String namadokter){
        List<dokterEntity> dokters=dokterRepo.findDokterEntitiesByNamaDokter(namadokter);
        return new ResponseEntity<>(dokters,HttpStatus.OK);
    }
}
