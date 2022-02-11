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
private String nome;
private String cognome;
private String numeroTelefono;
private String email;
private Esame[] libretto= new Esame[50];
private LocalDate datainserimento = LocalDate.now();
 

public LocalDate getDatainserimento(){
    return datainserimento;
}
    
public Alunno (){
    
}

public Alunno (String nome, String cognome){
    this.nome= nome;
    this.cognome=cognome;
    this.numeroTelefono="---";
    this.email="---";
    
}

public Alunno (String nome, String cognome, String numeroTelefono, String email){
    this.nome= nome;
    this.cognome=cognome;
    this.numeroTelefono= numeroTelefono;
    this.email=email;
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

    public boolean setCognome(String cognome) {
        cognome=cognome.trim();
        if(cognome.length()>= 2){
          this.cognome = cognome;
          return true;
         }
        else{
            
           return false;
        }
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setLibretto(Esame esame){
        for(int i=0; i<libretto.length; i++){
            if(libretto[i]== null){ 
                libretto[i]=esame;
                break;
            }
        }
    }


//area metodi o capacità abilità
    void stampaInfo() {
        System.out.println("\n\n-------Scheda alunno------");
        System.out.println("Nome : " + nome);
        System.out.println("Cognome : " + cognome);
        System.out.println("Mail: " + email);
        System.out.println("Telefono: " + numeroTelefono);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = datainserimento.format(myFormatObj);
        
        System.out.println("Data iscrizione: " + formattedDate);
        System.out.println("----------------------\n\n");
    }
    
    
}


