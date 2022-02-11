/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.esercizi_base_guerrini;

/**
 *
 * @author tss
 */
public class GreenPass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // data oggi
        int oggi = 790;
        // dati validità ministero
        int durata_v1 = 30;
        int durata_v2 = 120;
        int durata_v3 = 120;
        int durata_tampone = 2;
        int durata_covid = 180;

        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int tampone = 0;
        int covid = 0;

        v1 = 500;
        int dv1 = oggi - v1;
        boolean okv1 = dv1 <= durata_v1;

        v2 = 550;
        int dv2 = oggi - v2;
        boolean okv2 = dv2 <= durata_v2;

        v3 = 0;
        int dv3 = oggi - v3;
        boolean okv3 = dv3 <= durata_v3;

        tampone = 0;
        int dtampone = oggi - tampone;
        boolean oktampone = dtampone <= durata_tampone;

        covid = 590;
        int dcovid = oggi - covid;
        boolean okcovid = dcovid <= durata_covid;

        boolean greenpass = okcovid || oktampone || okv1 || okv2 || okv3;
        if (greenpass) {
            System.out.println("GREEN PASS VALIDO");
        } else {
            System.out.println("GREEN PASS NON VALIDO");
        }

    }

}
