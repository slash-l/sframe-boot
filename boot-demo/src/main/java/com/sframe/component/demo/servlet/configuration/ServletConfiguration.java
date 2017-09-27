package com.sframe.component.demo.servlet.configuration;

import java.util.Arrays;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ServletConfiguration {

	@Bean
	public ServletRegistrationBean createBookServlet(){
		ServletRegistrationBean servlet = new ServletRegistrationBean(new BookServlet(), "/book.do");
		return servlet;
	}
	
	@Bean
	public FilterRegistrationBean createFilterRegistrationBean(){
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new EchoFilter());
		filter.setUrlPatterns(Arrays.asList("/book.do"));
		return filter;
	}
	
	@Bean
	public ServletListenerRegistrationBean<StartupListener> createServletListenerRegistrationBean(){
		ServletListenerRegistrationBean<StartupListener> listener = new ServletListenerRegistrationBean<>(new StartupListener());
		return listener;
	}
}
