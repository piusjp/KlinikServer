/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controllers;

import com.Klinik.Entities.PasienEntity;
import com.Klinik.Repositories.PasienRepository;
import java.util.List;
import javax.xml.ws.Response;
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
@RequestMapping(value = "/pasien")
public class PasienController {
    
    @Autowired
    public PasienRepository pasienRepo;
    
    @RequestMapping(value = "/newpasien", method = RequestMethod.POST)
    public ResponseEntity<PasienEntity> updatePasien(@RequestBody PasienEntity pasienEnt ){
        PasienEntity allPasien=pasienRepo.saveAndFlush(pasienEnt);
        return new ResponseEntity<>(allPasien,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/allpasien",method = RequestMethod.GET)
    public ResponseEntity<List<PasienEntity>> allpasien(){
        List<PasienEntity> allpasien=pasienRepo.findAll();
        return new ResponseEntity<>(allpasien,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/id/{idPasien}",method = RequestMethod.GET)
    public ResponseEntity<PasienEntity> cariPasienById(@PathVariable Long idPasien){
        PasienEntity pasien=pasienRepo.findOne(idPasien);
        return new ResponseEntity<>(pasien,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/nama/{namaPasien}",method = RequestMethod.GET)
    public ResponseEntity<List<PasienEntity>> cariPasienByNama(@PathVariable String namaPasien){
        List<PasienEntity> pasiens=pasienRepo.findPasienEntitiesByNamaPasien(namaPasien);
        return new ResponseEntity<>(pasiens,HttpStatus.OK);
    }
    
}
