package com.dwapp.project

import com.fasterxml.jackson.annotation.JsonProperty
import com.yammer.dropwizard.config.Configuration
import com.yammer.dropwizard.db.DatabaseConfiguration

import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * Created by Mohsan on 03-05-2014.
 */
class ApplicationConfiguration extends Configuration{

    @Valid
    @NotNull
    @JsonProperty("database")
    private DatabaseConfiguration database = new DatabaseConfiguration();

    public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }

}
