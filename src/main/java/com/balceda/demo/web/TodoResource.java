package com.balceda.demo.web;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.balceda.demo.entity.Todo;
import com.balceda.demo.service.TodoService;

@Path("todos")
public class TodoResource {

	@Inject
	private TodoService todoService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("id") Long id) {

		Optional<Todo> foundTodo = todoService.findById(id);
		if (foundTodo.isPresent()) {
			Todo existingTodo = foundTodo.get();
			return Response.ok(existingTodo).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> findAll() {
		return todoService.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Todo save(Todo todo) {
		return todoService.save(todo);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Todo todo) {

		Optional<Todo> foundTodo = todoService.findById(id);
		if (foundTodo.isPresent()) {
			Todo existingTodo = foundTodo.get();
			existingTodo.setTask(todo.getTask());
			existingTodo.setDueDate(todo.getDueDate());
			todoService.save(existingTodo);

			return Response.ok(existingTodo).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id) {

		try {
			todoService.delete(id);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity("Todo entity with id " + id + " not found.").build();
		}
	}

}
