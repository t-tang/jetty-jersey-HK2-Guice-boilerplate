package org.ttang.jersey; 

import org.ttang.GreetingClass;

import com.google.inject.servlet.ServletModule;

public class GuiceModule extends ServletModule {
	
	@Override
	protected void configureServlets() {
		// No need to bind Jersey modules, since Jersey will discover these packages according to it's package config
		bind(GreetingClass.class);
	}
}