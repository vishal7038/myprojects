package edu.pr.web.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * @author Devika Bhatt
 *
 */


public class PplmgmtRequestInterceptor extends HandlerInterceptorAdapter 
{
	static final Logger logger = Logger.getLogger(PplmgmtRequestInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
				
		logger.debug("********  PplmgmtRequestInterceptor :: preHandle()  ");
	
		return true;
	
	}

}
