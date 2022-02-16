/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.oo_concetti_base;

/**
 *
 * @author tss
 */
public class C extends B {

    @Override//annotazione: metainformazione che possono essere usate dal compilatore o dalle librerie runtime
    public void m2() {
        super.m2();
        System.out.println("m2 super");//To change body of generated methods, choose Tools | Templates.
    }
    public void m4(){
        System.out.println("m4");        
    }
  
    
}
