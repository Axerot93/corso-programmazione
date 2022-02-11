/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionescuola;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author tss
 */
public class Corso {

    //area attributi o proprietà
    private String nomecorso = "---------";
    private String descrizione = "-------";
    private int durataore;
    private LocalDate datainizio;
    private String link = "www.ciacformazione.it";
    //una struttura per caricare i possibili 30 alunni (registro)
    Alunno[] registro = new Alunno[30];

    //elenco Alunni
    //costruttori
    public Corso() {

    }

    public Corso(String nomecorso, int durataore) {
        this.nomecorso = nomecorso;
        this.durataore = durataore;
        this.descrizione= "----";
        datainizio= LocalDate.now();
    }
    
    public Corso(String nomecorso, int durataore, int y, int m, int d) {
        this.nomecorso = nomecorso;
        this.durataore = durataore;
        this.descrizione= "----";
        setDatainizio(y,m,d);
    }
    
    

    public Corso(String nomecorso, int durataore, String descrizione) {
        this.nomecorso = nomecorso;
        this.durataore = durataore;
        this.descrizione = descrizione;
    }

    public String getNomecorso() {
        return nomecorso;
    }

    public void setNomecorso(String nomecorso) {
        if (nomecorso.length() > 0 && nomecorso.length() < 120) {
            this.nomecorso = nomecorso;
        }

    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getDurataore() {
        return durataore;
    }

    public void setDurataore(int durataore) {
        if (durataore > 10 && durataore < 6000) {
            this.durataore = durataore;
        }

    }

    public LocalDate getDatainizio() {
        return datainizio;
    }

     /**
     * imposta la data inizio dai 3 parametri numerici 
     * @param y int anno
     * @param m int mese
     * @param d int giorno
     * @return 
     */
    
    public boolean setDatainizio(String datainizio) {
        try{
        int y, m, d;
        String parts[] = datainizio.split(".");
        y = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        d= Integer.parseInt(parts[2]);
        LocalDate data = LocalDate.of(y,m,d);
        this.datainizio = data;
        return true;
        }
        catch(Exception e){
        return false;
        }
    }
    
    public void setDatainizio(int y, int m, int d) {
        
        LocalDate data = LocalDate.of(y,m,d);
        this.datainizio = data;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Alunno[] getRegistro() {
        return registro;
    }

    public void setRegistro(Alunno[] registro) {
        this.registro = registro;
    }

    void insertAlunno(Alunno alunno, int pos) {

        registro[pos] = alunno;
    }

    void insertAlunno(Alunno alunno) {

        int pos = 0;
        for (int i = 0; i < registro.length; i++) {
            if (registro[i] == null) {
                break;
            } else {
                registro[i].stampaInfo();
            }
        }

    }

    void stampaRegistro() {

        int pos = 0;
        for (int i = 0; i < registro.length; i++) {
            if (registro[i] == null) {
                break;
            } else {
                registro[i].stampaInfo();
            }

        }

    }

    //area metodi o capacità abilità
    String stampaInfo() {
        String ris="";
        ris +="\n\n--------Scheda corso----";
        ris +="\nNome del corso: " + nomecorso;
        ris +="\nNome del corso: " + durataore;
        ris +="\nDescrizione del corso " + descrizione;
        ris +="\nData inizio del corso " + datainizio.toString();
        ris +="\nLink corso: " + link;
        ris +="--------------\n\n";
        return ris;
    

    }

    String getInfo() {
        String ris="";
        ris +="\n\n--------Scheda corso----";
        ris +="\nNome del corso: " + nomecorso;
        ris +="\nNome del corso: " + durataore;
        ris +="\nDescrizione del corso " + descrizione;
        ris +="\nData inizio del corso " + datainizio.toString();
        ris +="\nLink corso: " + link + "\n" ;
        return ris;
    }
    
    
    String getCSV() {
        String ris="";
        //ris +="nomecorso; durataore; descrizione; datainizio;link\n";
        
        ris += nomecorso + ";" + durataore + ";" + descrizione + ";" + datainizio.toString() + ";" + link + "\n";
        /*
        ris +="\nNome del corso: " + durataore;
        ris +="\nDescrizione del corso " + descrizione;
        ris +="\nData inizio del corso " + datainizio.toString();
        ris +="\nLink corso: " + link + "\n";
        */
        return ris;
    }
    
    
 
    }
    
    
 
 
    
    


