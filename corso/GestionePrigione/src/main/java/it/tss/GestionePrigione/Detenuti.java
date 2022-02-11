/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.GestionePrigione;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.time.LocalDate;

/**
 *
 * @author Gian
 */
public class Detenuti {
    private String nome;
    private String cognome;
    private LocalDate datadinascita;
    private int numeroprigioniero;

    public Detenuti(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDatadinascita() {
        return datadinascita;
    }

    public void setDatadinascita(LocalDate datadinascita) {
        this.datadinascita = datadinascita;
    }

    public int getNumeroprigioniero() {
        return numeroprigioniero;
    }

   
    public void setNumeroprigioniero(){
        numeroprigioniero = (int) Math.random();
    }
    
    
}
