/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agendaappuntamenti;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class Appuntamento {

    private LocalDate data;
    private LocalTime orainizio;
    private LocalTime orafine;
    private String luogo;
    private String Persona;

    public Appuntamento(LocalDate data, LocalTime orainizio, LocalTime orafine, String luogo, String Persona) {
        this.data = data;
        this.orainizio = orainizio;
        this.orafine = orafine;
        this.luogo = luogo;
        this.Persona = Persona;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getOrainizio() {
        return orainizio;
    }

    public LocalTime getOrafine() {
        return orafine;
    }

    public String getLuogo() {
        return luogo;
    }

    public String getPersona() {
        return Persona;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.data);
        hash = 89 * hash + Objects.hashCode(this.orainizio);
        hash = 89 * hash + Objects.hashCode(this.orafine);
        hash = 89 * hash + Objects.hashCode(this.luogo);
        hash = 89 * hash + Objects.hashCode(this.Persona);
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
        final Appuntamento other = (Appuntamento) obj;
        if (!Objects.equals(this.luogo, other.luogo)) {
            return false;
        }
        if (!Objects.equals(this.Persona, other.Persona)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.orainizio, other.orainizio)) {
            return false;
        }
        if (!Objects.equals(this.orafine, other.orafine)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appuntamento{" + "data=" + data + ", orainizio=" + orainizio + ", orafine=" + orafine + ", luogo=" + luogo + ", Persona=" + Persona + '}';
    }

}
