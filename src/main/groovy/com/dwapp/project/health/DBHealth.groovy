package com.dwapp.project.health

import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.metrics.core.HealthCheck

/**
 * Created by Mohsan on 04-05-2014.
 */
class DBHealth extends HealthCheck {

    private final DatabaseConfiguration database;

    public DBHealth(DatabaseConfiguration database) {
        super("database");
        this.database = database;
    }

    @Override
    protected com.yammer.metrics.core.HealthCheck.Result check() throws Exception {
        if (database.isCheckConnectionWhileIdle()) {
            return com.yammer.metrics.core.HealthCheck.Result.healthy();
        } else {
            return com.yammer.metrics.core.HealthCheck.Result.unhealthy("Cannot connect to " + database.getUrl());
        }
    }
}
