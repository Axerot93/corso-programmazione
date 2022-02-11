/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionescuola;

/**
 *
 * @author tss
 */
public class GestioneScuola {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        Tool genio= new Tool();
        
        
        
      String nome= "tss java";
      int durata= 1000;
      Corso c1= new Corso(nome,durata);
      Corso c2= new Corso(nome,durata,2022, 3, 15);
      boolean ok;
      c1.setDatainizio("2022-02-03");
      ok=c1.setDatainizio("2022-02-03");
      ok= c1.setDatainizio("2022/30/03");
      c1.stampaInfo();
      c2.stampaInfo();
       
      String nomeAlunno="Luca";
      String cognome= "Rossi";
      String numeroTelefono="+39 3918134565 ";
      String email= "Lucarossi@gmail.com";
      
      Alunno a1=new Alunno(nomeAlunno, cognome);
      String oknumeroTelefono=genio.checkTel("0125-454545", "+36");
      a1.stampaInfo();
     
      Alunno a2=new Alunno(nomeAlunno, cognome, oknumeroTelefono, email);
      a2.stampaInfo();
      Alunno[] alunniRegistro= new Alunno[30];
      alunniRegistro[0]=a1;
      alunniRegistro[1]=a2;
      int i=0;
      Alunno primo = alunniRegistro[i];
      c1.insertAlunno(a2, 0);
      c1.insertAlunno(a1);
      c1.stampaRegistro();
      Esame es= new Esame("Guerrini", 100, "java");
      Alunno esaminando= c1.getRegistro()[0];
      esaminando.setLibretto(es);
       
       
     }
    
}
