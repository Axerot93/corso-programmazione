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
    Tool genio = new Tool();
        
    String nome="tss java";
    int durata= 1000;
    Corso c1= new Corso(nome,durata);
    Corso c2= new Corso(nome,durata,2022, 3, 15);
    boolean ok;
    c1.setDatainizio("2022-02-02");
    ok= c1.setDatainizio("2022-02-02");
    ok= c1.setDatainizio("2022/30/02");
    c1.stampaInfo();
    Alunno a1= new Alunno("rossi", "paolo");
    String oktel=genio.checkTel(" 0125-454545 ","+44");
    Alunno a2= new Alunno("rivera", "gianni","riv@riv.it",oktel);
    /*
    c1.insertAlunno(a1);
    c1.insertAlunno(a2);
    
    c1.stampaRegistro();
    Esame es= new Esame("guerrini",100,"java");
    Alunno esaminando = c1.getRegistro()[0];
    esaminando.setLibretto(es);
    */
    
    }
    
}
