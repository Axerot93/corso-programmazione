package it.tss.GestioneCalcio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tss
 */
public class Classifica implements Comparable<Classifica>{

    String nomesquadra;
    int punteggio;

    public Classifica(String nomesquadra, int punteggio) {
        this.nomesquadra = nomesquadra;
        this.punteggio = punteggio;

    }

    @Override
    public int compareTo(Classifica c2) {
        int punti1=punteggio;
        return c2.punteggio-punti1;
    }

}
