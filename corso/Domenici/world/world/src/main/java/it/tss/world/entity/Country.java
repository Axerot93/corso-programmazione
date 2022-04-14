/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.world.entity;

import it.tss.world.boundary.CountryResources;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

    @Id
    private String Code;

    @Column(nullable = true)
    private String Name;

    @Column(nullable = true)
    private String Continent;

    @Column(nullable = true)
    private String Region;

    @Column(nullable = true)
    private Float SurfaceArea;

    @Column(nullable = true)
    private Integer IndepYear;

    @Column(nullable = true)
    private Integer Population;

    @Column(nullable = true)
    private Float LifeExpectancy;

    @Column(nullable = true)
    private Float GNP;

    @Column(nullable = true)
    private Float GNPOld;

    @Column(nullable = true)
    private String LocalName;

    @Column(nullable = true)
    private String GovernmentForm;

    @Column(nullable = true)
    private String HeadOfState;

    @Column(nullable = true)
    private Integer Capital;

    @Column(nullable = true)
    private String Code2;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public Float getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(Float SurfaceArea) {
        this.SurfaceArea = SurfaceArea;
    }

    public Integer getIndepYear() {
        return IndepYear;
    }

    public void setIndepYear(Integer IndepYear) {
        this.IndepYear = IndepYear;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer Population) {
        this.Population = Population;
    }

    public Float getLifeExpectancy() {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(Float LifeExpectancy) {
        this.LifeExpectancy = LifeExpectancy;
    }

    public Float getGNP() {
        return GNP;
    }

    public void setGNP(Float GNP) {
        this.GNP = GNP;
    }

    public Float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(Float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return LocalName;
    }

    public void setLocalName(String LocalName) {
        this.LocalName = LocalName;
    }

    public String getGovernmentForm() {
        return GovernmentForm;
    }

    public void setGovernmentForm(String GovernmentForm) {
        this.GovernmentForm = GovernmentForm;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public void setHeadOfState(String HeadOfState) {
        this.HeadOfState = HeadOfState;
    }

    public Integer getCapital() {
        return Capital;
    }

    public void setCapital(Integer Capital) {
        this.Capital = Capital;
    }

    public String getCode2() {
        return Code2;
    }

    public void setCode2(String Code2) {
        this.Code2 = Code2;
    }
    
    public JsonObject toJsonSlice() {
        return Json.createObjectBuilder()
                .add("Code", this.Code)
                .add("link", UriBuilder.fromResource(CountryResources.class)
                        .path(CountryResources.class,"find")
                        .build(this.Code).toString())
                .build();

    }

    @Override
    public String toString() {
        return "Country{" + "Code=" + Code + ", Name=" + Name + ", Continent=" + Continent + ", Region=" + Region + ", SurfaceArea=" + SurfaceArea + ", IndepYear=" + IndepYear + ", Population=" + Population + ", LifeExpectancy=" + LifeExpectancy + ", GNP=" + GNP + ", GNPOld=" + GNPOld + ", LocalName=" + LocalName + ", GovernmentForm=" + GovernmentForm + ", HeadOfState=" + HeadOfState + ", Capital=" + Capital + ", Code2=" + Code2 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.Code);
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
        final Country other = (Country) obj;
        return Objects.equals(this.Code, other.Code);
    }

}
