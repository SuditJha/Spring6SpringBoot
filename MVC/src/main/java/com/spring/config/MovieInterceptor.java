package com.spring.config;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MovieInterceptor implements HandlerInterceptor {
	
	

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		Date accessedDate = new Date();
		System.out.println("Accesses Date : " + accessedDate);
		return true;
	}
	
	public void posthandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) throws Exception {
		
	}
	
	
	public void afterCompletion (HttpServletRequest req, HttpServletResponse res, Object handler, Exception exception) throws Exception {
		
	}
	
}
