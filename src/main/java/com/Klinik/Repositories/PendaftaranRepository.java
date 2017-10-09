/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Repositories;

import com.Klinik.Entities.PendaftaranEntity;
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
    
    public List<PendaftaranEntity> findPetugasPendaftaranEntitysByIdPendaftaran(Long idPetugasPendaftaran);
    
    @Query("select p from PendaftaranEntity p where p.usernamePendaftaran = ?1 and p.passwordPendaftaran = ?2")
    public Optional<PendaftaranEntity> findUsernameByUsername(String uname, String pwd);
}
