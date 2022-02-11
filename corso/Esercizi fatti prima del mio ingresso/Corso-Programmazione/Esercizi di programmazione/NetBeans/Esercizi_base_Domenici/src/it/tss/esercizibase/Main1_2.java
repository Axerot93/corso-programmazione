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
public class Main1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("inserisci il primo numero");
        int x = sc.nextInt();

        System.out.println("Inserisci il secondo numero");
        int y = sc.nextInt();
        int somma = 0;
        
        while (y != 0) {
            somma = x + somma;
            y = y - 1;
        }
        System.out.println("prodotto :" + somma);
    }
    
}
