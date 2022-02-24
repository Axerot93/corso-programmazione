package ex.room;


import java.time.LocalDate;
import java.time.Month;

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
    public static void main(String[] args) {
        Room r= new Room();
        r.reserve("Lucia", LocalDate.of(2022, Month.MARCH, 15), LocalDate.of(0, Month.MARCH, 30));
        r.reserve("Lucia", LocalDate.of(2022, Month.MAY, 15), LocalDate.of(0, Month.MAY, 30));
        r.reserve("Lucia", LocalDate.of(2022, Month.FEBRUARY, 25), LocalDate.of(0, Month.FEBRUARY, 14));
        r.reservations().forEach(v -> System.out.println(v));
        
        r.reserve("André", LocalDate.of(2022, Month.MAY, 28), LocalDate.of(2022, Month.JUNE,14));
        r.reserve("Gianluca", LocalDate.of(2022, Month.JULY,6), LocalDate.of(2022, Month.JULY,31));
    }
    
}
