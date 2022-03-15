/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tss
 */
public class Alunno {

    private String nome;
    private String cognome;
    private String telefono = "---";
    private String mail = "---";
    private LocalDate datainserimento = LocalDate.now();
    private Esame[] libretto = new Esame[50];


    public Alunno() {
    }

    public Alunno(String cognome, String nome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Alunno(String nome, String cognome, String telefono, String mail) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.mail = mail;
    }

    
    public LocalDate getDatainserimento() {
    return datainserimento;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        try {
            if (nome.length() >= 2) {
                this.nome = nome;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getCognome() {
        return cognome;
    }

    public boolean setCognome(String cognome) {

        cognome = cognome.trim();
        if (cognome.length() >= 2) {
            this.cognome = cognome;
            return true;
        } else {
            return false;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setLibretto(Esame esame){
        for(int i=0; i<libretto.length; i++){
            if(libretto[i]== null){
                libretto[i]= esame;
                break;
            }
        }
    }
    
    
    void stampaInfo() {
        System.out.println("\n\n-------Scheda alunno-------");
        System.out.println("Il nome dell'alunno è: " + nome);
        System.out.println("Il cognome dell'alunno è: " + cognome);
        System.out.println("Il numeri di telefono è: " + telefono);
        System.out.println("La mail dell'alunno è: " + mail);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("d/M/yyyy");
        String formattedDate = datainserimento.format(myFormatObj);
        System.out.println("Data iscrizione: " + formattedDate);
        System.out.println("---------------------------\n\n");
    }

}
