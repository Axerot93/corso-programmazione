/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class Book {

    private String titolo;
    private int isbn;
    private LocalDate dataprestito;

    public Book(String titolo, int isbn) {
        this.titolo = titolo;
        this.isbn = isbn;
    }
    
    

    public String getTitolo() {
        return titolo;
    }

    public int getIsbn() {
        return isbn;
    }

    public LocalDate getDataprestito() {
        return dataprestito;
    }

    public void setDataprestito(LocalDate dataprestito) {
        this.dataprestito = dataprestito;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.titolo);
        hash = 61 * hash + this.isbn;
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
        final Book other = (Book) obj;
        if (this.isbn != other.isbn) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        return true;
    }
    
    
    

  

}
