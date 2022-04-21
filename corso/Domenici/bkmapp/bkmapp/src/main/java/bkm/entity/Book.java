/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bkm.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime datacreazione = LocalDateTime.now();

    @Column(nullable = false)
    private String descrizione;

    @Column(nullable = false)
    private String link;

    @JsonbTransient
    @ManyToMany
    @JoinTable(name = "book_tag",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new TreeSet<>();

    @Column(nullable = false)
    private boolean condiviso;

    @ManyToOne(optional = false)
    private User utente;

    public LocalDateTime getDatacreazione() {
        return datacreazione;
    }
    
    @JsonbTransient
    public void setDatacreazione(LocalDateTime datacreazione) {
        this.datacreazione = datacreazione;
    }

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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public boolean isCondiviso() {
        return condiviso;
    }

    public void setCondiviso(boolean condiviso) {
        this.condiviso = condiviso;
    }

    public User getUtente() {
        return utente;
    }

    public void setUtente(User utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Book{" + "dataCreazione=" + datacreazione + ", descrizione=" + descrizione + ", link=" + link + ", tags=" + tags + ", condiviso=" + condiviso + ", utente=" + utente + '}';
    }

}
