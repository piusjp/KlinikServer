/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Controllers;

import com.Klinik.Entities.PendaftaranEntity;
import com.Klinik.Services.PendaftaranService;
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
@RequestMapping(value = "/petugaspendaftaran")
public class PendaftaranController {
    
    @Autowired
    public PendaftaranService petugasPendaftaranServ;
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<PendaftaranEntity> login(@RequestBody PendaftaranEntity dataPetugas){
        if(petugasPendaftaranServ.login(dataPetugas)==true)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
