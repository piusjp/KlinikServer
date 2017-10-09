/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Repositories;

import com.Klinik.Entities.PenangananEntity;
import com.Klinik.Entities.PenangananEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author HP
 */
@RestResource
public interface PenangananRepository extends JpaRepository<PenangananEntity, Long>{
    
    public List<PenangananEntity> findPenangananEntitiesByWaktuPenanganan(String namaPenanganan);
}
