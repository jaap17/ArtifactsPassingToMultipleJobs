package org.acme.resource;

import org.acme.config.Message;
import org.acme.mockresponse.OneLoginResponseBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Resource class to poll events of OneLogin.
 */
@Path("/onelogin")
public class OneLoginResource {

    @Inject
    Message message;

    @Inject
    Logger logger;

    /* Getting token name stored in the application.properties file */
    @ConfigProperty(name = "token.value")
    String bearerToken;

    @GET
    @Path("/events")
    public Response getEvents(@HeaderParam("Authorization") String authorizationHeader) {
        logger.debugf("Header: %s", authorizationHeader);
        if (authorizationHeader == null) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(message.error().bearerTokenIsMissing())
                .build();
        }

        if (authorizationHeader.startsWith("Bearer ")) {
            // Extract the token from the Authorization header
            var token = authorizationHeader.substring("Bearer ".length());
            if (token.equals(bearerToken)) {
                // Gets mock response
                var jsonArray = OneLoginResponseBuilder.getMockResponse();
                return Response.ok(jsonArray).build();
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity(message.error().bearerTokenIsInvalid())
                .build();
    }
}
