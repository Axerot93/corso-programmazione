/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.world.control;

import it.tss.world.entity.Country;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author tss
 */

@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class CountryStore {
    
    @PersistenceContext
    EntityManager em;

    
    public List<Country> all() {
        return em.createQuery("select e from Country e ", Country.class)
                .getResultList();
    }
    
    public Country save(Country entity) {
        return em.merge(entity);
    }

    public Optional<Country> find(String id) {
        Country found = em.find(Country.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
}
