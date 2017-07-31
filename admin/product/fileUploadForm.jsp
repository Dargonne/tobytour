<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<% String checkImage=request.getParameter("checkImage");
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Image File Upload...</title>
<script type="text/javascript" src="./js/product.js"></script>
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../temp/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../temp/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../temp/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
		 <div class="box box-primary">
            <div class="box-header with-border">
        	<%
				if(checkImage.equals("product")){
			%>
 			<h3 class="box-title">商品画像付き</h3>  </div>
			<div class="box-body">
				<div class="form-group">
 				<form role="form" action="productImageUpload.jsp" method="post" enctype="multipart/form-data">
  					<input type="file" name="up_file"/> <label for="up_file"></label><br>
   					<p class="help-block">画像を添付してください。</p>
   					<input type="submit" class="btn btn-primary" value="Upload"/>
 				</form>
 				</div>
 			</div>
 			
			<%}else if(checkImage.equals("hotel")){
			%><h3 class="box-title">ホテル画像添付</h3>  </div>
 			<div class="box-body">
 				<div class="form-group">
 				<form action="hotelImageUpload.jsp" method="post" enctype="multipart/form-data">
 				 <input type="file" name="up_file"/> <label for="up_file"></label><br>
   				<p class="help-block">画像を添付してください。 </p>
   				<input type="submit" class="btn btn-primary"  value="Upload"/>
   				</form>
 				</div>
 			</div>
		<%} %>
</div>
</body>
</html>