/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.world.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage implements Serializable {

    @EmbeddedId
    protected CountrylanguagePK countrylanguagePK;

    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Country country;

    @Enumerated(EnumType.STRING)
    private IsOfficialEnum IsOfficial;

    private Float Percentage;

    public Country getCountryCode() {
        return country;
    }

    public void setCountryCode(Country country) {
        this.country = country;
    }

    public IsOfficialEnum getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(IsOfficialEnum IsOfficial) {
        this.IsOfficial = IsOfficial;
    }

    public Float getPercentage() {
        return Percentage;
    }

    public void setPercentage(Float Percentage) {
        this.Percentage = Percentage;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.countrylanguagePK);
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
        final CountryLanguage other = (CountryLanguage) obj;
        return Objects.equals(this.countrylanguagePK, other.countrylanguagePK);
    }

    @Override
    public String toString() {
        return "CountryLanguage{" + "countrylanguagePK=" + countrylanguagePK + ", country=" + country + ", IsOfficial=" + IsOfficial + ", Percentage=" + Percentage + '}';
    }

}
