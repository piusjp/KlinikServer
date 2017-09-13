/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Repositories;

import com.Klinik.Entities.penangananEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP
 */
@RestResource
public interface penangananRepository extends JpaRepository<penangananEntity, Long>{
    
    public List<penangananEntity> findPenangananEntitiesByNamaPenanganan(String namaPenanganan);
}
