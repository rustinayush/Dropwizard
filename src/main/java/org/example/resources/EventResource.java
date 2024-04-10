package org.example.resources;

import io.dropwizard.jersey.params.LongParam;
import org.example.EventRepository;
import org.example.api.Event;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Events")
@Produces({MediaType.APPLICATION_JSON})
public class EventResource {

    private final EventRepository repository;

    public EventResource(EventRepository repository) {
        this.repository = repository;
    }

    @GET
    public List<Event> allEvents() {
        return repository.findAll();
      }

    @GET
    @Path("{id}")
    public Event event(@PathParam("id") LongParam id) {
        return repository.findById(id.get())
                .orElseThrow(() ->
                        new WebApplicationException("Event not found", 404));
    }

    @POST
    public Event create(Event event) {
        return repository.save(event);
    }

    @PUT
    @Path("{id}")
    public Event update(@PathParam("id") LongParam id, Event event) {
        return repository.update(id.get(), event)
                .orElseThrow(() ->
                        new WebApplicationException("Event not found", 404));
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam id) {
        repository.delete(id.get());
        return Response.ok().build();
    }
}
