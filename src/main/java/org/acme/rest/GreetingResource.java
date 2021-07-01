package org.acme.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greeting")
public class GreetingResource {

    @ConfigProperty(name = "APP_NAME")
    String appName;
    public static final String ANSI_BLUE = "\033[0;34m";
    public static final String ANSI_RESET = "\033[0m";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println( ANSI_BLUE + "Application Name " + appName + ANSI_RESET + "\n");
        return ANSI_BLUE + "Application Name " + appName + ANSI_RESET;
    }
}