package com.sframe.component.demo.servlet.annotation;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/user.do")
public class LogFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("income log filter " + request.getRemoteHost());
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
