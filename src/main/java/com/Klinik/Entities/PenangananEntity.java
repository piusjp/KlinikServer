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
public class PenangananEntity{

    public PenangananEntity() {
    }
    
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPenanganan;
    
    @Column
    private String idPasien;
    
    @Column
    private String idDokter;
    
    @Column
    private String waktuPenanganan;
    
    @Column
    private String biayaPenanganan;
    
    @Column
    private String ruangPenanganan;
    
    @Column
    private String keluhanPenanganan;
    
    @Column
    private String jenisPenyakit;
    
    @Column
    private String resepObat;
}
