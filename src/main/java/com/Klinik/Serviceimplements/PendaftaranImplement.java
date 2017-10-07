/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Serviceimplements;

import com.Klinik.Entities.PendaftaranEntity;
import com.Klinik.Repositories.PendaftaranRepository;
import com.Klinik.Services.PendaftaranService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service("petugasPendaftaran")
@Transactional
public class PendaftaranImplement implements PendaftaranService{
    
    @Autowired
    private PendaftaranRepository petugasPendaftaranRepo;
    
    public boolean login (PendaftaranEntity dataPetugas){
        Optional<PendaftaranEntity> result = petugasPendaftaranRepo.findUsernameByUsername(dataPetugas.getUsernamePendaftaran(), dataPetugas.getPasswordPendaftaran());
        if(result.isPresent()){
            return true;
        }else{
            return false;
        }
    }
    
}
