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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        A a = new A();
        B b = new B();
        C c = new C();
        E e = new E();
         
        a.m1();
        c.m2();
        
        
        A aa = new C();//SI, in quanto B estende A, diventando esso stesso A

        //B bb = new A(); // NO, in quanto A non sa fare le cose di B 
        //e quindi non vale la modifica
        if(a instanceof B){ //verifica se la variabile contiene il tipo indicato
            System.out.println("a contine un oggetto di tipo B");
        }
        else{
            System.out.println("a non contine un oggetto di tipo B");
        }
        
        aa.m2();
        //B bb = new A(); // NO, in quanto A non sa fare le cose di B 
        //e quindi non vale la modifica
        
    }
    
    

}
