package org.ttang.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/hello")
public class JerseyModule {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response hello() {
		return Response.ok("world").build();
	}
}