/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.negozio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 * @param <E>
 */
public class Catalogo <E extends Articolo> implements Iterable {
    List<Articolo> articoli = new ArrayList<>();
    
    public void aggiungiArticoli(E art){
        articoli.add(art);
    }
    List<E> getArticoliSottoPrezzo(double prezzo){
           return(List<E>) articoli.stream()
                   .filter(v->v.getPrezzo()<= prezzo)
                   .collect(Collectors.toList());
    }
    @Override
    public String toString(){
       return articoli.stream()
       .map(Articolo::toString)
       .collect((Collectors.joining("\n")));
               }

    @Override
    public Iterator iterator() {
        return articoli.iterator();
    }
}