/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.parametri;

import java.util.Arrays;

/**
 *
 * @author tss
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 10;
        m1(x);
        System.out.println("x= "+ x);
        int[] numeri = {10,20};
        m2(numeri);
        System.out.println(Arrays.toString(numeri));
    }
  public static void m1(int numero){
        numero = numero + 10;
    }
    public static void m2(int[] num){
        num[1] = num[1] + 10;
}    

}
  

