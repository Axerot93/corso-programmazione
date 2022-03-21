/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jee.start.resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.json.JsonObject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tss
 */
@Path("ping")
public class Ping {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@DefaultValue("it")@QueryParam("language")String ln){
        
        if (ln==null){
            
                //throw new BadRequestException("parametro mancante");
                throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).header("mancca il parametro language",ln).build());
            
            
        }
        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        switch(ln){
            
                case"it":
                df= DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm.ss", Locale.ITALY);
                return "ping ok!!" + LocalDateTime.now().format(df); 
                
                case"en":
                df= DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm.ss", Locale.ENGLISH);
                return "ping ok!!" + LocalDateTime.now().format(df); 
                
                default:                
                return "ping ok!!" + LocalDateTime.now().format(df); 
        }
        
    }

   
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping1(@PathParam("id")String id){
        return "ping 1 ok!!" + "parametro: " + id + " " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME); 
    }
}
