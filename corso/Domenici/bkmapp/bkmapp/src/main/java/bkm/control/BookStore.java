/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bkm.control;

import bkm.entity.Book;
import bkm.entity.Tag;
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
public class BookStore {

    @PersistenceContext
    EntityManager em;

    @Inject
    TagStore tagStore;

    public List<Book> all() {
        return em.createQuery("select e from Book e order by e.datacreazione DESC", Book.class)
                .getResultList();
    }

    public Optional<Book> find(Long id) {
        Book found = em.find(Book.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public List<Book> byUser(Long userId) {
        return em.createQuery("select e from Book e where (e.utente.id= :userId) or (e.utente.id <> :userId and e.condiviso order = true) by e.datacreazione DESC", Book.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public Book save(Book entity) {
        return em.merge(entity);
    }

    public void addTag(Book found, String tag) {
        Book toupdate = find(found.getId()).get();
        Tag saved = tagStore.saveIfNotExists(tag);
        toupdate.getTags().add(saved);
        save(toupdate);
    }

    public void removeTag(Long id, String tag) {
        final Book toupdate = find(id).get();
        Optional<Tag> found = tagStore.byName(tag);
        if (found.isPresent()) {
            toupdate.getTags().remove(found.get());
            save(toupdate);
        }
    }

    public void deleteByUser(Long id) {
        byUser(id).stream().map(Book::getId).forEach(this::delete);
    }

    public void delete(Long id) {
                em.remove(em.getReference(Book.class, id));
    }

}
