/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.world.boundary;

import it.tss.world.control.CityStore;
import it.tss.world.control.CountryStore;
import it.tss.world.entity.City;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */

@Path("/city")
public class CityResources {
    
    @Inject
    CityStore storecity;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> all(){
        return storecity.all();
    }
    
    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public City findByName(@QueryParam("name") String name){
        return storecity.byName(name).orElseThrow(() ->new NotFoundException("tag non trovato"));
    }
    
}
