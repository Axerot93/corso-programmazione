/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss_ex_1_8_terminale;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {
        Scanner dm = new Scanner(System.in);
        System.out.println("inserisci il numero da analizzare");
        int x = dm.nextInt();
        int n = 1;
        int sommaDivisori = 0;

        while (n < x) {
            if (x % n == 0) {
                sommaDivisori = sommaDivisori + n;
                
            }
            n++;
        }
        if (sommaDivisori == x) {
            System.out.println(x + " perfetto");
        } else if (sommaDivisori > x) {
            System.out.print(x + " abbondante");
        } else {
            System.out.println(x + " difettivo");
        }
    }
}
