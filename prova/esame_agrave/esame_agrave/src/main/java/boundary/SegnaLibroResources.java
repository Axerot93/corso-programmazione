/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.SegnaLibroStore;
import entity.User;
import control.UserStore;
import entity.SegnaLibro;
import entity.constant.UserRoles;
import entity.StatusBkms;
import security.JWTManager;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PATH;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.path;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author tss
 */
@Path("/segnalibri")
@Tag(name = "Gestione di Segnalibri", description = "Permette di gestire Segnalibri")
@DenyAll
public class SegnaLibroResources {
    
    @Inject
    private SegnaLibroStore storebook;

    @Inject
    private UserStore storeuser;
    
    @Context
    ResourceContext rc;
    
    @Context
    UriInfo uriInfo;
    
    @Inject
    private JWTManager jwtManager;
    
    @Inject
    private JsonWebToken token;
    
    @Claim(value = "sub")
    private String sub;
    
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Restituisce tutti SegnaLIbro di uno uttenti")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Elenco ritornato con successo"),
        @APIResponse(responseCode = "404", description = "Elenco non trovato")
    })
    @RolesAllowed({"Admin","User"})
    public List<JsonObject> all(@DefaultValue("1") @QueryParam("page") int page, @DefaultValue("10") @QueryParam("size") int size) {
        System.out.println(token);
        User usr = storeuser.findUserbyLogin(token.getName()).orElseThrow(() -> new NotFoundException("user non trovato. id=" + token.getName()));
        System.out.println("Cerca bkms per " + usr.toString());
        return storebook.findAllByUserJson(usr.getId(), page,size);
    }

    
    
    @GET
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Restituisce tutti SegnaLIbro di uno uttenti")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Elenco ritornato con successo"),
        @APIResponse(responseCode = "404", description = "Elenco non trovato")
    })
    @PermitAll
    public Response allnew(@DefaultValue("1") @QueryParam("page") int page, @DefaultValue("10") @QueryParam("size") int size) {
        //System.out.println(token);
        //User usr = storeuser.findUserbyLogin(token.getName()).orElseThrow(() -> new NotFoundException("user non trovato. id=" + token.getName()));
        System.out.println("Cerca bkms per " + 1);
        
   //     return storebook.findAllByUserJson(Long.getLong("1"), 1,1000);
        return Response.status(Response.Status.OK)
                .header("intPage", 10)
                .header("intReg", 1000)
              //  .(storebook.findAllByUserJson(Long.getLong("1"), 1,1000))
                .build();
    }
    
    
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Restituisce tutti BookMarks di un utente")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Bkms singolo di un utente"),
        @APIResponse(responseCode = "404", description = "Bkm non trovato")
    })
    @RolesAllowed({"Admin","User"})
    public List<JsonObject>  findbkm(@PathParam("id") Long id) {
        
        User usr = storeuser.findUserbyLogin(token.getName()).orElseThrow(() -> new NotFoundException("user non trovato. id=" + token.getName()));
        SegnaLibro bkm = storebook.find(id).orElseThrow(() -> new NotFoundException("Bkm non trovato. id=" + id.toString()));
        if(bkm.getUsr() != usr){    
            new NotFoundException("SegnaLibro non trovato. id=" + id.toString());
        }
        System.out.println("Cerca SegnaLivbro per valutazione " + usr.toString());
        return storebook.findBkmsJson(id);
    }
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)   
    @Operation(description = "Permette la registrazione di un nuovo SegnaLIbro")
    @APIResponses({
        @APIResponse(responseCode = "201", description = "Nuovo SegnaLIbro creato con successo"),
        @APIResponse(responseCode = "404", description = "Non è stato possibile creare nuovo SegnaLIbro")
    })
    @RolesAllowed({"Admin","User"})
    public Response create(@Valid SegnaLibro entity) {
        System.out.println("id: " + token.getName());
        System.out.println(entity.toString());
        User usr = storeuser.findUserbyLogin(token.getName()).orElseThrow(() -> new NotFoundException("user non trovato. id=" + token.getName()));
        entity.setUsr(usr);
        entity.setCreazione(LocalDateTime.now());
        entity.setUsragg(usr);
        entity.setAggiornamento(LocalDateTime.now());
        entity.setStatus(StatusBkms.Nuovo);
        SegnaLibro saved = storebook.save(entity);
        System.out.println("SegnaLibro creato " + saved.toString());
        return Response.status(Response.Status.CREATED)
                .entity(saved)
                .build();
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)   
    @Operation(description = "Permette aggiornare un SegnaLibro")
    @APIResponses({
        @APIResponse(responseCode = "201", description = "Nuovo SegnaLibro creato con successo"),
        @APIResponse(responseCode = "404", description = "Non è stato possibile aggiornare il SegnaLibro")
    })
    @RolesAllowed({"Admin","User"})
    public Response update(@Valid SegnaLibro entity) {

        User usr = storeuser.findUserbyLogin(token.getName()).orElseThrow(() -> new NotFoundException("User non trovato. id=" + token.getName()));
        SegnaLibro bkms = storebook.find(entity.getId()).orElseThrow(() -> new NotFoundException("SegnaLibro non trovato. id=" + entity.getDescrizione()));

        if((!entity.getStatus().equals(bkms.getStatus())) && usr.getRoleuser() != UserRoles.Admin){    
            new NotFoundException("Bookmark non trovato. id=" + entity.getDescrizione());
        }
 
        if((!entity.getStatus().equals(bkms.getStatus())) && usr.getRoleuser().equals(UserRoles.Admin) && entity.getStatus().equals(StatusBkms.Vietato)){    
            entity.setCondiviso(false);   
        }
        
        if(!usr.equals(bkms.getUsr()) || usr.getRoleuser() != UserRoles.Admin){
            new NotFoundException("Bookmark non trovato. id=" + entity.getDescrizione());
        }
        
        entity.setId(bkms.getId());
        entity.setVersion(bkms.getVersion());
        entity.setUsr(bkms.getUsr());
        entity.setUsragg(usr);
        entity.setCreazione(bkms.getCreazione());
        entity.setAggiornamento(LocalDateTime.now());
        
        bkms = storebook.save(entity);
        System.out.println("SegnaLibro creato " + bkms.toString());
        
        return Response.status(Response.Status.CREATED)
                .entity(bkms)
                .build();
    }
    
    
    /*-------Tags a un SegnaLIbro----------*/
    
    @PATCH
    //@Path("{id}")
    @Operation(description = "Permette aggiungere una lista di Tag a un SegnaLIbro")
    @APIResponses({
        @APIResponse(responseCode = "201", description = "SegnaLIbro aggiornato con successo"),
        @APIResponse(responseCode = "404", description = "Non è stato possibile aggiornare il SegnaLIbro")
    })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)   
    @RolesAllowed({"Admin","User"})
    public Response addTag(JsonObject jbook){
        
        System.out.println(jbook);
        
        String tg = jbook.getString("Tags");
        String[] tgs = tg.split("#");
        
        SegnaLibro found = storebook.find(Long.parseLong(jbook.getString("idBook"))).orElseThrow(() -> new NotFoundException());
        
        storebook.addTag(found,tgs);
        
        return Response.status(Response.Status.CREATED)
                .build();
        
    }
    
    @DELETE
    @Operation(description = "Permette cancellare un SegnaLIbro")
    @APIResponses({
        @APIResponse(responseCode = "201", description = "SegnaLIbro cancellato con successo"),
        @APIResponse(responseCode = "404", description = "Non è stato possibile cancellare il SegnaLIbro")
    })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)   
    @RolesAllowed({"Admin","User"})
    public Response cancellaBook(JsonObject jbook){
        
        System.out.println(jbook);
        User usr = storeuser.findUserbyLogin(token.getName()).orElseThrow(() -> new NotFoundException("User non trovato. id=" + token.getName()));
        SegnaLibro found = storebook.find(Long.parseLong(jbook.getString("idBook"))).orElseThrow(() -> new NotFoundException());
        
        if(!usr.equals(found.getUsr()) || usr.getRoleuser() != UserRoles.Admin){
            new NotFoundException("SegnaLIbro non trovato. id=" + found.getId());
        }
        
        storebook.delete(found.getId());
        
        return Response.status(Response.Status.OK)
                .build();
        
    }
       
}
