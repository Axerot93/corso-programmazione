/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.ex_1_8_terminale_2;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("devi passare un numero come parametro!!");
        }
        int x = Integer.parseInt(args[0]);
        int n = 1;
        int sommaDivisori = 0;

        while (n < x) {
            if (x % n == 0) {
                sommaDivisori += n;

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

    public static String analizza(int x) {
        String risultato;
        int n = 1;
        int sommaDivisori = 0;

        while (n < x) {
            if (x % n == 0) {
                sommaDivisori += n;

            }
            n++;
        }
        if (sommaDivisori == x) {
            risultato = " perfetto";
        } else if (sommaDivisori > x) {
            risultato = " abbondante";
        } else {
            risultato = " difettivo";
        }
        return risultato;
    }
    
