<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="./product/js/product.js"></script>
<body>
	<%
	String path = new java.io.File("../real/Toby/WebContent/temp/img/product/").getCanonicalPath();
	
		String fileName = "";
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 10, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration files = mr.getFileNames();
			String file1 = (String) files.nextElement();
			fileName = mr.getFilesystemName(file1);
			session.setAttribute("productImage", fileName);
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