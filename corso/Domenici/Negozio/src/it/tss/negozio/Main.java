/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.negozio;

/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Catalogo a = new Catalogo();
        Prodotto b = new Prodotto("Dentifricio", 0.99);
        Prodotto c = new Prodotto("Pc Gaming", 1890.99);
        Prodotto d = new Prodotto("Vetril", 1.99);
        a.aggiungiArticoli(b);
        a.aggiungiArticoli(c);
        a.aggiungiArticoli(d);
        System.out.println(a.getArticoliSottoPrezzo(100.99));
        System.out.println("lista completa");
        System.out.println(a.toString());
        
        
        
        
        provaMobile n= new provaMobile();
        Mobile tavolo= new Mobile("Tavolo",100.00,50, 100, 60);
        Mobile mobiletto= new Mobile("mobiletto bagno", 80.00,60, 80, 20);
        Mobile credenza = new Mobile("credenza cucina",120,80,150,90);
        Catalogo mobili= new Catalogo();
        mobili.aggiungiArticoli(tavolo);
        mobili.aggiungiArticoli(mobiletto);
        mobili.aggiungiArticoli(credenza);
        System.out.println(n.scegliMobile(mobili.articoli,90.00, 70, 90, 30));
    }
}
