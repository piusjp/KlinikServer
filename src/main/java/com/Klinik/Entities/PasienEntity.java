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
public class PasienEntity {

    public PasienEntity() {
    }
    
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPasien;
    
    @Column
    private String ktpPasien;
    
    @Column
    private String namaPasien;
    
    @Column
    private String alamatPasien;
    
    @Column
    private String kontakPasien;
    
    @Column
    private String tanggalLahirPasien;
    
    @Column
    private String tempatLahirPasien;
}
