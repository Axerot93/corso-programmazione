/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clinica;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Prenotazione {
    private final String nomepaziente;
    private final Specialista specialista;

    public Prenotazione(String nomepaziente, Specialista specialista) {
        this.nomepaziente = nomepaziente;
        this.specialista = specialista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nomepaziente);
        hash = 83 * hash + Objects.hashCode(this.specialista);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prenotazione other = (Prenotazione) obj;
        if (!Objects.equals(this.nomepaziente, other.nomepaziente)) {
            return false;
        }
        if (this.specialista != other.specialista) {
            return false;
        }
        return true;
    }

    public String getNomepaziente() {
        return nomepaziente;
    }

    public Specialista getSpecialista() {
        return specialista;
    }

    

    

  

   
   
       
}
