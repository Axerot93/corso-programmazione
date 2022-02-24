/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizioesame;


import java.time.LocalDateTime;

/**
 *
 * @author tss
 */
public class Scontrino {
   private Prodotto prodottovenduto;
   private float Iva;
   private float prezzofinale;
   private LocalDateTime data; 
   private int quantitaVenduta;

    public Scontrino(Prodotto prodotto, float Iva, float prezzofinale, LocalDateTime data, int quantitaVenduta) {
        this.prodottovenduto = prodotto;
        this.Iva = Iva;
        this.prezzofinale = prezzofinale;
        this.data = data;
        this.quantitaVenduta= quantitaVenduta;
    }
   
   public String stampaScontrino(){
       String ris = "";
        ris += "-------Scontrino------";
        ris += "\nProdotto: " + prodottovenduto.getNome();
        ris += "\nIva: " + Iva;
        ris += "\nprezzo finale: " + prezzofinale;
        ris += "\ndata: " + data.toString();
        ris += "\n";
        return ris;
   }
    
}
