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
        int[] input = generaArrayCasuale(50, 1000);
        ArrayTools.stampa(input);

        System.out.println("il massimo è:" + ArrayTools.max(input));
        System.out.println(ArrayTools.min(input));
        System.out.println(ArrayTools.ricerca(input, 5));
        System.out.println(ArrayTools.media(input));

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
