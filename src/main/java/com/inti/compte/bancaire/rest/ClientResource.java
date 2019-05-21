package com.inti.compte.bancaire.rest;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti.compte.bancaire.entities.Client;
import com.inti.compte.bancaire.entities.Compte;
import com.inti.compte.bancaire.metier.IClientMetier;



@Path("/clients")
public class ClientResource {

    @Autowired
    private IClientMetier clientRepository;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

 
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Client getClient(@PathParam("id")  Long id) {
        return clientRepository.consulterClient(id)  ;
    }
/*
    @PUT
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateClient(Client Client, @PathParam("id") int id) {
        clientRepository.updateClient(Client, id);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }*/

    @DELETE
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteClient(@PathParam("id") Long id) {
        clientRepository.supprimerClient(id);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addClient(Client client, @Context UriInfo uriInfo) {
    	// Client(String nom, Collection<Compte> comptes) 
        clientRepository.ajouter(new Client(client.getNom(), client.getComptes()));
        return Response.status(Response.Status.CREATED.getStatusCode()).header("Location", String.format("%s/%s", uriInfo.getAbsolutePath().toString(), client.getCode())).build();
    }
   
}
