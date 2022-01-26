/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.metodioverload;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class ProgDist3D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float x, y, z;
        x = Tool.insNumero("Dimmi x:");
        y = Tool.insNumero("Dimmi y:");
        z = Tool.insNumero("Dimmi z:");
        float distanza = Tool.dist3d(x, y, z);
        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println("z:" + z);
        System.out.println("distanza:" + distanza);
    }

}
