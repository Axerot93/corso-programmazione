/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola.services;

import com.mycompany.gestionescuola.entity.Corso;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class CorsoService {
    private EntityManager em;

    public CorsoService() {
        this.em = DbManager.getInstance().getEM();
    }
    
    public List<Corso> all(){
        return em.createQuery("select e from Corso e order by e.titolo")
                .getResultList();
    } 
    
}
