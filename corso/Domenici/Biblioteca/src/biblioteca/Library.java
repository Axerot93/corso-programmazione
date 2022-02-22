/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class Library {

    List<Book> listalibri = new ArrayList<>();
    List<Book> libriprestati = new ArrayList<>();

    public boolean addBook(Book libro) {
        boolean ris = true;

        ris = addBook(libro, listalibri);

        return ris;

    }

    public boolean addBook(Book libro, List<Book> libriprestati) {
        boolean ris = true;

        if (!(libriprestati.size() == 0)) {
            for (Book book : libriprestati) {
                if (book.getIsbn() == libro.getIsbn()) {
                    ris = false;
                    return ris;
                } 
            }
            
            libriprestati.add(libro);
        } else {

            libriprestati.add(libro);
        }

        return ris;

        //quando inserisco un libro
        //fatto
        //quando faccio prestito
        // il libro gia è presente ?
        //ciclo per entrambi list. 
        // libro è presente a lista disponibili?
        /// ritorna true
        // libro é disponibile a lista prestito `
        //ritorna false
    }

    public boolean verificaBook(Book libro, List<Book> listLibro) {
        boolean ris = true;
        for (Book book : listLibro) {
            if (book.getIsbn() == libro.getIsbn()) {
                ris = false;
            } else {

                return ris;
            }

        }
        return ris;

        //quando inserisco un libro
        //fatto
        //quando faccio prestito
        // il libro gia è presente ?
        //ciclo per entrambi list. 
        // libro è presente a lista disponibili?
        /// ritorna true
        // libro é disponibile a lista prestito `
        //ritorna false
    }

    public boolean loanBook(Book libro) {
        boolean ris = true;

        if (verificaBook(libro, listalibri)) {

            libro.setDataprestito(LocalDate.now());

            if (addBook(libro, libriprestati)) {
                listalibri.remove(libro);
                System.out.println("libro consegnato!");

                return ris;
            } else {
                System.out.println("libro già prestato!");
                ris = false;
            }
        } else {

            if (!verificaBook(libro, libriprestati)) {

                throw new UnsupportedOperationException("il libro non è mai stato nella libreria!");

            }
        }

        return ris;

    }

    public void returnBook(Book libro) {
        if (verificaBook(libro, libriprestati)) {

            if (addBook(libro, listalibri)) {

                libriprestati.remove(libro);

                System.out.println("libro riconsegnato!");

            } else {

                throw new UnsupportedOperationException("il libro non risulta in prestito");
            }

        }

    }

    public void printLoans() {
        for (int i = 0; i < libriprestati.size(); i++) {
            System.out.println("lista libri prestati: " + libriprestati.get(i).getTitolo() + " data del prestito: " + libriprestati.get(i).getDataprestito());

        }
        {

        }

    }

}
