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
public class Main1_8_2 {
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        int y = 1;
        int k = 1;
        int sommadv = 0;
        int perfetti[]= new int [30];
        int abbondanti[]= new int [30];
        int difettivi[]= new int [30];
        int nperfetti = 0;
        int nabbondanti = 0;
        int ndifettivi = 0;
        
        System.out.println("Inserisci il numero: ");
        x = sc.nextInt();
        while (k<=x){
            while (y < k){          
                if (k%y == 0){
                    sommadv = sommadv + y;
                }
                y = y+1;          
            }           
            if (k == sommadv) {
                perfetti[nperfetti] = k;
                nperfetti = nperfetti + 1;
            }
            else if (k < sommadv) {
                abbondanti[nabbondanti] = k;
                nabbondanti = nabbondanti + 1;
            }
            else if (k > sommadv) {
                difettivi[ndifettivi] = k;
                ndifettivi = ndifettivi + 1;
            }
            y = 1;
            sommadv = 0;
            k = k+1;
        }
        int i = 0;
        while (i < nperfetti){
            System.out.println("Fa parte dei numeri perfetti: " + perfetti[i]);
            i = i+1;
        }
        i = 0;
        while (i < nabbondanti){
            System.out.println("Fa parte dei numeri abbondanti: " + abbondanti[i]);
            i = i+1;
        }
        i = 0;
        while (i < ndifettivi){
            System.out.println("Fa parte dei numeri difettivi: " + difettivi[i]);
            i = i+1;
        }
    }
}
