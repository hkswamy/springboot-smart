/**
 * 
 */
package com.telcosmart.apigateway.filter;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author Kumaraswami Hosuru
 *
 */
public class ApiGatewayFilter extends ZuulFilter{
	
	private static Logger log = (Logger) LoggerFactory.getLogger(ApiGatewayFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest hsr = rc.getRequest();
		log.info(String.format("%s request to %s", hsr.getMethod() ,hsr.getRequestURL().toString()));
		return null;
	}

	@Override
	public String filterType() {
		return "Pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
