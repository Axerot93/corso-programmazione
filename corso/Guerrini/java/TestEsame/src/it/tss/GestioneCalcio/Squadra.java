package it.tss.GestioneCalcio;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tss
 */
public class Squadra {
private  String nome;
private  String sede;

    public Squadra(String nome, String sede) {
        this.nome = nome;
        this.sede = sede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
    
    
    String getCSV() {    // 
        String ris = "";
        
        //ris += "nome;sede;\n";

        ris += nome + ";" + sede + "\n";
        return ris;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.sede);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Squadra other = (Squadra) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sede, other.sede)) {
            return false;
        }
        return true;
    }

    
    public int getPunteggio(){
        int ris=0;
        for (Partita partita : WinCalcio.listapartite) {
            if(nome.equals(partita.getSquadra1())){
           if(partita.getGol1()== partita.getGol2()){
                  ris+=1;
            }
           else if(partita.getGol1() > partita.getGol2()){
               ris+= 3;
           }
           else{
               
           }
      }
                     if(nome.equals(partita.getSquadra2())){
           if(partita.getGol1()== partita.getGol2()){
                  ris+=1;
            }
           else if(partita.getGol1() < partita.getGol2()){
               ris+= 3;
           }
           else{
               
           }
      }
        
    }
    return ris;
}
}
