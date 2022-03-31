/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.boundary;



import it.tss.blogapp.control.TagStore;
import it.tss.blogapp.entity.Tag;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("/tag")
public class TagResource {

    @Inject
    private TagStore tag;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> all() {
        return tag.all();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Valid Tag entity) {
        tag.save(entity);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tag find(@PathParam("id") Long id) {
        return tag.find(id).orElseThrow(() -> new NotFoundException("Tag non trovato. id=" + id));
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Tag found = tag.find(id).orElseThrow(() -> new NotFoundException("Tag non trovato. id=" + id));
        tag.delete(found.getId());
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@Valid Tag entity) {
        tag.update(entity);
    }
}

