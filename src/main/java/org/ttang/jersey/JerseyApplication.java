package org.ttang.jersey;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.google.inject.Guice;

public class JerseyApplication extends ResourceConfig {
	@Inject
    public JerseyApplication(ServiceLocator serviceLocator) {
        
		packages(JerseyApplication.class.getPackage().getName());
		
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
    	GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
    	guiceBridge.bridgeGuiceInjector(Guice.createInjector(new GuiceModule()));
    }
}