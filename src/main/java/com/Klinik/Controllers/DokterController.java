/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controllers;

import com.Klinik.Entities.DokterEntity;
import com.Klinik.Repositories.DokterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
public class DokterController {
    
    @Autowired
    private DokterRepository dokterRepo;
    
    @RequestMapping(value = "/newdokter",method =RequestMethod.POST )
    public ResponseEntity<DokterEntity> updateDokter(@RequestBody DokterEntity dokterEnt){
        DokterEntity newDok=dokterRepo.saveAndFlush(dokterEnt);
        return new ResponseEntity<>(newDok,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/alldokter",method = RequestMethod.GET)
    public ResponseEntity<List<DokterEntity>> allPasien(){
        List<DokterEntity> allDok=dokterRepo.findAll();
        return new ResponseEntity<>(allDok,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/id/{idDokter}", method = RequestMethod.GET)
    public ResponseEntity<DokterEntity> cariDokterById(@PathVariable Long idDokter){
        DokterEntity dokter=dokterRepo.findOne(idDokter);
        return new ResponseEntity<>(dokter,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/nama/{namaDokter}", method = RequestMethod.GET)
    public ResponseEntity<List<DokterEntity>> cariDokterByNama(@PathVariable String namaDokter){
        List<DokterEntity> dokters=dokterRepo.findDokterEntitiesByNamaDokter(namaDokter);
        return new ResponseEntity<>(dokters,HttpStatus.OK);
    }
}
