package com.inti.compte.bancaire.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti.compte.bancaire.entities.Compte;
import com.inti.compte.bancaire.metier.IBanqueMetier;

@Path("/comptes")
public class CompteResource {


/*
    @Autowired
    private IBanqueMetier compteRepository;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Compte> getAllComptes() {
        return compteRepository.;
    }

 
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Compte getCompte(@PathParam("id")  Long id) {
        return compteRepository.consulterCompte(id)  ;
    }
/*
    @PUT
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateCompte(Compte Compte, @PathParam("id") int id) {
        compteRepository.updateCompte(Compte, id);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteCompte(@PathParam("id") Long id) {
        compteRepository.supprimerCompte(id);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addCompte(Compte compte, @Context UriInfo uriInfo) {
    	// Compte(String nom, Collection<Compte> comptes) 
        compteRepository.ajouter(new Compte(Compte.getNom(), Compte.getComptes()));
        return Response.status(Response.Status.CREATED.getStatusCode()).header("Location", String.format("%s/%s", uriInfo.getAbsolutePath().toString(), Compte.getCode())).build();
    }*/
   
}

