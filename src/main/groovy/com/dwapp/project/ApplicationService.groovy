package com.dwapp.project

import com.dwapp.project.domain.Person
import com.dwapp.project.health.DBHealth
import com.dwapp.project.rest.PersonController
import com.dwapp.project.service.PersonService
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.assets.AssetsBundle
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.hibernate.HibernateBundle

/**
 * Created by Mohsan on 03-05-2014.
 */
class ApplicationService extends Service<ApplicationConfiguration> {


    final HibernateBundle<ApplicationConfiguration> hibernate = new HibernateBundle<ApplicationConfiguration>(Person.class,Person.class) {
        @Override
        public DatabaseConfiguration getDatabaseConfiguration(ApplicationConfiguration configuration) {
            return configuration.getDatabaseConfiguration()
        }
    }

    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args)
    }

    @Override
    void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.setName("project");
        bootstrap.addBundle(hibernate)
        bootstrap.addBundle(new AssetsBundle("/assests/", "/", "index.html"))

    }

    @Override
    void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
        final PersonService personService = new PersonService(hibernate.getSessionFactory())
        environment.addResource(new PersonController(personService))
        environment.addHealthCheck(new DBHealth(hibernate.getDatabaseConfiguration(configuration)));

    }


}
