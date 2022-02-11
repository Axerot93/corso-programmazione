/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizibase;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Main1_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("inserisci il primo numero");
        int x = sc.nextInt();

        System.out.println("Inserisci il secondo numero");
        int y = sc.nextInt();
        int quoziente = 0;
        int calcola = x;
        if (y != 0)
        {
            while (y <= calcola) {
                quoziente = quoziente + 1;
                calcola = calcola - y;
            }

            System.out.println("il quoziente è: " + quoziente);
            System.out.println("il resto è: " + calcola);
        }else
        
        
            System.out.println("impossiible calcoalre la divisione x 0");
    }
}
