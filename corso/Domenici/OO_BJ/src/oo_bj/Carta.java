/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_bj;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class Carta {

    public static enum Seme {
        CUORI, QUADRI, FIORI, PICCHE;
    }

    public static enum Nome {
        ASSO, DUE, TRE, QUATTRO, CINQUE, SEI, SETTE, OTTO, NOVE, DIECI, FANTE, REGINA, RE;
    }
    private final Seme seme;
    private final ArrayList<Integer> valoripossibili;
    private int valore;
    private boolean coperta = false;
    private final Nome nome;

    public Carta(Seme seme, int valore, Nome nome) {
        this.seme = seme;
        this.valore = valore;
        this.nome = nome;
        this.valoripossibili=new ArrayList<>();
    }
    
    

    
    
    public Carta(Seme seme, int valore, Nome nome, ArrayList<Integer> valori) {
        this.seme = seme;
        this.valore = valore;
        this.nome = nome;
        this.valoripossibili = new ArrayList<>(valori);
        if (this.valoripossibili.isEmpty()) {
            valoripossibili.add(valore);

        }
    }

    public void setCoperta(boolean coperta) {
        this.coperta = coperta;
    }

    public Seme getSeme() {
        return seme;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        if (!valoripossibili.contains(valore)) {
            throw new IllegalArgumentException("valore non previsto!");
        }
        this.valore = valore;
    }

    public Nome getNome() {
        return nome;
    }
    

    @Override
    public String toString() {
        return this.coperta ? "???????" :
            this.nome.name() + " di " + this.seme.name();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.seme);
        hash = 71 * hash + this.valore;
        hash = 71 * hash + Objects.hashCode(this.nome);
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
        final Carta other = (Carta) obj;
        if (this.valore != other.valore) {
            return false;
        }
        if (this.seme != other.seme) {
            return false;
        }
        if (this.nome != other.nome) {
            return false;
        }
        return true;
    }
        
}
