/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.GestionePrigione;

import java.time.LocalDate;

/**
 *
 * @author Gian
 */
public class AddettiMensa {
    private String nomeAM;
    private String cognomeAM;
    private LocalDate datadinascitaAM;
    private String internoMensa;
    private AddettiMensa listaAM [] = new AddettiMensa [100];

    public AddettiMensa(String nomeAM, String cognomeAM, LocalDate datadinascitaAM) {
        this.nomeAM = nomeAM;
        this.cognomeAM = cognomeAM;
        this.datadinascitaAM = datadinascitaAM;
    }

    public String getNomeAM() {
        return nomeAM;
    }

    public String getCognomeAM() {
        return cognomeAM;
    }

    public LocalDate getDatadinascitaAM() {
        return datadinascitaAM;
    }

    public String getInternoMensa() {
        return internoMensa;
    }

    public AddettiMensa[] getListaAM() {
        return listaAM;
    }
    
    
}
