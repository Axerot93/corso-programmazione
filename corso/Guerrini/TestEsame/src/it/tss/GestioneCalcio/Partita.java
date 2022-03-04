/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.GestioneCalcio;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Partita {
    private int giornata;
    private String squadra1;
    private String squadra2;
    private int gol1;
    private int gol2;

    public Partita(int giornata, String squadra1, String squadra2, int gol1, int gol2) {
        this.giornata = giornata;
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
        this.gol1 = gol1;
        this.gol2 = gol2;
    }

    public int getGiornata() {
        return giornata;
    }

    public void setGiornata(int giornata) {
        this.giornata = giornata;
    }

    public String getSquadra1() {
        return squadra1;
    }

    public void setSquadra1(String squadra1) {
        this.squadra1 = squadra1;
    }

    public String getSquadra2() {
        return squadra2;
    }

    public void setSquadra2(String squadra2) {
        this.squadra2 = squadra2;
    }

    public int getGol1() {
        return gol1;
    }

    public void setGol1(int gol1) {
        this.gol1 = gol1;
    }

    public int getGol2() {
        return gol2;
    }

    public void setGol2(int gol2) {
        this.gol2 = gol2;
    }
    
    
      String getCSV() {    // 
        String ris = "";
        
        //ris += "Giornata;squadra1;squadra2;gol1;gol2;\n";

        ris += giornata + ";" + squadra1 + ";" + squadra2 + ";" + gol1 + ";" + gol2 + "\n";
        return ris;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.giornata;
        hash = 79 * hash + Objects.hashCode(this.squadra1);
        hash = 79 * hash + Objects.hashCode(this.squadra2);
        hash = 79 * hash + this.gol1;
        hash = 79 * hash + this.gol2;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partita other = (Partita) obj;
        if (this.giornata != other.giornata) {
            return false;
        }
        if (this.gol1 != other.gol1) {
            return false;
        }
        if (this.gol2 != other.gol2) {
            return false;
        }
        if (!Objects.equals(this.squadra1, other.squadra1)) {
            return false;
        }
        if (!Objects.equals(this.squadra2, other.squadra2)) {
            return false;
        }
        return true;
    }
      
    
    
}
