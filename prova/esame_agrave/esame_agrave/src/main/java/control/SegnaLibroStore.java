/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import entity.SegnaLibro;
import entity.Etichetta;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author tss
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class SegnaLibroStore {

    @PersistenceContext
    EntityManager em;

    @Inject
    EtichettaStore storetag;

    public List<SegnaLibro> findAllByUserCreated(Long id) {



        return em.createQuery("select e from SegnaLibro e where e.usr.id = :id and e.cancellato = false", SegnaLibro.class)
                .setParameter("id", id)
                .getResultList();

    }
    
    public List<SegnaLibro> findAllByUser(Long id) {

        System.out.println("bookstore");
        System.out.println(id);

        return em.createQuery("select e from SegnaLibro e where (e.usr.id = :id) OR (e.usr.id <> :id and e.condiviso = 1) "
                + "and e.cancellato = false and e.usr.cancellato = false", SegnaLibro.class)
                .setParameter("id", id)
                .getResultList();

    }
 
    public List<JsonObject> findAllForValidating(int page, int size) {

        List<SegnaLibro> books = em.createQuery("select e from SegnaLibro e where e.condiviso = 1 "
                                            + "and e.cancellato = false "
                                            + "and e.usr.cancellato = false "
                                            + "and e.status = 'Nuovo'", SegnaLibro.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();

        List<JsonObject> jbook = new ArrayList<>();
        
        
        for (SegnaLibro book : books) {
            
            JsonObject jb = Json.createObjectBuilder()
                .add("IdBookMk", book.getId().toString())
                .add("descrizione", book.getDescrizione())
                .add("link", book.getLink())
                .add("Utente", book.getUsr().getFirstName())
                .add("condiviso", book.isCondiviso())
                .add("DtCreazione", book.getCreazione().toString())
                .add("Tags", book.tagstostring())
                .build();
            
            jbook.add(jb);
        }
        
        return jbook;
        
    }
     
    public List<JsonObject> findAllByUserJson(Long id, int page, int size) {

        List<SegnaLibro> books = em.createQuery("select e from SegnaLibro e where ((e.usr.id = :id) OR (e.usr.id <> :id and e.condiviso = 1)) "
                + "and e.cancellato = false and e.usr.cancellato = false "
                + "order by e.creazione desc", SegnaLibro.class)
                .setParameter("id", id)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();

        List<JsonObject> jbook = new ArrayList<>();
        
        
        for (SegnaLibro book : books) {
            
            JsonObject jb = Json.createObjectBuilder()
                .add("idbkm", book.getId().toString())
                .add("descrizione", book.getDescrizione())
                .add("link", book.getLink())
                .add("utente", book.getUsr().getFirstName())
                .add("condiviso", book.isCondiviso())
                .add("dtcreazione", book.getCreazione().toString())
                .add("status", book.getStatus().toString())
                .add("dtaggiornamento", book.getAggiornamento().toString())
                .add("utenteagg", book.getUsragg().getFirstName()) 
                .add("Tags", book.tagstostring())
                .add("mail", book.getUsr().getEmail())  
                .build();
            
            jbook.add(jb);
        }
        
        return jbook;
        
    }

    public List<JsonObject> findBkmsJson(Long id) {

        List<SegnaLibro> books = em.createQuery("select e from SegnaLibro e where e.id = :id", SegnaLibro.class)
                .setParameter("id", id)
                .getResultList();

        
        List<JsonObject> jbook = new ArrayList<>();
        
        
        for (SegnaLibro book : books) {
            
            JsonObject jb = Json.createObjectBuilder()
                .add("idbkm", book.getId().toString())
                .add("descrizione", book.getDescrizione())
                .add("link", book.getLink())
                .add("utente", book.getUsr().getFirstName())
                .add("condiviso", book.isCondiviso())
                .add("dtcreazione", book.getCreazione().toString())
                .add("status", book.getStatus().toString())
                .add("dtaggiornamento", book.getAggiornamento().toString())
                .add("utenteagg", book.getUsragg().getFirstName())
                .add("Tags", book.tagstostring())
                .add("mail", book.getUsr().getEmail())  
                .build();
            
            jbook.add(jb);
        }
        
        return jbook;
    }

    public Optional<SegnaLibro> find(Long id) {
        SegnaLibro found = em.find(SegnaLibro.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public SegnaLibro save(SegnaLibro entity) {

        return em.merge(entity);

    }

    public void deleteByUser(Long id) {
        findAllByUser(id).stream().map(SegnaLibro::getId).forEach(this::delete);
    }

    public void delete(Long id) {
        
        SegnaLibro found = em.find(SegnaLibro.class, id);
        found.setCancellato(true);
        save(found);
        
    }
    
    public void addTag(SegnaLibro found, String[] tags) {

        SegnaLibro toupdate = em.find(SegnaLibro.class, found.getId());
    
        if(tags.length > 0){
            for (String tag : tags) {
                Etichetta saved = storetag.saveIfNotExists(tag);
                toupdate.getTags().add(saved);
            }
        }
        
        save(toupdate);
    }
    
    public void removeTag(Long id, String tag) {

        final SegnaLibro toupdate = find(id).get();
        Optional<Etichetta> found = storetag.byName(tag);
        if (found.isPresent()) {
            toupdate.getTags().remove(found.get());
            save(toupdate);
        }
    }
    

}
