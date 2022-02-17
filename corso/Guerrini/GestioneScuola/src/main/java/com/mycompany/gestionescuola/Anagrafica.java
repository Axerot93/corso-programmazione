/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionescuola;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author tss
 */
public class Anagrafica {

    private final int id_anagrafica;
    private String cognome;
    private String nome;
    private String mail;

    public Anagrafica(int id_anagrafica, String cognome, String nome, String mail) {
        this.id_anagrafica = id_anagrafica;
        this.cognome = cognome;
        this.nome = nome;
        this.mail = mail;
    }

    public Anagrafica(int id_anagrafica, String cognome, String nome) {
        this.id_anagrafica = id_anagrafica;
        this.cognome = cognome;
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId_anagrafica() {
        return id_anagrafica;
    }

    String getCSV() {
        String ris = "";
        ris += id_anagrafica + ";" + cognome + ";" + nome + ";" + mail + "\n";
        return ris;
    }

    

}
