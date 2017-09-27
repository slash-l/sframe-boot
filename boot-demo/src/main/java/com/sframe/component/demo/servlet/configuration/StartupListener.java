package com.sframe.component.demo.servlet.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("=================");
		System.out.println("application is started");
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}
}
