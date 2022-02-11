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
public class Main1_7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        int npari = 0;
        int ndispari = 0;
        int mediaP = 0;
        int mediaD = 0;
        int sommaP = 0;
        int sommaD = 0;
        boolean ContinuaCiclo = true;
        while(ContinuaCiclo){
            System.out.println("Inserisci il numero: ");
            x = sc.nextInt();
            if(x==0){
                ContinuaCiclo = false;
            }
            else if(x%2 == 0){
                sommaP = sommaP + x;
                npari = npari + 1;     
            }
            else{
                sommaD = sommaD + x;
                ndispari = ndispari + 1;
            }
        }
        if (npari>0){
            mediaP = sommaP / npari;
        }
        if (ndispari>0){
            mediaD = sommaD / ndispari;
        }
        System.out.println("La media dei numeri pari è: " + mediaP);
        System.out.println("La media dei numeri dispari è: " + mediaD);
        if(mediaD==mediaP){
            System.out.println("La media dei numeri dispari è uguale a quella dei numeri dispari");       
        }
        else if(mediaD<mediaP) {
            System.out.println("La media dei numeri pari è quella maggiore");
        }
        else {
            System.out.println("La media dei numeri dispari è quella maggiore");
        }
    }   
}
