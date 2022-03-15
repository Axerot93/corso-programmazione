/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola.services;

import com.mycompany.gestionescuola.entity.Anagrafica;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class AnagraficaService {
    
    private EntityManager em;

    public AnagraficaService() {
        this.em = DbManager.getInstance().getEM();
    }
    
    public List<Anagrafica> all(){
        return em.createQuery("select e from Anagrafica e order by e.cognome")
                .getResultList();
    }
}
