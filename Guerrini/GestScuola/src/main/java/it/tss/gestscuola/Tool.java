/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.gestscuola;

/**
 *
 * @author tss
 */
public class Tool {
        String ceckTel(String tel){
            String ris="";
            tel=tel.replace(" ", "");
            tel=tel.replace("-", "");
            tel=tel.replace(".", "");
            tel=tel.replace("(", "");
            tel=tel.replace(")", "");
            try{
            long ltel = Long.parseLong(tel);
            String tre= tel.substring(0, 3);
            if(tre.equals("+39"))
                ris=tel;
            else
                ris="+39"+tel;
            }
            catch(Exception e){
                ris="";
            }
            return ris;
    }
        String ceckTel1(String tel){
            String ris="";
            tel=tel.replace(" ", "");
            tel=tel.replace("-", "");
            tel=tel.replace(".", "");
            tel=tel.replace("(", "");
            tel=tel.replace(")", "");
            try{
            long ltel = Long.parseLong(tel);
            String tre= tel.substring(0, 3);
            if(tre.equals("+33"))
                ris=tel;
            else
                ris="+33"+tel;
            }
            catch(Exception e){
                ris="";
            }
            return ris;
    }
    
}
