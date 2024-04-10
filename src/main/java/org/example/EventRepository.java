package org.example;

import org.example.api.Event;
import org.example.resources.EventResource;
import org.omg.CORBA.Environment;

import java.util.List;
import java.util.Optional;

public interface EventRepository {


    //Get All the Events
    List<Event> findAll();

    //Get specific Events
    Optional<Event> findById(Long id);

    //Post the Events
    Event save(Event event);

    //Update the Specific Events
    Optional<Event> update(Long id, Event event);

    //Delete the specific Events
    void delete(Long id);

}
