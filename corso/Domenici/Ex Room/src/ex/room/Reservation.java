package ex.room;

import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tss
 */
public class Reservation {
  private String nome;
  private  LocalDate start;
  private  LocalDate finish;

    public Reservation(String nome, LocalDate start, LocalDate finish) {
        this.nome = nome;
        this.start = start;
        this.finish = finish;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getFinish() {
        return finish;
    }
    
  
  
}
