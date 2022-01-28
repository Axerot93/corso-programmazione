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
public class Tool {

    static float insNumero() {
        float ris = 0;
        String txtnumero = JOptionPane.showInputDialog("inserisci il numero");
        txtnumero = txtnumero.replaceAll((","), ("."));
        try {
            ris = Float.parseFloat(txtnumero);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "ERRORE, assegnato 0\n" + e.getMessage());
        }
        return ris;

    }

    static float insNumero(String messaggio) {
        float ris = 0;
        boolean ok = false;
        //finchè non è ok, chiedo il numero
        while (!ok) {

            String txtnumero = JOptionPane.showInputDialog(messaggio);
            txtnumero = txtnumero.replaceAll((","), ("."));
            try {
                ris = Float.parseFloat(txtnumero);
                ok = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "ERRORE, ritenta!!\n" + e.getMessage());

            }

        }
        return ris;
    }

    static float insNumero(String messaggio, int numero_decimali) {
        float ris = 0;
        String txtnumero = JOptionPane.showInputDialog(messaggio);
        txtnumero = txtnumero.replaceAll((","), ("."));
        try {
            ris = Float.parseFloat(txtnumero);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "ERRORE, assegnato 0\n" + e.getMessage());
            //arrotondare a numero_decimali

        }
        float potenza = (float) Math.pow(10, numero_decimali);
        ris = Math.round(ris * potenza) / potenza;
        return ris;

    }

    /**
     * metodo per chiedere tramite messaggio un numero che verrà arrotondato
     * alla seconda cifra decimale
     *
     * @param messaggio domanda da porre all'utente
     * @return numero float arrotondato alla seconda cifra decimale
     */
    static float insValuta(String messaggio) {
        return insNumero(messaggio, 2);
    }

    static String WeeksDays(int day) {
        String giorno = "";
        switch (day) {
            case 1:
                giorno = "Monday";
                break;
            case 2:
                giorno = "Tuesday";
                break;
            case 3:
                giorno = "Wednesday";
                break;
            case 4:
                giorno = "Thursday";
                break;
            case 5:
                giorno = "Friday";
                break;
            case 6:
                giorno = "Saturday";
                break;
            case 7:
                giorno = "Sunday";
                break;
            default:
                giorno = "unknown";
        }
        return giorno;
    }

    static float dist3d(float x, float y, float z) {
        float ris = 0;
        double calcolo = x * x + y * y + z * z;
        calcolo = Math.sqrt(calcolo);
        ris = (float) calcolo;
        return ris;
    }

    /**
     * carica dati random in array
     *
     * @param ar array da caricare
     * @return array caricato di numeri random 1...10
     */
    static int[] loadData(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (int) (Math.random() * 10) + 1;
        }
        return ar;
    }

    /**
     * carica dati random in array
     *
     * @param ar array da caricare
     * @param range valore massimo del dato 1.... range
     * @return array caricato di numeri random 1...range
     */
    static int[] loadData(int[] ar, int range) {
        for (int i = 0; i < ar.length; i++) {
            double caso = Math.random();
            caso = caso * range;
            int valore = (int) caso;
            valore++;
            ar[i] = valore;
        }
        return ar;
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
        //eseguo n controlli per quanto è lungo il virus
        int vlen = virus.length;

        int numcontrolli = ar.length - vlen;
        for (int k = 0; k < numcontrolli; k++) {
            boolean ok = true;
            //ciclo controllo sequenza
            for (int i = 0; i < vlen; i++) {
                if (virus[i] != ar[i+k]) {
                    ok = false;
                    break;
                }
            }
            //fine controllo virus in posizione
            if(ok){
                pos=k;
                break;
            }

        }

        return pos;
    }

}
