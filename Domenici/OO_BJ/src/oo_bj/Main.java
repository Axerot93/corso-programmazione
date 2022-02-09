/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_bj;

/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carta carta1 = new Carta(Carta.Seme.CUORI, 9, Carta.Nome.NOVE);
        //System.out.println(carta.toString());
        Carta carta2 = new Carta(Carta.Seme.CUORI, 9, Carta.Nome.NOVE);
        System.out.println(carta1.equals(carta2));
        Mazzo mazzo = new Mazzo(52); 
        for (int i = 0; i < 10; i++) {
            Carta cartapescata= mazzo.pesca();
            System.out.println(cartapescata.toString());
            
        }
    }
    
}
