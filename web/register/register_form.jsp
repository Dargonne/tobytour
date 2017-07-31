<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %>
<%@ page import ="javax.servlet.http.HttpServletRequest" %>
<%@ page import ="javax.servlet.http.HttpServletResponse" %>
<%@ page import ="javax.servlet.http.HttpSession" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>TOBYTOUR - 24Hours Your Travel Partner</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="author" content="http://bootstraptaste.com" />
<!-- css -->
<link href="../temp/css/bootstrap.min.css" rel="stylesheet" />
<link href="../temp/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="../temp/css/jcarousel.css" rel="stylesheet" />
<link href="../temp/css/flexslider.css" rel="stylesheet" />
<link href="../temp/css/style.css" rel="stylesheet" />


<!-- Theme skin -->
<link href="../temp/skins/default.css" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<script>
	function checkID()
	{
		var sid = document.frm.userID.value; 
		if(sid == "") 
		{
			alert('入力されたIDがありません。'); 
		} else{
			window.open("register_validate_id.jsp?id=" + sid, "", "width=400 height=150"); 
			
		}
	}
</script>
</head>
<body>
<div id="wrapper">
<!-- start header -->
		<header>
		<c:choose>
			 <c:when test="${id != null }">
      			  <div class="navbar navbar-default navbar-static-top">
           			 <div class="container">
               		 <div class="navbar-header">
                    		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                       	 <span class="icon-bar"></span>
                       	 <span class="icon-bar"></span>
                      	  <span class="icon-bar"></span>
                   	 </button>
                   	 <a class="navbar-brand" href="../main/WebMainServlet?command=main_page"><span>T</span>obyTOUR</a>
               	 </div>
                	<div class="navbar-collapse collapse">
                 	   <ul class="nav navbar-nav">
                        <li class="active"><a href="../main/WebMainServlet?command=main_page">Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">Product <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../product/ProductServlet?command=product_list">日本</a></li>
                            </ul>
                        </li>
						<li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">MY PAGE <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
								<li><a href="../mypage/MainServlet?command=mypage_form">マイページ</a></li>
                                <li><a href="../mypage/ModifyServlet?command=modify_main">情報修正</a></li>
								<li><a href="../mypage/WebRequestServlet?command=request_list">1:1お問い合わせ</a></li>
								<li><a href="../mypage/MemberOutServlet?command=member_out_form">会員脱退</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">FAQ <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
								<li><a href="../faq/notice/WebNoticeServlet?command=notice_list">公知事項</a></li>
                                <li><a href="../faq/often_question/WebFaqListServlet?command=faq_list">しきりにする質問</a></li>
                            </ul>
                        </li>
                        <li><a href="../login/LoginServlet?command=logout">Log-Out</a></li>
                    </ul>
                </div>
            </div>
        </div>  
	</c:when>
	 <c:when test="${id eq null }">
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="../main/WebMainServlet?command=main_page"><span>T</span>obyTOUR</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="../main/WebMainServlet?command=main_page">Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">Product <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../product/ProductServlet?command=product_list">日本</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">FAQ <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
								<li><a href="../faq/notice/WebNoticeServlet?command=notice_list">公知事項</a></li>
                                <li><a href="../faq/often_question/WebFaqListServlet?command=faq_list">しきりにする質問</a></li>
                            </ul>
                        </li>
                        <li><a href="../login/LoginServlet?command=login_form">Log-In</a></li>
					    <li><a href="../register/RegisterServlet?command=register_form">REGISTER</a></li>
                    </ul>
                </div>
            </div>
        </div>
        </c:when>
	</c:choose>
	</header>
	<!-- end header -->
	<section id="inner-headline">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<ul class="breadcrumb">
					<li><a href="#"><i class="fa fa-home"></i></a><i class="icon-angle-right"></i></li>
					<li><a href="#">会員加入</a><i class="icon-angle-right"></i></li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<section id="content">
	<div class="container">
		<div class="row demobtn">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-12">
						<h2>会員加入</h2>
					</div>
				</div>
				<!-- divider -->
				<div class="row">
					<div class="col-lg-12">
						<div class="solidline">
						</div>
					</div>
				</div>
				<!-- end divider -->
				<div class="col-lg-12">
				<div class="pricing-box-alt">
					<div class="pricing-content">
					<form name="frm" action="./RegisterServlet" method="post">
						<input type="hidden" name="command" value="register_insert" />
						<table border="0" align="center">
							<tr>
								<td colspan="2">&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td><p align="right">ID : </p></td>
								<td><p align="left">&nbsp;<input type="text" placeholder="ex)email@youremail.com" name="userID"  size="30"/>&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-theme" name="validateID" value="重複確認" onClick="javascript:checkID()"/></p></td>
							</tr>
							<tr>
								<td><p align="right">PW : </p></td>
								<td><p align="left">&nbsp;<input type="password" placeholder="英文、数字を含めた10~15字前後 " name="userPassword1" size="30" /></p></td>
							</tr>
							<tr>
								<td><p align="right">PW再入力 : </p></td>
								<td><p align="left">&nbsp;<input type="password" placeholder="同一のパスワードを入力してください " name="userPassword2" size="30"/></p></td>
							</tr>
							<tr>
								<td><p align="right">名前 : </p></td>
								<td><p align="left">&nbsp;<input type="text" placeholder="名前を入力してください" name="userName" size="30"/></p></td>
							</tr>
							<tr>
								<td><p align="right">生年月日 : </p></td>
								<td><p align="left">&nbsp;<input type="text" placeholder="ex)20000713" name="userBirth" size="30"/> </p></td>
							</tr>
							<tr>
								<td><p align="right">性別 : </p></td>
								<td><p align="left">&nbsp;<input type="radio" name="userSex" value="0" checked="checked"/>&nbsp;&nbsp;男性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="userSex" value="1" />&nbsp;&nbsp;女性</p></td>
							</tr>
							<tr>
								<td><p align="right">連絡先 : </p></td>
								<td><p align="left">&nbsp;<input type="text" name="userPhone"	 placeholder="ex)07012345678" size="30"/></p></td>
							</tr>
							<tr>
								<td><p align="right">住所く : </p></td>
								<td><p align="left">&nbsp;<input type="text" name="userAddress"	 placeholder="ex)東京市" size="30"/></p></td>
							
							</tr>
							<tr>
								<td><p align="right">ﾒｰﾙ受信するかどうか : </p></td>
								<td><p align="left">&nbsp;<input type="radio" name="userEmail" value="0" />&nbsp;&nbsp;はい&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="userEmail" value="1" />&nbsp;&nbsp;いいえ</p></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;&nbsp;</td>
							</tr>
						</table>
					</div>
					<div class="pricing-action">
						<input type="submit" class="btn btn-medium btn-theme" value="会員加入" />&nbsp;&nbsp;<input type="reset" class="btn btn-medium btn-theme" value="もう一度書く" />&nbsp;&nbsp;<input type="button" class="btn btn-medium btn-theme" onclick="location.href='../main/WebMainServlet?command=main_page'" value="キャンセル" />
					</div>
				</div>
			</div>
			</form>
				<!-- divider -->
				<div class="row">
					<div class="col-lg-12">
						<div class="solidline">
						</div>
					</div>
				</div>
				<!-- end divider -->
			
		</div>
	</div>
	</section>
