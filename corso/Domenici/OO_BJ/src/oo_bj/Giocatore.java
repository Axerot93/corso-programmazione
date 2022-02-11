/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_bj;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Giocatore {

    private String nome;
    private int soldi;
    private final int maxSoldi;
    private final int minSoldi;
    private final ArrayList<Carta> mano = new ArrayList<>();

    public Giocatore(String nome) {
        this(nome,100, 150, 50);
    }

    public Giocatore(String nome,int soldi) {
        this(nome,soldi, soldi + 2, soldi - 2);
    }

    public Giocatore(String nome,int soldi, int maxSoldi, int minSoldi) {
        this.nome = nome;
        this.soldi = soldi;
        this.maxSoldi = maxSoldi;
        this.minSoldi = minSoldi;
    }

 /*
    --------------------------------getsoldi------------------------------------
    */
    public int getSoldi() {
        return soldi;
    }

    public String getNome() {
        return nome;
    }

    /*
    --------------------------metodi--------------------------------------------
     */
    public boolean isContinuaPartita() {
        boolean continua = soldi > minSoldi && soldi < maxSoldi;
        if (continua) {
            mano.clear();
        }
        return continua;
    }

    public void addCarta(Carta c) {
        mano.add(c);
    }

    public void initMano() {
        mano.clear();
    }

    public boolean isContinuaMano() {
        return valoreMano() <= 15;
    }

    public int valoreMano() {
        int result = 0;
        for (Carta carta : mano) {
            result += carta.getValore();
        }
        return result;
    }

    public boolean isOut() {
        return valoreMano() > 21;
    }
       public void incrementaSoldi() {
        soldi++;
    }

    public void decrementaSoldi() {
        soldi--;
    }

/*
    --------------------------------to string-----------------------------------
    */
    @Override
    public String toString() {
        String result = "-------------mano giocatore----------- \n";
        for (Carta carta : mano) {
            result += carta.toString() + "\n";

        }
        result += "valore: " + valoreMano();
        return result;
    }

}
