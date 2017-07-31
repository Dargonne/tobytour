<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.web.dao.RegisterDAO" %>
<%@ page import = "java.io.PrintWriter" %>
<%
	String id = request.getParameter("id"); 
	try{
		RegisterDAO dao = RegisterDAO.getInstance();
		PrintWriter resultOut = response.getWriter();
		if(!dao.validateID(id)){
			resultOut.println("<html><head><title>ID 重複ﾁｴｯｸ</title>"); 
			resultOut.println("<script>"); 
			resultOut.println(" alert('IDが使用中です。他のIDを使用してください。');"); 
			resultOut.println(" self.opener = self; "); 
			resultOut.println(" self.close();");
			resultOut.println("</script>"); 
		} else {
			resultOut.println("<html><head><title>ID 重複ﾁｴｯｸ</title>"); 
			resultOut.println("<script>"); 
			resultOut.println(" alert('使用可能IDです。');"); 
			resultOut.println(" self.opener = self; "); 
			resultOut.println(" self.close();");
			resultOut.println("</script>"); 
		}
		
		
	}catch(Exception e){}


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID 重複ﾁｴｯｸ</title>
</head>
<body>

</body>
</html>