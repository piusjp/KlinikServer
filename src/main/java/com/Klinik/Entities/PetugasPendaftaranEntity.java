/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Klinik.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author HP
 */
@Entity
@Data
public class PetugasPendaftaranEntity {
    
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPetugasPendaftaran;
    
    @Column
    private String namaPetugasPendaftaran;
    
    @Column
    private String ktpPetugasPendaftaran;
    
    @Column
    private String usernamePetugasPendaftaran;
    
    @Column
    private String passwordPetugasPendaftaran;
}
