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
public class Banco {

    private final ArrayList<Carta> mano = new ArrayList<>();

    public void initMano() {
        mano.clear();
    }

    public void addCarta(Carta c) {
        if (mano.size() == 2) {
            mano.get(1).setCoperta(false);
        }
        mano.add(c);
    }

    public boolean isContinuaMano() {
        return valoreMano() < 17;
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
        String result = "-------- Banco ------------- \n";
        for (Carta carta : mano) {
            result += carta.toString() + "\n";
        }
        result += "valore: " + valoreMano();
        return result;
    }
}
