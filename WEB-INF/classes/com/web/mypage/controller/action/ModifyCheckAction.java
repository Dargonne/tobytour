package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.ModifyDAO;
import com.web.dto.ModifyDTO;

public class ModifyCheckAction implements MypageAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/mypage/modifyForm.jsp";
        
		 HttpSession session = request.getSession();
	     String id= (String) session.getAttribute("id"); 
	        
	        if(id == null){
	        	
	        	response.setContentType("text/html; charset=utf-8"); 
	        	PrintWriter out = response.getWriter();
				
				out.println("<html><head>");
				out.println("<script>");
				out.println(" alert('ﾛｸﾞｲﾝした状態ではありません。 ﾛｸﾞｲﾝしてください。');");
				out.println(" history.back();"); 
				out.println("</script></head><body></body></html>"); 
				
				out.close();	
	        }
        
		ModifyDTO dto = new ModifyDTO();
		String getpass;

		id = request.getParameter("id");
		request.setAttribute("id", id);
		getpass = request.getParameter("pass");

		ModifyDAO dao = ModifyDAO.getInstance();
		dto = dao.checkPass(id);

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		if (dto.getPass().equals(getpass)) {
			request.setAttribute("name", dto.getName());
			request.setAttribute("birth", dto.getBirth());
			request.setAttribute("sex", dto.getSex());
			request.setAttribute("address", dto.getAddress()); 
			request.setAttribute("phone", dto.getPhone());
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			out.println("<script type='text/javascript'>alert('パスワ-ドが一致しません。')");
			out.println("location.href('ModifyServlet?command=modify_main')</script>");
		}
	}
}
