package com.lanqiao.CRM.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.lanqiao.CRM.entity.PICharge;

/**
 * Servlet Filter implementation class SessionFilter
 */

public class SessionFilter implements Filter {

	public FilterConfig config;
	  
    String excludeUrl=".*\\.css$,.*\\.js$,.*\\.jpg$,.*\\.png$,.*\\.gif$,.*\\.action$";
  //不需要过滤的模式集合
	private List<Pattern> excludeConllections =null;

    public void destroy() {
        this.config = null;
    }

    public static boolean isContains(String container, String[] regx) {
        boolean result = false;

        for (int i = 0; i < regx.length; i++) {
            if (container.indexOf(regx[i]) != -1) {
                return true;
            }
        }
        return result;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
        response.setContentType("textml;charset=UTF-8");  
        String logonStrings = config.getInitParameter("logonStrings");        // 登录登陆页面
        String includeStrings = config.getInitParameter("includeStrings");    // 过滤资源后缀参数
        String redirectPath = hrequest.getContextPath() + config.getInitParameter("redirectPath");// 没有登陆转向页面
        String disabletestfilter = config.getInitParameter("disabletestfilter");// 过滤器是否有效
        System.out.println("logonStrings=="+logonStrings);
        System.out.println("includeStrings=="+includeStrings);
        System.out.println("redirectPath=="+redirectPath);
        System.out.println("disabletestfilter=="+disabletestfilter);
        
      
        
        if (disabletestfilter.toUpperCase().equals("Y")) {    // 过滤无效
            chain.doFilter(request, response);
            return;
        }
        String[] logonList = logonStrings.split(";");
        String[] includeList = includeStrings.split(";");

        if (!this.isContains(hrequest.getRequestURI(), includeList)) {// 只对指定过滤参数后缀进行过滤
            chain.doFilter(request, response);
            return;
        }

        if (this.isContains(hrequest.getRequestURI(), logonList)) {// 对登录页面不进行过滤
            chain.doFilter(request, response);
            return;
        }
        String uri = hrequest.getRequestURI();
        System.out.println("uri======"+uri);
        PICharge pic = ( PICharge ) hrequest.getSession().getAttribute("PICharge");//判断用户是否登录
        if (this.isExcluderUrl(uri)) {
			//放行
			chain.doFilter(request, response);
		}else{
			 
	        if (pic == null) {
	        	resp.sendRedirect("/CRM/login.html");
	            
	            return;
	        }else {
	            chain.doFilter(request, response);
	            return;
	        }
		}
       
    }
  //判断路径是否需要过滤，如果不需要，则返回true	否则返回false
  	private boolean isExcluderUrl(String requestUrl){
  		for(Pattern p:excludeConllections){
  			if (p.matcher(requestUrl).matches()) {
  				return true;
  			}
  		}
  		return false;
  		
  	}
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
        excludeConllections = new ArrayList<Pattern>();
		//获取WEB.XML 里filter初始化参数
		String str = config.getInitParameter("excludeUrlFromXml");
		excludeUrl+=","+str;
		System.out.println(str);
		
		String[] tokens =excludeUrl.split(",");
		for (String token:tokens) {
			excludeConllections.add(Pattern.compile(token));
		}
    }
}
