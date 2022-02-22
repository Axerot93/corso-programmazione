/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CellPhone;

/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CellPhone a = new CellPhone("Timmy", "3341234");
        CellPhone b = new CellPhone("Megafon", "3355678");
        CellPhone c = new CellPhone("Odissey", "3384343");
        
        
        System.out.println(a.getCost(b, 10));
        System.out.println(b.getCost(a, 8));
        System.out.println(a.getCost(c, 10));
        
        CellPhone.setCost("Timmy", "Timmy", (float) 0.05);
        CellPhone.setCost("Timmy", "Megafon", (float) 0.15);
        CellPhone.setCost("Megafon", "Timmy", (float) 0.25);
        
        System.out.println(a.getCost(b, 10));
        System.out.println(b.getCost(a, 8));
        System.out.println(a.getCost(c, 10));
        
        
    }
    
}
