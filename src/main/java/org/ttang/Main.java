package org.ttang;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.ttang.jersey.JerseyApplication;


public class Main {
	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		ServletContextHandler sch = new ServletContextHandler(server, "/");
		sch.addServlet(DefaultServlet.class,"/").setInitParameter("resourceBase", "webapps");

        ServletHolder jerseyServletHolder = new ServletHolder(new ServletContainer());
        jerseyServletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyApplication.class.getCanonicalName());
        sch.addServlet(jerseyServletHolder, "/services/*");

		server.start();
		server.join();
	}
}

