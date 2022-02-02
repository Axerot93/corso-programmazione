/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.gestscuola;

import java.util.Date;

/**
 *
 * @author tss
 */
public class Corso {

    //area attributi o proprieta'
    String nomecorso;
    String descrizione;
    int durataore;
    Date datainizio;
    String link = "www.ciacformazione.it";
    //una struttura per caricare i possibili 30 alunni (registro)
    Alunno[] registro = new Alunno[30];
    //elenco Alunni

    //costruttori
    public Corso(String nomecorso, int durataore) {
        this.nomecorso = nomecorso;
        this.durataore = durataore;
        this.descrizione = "....";
        datainizio = new Date();

    }

    public Corso(String nomecorso, int durataore, String descrizione) {
        this.nomecorso = nomecorso;
        this.durataore = durataore;
        this.descrizione = descrizione;
        datainizio = new Date();
    }

    public Corso() {
        nomecorso = "nn";
        durataore = 0;
        descrizione = "nn";
        datainizio = new Date();
    }

    void insertAlunno(Alunno alunno, int pos) {
        registro[pos] = alunno;

    }

    void insertAlunno(Alunno alunno) {
        int pos = 0;
        for(int i=0;i<registro.length;i++){
            if (registro[i] == null){
                pos=i;
                break;
            } 
                
        }
        registro[pos] = alunno;

    }
        void stampaRegistro() {
            for(int i=0;i<registro.length;i++){
                if(registro[i]==null)
                    break;
                    else
                    registro[i].stampalistaAlunni();
                            
                    
                
                
                
           
                
        }
       
    }

    //metodi o capacita' abilita'   
    /**
     * il metodo stampa le informazioni del corso
     */
    void stampaInfo() {
        System.out.println("\n\n-------scheda corso-------");
        System.out.println("Nome corso: " + nomecorso);
        System.out.println("Durata corso: " + durataore);
        System.out.println("Descrizione del corso: : " + descrizione);
        System.out.println("Data di inizio del corso: " + datainizio.toString());
        System.out.println("Link corso: " + link);
        System.out.println("--------------------------\n\n");
       
    }

}
