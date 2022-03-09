package it.tss.jdbc;



import java.math.BigDecimal;
import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbscuola");       
        EntityManager em = emf.createEntityManager();
        
        em.createQuery("select e from Corso e ", Corso.class)
                .getResultList()
                .forEach(System.out::println);
        
        Corso tosave = new Corso();
        tosave.setTitolo("jakarta EE parte 3");
        tosave.setDatainizio(LocalDate.now());
        tosave.setCosto(BigDecimal.valueOf(120,50));
        tosave.setData(LocalDateTime.now());
        
        em.getTransaction().begin();
        
        
        //em.persist(tosave);
        
        
        em.getTransaction().commit();
    }
}
