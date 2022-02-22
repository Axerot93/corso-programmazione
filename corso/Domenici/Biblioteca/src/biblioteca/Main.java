/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Book a= new Book("a", 1);
        Book b= new Book("b", 2);
        Book c= new Book("c", 3);
        
        Library lib= new Library();

        //lib.addBook(libro);
        //lib.loanBook(libro);
        
        System.out.println(lib.addBook(a));
        System.out.println(lib.addBook(b));
        System.out.println(lib.addBook(c));
        System.out.println(lib.addBook(a));
        System.out.println(lib.loanBook(b));
        System.out.println(lib.loanBook(a));
        
        
        lib.printLoans();
                
  
    }
    
}
