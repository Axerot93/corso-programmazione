/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.oo_concetti_base;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class Main1 {
    public static void main(String[] args) {
        
        List<A> list = new ArrayList<>();
        list.add(new A());
        list.add(new B());
        list.add(new A());
        list.add(new B());
        list.add(new C());        
        eseguiM2(list);
    }
    
    public static void eseguiM2(List<A> list){
        for (A a : list) {
            a.m2();
            
        }
    }
}
