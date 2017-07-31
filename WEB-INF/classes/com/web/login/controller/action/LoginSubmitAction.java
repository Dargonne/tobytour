package com.web.login.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.LoginDAO;
import com.web.dto.LoginDTO;

public class LoginSubmitAction implements LoginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url_user = "/web/login/finishUser.jsp";

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		LoginDTO dto = new LoginDTO();
		LoginDAO dao = LoginDAO.getInstance();
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		dto = dao.loginSubmit(id);

		// 세션초기화 및 생성
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		session = request.getSession(true);


		if (dto.getId()==null) {
			out.println("<script type='text/javascript'>alert('会員がありません。')");
			out.println("location.href('./LoginServlet?command=login_form')</script>"); 
		} else if (id.equals(dto.getId()) && pass.equals(dto.getPass())) {
			session.setAttribute("id", dto.getId());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url_user);
			dispatcher.forward(request, response);

		} else if (id.equals(dto.getId()) && pass != dto.getPass()) {
			out.println("<script type='text/javascript'>alert('ﾊﾟｽﾜ-ﾄﾞが違います。')");
			out.println("location.href('./LoginServlet?command=login_form')</script>");
		}
	}

}
