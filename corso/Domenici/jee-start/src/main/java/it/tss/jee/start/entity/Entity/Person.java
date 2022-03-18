/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jee.start.entity.Entity;

import java.time.LocalDate;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;

/**
 *
 * @author tss
 */
@JsonbPropertyOrder({"id", "nome", "cognome", "eta", "data creazione"})
public class Person {

    public Person() {

    }
    @JsonbTransient
    private int id;
    @JsonbProperty(value = "first_name")
    private String nome;
    @JsonbProperty(value = "last_name")
    private String cognome;
    @JsonbProperty(value = "age")
    private int eta;
    @JsonbProperty(value = "creation_date")
    @JsonbDateFormat(value = "dd/MM/yyyy", locale = "it")
    private LocalDate dataCreazione;

    public Person(int id, String nome, String cognome, int eta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.dataCreazione = LocalDate.now();
    }
    
    public JsonObject ToJsonMin() {
        return Json.createObjectBuilder()
                .add("last_name", this.cognome)
                .add("age", this.eta)
                .build();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public LocalDate getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", creato il=" + dataCreazione + '}';
    }

}
