/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.world.boundary;

import it.tss.world.control.CityStore;
import it.tss.world.control.CountryStore;
import it.tss.world.entity.City;
import it.tss.world.entity.Country;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

/**
 *
 * @author tss
 */

@Path("/country")
public class CountryResources {
   
    
    @Inject
    CountryStore storecountry;
    @Inject
    CityStore storecity;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> all() {
        return storecountry.all();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Country> find(@PathParam("id") String id) {
        return storecountry.find(id);
    }
    
    @POST
    @Path("{id}/city")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCity(@PathParam("id") String id, @Valid City entity) {
        storecity.save(entity);
    }
    
   
    

}
