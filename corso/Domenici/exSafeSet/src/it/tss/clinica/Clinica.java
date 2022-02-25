/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clinica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class Clinica {

    ArrayList<Prenotazione> listaprenotazioni = new ArrayList<>();

    public void prenota(String nomepaziente, Specialista s) {
        Prenotazione p = new Prenotazione(nomepaziente, s);
        for (Prenotazione r : listaprenotazioni) {
            if (p.equals(r)) {
                JOptionPane.showMessageDialog(null, "PAZIENTE GIA' INSERITO");
                return;
            }

        }
        listaprenotazioni.add(p);
    }

    public void cancellaPrenotazione(String nomepaziente, Specialista s) {
        Prenotazione p = new Prenotazione(nomepaziente, s);
        for (Prenotazione r : listaprenotazioni) {
            if (p.equals(r)) {
                JOptionPane.showMessageDialog(null, "PRENOTAZIONE RIMOSSA");
                listaprenotazioni.remove(p);
                return;
            }

        }
        JOptionPane.showMessageDialog(null, "PRENOTAZIONE INESISTENTE!");
    }
    public Collection<Prenotazione> getPrenotati(Specialista specialista){
        return listaprenotazioni.stream()
                .filter(v -> v.getSpecialista()== specialista)
                .collect(Collectors.toList());
                
        
    }

}
