/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola;

/**
 *
 * @author tss
 */
public class Tool {

    String checkTel(String tel) {
        String ris = "";
        //tolgo gli spazi
        tel = tel.replace(" ", "");
        //tolgo trattini
        tel = tel.replace("-", "");
        tel = tel.replace(".", "");
        tel = tel.replace("(", "");
        tel = tel.replace(")", "");
        try {
            long ltel = Long.parseLong(tel);
            String tre = tel.substring(0, 3);
            if (tre.equals("+39")) {
                ris = tel;
            } else {
                ris = "+39" + tel;
            }
        } catch (Exception e) {
            ris = "";

        }
        return ris;
    }
    
    String checkTel(String tel, String prefix ) {
        String ris = "";
        //tolgo gli spazi
        tel = tel.replace(" ", "");
        //tolgo trattini
        tel = tel.replace("-", "");
        tel = tel.replace(".", "");
        tel = tel.replace("(", "");
        tel = tel.replace(")", "");
        try {
            long ltel = Long.parseLong(tel);
            String tre = tel.substring(0, 3);
            if (tre.equals(prefix)) {
                ris = tel;
            } else {
                ris = prefix + tel;
            }
        } catch (Exception e) {
            ris = "";

        }
        return ris;
    }
}
