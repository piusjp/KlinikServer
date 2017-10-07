/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Repositories;

import com.Klinik.Entities.PendaftaranEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author HP
 */
@RestResource
public interface PendaftaranRepository extends JpaRepository<PendaftaranEntity, Long>{
    
    public List<PendaftaranEntity> findPetugasPendaftaranEntitysByIdPetugasPendaftaran(Long idPetugasPendaftaran);
    
    @Query("select username from pendaftaranEntity where username=?1 and password=?2")
    public Optional<PendaftaranEntity> findUsernameByUsername(String uname, String pwd);
}
