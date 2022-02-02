
package it.tss.OO_dado_object;

import java.util.Random;

/**
 *
 * @author tss
 */
public class Dado {
  private final int numeroFacce;
  private int ultimoLancio;

    public Dado(int nFacce) {
        this.numeroFacce = nFacce;
    }
  
  public void lancia(){
      Random rnd = new Random();
      ultimoLancio = rnd.nextInt(numeroFacce) +1;
  }

    public int getNumeroFacce() {
        return numeroFacce;
    }

    public int getUltimoLancio() {
        return ultimoLancio;
    }
  
   
}
