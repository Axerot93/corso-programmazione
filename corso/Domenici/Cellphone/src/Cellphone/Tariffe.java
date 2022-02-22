/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cellphone;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class Tariffe {
private String origine;
private String arrivo;
private Float valorealminuto;

    public Tariffe(String origine, String arrivo, Float valorealminuto) {
        this.origine = origine;
        this.arrivo = arrivo;
        this.valorealminuto = valorealminuto;
    }

    public String getOrigine() {
        return origine;
    }

    public String getArrivo() {
        return arrivo;
    }

    public Float getValorealminuto() {
        return valorealminuto;
    }


}

