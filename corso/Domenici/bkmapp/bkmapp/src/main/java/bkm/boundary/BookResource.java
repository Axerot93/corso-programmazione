/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bkm.boundary;

import bkm.control.BookStore;
import bkm.control.TagStore;
import bkm.entity.Book;
import bkm.entity.Tag;
import bkm.entity.User;
import java.util.List;
import java.util.Set;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

@Path("/books")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(
        name = "Gestione Books", description = "Permetti ad ogni utente di gestire i propri Books"
)
@DenyAll
public class BookResource {
    @Inject
    BookStore store;
    
    @Inject
    TagStore tagStore;
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("users")
    public List <Book> find(@PathParam("id") Long id) {
        return store.byUser(id);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("users")
    public Book update(@PathParam("id") Long id, @Valid Book entity) {
        return store.save(entity);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("users")
    public void delete(@PathParam("id") Long id) {
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Permette la registrazione di un nuovo book")
    @APIResponses({
        @APIResponse(responseCode = "201", description = "book creato con successo")
    })
    @RolesAllowed("users")   
    public Response create(@Valid Book entity) {
        Book saved = store.save(entity);
        return Response.status(Response.Status.CREATED)
                .entity(saved)
                .build();
    }
    
     @PATCH
    @Path("{id}/tags")
    @Consumes(MediaType.TEXT_PLAIN)
    public void addTag(@PathParam("id") Long id, @NotBlank String tag) {
        Book found = store.find(id).orElseThrow(() -> new NotFoundException());
        store.addTag(found,tag);
    }

  }
