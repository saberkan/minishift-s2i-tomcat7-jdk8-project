package fr.dauphine.tprestjersey.services;

import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.dauphine.tprestjersey.model.Database;
import fr.dauphine.tprestjersey.model.Todo;
import fr.dauphine.tprestjersey.model.Todos;


@Path("/todo")
public class TodoService {

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Todo getTodo(@PathParam("id") String id) {
		return Database.getTodo(id);
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Todos getTodos() {
		Todos todos = new Todos();
		for(Entry<String, Todo> entry : Database.todos.entrySet()) {
			todos.add(entry.getValue());
		}
		return todos;
	}
	
	@DELETE
	@Path("/{id}")
	public void removeTodo(@PathParam("id") String id) {
		Database.todos.remove(id);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addTodo(@FormParam("id") String id, @FormParam("titre") String titre, @FormParam("description") String description) {
		System.out.println("addTodo - id : " + id + ", titre : " + titre + ", description : " + description);
		Todo todo = new Todo();
		todo.setId(id);
		todo.setTitre(titre);
		todo.setDescription(description);
		Database.todos.put(id, todo);
		return Response.status(201).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response addTodo(@PathParam("todo") Todo todo) {
		System.out.println("addTodo2 :" + todo);
		/*System.out.println("addTodo - id : " + id + ", titre : " + titre + ", description : " + description);
		Todo todo = new Todo();
		todo.setId(id);
		todo.setTitre(titre);
		todo.setDescription(description);*/
		Database.todos.put(todo.getId(), todo);
		return Response.status(201).build();
	}


	
	@PUT
	@Path("/{id}")
	public void updateTodo(@PathParam("id") String id) {
		Todo todo = Database.getTodo(id);
		todo.setDone(!todo.isDone());
		Database.todos.put(id, todo);
	}
	
	
}
