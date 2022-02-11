/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.esercizi_base_guerrini;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class Ammissione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int myvoto;
        // per essere ammesso almeno 5

        String vototx = JOptionPane.showInputDialog("inserisci la media dei voti [0...10]");
        // converto in intero la stringa vototx
        boolean lode = 
                vototx.equalsIgnoreCase("10 e lode")
                ||
                vototx.equalsIgnoreCase("10 con lode")
                ||
                vototx.equalsIgnoreCase("10 lode")
                ;
                
        
        if (!lode) 
            myvoto= Integer.parseInt(vototx);
        else
            myvoto=10;

        // se almeno 5
        if (!(myvoto >= 0 && myvoto <= 10)) {
            System.out.println("IL NUMERO INSERITO NON E' AMMISSIBILE");
            return;
        }
        boolean outofrange = !(myvoto >= 0 && myvoto <= 10);
        if (outofrange){
            System.out.println("IL NUMERO INSERITO NON E' AMMISSIBILE");
            return;
        } 
        
        /*  if (myvoto < 0 || myvoto > 10){
            System.out.println("IL NUMERO INSERITO NON E' AMMISSIBILE");
            return;
        }
         */
        if (myvoto >= 5) {
            System.out.println("AMMESSO!!!");
            // fascia pericolante 5-6
            if (myvoto >= 5 && myvoto <= 6) // no graffe un solo comando
            {
                System.out.println("SEI PERICOLANTE!!!");
            } // stampa pericolante
            else {
                if (myvoto >= 7 && myvoto <= 8) {
                    System.out.println("DISCRETO!!!");
                } else {
                    System.out.println("OTTIMO!!!");
                    if (lode) System.out.println("OTTIMO CON LODE!!!");
                }
            }

            // stampo ammesso
        } else {
            System.out.println("ATTENZIONE NON AMMESSO!!!");
            // altrimenti
            // stampo NON ammesso
        }

    }

}
