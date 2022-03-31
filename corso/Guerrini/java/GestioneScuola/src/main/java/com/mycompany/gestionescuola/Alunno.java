/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionescuola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tss
 */
public class Alunno {

    private String cognome;
    private String nome;
    private String mail;
    private String tel;
    private LocalDate datainserimento = LocalDate.now();
    private Esame[] libretto= new Esame[50];
    public Alunno() {
    }

    public Alunno(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
        
    }

    public Alunno(String cognome, String nome, String mail, String tel) {
        this.cognome = cognome;
        this.nome = nome;
        this.mail = mail;
        this.tel = tel;
    }

    public LocalDate getDatainserimento() {
        return datainserimento;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setLibretto(Esame esame){
        for (int i=0;i<libretto.length;i++){
            if (libretto[i]== null){
                libretto[i]=esame;
                break;
                
            }
        }
    }
    
    void stampaInfo() {
        System.out.println("\n\n-------Scheda alunno------");
        System.out.println("Nome : " + nome);
        System.out.println("Cognome : " + cognome);
        System.out.println("Mail: " + mail);
        System.out.println("Telefono: " + tel);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = datainserimento.format(myFormatObj);
        
        System.out.println("Data iscrizione: " + formattedDate);
        System.out.println("----------------------\n\n");
    }

}
