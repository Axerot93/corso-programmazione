/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizibase;

import java.util.Scanner;

/**
 *
 * @author eigji
 */
public class Main1_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;        
        int somma = 0;
        boolean continuaCiclo = true;
        while (continuaCiclo){
            System.out.println("inserisci il numero: ");
            x = sc.nextInt();
            if (x != 0){
                somma = somma + x;            
            }
            else {
                continuaCiclo = false;
            }
        }
        System.out.println("la somma è: " + somma);
    }
    
}
