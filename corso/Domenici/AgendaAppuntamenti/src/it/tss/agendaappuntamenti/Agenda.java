/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agendaappuntamenti;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class Agenda {
    
    ArrayList<Appuntamento> appuntamenti = new ArrayList<>();
    
    public Appuntamento aggiungi(LocalDate data, LocalTime start, LocalTime finish, String luogo, String persona) {
        Appuntamento result = new Appuntamento(data, start, finish, luogo, persona);
        appuntamenti.add(result);
        return result;
    }

    public void cancella(Appuntamento a) {
        appuntamenti.remove(a);
    }
    
    public void cancella(LocalDate a) {
        appuntamenti.removeIf(v -> v.getData().equals(a));
    }
    
    public List<Appuntamento> cerca(LocalDate data, String luogo, String persona) {
       appuntamenti.removeAll(cerca(data, luogo, persona));
        return null;
        
    }
    
    public void stampa() {
        System.out.println("-------------------agenda---------------");
        //appuntamenti.forEach(v -> System.out.println(v));
        //appuntamenti.forEach(System.out::println);
        appuntamenti.forEach(this::stampaAppuntamento);
    }

    public void stampaAppuntamento(Appuntamento a) {
        String frase = String.format("%s alle %s fino alle %s ad %s con %s", a.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                a.getOrainizio(), a.getOrafine(), a.getLuogo(), a.getPersona());
        System.out.println(frase);
    }
}
