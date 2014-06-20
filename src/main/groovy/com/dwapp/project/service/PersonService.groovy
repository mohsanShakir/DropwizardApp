package com.dwapp.project.service

import com.dwapp.project.domain.Person
import com.yammer.dropwizard.hibernate.AbstractDAO
import org.hibernate.SessionFactory
import org.hibernate.criterion.DetachedCriteria

/**
 * Created by Mohsan on 03-05-2014.
 */
class PersonService extends AbstractDAO<Person> {

    public PersonService(SessionFactory factory) {
        super(factory);
    }

    public void save(Person p) {
        currentSession().persist(p)
    }


    public List<Person> findAll() {
        return currentSession().createCriteria(Person.class).list()
    }




}
