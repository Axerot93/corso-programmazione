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
                ok=true;
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
    
    static float dist3d(float x,float y, float z){
        float ris=0;
        double calcolo=x*x+y*y+z*z;
        calcolo= Math.sqrt(calcolo);
        ris = (float) calcolo;
        return ris;
    }

}
