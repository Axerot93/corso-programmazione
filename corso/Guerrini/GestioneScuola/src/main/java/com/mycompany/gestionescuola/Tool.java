/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionescuola;

/**
 *
 * @author tss
 */
public class Tool 
{
    String checkTel(String numeroTelefono)
    {
        String ris="";
        //tolgo gli spazi
        numeroTelefono=numeroTelefono.replace(" ","");
        numeroTelefono=numeroTelefono.replace("-","");
        numeroTelefono=numeroTelefono.replace(".","");
        numeroTelefono=numeroTelefono.replace("(","");
        numeroTelefono=numeroTelefono.replace(")","");
        
        long lnumeroTelefono;
        
        try{
            lnumeroTelefono = Long.parseLong(numeroTelefono);
            String tre= numeroTelefono.substring(0,3);
            if(tre.equals("+39")){
                ris=numeroTelefono;
            }
            else{
                ris="+39" + numeroTelefono;
            }
        }
        catch(Exception e){
            ris="";
            
        }
            
        return ris;
    }
    
    
    String checkTel(String numeroTelefono, String prefisso)
    {
        String ris="";
        //tolgo gli spazi
        numeroTelefono=numeroTelefono.replace(" ","");
        numeroTelefono=numeroTelefono.replace("-","");
        numeroTelefono=numeroTelefono.replace(".","");
        numeroTelefono=numeroTelefono.replace("(","");
        numeroTelefono=numeroTelefono.replace(")","");
        prefisso=prefisso.replace(" ","");
        prefisso=prefisso.replace("-","");
        prefisso=prefisso.replace(".","");
        prefisso=prefisso.replace("(","");
        prefisso=prefisso.replace(" )","");
        prefisso=prefisso.replace("+","");
        
        long lnumeroTelefono;
        long lprefisso;
        
        try{
            lnumeroTelefono = Long.parseLong(numeroTelefono);
            lprefisso= Long.parseLong(prefisso);
            
            
             ris="+" + prefisso + numeroTelefono;
            
        }
        catch(Exception e){
            ris="";
            
        }
            
        return ris;
    }
}

