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
public class GestioneScuola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String nome = "tss java";
        int durata = 1000;
        Tool tool = new Tool();
        Corso c1 = new Corso(nome, durata);
        c1.stampaInfo();
       
        String tel = tool.ceckTel("0 1 2 5 - (3 )6 3 6 3 6");
        String tel1 = tool.ceckTel1("0 1 2 5 - (3 )6 3 4 5 5 6 73 6");
        Alunno alunno1 = new Alunno("Gianluca", "Agrave", "----", tel1);
        Alunno alunno2 = new Alunno("Carmelo", "Giangianni", "----", tel);
        alunno1.stampalistaAlunni();
        alunno2.stampalistaAlunni();
        c1.insertAlunno(alunno1);
        c1.insertAlunno(alunno2);
        c1.stampaRegistro();
        

    }

}