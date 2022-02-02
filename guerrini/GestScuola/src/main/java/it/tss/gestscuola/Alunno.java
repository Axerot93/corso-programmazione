/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.gestscuola;

/**
 *
 * @author tss
 */
public class Alunno {
    String nomeAlunno;
    String cognome;
    String email;
    String tel;

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
    
    
    void stampalistaAlunni(){
        System.out.println("\n\n------info alunno------");
        System.out.println("cognome: " + cognome);
        System.out.println("nome: " + nomeAlunno);
        System.out.println("indirizzo e-mail: " + email);
        System.out.println("Recapito: " + tel);
        System.out.println("-----------------------\n\n");
}
   
               
    }
    



