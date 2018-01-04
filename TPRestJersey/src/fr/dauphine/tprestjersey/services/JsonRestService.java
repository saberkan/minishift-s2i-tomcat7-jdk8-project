package fr.dauphine.tprestjersey.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class JsonRestService {
	
	@POST
	@Path("/jsonRestService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response receiveData(InputStream incomingData) {
		StringBuilder receiveBuilder = new StringBuilder();
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while((line = in.readLine()) != null) {
				receiveBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + receiveBuilder.toString());
		
		return Response.status(200).entity(receiveBuilder.toString()).build();
	}
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "JsonRestService succefully started";
		return Response.status(200).entity(result).build();
	}
}
