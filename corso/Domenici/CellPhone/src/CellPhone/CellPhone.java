/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CellPhone;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author tss
 */
public class CellPhone {
    String gestore;
    String numeroDiTelefono;
    static List<Tax> tariffe= new ArrayList<>();

    public CellPhone(String gestore, String numeroDiTelefono) {
        this.gestore = gestore;
        this.numeroDiTelefono = numeroDiTelefono;
    }
   
    
    public static void setCost(String origine, String arrivo, float costominuto){
        
        Tax t = new Tax(origine, arrivo, costominuto);
        tariffe.add(t);
        
    }
    
    
    public float getCost (CellPhone phone, int durata){
        
        if(tariffe.isEmpty())
        {
            System.out.println("Non esiste impostazione per nessun gestore"); 
            return 0;
        }
        
        for (Tax tax : tariffe) {
            
            if(tax.getOrigine() == this.gestore && tax.getArrivo() == phone.gestore){
            return (tax.getValoreminuto() * (float) durata);   
            }
                       
        }
        
        throw new UnsupportedOperationException("Non esiste impostazione per questo gestore"); 
                
        
    }
}

