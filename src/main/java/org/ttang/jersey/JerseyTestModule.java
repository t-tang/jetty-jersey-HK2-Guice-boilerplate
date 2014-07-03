package org.ttang.jersey;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ttang.GreetingClass;

@Path("/hello")
@Singleton
public class JerseyTestModule {
	
	@Inject GreetingClass greetingClass;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello() {
		return Response.ok(greetingClass).build();
	}
}