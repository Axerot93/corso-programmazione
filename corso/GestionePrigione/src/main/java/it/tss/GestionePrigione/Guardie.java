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
public class Guardie {
    private String nomeG;
    private String cognomeG;
    private LocalDate DataDiNascitaG;
    private String recapitoG;
    private String internoG;
    private Guardie listaG [] = new Guardie [100];

    public Guardie(String nomeG, String cognomeG) {
        this.nomeG = nomeG;
        this.cognomeG = cognomeG;
    }

    public String getNomeG() {
        return nomeG;
    }

    public void setNomeG(String nomeG) {
        this.nomeG = nomeG;
    }

    public String getCognomeG() {
        return cognomeG;
    }

    public void setCognomeG(String cognomeG) {
        this.cognomeG = cognomeG;
    }

    public LocalDate getDataDiNascitaG() {
        return DataDiNascitaG;
    }

    public void setDataDiNascitaG(LocalDate DataDiNascitaG) {
        this.DataDiNascitaG = DataDiNascitaG;
    }

    public String getRecapitoG() {
        return recapitoG;
    }

    public void setRecapitoG(String recapitoG) {
        this.recapitoG = recapitoG;
    }

    public String getInternoG() {
        return internoG;
    }

    public void setInternoG(String internoG) {
        this.internoG = internoG;
    }

    public Guardie[] getListaG() {
        return listaG;
    }

    public void setListaG(Guardie[] listaG) {
        this.listaG = listaG;
    }
    
}
