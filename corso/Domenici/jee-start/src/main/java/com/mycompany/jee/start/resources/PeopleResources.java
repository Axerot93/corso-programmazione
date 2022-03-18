/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jee.start.resources;

import it.tss.jee.start.entity.Entity.Person;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("people")
public class PeopleResources {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Person> all(){
        return Stream.of(new Person(1, "mario", "rossi", 35), new Person(2,"maria","verdi",25))
                .collect(Collectors.toList());
    }
      @GET
      @Produces(MediaType.APPLICATION_JSON)
      @Path("lastnames")
    
    public JsonArray allCognomi(){
        return Stream.of(new Person(1, "mario", "rossi", 35), new Person(2,"maria","verdi",25))
                .map(Person::ToJsonMin).collect(JsonCollectors.toJsonArray());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Person p){
        System.out.println(p);
    }
}
