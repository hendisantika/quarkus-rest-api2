package com.hendisantika.people.web;

import com.hendisantika.people.db.PersonRepository;
import com.hendisantika.people.model.Person;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-rest-api2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/10/21
 * Time: 06.58
 */
@Path("/people")
public class PersonResource {

    private final PersonRepository personRepository;

    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // using `Response` requires extra code to enable runtime reflection
    // this is important if running against GraalVM
    // the serialization type can infer the serialization types at compile time
    // meaning that nothing needs to be done when the code below is used
    // maybe cover this in a separate post?
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("id") UUID id) {
        return personRepository.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Person post(Person person) {
        return personRepository.insert(
                new Person(UUID.randomUUID(), person.getName(), person.getAge()));
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person put(@PathParam("id") UUID id, Person person) {
        if (personRepository.findById(id) == null) {
            throw new PersonNotFoundException(id);
        }
        return personRepository.update(new Person(id, person.getName(), person.getAge()));
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") UUID id) {
        if (personRepository.findById(id) == null) {
            throw new PersonNotFoundException(id);
        }
        personRepository.deleteById(id);
    }
}
