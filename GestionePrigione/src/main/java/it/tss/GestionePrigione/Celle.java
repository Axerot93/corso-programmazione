/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.GestionePrigione;

/**
 *
 * @author Gian
 */
public class Celle {
    /*
    numero di celle
    
    turni guardie
    */
    private Detenuti RegistroDetenuti [] = new Detenuti [3000];
    private Celle listacelle [] = new Celle [3000];
    private Guardie TurniGuardie [] = new Guardie [3];

    public Detenuti[] getRegistroDetenuti() {
        return RegistroDetenuti;
    }

    public Celle[] getListacelle() {
        return listacelle;
    }

    public Guardie[] getTurniGuardie() {
        return TurniGuardie;
    }
            
            
     
}
