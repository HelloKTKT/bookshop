package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req1, ServletResponse res1, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) req1;
		HttpServletResponse res=(HttpServletResponse) res1;
		HttpSession hs=req.getSession(false);
		System.out.println("filter ok!");
		if(hs==null||hs.getAttribute("userid")==null){
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter out=res.getWriter();
			out.print("<script language='javascript'>window.alert('ÇëÄúÏÈµÇÂ¼£¡');</script>"); 
			out.print("<script>window.history.go(-1);</script> ");
			out.flush();
			out.close();
			//res.sendRedirect("../login.html");
		}else{
			res.setContentType("text/html;charset=UTF-8");
		chain.doFilter(req, res);
		}
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
