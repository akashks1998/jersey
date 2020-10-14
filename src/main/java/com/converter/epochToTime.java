package com.converter;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Path("/epochToTime")
public class epochToTime {
    @RolesAllowed("ADMIN")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response converter(@FormParam("epoch") Long epoch) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return Response.ok(dateFormat.format(new Date(epoch))).build();
    }
}