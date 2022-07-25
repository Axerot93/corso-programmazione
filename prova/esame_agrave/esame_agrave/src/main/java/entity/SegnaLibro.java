/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import boundary.mapping.EtichettaTypeAdapter;
import entity.constant.BaseEntity;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "segnalibro")
public class SegnaLibro extends  BaseEntity {
    
    @NotBlank
    @Column(nullable = false)
    private String descrizione;
    
    @NotBlank
    @Column(nullable = false)
    private String link;
    
    //@JsonbTypeAdapter(EtichettaTypeAdapter.class)
    @JsonbTransient
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "segnalibro_tag", 
               joinColumns = @JoinColumn(name = "segna_id"), 
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Etichetta> tags = new TreeSet<>();
    
    
    @JsonbTransient
    @ManyToOne(optional = false)
    private User usr;
    
    @NotNull
    @Column(nullable = false)
    private boolean condiviso;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusBkms status;
    
    //@NotBlank
    @Column(nullable = false)
    private LocalDateTime creazione;

    //@NotBlank
    @Column(nullable = false)
    private LocalDateTime aggiornamento;

    @JsonbTransient
    @ManyToOne(optional = false)
    private User usragg;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Etichetta> getTags() {
        return tags;
    }

    public void setTags(Set<Etichetta> tags) {
        this.tags = tags;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public boolean isCondiviso() {
        return condiviso;
    }

    public void setCondiviso(boolean condiviso) {
        this.condiviso = condiviso;
    }

    public StatusBkms getStatus() {
        return status;
    }

    public void setStatus(StatusBkms status) {
        this.status = status;
    }

    public LocalDateTime getCreazione() {
        return creazione;
    }

    @JsonbTransient
    public void setCreazione(LocalDateTime creazione) {
        this.creazione = creazione;
    }

    public LocalDateTime getAggiornamento() {
        return aggiornamento;
    }

    @JsonbTransient
    public void setAggiornamento(LocalDateTime aggiornamento) {
        this.aggiornamento = aggiornamento;
    }

    public User getUsragg() {
        return usragg;
    }

    
    public void setUsragg(User usragg) {
        this.usragg = usragg;
    }
    
    
    public String tagstostring(){
        
        String res = "";
        
        for (Etichetta tag : tags) {
            res += "#" + tag.getName();
        }
        
        return res;
        
    }
        
    
    
    
}
