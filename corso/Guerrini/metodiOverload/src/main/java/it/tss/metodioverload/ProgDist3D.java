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
        //chiedo dimensione degli array        
        int dim1=(int) Tool.insNumero("Dimmi dim1:");
        int dim2=(int) Tool.insNumero("Dimmi dim2:");
        //creo array con cui lavorare
        int ar1[]=new int [2000];
        int ar2[]=new int [dim2];
        int arOK[]=new int [dim1+dim2];
        ar1=Tool.loadData(ar1, 10);
        ar2=Tool.loadData(ar2, 5);
        arOK=Tool.concatArrays(ar1,ar2);
        System.out.println("primo elemento:" +ar1[0]);
        int[]file={123,234,354,456,354,234,123,234};
        file=Tool.concatArrays(ar1, file);
        int[]virus={3,3,3};
        int posvirus= Tool.cercaVirus(file,virus);
    }

}
