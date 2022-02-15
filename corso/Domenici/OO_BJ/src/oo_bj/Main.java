/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bj;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Mazzo mazzo = new Mazzo();

        Giocatore g = new Giocatore();
        Banco b = new Banco();

        do {
            if (mazzo.numeroCarte() < 20) {
                mazzo.crea();
            }
            b.initMano();
            g.initMano();
            g.addCarta(mazzo.pesca(false));
            g.addCarta(mazzo.pesca(false));
            System.out.println(g.toString());
            b.addCarta(mazzo.pesca(false));
            b.addCarta(mazzo.pesca(true));
            System.out.println(b.toString());
            while (g.isContinuaMano() && !g.isOut()) {
                Thread.sleep(3000);
                g.addCarta(mazzo.pesca(false));
                System.out.println(g.toString());
            }
            if (g.isOut()) {
                g.decrementaSoldi();
                System.out.println("soldi giocatore: " + g.getSoldi());
                continue;
            }
            while (b.isContinuaMano() && !b.isOut()) {
                Thread.sleep(3000);
                b.addCarta(mazzo.pesca(false));
                System.out.println(b.toString());
            }
            if (b.isOut() || b.valoreMano() < g.valoreMano()) {
                g.incrementaSoldi();
                //stampaMano
            } else if (b.valoreMano() > g.valoreMano()) {
                g.decrementaSoldi();
            }
            System.out.println("soldi giocatore: " + g.getSoldi());

        } while (g.isContinuaPartita());

    }
}
