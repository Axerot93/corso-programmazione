/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.ex_array;

import static it.tss.ex_array.ArrayTools.media;
import java.util.Arrays;

/**
 *
 * @author tss
 */
public class ArrayTools {

    public static void stampa(int[] numeri) {
//        for(int i = 0 ; i < numeri ; i++){
        for (int i = 0; i < numeri.length; i++) {
            if(i == numeri.length -1){
                
            }else{
                
            }
            System.out.print(numeri[i] + ",");
        }
        System.out.println("");
    }
     public static void stampa1(int[] numeri) {
//        for(int i = 0 ; i < numeri ; i++){
        for (int i = 0; i < numeri.length; i++) {
            String separatore = i==(numeri.length-1)? "":",";
           
            System.out.print(numeri[i] + separatore);
        }
        System.out.println("");
    }
     
         public static void stampaNumeriIndiciDispari(int[] numeri) {
//        for(int i = 0 ; i < numeri ; i++){
        for (int i = 0; i < numeri.length; i++) {
            
           if(i%2!=0){
               continue;
           }
               System.out.print(numeri[i] + ",");
        }
        System.out.println("");
        }
         
    public static boolean ricerca(int[] numeri, int n) {
        boolean trovato = false;
        int indice = 0;
        while (indice < numeri.length) {
            if (numeri[indice] == n) {
                trovato = true;
            }

            indice++;

        }

        return trovato;

    }
    public static boolean ricerca1(int[] numeri, int n) {
        boolean trovato = false;
        for(int idx=0;idx<numeri.length;idx++){
            if(numeri[idx]==n){
                trovato=true;
                break;
            }
       

        }

        return trovato;

    }
       public static boolean ricerca2(int[] numeri, int n) {
        for(int idx=0;idx<numeri.length;idx++){
            if(numeri[idx]==n){
                return true;
               
            }
       

        }

        return false;

    }
       /**
        * Ritorna l'indice dell'elemento trovato, altrimenti -1
        * 
        * @param numeri
        * @param n
        * @return 
        */
              public static int ricercaIndexof(int[] numeri, int n) {
        for(int idx=0;idx<numeri.length;idx++){
            if(numeri[idx]==n){
                return idx;
               
            }
       

        }

        return -1;

    }
                    /**
        * Ritorna l'indice dell'elemento trovato, altrimenti -1
        * 
        * @param start indice dal quale partire con la ricerca
        * @param numeri
        * @param n
        * @return 
        */
              public static int ricercaIndexof(int start, int[] numeri, int n) {
        return ricercaIndexof(0,numeri,n);
            }
       

        

    


    public static int max(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il massimo, array non esistente");
        }

        int max = numeri[0];
        int indice = 1;
        while (indice > numeri.length);
        if (numeri[indice] > max) {
            max = numeri[indice];

        }
        indice = indice + 1;

        return max;
    }

    public static int min(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array non esistente");
        }
        int min = numeri[0];
        int indice = 1;
        while (indice < numeri.length) {
            if (numeri[indice] < min) {
                min = numeri[indice];

            }
            indice = indice + 1;
        }

        return min;
    }
      public static int somma(int[] numeri) {
        int ris = 0;
        for (int i = 0; i < numeri.length; i++) {
            ris += numeri[i];
        }
        return ris;
      }

    public static double media(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare la media, array non esistente");
        }
        double ris = 0;
        for (int i = 0; i < numeri.length; i++) {
            ris += numeri[i];
        }

        ris = ris / numeri.length;

        return ris;

    }

    static int[] concatArrays(int[] ar1, int[] ar2) {
        int dim1 = ar1.length;
        int dim2 = ar2.length;
        int dimok = dim1 + dim2;
        int[] arok = new int[dimok];
        //0 con 0, 1 con 1, 2 con 2, etc... per ar1 e arok
        for (int i = 0; i < dim1; i++) {
            arok[i] = ar1[i];
            //inserimento secondo array da ultima posizione precedente
        }
        for (int i = 0; i < dim2; i++) {
            arok[i + dim1] = ar2[i];

        }
        return arok;
    }

    static int cercaVirus(int[] ar, int[] virus) {
        int pos = - 1;

        //controllo virus su prima posizione
        //eseguo n controlli per quanto ?? lungo il virus
        int vlen = virus.length;

        int numcontrolli = ar.length - vlen;
        for (int k = 0; k < numcontrolli; k++) {
            boolean ok = true;
            //ciclo controllo sequenza
            for (int i = 0; i < vlen; i++) {
                if (virus[i] != ar[i + k]) {
                    ok = false;
                    break;
                }
            }
            //fine controllo virus in posizione
            if (ok) {
                pos = k;
                break;
            }

        }

        return pos;
    }

    public static void sort(int[] numeri) {

    }
        public static int[] copia(int[] numeri){
        int[] ris= new int [numeri.length];
        for(int i=0;i<numeri.length;i++){
            ris[i]=numeri[i];
        }
        return ris;
     
    

}
        public static int[] unisci (int[] numeri1, int[]numeri2){
            int[] ris=new int[numeri1.length+numeri2.length];
            for(int i=0;i<numeri1.length;i++){
                ris[i]=numeri1[i];
        }
                 for(int i=0;i<numeri2.length;i++){
                ris[i]=numeri2[i];
        }
                 return ris;
                 }
    public static int[] intersezione(int[] numeri1, int[] numeri2) {
        int[] ris = {};
        for (int n : numeri1) {
            if (ricerca(ris, n) == false && ricerca(numeri2, n) == true) {
                int[] tmp = new int[1];
                tmp[0] = n;
                ris = unisci(ris, tmp);
            }
        }
        return ris;
    }
        public static boolean contieneValori(int[] numeri1, int[] numeri2){
        boolean ris = true;
            for(int n:numeri2){
             if(ricerca(numeri1,n)==false){
                 ris=false;
                 break;
             }
             
            }
            return ris;
            
        }
        public static boolean contieneSequenza(int[] numeri1, int[] numeri2){
            if (numeri2.length == 0){
                return false;
            }
            if(numeri2.length>numeri1.length){
                return false;
            }
            boolean ris = false;
            int n=numeri2[0];
            int start = ricercaIndexof(numeri1, n);
            while(start !=-1 && numeri1.length>= start + numeri2.length && !ris){
                ris=true;
                for(int i=0;i<numeri2.length;i++){
                    if(numeri1[start+i]!=numeri2[i]){
                        ris=false;
                        break;
                    }
                }
                start = ricercaIndexof(start + 1,numeri1, n);
                
            }
            
            return false;
            
            }
            public static void ordinaBubble(int[] numeri) {
        boolean ordinato;
        do {
            ordinato = true;
            int indice = 0;
            while (indice < numeri.length - 1) {
                if (numeri[indice] > numeri[indice + 1]) {
                    int tmp = numeri[indice];
                    numeri[indice] = numeri[indice + 1];
                    numeri[indice + 1] = tmp;
                    ordinato = false;
                }
                indice = indice + 1;
            }
        } while (!ordinato);
    }
}


