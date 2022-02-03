/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.gestscuola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tss
 */
public class Alunno {

    private String nomeAlunno;
    private String cognome;
    private String email;
    private String tel;
    private LocalDate datainserimento = LocalDate.now();

    public Alunno(String nome, String cognome) {
        this.nomeAlunno = nome;
        this.cognome = cognome;
    }

    public Alunno(String nomeAlunno, String cognome, String email, String tel) {
        this.nomeAlunno = nomeAlunno;
        this.cognome = cognome;
        this.email = email;
        this.tel = tel;
    }

    public String getNomeAlunno() {
        return nomeAlunno;
    }

    public void setNomeAlunno(String nomeAlunno) {
        this.nomeAlunno = nomeAlunno;

    }

    public String getCognome() {
        return cognome;
    }

    public boolean setCognome(String cognome) {
        cognome = cognome.trim();
        if (cognome.length() >= 2) {
            this.cognome = cognome;
            return true;
        }
        else{
            return false;
        }
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public LocalDate getDatainserimento() {
        return datainserimento;
    }
    

    void stampalistaAlunni() {
        System.out.println("\n\n------info alunno------");
        System.out.println("cognome: " + cognome);
        System.out.println("nome: " + nomeAlunno);
        System.out.println("indirizzo e-mail: " + email);
        System.out.println("Recapito: " + tel);
        DateTimeFormatter myformatobj= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = datainserimento.format(myformatobj);
        System.out.println("Data iscrizione: " + formattedDate);
        System.out.println("-----------------------\n\n");
    }

}
