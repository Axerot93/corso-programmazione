/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.world.control;

import it.tss.world.entity.City;
import it.tss.world.entity.Country;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author tss
 */

@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class CityStore {
    
    @PersistenceContext
    EntityManager em;

    public Optional<City> byName(String tag) {
        try {
            return Optional.of(em.createQuery("select e from City e ", City.class)
                    .setParameter("name", tag.trim().toLowerCase())
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    public List<City> all() {
        return em.createQuery("select e from City e ")
                .getResultList();
    }

     public void save(City entity) {
         em.merge(entity);
    }
}
