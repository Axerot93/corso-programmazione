/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.negozio;

/**
 *
 * @author tss
 */
public class Mobile implements Articolo {

    private String nome;
    private double prezzo;
    private int Larghezza;
    private int Altezza;
    private int Profondita;

    public Mobile(String nome, double prezzo, int Larghezza, int Altezza, int Profondita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.Larghezza = Larghezza;
        this.Altezza = Altezza;
        this.Profondita = Profondita;
    }
@Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Mobile{"+"nome"+nome +" "+ "Larghezza=" + Larghezza + ", Altezza=" + Altezza + ", Profondit\u00e0=" + Profondita + '}';
    }

    public int getLarghezza() {
        return Larghezza;
    }

    public int getAltezza() {
        return Altezza;
    }

    public int getProfondita() {
        return Profondita;
    }

    
    }

    

