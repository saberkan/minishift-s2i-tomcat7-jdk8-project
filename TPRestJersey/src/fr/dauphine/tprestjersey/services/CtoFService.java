package fr.dauphine.tprestjersey.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ctofservice")
public class CtoFService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response convertCtoF() {
		Double resultat = (36.8 * 9) / 5 + 32;
		return Response.status(200).entity("<ctofservice>" + "<celsius>" + 36.8 + "</celsius>" + "<ctofoutput>" + resultat + "</ctofoutput>" + "</ctofservice>").build();
	}
	
	@GET
	@Path("/{c}")
	@Produces(MediaType.APPLICATION_XML)
	public Response convertCtoFfromInput(@PathParam("c") double c) {
		Double resultat = (c * 9) / 5 + 32;
		return Response.status(200).entity("<ctofservice>" + "<celsius>" + c + "</celsius>" + "<ctofoutput>" + resultat + "</ctofoutput>" + "</ctofservice>").build();
	}
	
}
