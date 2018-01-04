package fr.dauphine.tprestjersey.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/ftocservice")
public class FtoCService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response converFtoC() {
		JSONObject jsonObject = new JSONObject();
		Double resultat = 98.24;
		jsonObject.put("F Value", 98.24);
		jsonObject.put("C Value", resultat);
		return Response.status(200).entity(jsonObject.toString()).build();

	}
	
	@GET
	@Path("/{f}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertCtoFfromInput(@PathParam("f") double f) {
		JSONObject jsonObject = new JSONObject();
		double resultat = (f - 32)*5/9;
		jsonObject.put("F Value", f);
		jsonObject.put("C Value", resultat);
		return Response.status(200).entity(jsonObject.toString()).build();

	}
	

}
