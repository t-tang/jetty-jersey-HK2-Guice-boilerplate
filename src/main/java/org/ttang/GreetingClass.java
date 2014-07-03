package org.ttang;

import javax.inject.Singleton;

@Singleton
public class GreetingClass {
	private static final String greeting = "Greetings";

	public String getGreeting() {
		return greeting;
	}
}