<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">TOBYTOUR PROJECT</h5>
					<address>
					<strong>The Ctrl + C, V Team</strong><br>
					 825, Gyeryong-ro, Jung-gu, Daejeon, Korea
					</address>
					<p>
						<i class="icon-phone"></i> (070)1234-5678 <br>
						<i class="icon-envelope-alt"></i> help@flytoby.com
					</p>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">主要メニュー</h5>
					<ul class="link-list">
						<li><a href="../../main/WebMainServlet?command=main_page">HOME</a></li>
						<li><a href="../../product/ProductServlet?command=product_list">PRODUCT</a></li>
						<li><a href="../../mypage/WebRequestServlet?command=request_list">FAQ</a></li>
						<li><a href="../../register/RegisterServlet?command=register_form">REGISTER</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">HELP DESK</h5>
					<ul class="link-list">
						<li>運営日 : 年中無休</li>
						<li>運営時間 : 00:00 ~ 24:00(24時間)</li>
						<li>連絡先 : (070)1234-5678</li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="widget">
					<h5 class="widgetheading">COOPERATION ORGANIZATION</h5>
					<ul class="link-list">
						<li><a href="http://koreanair.com/" target="_blank">KOREAN AIR</a></li>
						<li><a href="http://flyasiana.com/" target="_blank">ASIANA AIR</a></li>
						<li><a href="http://www.jal.com/" target="_blank">JAL</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="sub-footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="copyright">
						<p>
							<span>Copyright &copy; TOBYTOUR 2016 All right reserved. Powered By </span><a href="http://bootstraptaste.com" target="_blank">Bootstrap Themes</a>
						</p>
                        <!-- 
                            All links in the footer should remain intact. 
                            Licenseing information is available at: http://bootstraptaste.com/license/
                            You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Moderna
                        -->
					</div>
				</div>
				<div class="col-lg-6">
					<ul class="social-network">
						<li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest"></i></a></li>
						<li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</footer>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../temp/js/jquery.js"></script>
<script src="../temp/js/jquery.easing.1.3.js"></script>
<script src="../temp/js/bootstrap.min.js"></script>
<script src="../temp/js/jquery.fancybox.pack.js"></script>
<script src="../temp/js/jquery.fancybox-media.js"></script>
<script src="../temp/js/google-code-prettify/prettify.js"></script>
<script src="../temp/js/portfolio/jquery.quicksand.js"></script>
<script src="../temp/js/portfolio/setting.js"></script>
<script src="../temp/js/jquery.flexslider.js"></script>
<script src="../temp/js/animate.js"></script>
<script src="../temp/js/custom.js"></script>
</body>
</html>