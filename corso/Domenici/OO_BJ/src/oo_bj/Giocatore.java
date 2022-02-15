/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bj;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Giocatore {

    private int soldi;
    private final int maxSoldi;
    private final int minSoldi;
    private final ArrayList<Carta> mano = new ArrayList<>();

    public Giocatore() {
        this(10, 15, 5);
    }

    public Giocatore(int soldi) {
        this(soldi, soldi + 2, soldi - 2);
    }

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

    public void initMano() {
        mano.clear();
    }

    public void addCarta(Carta c) {
        mano.add(c);
    }

    public boolean isContinuaPartita() {
        return soldi > minSoldi && soldi < maxSoldi;
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

    @Override
    public String toString() {
        String result = "-------- Giocatore ------------- \n";
        for (Carta carta : mano) {
            result += carta.toString() + "\n";
        }
        result += "valore: " + valoreMano();
        return result;
    }

}
