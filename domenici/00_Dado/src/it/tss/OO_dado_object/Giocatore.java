/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.OO_dado_object;

/**
 *
 * @author tss
 */
public class Giocatore {

    private int soldi;
    private final int maxSoldi;
    private final int minSoldi;

    /**
     * crezione del giocatore con inserimento della quantità di soldi di
     * partenza, il limite minimo di soldi e il limite massimo di soldi
     *
     * @param valore
     */
   
    

    public Giocatore(int soldi, int maxSoldi, int minSoldi) {
        this.soldi = soldi;
        this.maxSoldi = maxSoldi;
        this.minSoldi = minSoldi;
    }

    public void incrementaSoldi() {
        soldi++;
    }

    public void decrementaSoldi() {
        soldi--;
    }

    public int getSoldi() {
        return soldi;
    }
    public boolean isContinua(){
        return soldi > minSoldi && soldi<maxSoldi;
    }
}
