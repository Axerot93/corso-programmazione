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
public class Main1_8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        int y = 1;
        int sommadv = 0;
        
        System.out.println("Inserisci il numero: ");
        x = sc.nextInt();
        while (y < x){          
            if (x%y == 0){
                sommadv = sommadv + y;
            }
            y = y+1;          
        }
        System.out.println("La somma dei divisori è: " + sommadv);
        if (x == sommadv) {
            System.out.println("Il numero è perfetto");
        }
        else if (x < sommadv) {
            System.out.println("Il numero è abbondante");
        }
        else if (x > sommadv) {
            System.out.println("Il numero è difettivo");
        }
    }    
}
