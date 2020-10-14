package com.converter;

import org.glassfish.jersey.server.ResourceConfig;

public class resourceConf extends ResourceConfig {
    public resourceConf() {
        packages("com.converter");
        register(AuthFilter.class);
    }
}