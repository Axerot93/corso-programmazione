/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizioesame;

/**
 *
 * @author tss
 */
public class Prodotto {

    private final int idProdotto;
    private final String nome;
    private float prezzo;
    private int quantitaProdotto;

    public Prodotto(int idProdotto, String nome, float prezzo, int quantitaProdotto) {
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantitaProdotto = quantitaProdotto;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public String getNome() {
        return nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public int getQuantitaProdotto() {
        return quantitaProdotto;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setQuantitaProdotto(int quantitaProdotto) {
        this.quantitaProdotto = quantitaProdotto;
    }

    String getCSV() {    // 
        String ris = "";
        
        //ris += "idProdotto;nome;prezzo;quantitaProdotto;link\n";

        ris += idProdotto + ";" + nome + ";" + prezzo
                + ";" + quantitaProdotto + ";"
                + "\n";
        return ris;
    }

}
