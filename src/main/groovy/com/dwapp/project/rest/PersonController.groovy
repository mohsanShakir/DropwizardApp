package com.dwapp.project.rest

import com.dwapp.project.domain.Person
import com.dwapp.project.service.PersonService
import com.yammer.dropwizard.hibernate.UnitOfWork

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Created by Mohsan on 03-05-2014.
 */
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
class PersonController {

    final PersonService personService

    public PersonController(PersonService personService) {
        this.personService = personService
    }

    @GET
    @UnitOfWork
    public List<Person> listPersons() {
        return personService.findAll()
    }

    @Path("/add")
    @GET
    @UnitOfWork
    public String savePerson() {
        personService.save(new Person(name: "Mohsan", age: 21))
        return "Person created"
    }

}
