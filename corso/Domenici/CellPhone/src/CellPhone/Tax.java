/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CellPhone;

/**
 *
 * @author tss
 */
public class Tax {
    
    String Origine;
    String Arrivo;
    Float valoreminuto;

    public Tax(String Origine, String Arrivo, Float valoreminuto) {
        this.Origine = Origine;
        this.Arrivo = Arrivo;
        this.valoreminuto = valoreminuto;
    }

    public String getOrigine() {
        return Origine;
    }

    public String getArrivo() {
        return Arrivo;
    }

    public Float getValoreminuto() {
        return valoreminuto;
    }
    
    
    
}
