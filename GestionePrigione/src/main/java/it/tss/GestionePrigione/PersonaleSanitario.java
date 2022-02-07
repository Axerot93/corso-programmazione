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
public class PersonaleSanitario {
    private String nomepm;
    private String cognomepm;
    private LocalDate datadinascitapm;
    private PersonaleSanitario listaaddetti[] = new PersonaleSanitario [100];
    private PersonaleSanitario turniinfermieria[]=new PersonaleSanitario [3];  

    public String getNomepm() {
        return nomepm;
    }

    public void setNomepm(String nomepm) {
        this.nomepm = nomepm;
    }

    public String getCognomepm() {
        return cognomepm;
    }

    public void setCognomepm(String cognomepm) {
        this.cognomepm = cognomepm;
    }

    public LocalDate getDatadinascitapm() {
        return datadinascitapm;
    }

    public void setDatadinascitapm(LocalDate datadinascitapm) {
        this.datadinascitapm = datadinascitapm;
    }

    public PersonaleSanitario[] getListaaddetti() {
        return listaaddetti;
    }

    public void setListaaddetti(PersonaleSanitario[] listaaddetti) {
        this.listaaddetti = listaaddetti;
    }

    public PersonaleSanitario[] getTurniinfermieria() {
        return turniinfermieria;
    }

    public void setTurniinfermieria(PersonaleSanitario[] turniinfermieria) {
        this.turniinfermieria = turniinfermieria;
    }
           
            

}