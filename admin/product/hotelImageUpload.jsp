<%@page import="java.io.File"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %>
<%@ page import ="javax.servlet.http.HttpServletRequest" %>
<%@ page import ="javax.servlet.http.HttpServletResponse" %>
<%@ page import ="javax.servlet.http.HttpSession" %>
<% 
	String loginID = (String) session.getAttribute("id");	
	
	if(loginID == null){
		PrintWriter scriptOut = response.getWriter(); 
		
		scriptOut.println("<html><head>"); 
		scriptOut.println("<script>"); 
		scriptOut.println(" alert('ログインされていませんでした。ログインしてください。'); "); 
		scriptOut.println(" history.back();"); 
		scriptOut.println("</script><body></body></html>"); 
		
		scriptOut.close(); 
	}
%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="./product/js/product.js"></script>
<body>
	<%
			
		String path = new java.io.File("../real/Toby/WebContent/temp/img/hotel/").getCanonicalPath();
		
		String fileName = "";
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 10, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration files = mr.getFileNames();
			String file1 = (String) files.nextElement();
			fileName = mr.getFilesystemName(file1);
			File s_file = mr.getFile("up_file");
			session.setAttribute("hotelImage", fileName);
	%>
	<script type="text/javascript">
		alert("アップロードが完了しました。");
		window.close();
	</script>
	<%
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>