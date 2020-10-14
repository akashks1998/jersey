package com.converter;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Path("/timeToEpoch")
public class timeToEpoch
{

    @RolesAllowed("ADMIN")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response converter(@FormParam("dateAndTime") String dateAndTime) {

        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        try{
            Date date = df.parse(dateAndTime);
            long epoch = date.getTime();
            return Response.ok(String.valueOf(epoch)).build();
        }catch (ParseException e){
            return Response.status(400).entity("Incorrect format required format is dd/mm/yyyy HH:mm:ss").build();
        }
    }
}
