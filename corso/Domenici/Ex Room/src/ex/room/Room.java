/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex.room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class Room {

    ArrayList<Reservation> listaprenotazioni = new ArrayList<Reservation>();

    public Reservation reserve(String nome, LocalDate start, LocalDate finish) {
        Reservation r = new Reservation(nome, start, finish);
        if (isOccupata(r)) {
            throw new IllegalArgumentException("Periodo occupato");
           
        }
        listaprenotazioni.add(r);
        return r;
        

    }

    private boolean isOccupata(Reservation nuova) {
        for (Reservation r : listaprenotazioni) {
            if (
                 nuova.getStart().equals(r.getStart()) || 
                 nuova.getStart().isAfter(r.getStart()) && nuova.getStart().isBefore(r.getFinish()) ||
                 nuova.getFinish().isAfter(r.getStart()) && nuova.getFinish().isBefore(r.getFinish())
               ){
                return true;
            }
        

        }
        return false;
    }

    public List<Reservation> reservations() {
        for (Reservation r : listaprenotazioni) {

        }
        return null;
        
       
    }

}
