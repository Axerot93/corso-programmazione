/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clinica;

import java.util.Collection;

/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Clinica c = new Clinica();
        c.prenota("Pippo Franco", Specialista.OCULISTA);
        c.prenota("Leo Gulotta", Specialista.OCULISTA);
        c.prenota("Leo Gulotta", Specialista.OCULISTA);
        c.prenota("Ciccio Ingrassia", Specialista.PEDIATRA);
        c.prenota("Leo Gulotta", Specialista.PEDIATRA);
        c.cancellaPrenotazione("Ciccio Ingrassia", Specialista.PEDIATRA);
        Collection<Prenotazione> ocu = c.getPrenotati(Specialista.OCULISTA);
        System.out.println(ocu);
    }
    
}
