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
		scriptOut.println(" alert('ﾛｸﾞｲﾝした状態ではありません。ﾛｸﾞｲﾝしてください。'); "); 
		scriptOut.println(" history.back();"); 
		scriptOut.println("</script><body></body></html>"); 
		
		scriptOut.close(); 
	}
	
%>
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

<!-- Theme Skin -->
<link href="../temp/skins/default.css" rel="stylesheet" />
<style>
	#bline {border-bottom:1px dotted  #CCCCCC; }
</style>
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
					<li><a href="#">旅行商品購買</a><i class="icon-angle-right"></i></li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<section id="content">
	<form action="./ProductServlet" method="post">
	<input type="hidden" name="command" value="purchase_proc" />
	<input type="hidden" name="subproduct_no" value="${productSubNo }"/>
	<input type="hidden" name="id" value="${userID }"/>
	<input type="hidden" name="traveler" value="${traveler }"/>
	<input type="hidden" name="totalcost" value="${totalCost }"/>
	<input type="hidden" name="mainproduct_no" value="${productMainNo }" />
	<input type="hidden" name="travelerCount" value="${travelerCount }" />
	<div class="container">
		<div class="row demobtn">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-12">
						<h1>決済内訳最終確認</h1>
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
					<table border="0" align="center" width="80%">
						<tr>
							<th id="bline" width="20%"><h4><p align="right">商品名 : </p></h4></th>
							<td id="bline" width="60%"><h4><p align="left">&nbsp;&nbsp;${productName }</p></h4></td>
						</tr>	
						<tr>
							<th id="bline"><h4><p align="right">ﾒｲﾝ商品番号 : </p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${productMainNo }</p></h4></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">細部商品番号 : </p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${productSubNo }</p></h4></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">出発日 : </p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${startDay }</p></h4></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">到着日 : </p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${endDay }</p></h4></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">1当たりの商品金額 :</p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;<fmt:formatNumber value="${selectCost }" pattern="#,###.##"/>円</p></h4></td>
						</tr>		
						<tr>
							<th id="bline"><h4><p align="right">1当たり油類税金額 :</p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;<fmt:formatNumber value="${oilCost }" pattern="#,###.##"/>円</p></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">注文者ID :</p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${userID }</p></h4></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">注文者名前 :</p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${userName }</p></h4></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">注文者連絡先 :</p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${userPhone }</p></h4></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">旅行人員 :</p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${travelerCount }人</p></h4></td>
						</tr>
						<tr>
							<th id="bline"><h4><p align="right">旅行者名前 :</p></h4></th>
							<td id="bline"><h4><p align="left">&nbsp;&nbsp;${traveler }</p></h4></td>
						</tr>		
						<tr>
							<th id="bline"><h4><p align="right">決済手段 :</p></h4></th>
							<td id="bline"><p align="left">&nbsp;
								<select name="paymentMeasure">
									<option value="0">振込み</option>
									<option value="1">ｶｰﾄﾞ決済</option>
								</select></p></td>
						</tr>	
						<tr>
							<td colspan="2"><center><h3> 総決済金額 :&nbsp;<font color="red"><fmt:formatNumber value="${totalCost }" pattern="#,###.##"/>  円(10% V.A.T Included)</font></h3></center></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><h4> 当該内訳を確認して正しいなら決済手段を選択した後確認ﾎﾞﾀﾝを押してください。</h4></td>
						</tr>
						<tr>
							<td colspan="2"><br/>
							<p align="center"><input type="submit" class="btn btn-medium btn-theme"  value="決済する"/>&nbsp;&nbsp;<input type="button" onclick="location.href='../main/WebMainServlet?command=main_page'" class="btn btn-medium btn-theme"  value="キャンセル"></p><br/>
							</td>
						</tr>						
						</table>
			</div>
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




