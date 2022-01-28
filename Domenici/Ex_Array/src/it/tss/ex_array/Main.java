/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.ex_array;

import java.util.Random;

/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] input = generaArrayCasuale(10, 10);
        int[] input1 = generaArrayCasuale(2, 20);
        ArrayTools.stampa(input);
        ArrayTools.stampa(input1);
    
              System.out.println("ricerca 5: " + ArrayTools.ricerca(input, 5));
        System.out.println("MAX: " + ArrayTools.max(input));
        System.out.println("MIN: " + ArrayTools.min(input));
        System.out.println("SOMMA: " + ArrayTools.somma(input));
        System.out.println("MEDIA: " + ArrayTools.media(input));
        System.out.println("COPIA:");
        ArrayTools.stampa(ArrayTools.copia(input));
        System.out.println("UNISCI:");
        ArrayTools.stampa(ArrayTools.unisci(input,input1));
        System.out.println("INTERSEZIONE:");
        ArrayTools.stampa(ArrayTools.intersezione(input,input1));
        System.out.println("ORDINA:");
        ArrayTools.ordinaBubble(input);
        ArrayTools.stampa(input);
        System.out.println("CONTIENE SEQUENZA:" + ArrayTools.contieneSequenza(input, input1));
        

    }

    /**
     *
     * @param ncelle numero di celle nell'array
     * @param max massimo intero contenuto nell'array
     * @return
     */
    private static int[] generaArrayCasuale(int ncelle, int max) {
        int[] ris = new int[ncelle];
        for (int i = 0; i < ris.length; i++) {
            ris[i] = generaNumeroCasuale(max);
        }
        return ris;
    }

    private static int generaNumeroCasuale(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
