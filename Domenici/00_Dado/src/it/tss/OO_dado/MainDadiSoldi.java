/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.OO_dado;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class MainDadiSoldi {

     static int soldi;
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       System.out.println("inserisci i soldi");
       soldi = sc.nextInt();
       int contamani = 1;
       while(soldi>0){
           gioca(contamani);
           contamani++;
       }
      
    }
    
    private static void gioca(int numMano) {
        int dg = lanciaDado();
        int db = lanciaDado();
        System.out.println(
           String.format("Mano numero %s banco=%s giocatore=%s", numMano,db,dg));
        if(dg>db){
            soldi++;
            System.out.println("mano vinta dal giocatore soldi= " + soldi);
        }
        else{
            soldi--;
            System.out.println("mano vinta dal banco");
        }
        System.out.println("--------------------------------------------------");
     /**
        * lancio dado
        * @return intero da 1 a 6
        */

   
    
}
     private static int lanciaDado() {
      Random rnd = new Random();
      return rnd.nextInt(6);
      
    }
}