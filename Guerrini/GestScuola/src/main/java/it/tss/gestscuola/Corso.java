/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.gestscuola;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author tss
 */
public class Corso {

    //area attributi o proprieta'
    private String nomecorso;
    private String descrizione;
    private int durataore;
    private LocalDate datainizio;
    private String link = "www.ciacformazione.it";
    //una struttura per caricare i possibili 30 alunni (registro)
    private Alunno[] registro = new Alunno[30];
    //elenco Alunni

    //costruttori
    public Corso(String nomecorso, int durataore) {
        this.nomecorso = nomecorso;
        this.durataore = durataore;
        this.descrizione = "---";
        datainizio = LocalDate.now();

    }

    public Corso(String nomecorso, int durataore, String descrizione) {
        this.nomecorso = nomecorso;
        this.durataore = durataore;
        this.descrizione = descrizione;
        datainizio = LocalDate.now();
    }
   
    public Corso(String nomecorso, int durataore, int y, int m, int d) {
        this.nomecorso = nomecorso;
        this.durataore = durataore;
        this.descrizione = "---";
        setDatainizio(y, m, d);
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
        if (durataore > 0 && durataore < 6000) {
            this.durataore = durataore;
        }
    }

    public LocalDate getDatainizio() {
        return datainizio;
    }

    public void setDatainizio(LocalDate datainizio) {
        this.datainizio = datainizio;
    }

    /**
     * Imposta la data da data testo
     *
     * @param datainizio formato YYYY/MM/DD 2022/02/03
     */
    public boolean setDatainizio(String datainizio) {
        try {
            int y, m, d;
            String parts[] = datainizio.split("-");
            y = Integer.parseInt(parts[0]);
            m = Integer.parseInt(parts[1]);
            d = y = Integer.parseInt(parts[2]);
            LocalDate data = LocalDate.of(y, m, d);
            this.datainizio = data;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 
     * @param y int anno
     * @param m int mese
     * @param d int giorno
     * @return 
     */
    
    public boolean setDatainizio(int y, int m, int d) {
        try{
        LocalDate data = LocalDate.of(y, m, d);
        this.datainizio = data;
        return true;
        }
        catch(Exception e){
            return false;
        }
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

    public Corso() {
        nomecorso = "nn";
        durataore = 0;
        descrizione = "nn";
        datainizio = LocalDate.now();
    }

    void insertAlunno(Alunno alunno, int pos) {
        registro[pos] = alunno;

    }

    void insertAlunno(Alunno alunno) {
        int pos = 0;
        for (int i = 0; i < registro.length; i++) {
            if (registro[i] == null) {
                pos = i;
                break;
            }

        }
        registro[pos] = alunno;

    }

    void stampaRegistro() {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i] == null) {
                break;
            } else {
                registro[i].stampalistaAlunni();
            }

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
    String getInfo(){
        String ris ="";
        ris+=("-------scheda corso-------");
        ris+=("\nNome corso: " + nomecorso);
        ris+=("\nDurata corso: " + durataore);
        ris+=("\nDescrizione del corso: : " + descrizione);
        ris+=("\nData di inizio del corso: " + datainizio.toString());
        ris+=("\nLink corso: " + link+"\n");
        return ris;
    } 
    /**
     * ritorno un csv con i corsi
     * testata nomecorso;durataore;descrizione;datainizio;link
     * elenco dati separati da ; e fine linea
     * @return String csv
     */
      String getCSV(){ 
        String ris ="";
        
        ris+= nomecorso + ";" +durataore+";"+descrizione+";"+datainizio + ";"+link+"\n";
       
        return ris;
    } 

}
