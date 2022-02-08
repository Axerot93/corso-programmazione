/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.gestscuola;

import java.time.LocalDate;

/**
 *
 * @author tss
 */
public class Esame {

   
    private String docente;
    private LocalDate dataesame;
    private int voto;
    private String materie;
    private String note;

    public Esame(String docente, int voto, String materie) {
        
        this.docente = docente;
        this.voto = voto;
        this.materie = materie;
        this.dataesame=LocalDate.now();
    }
    
    public String getDocente() {
        return docente;
    }

    public LocalDate getDataesame() {
        return dataesame;
    }

    public int getVoto() {
        return voto;
    }

    public String getMaterie() {
        return materie;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}

    
    

  