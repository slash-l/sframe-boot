package com.sframe.component.demo.servlet.annotation;

import java.time.LocalDateTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("app startup at " + LocalDateTime.now().toString());
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}
}
