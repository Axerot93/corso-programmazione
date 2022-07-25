/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entity.Etichetta;
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
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class EtichettaStore {

    @PersistenceContext
    EntityManager em;

    

    public List<Etichetta> all() {

        return em.createQuery("select e from Etichetta e where e.cancellato = false").getResultList();

    }

    public Optional<Etichetta> find(Long id) {

        Etichetta found = em.find(Etichetta.class, id);

        return found == null ? Optional.empty() : Optional.of(found);

    }

    public Etichetta save(Etichetta entity) {

        return em.merge(entity);

    }

    public void delete(Long id) {       
        Etichetta found = em.getReference(Etichetta.class, id);
        found.setCancellato(true);
        this.save(found);
    }
   
     public Etichetta saveIfNotExists(String tag) {
        Optional<Etichetta> found = byName(tag);
        if (found.isPresent()) {
            
            if(found.get().isCancellato() == true){
                found.get().setCancellato(false);
                this.save(found.get());
            }
            
            return found.get();
        }
        return this.save(new Etichetta(tag));
    }

 
    public Optional<Etichetta> byName(String tag) {
        try {
            return Optional.of(em.createQuery("select e from Etichetta e where TRIM(LOWER(e.name))= :name", Etichetta.class)
                    .setParameter("name", tag.trim().toLowerCase())
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }


}
