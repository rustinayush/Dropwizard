package org.example;

import io.dropwizard.Configuration;
import org.example.resources.EventResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class EventApplication<EventConfiguration extends Configuration> extends Application<EventConfiguration>{
    public static void main(String[] args) throws Exception {
        new EventApplication().run(args);
    }



    @Override
    public void run(EventConfiguration eventConfiguration, Environment environment) throws Exception {
        EventRepository repository = new DummyEventRepository();
        EventResource eventResource = new EventResource(repository);
        environment.jersey().register(eventResource);
    }
}
