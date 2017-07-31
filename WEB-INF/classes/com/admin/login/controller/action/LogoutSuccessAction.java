package com.admin.login.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutSuccessAction implements LoginAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("text/html; charset=utf-8"); 
		out.println("<html><head>");
		out.println("<script>"); 
		out.println("windows.close();");
		out.println("window.open('../main/MainServlet?command=main_page', '_blank');");
		out.println("</script><body></body></html>");
		
		out.close();
		
		
		
	}

}
