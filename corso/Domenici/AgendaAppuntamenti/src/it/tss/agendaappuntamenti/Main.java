/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agendaappuntamenti;

import java.time.LocalDate;
import java.time.LocalTime;

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
        Agenda ag = new Agenda();
        Appuntamento ap1 = ag.aggiungi(LocalDate.now(), LocalTime.of(14, 30), LocalTime.of(15, 30), "Ivrea", "Giangianni");
        Appuntamento ap2 = ag.aggiungi(LocalDate.now().plusDays(1), LocalTime.of(16, 30), LocalTime.of(18, 30), "Torino", "Giannangela");
        ag.cerca(LocalDate.now(), null, null).forEach(ag::stampaAppuntamento);
    }

}
