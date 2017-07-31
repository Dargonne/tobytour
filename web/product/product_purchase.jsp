<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<style>
	#bline {border-bottom:1px dotted  #CCCCCC; }
</style>
<script language="javascript">
	function addInput(inputNo) {
		var strInput = "";
		inputBox.innerHTML = "";
	
		for (var i=1; i <= inputNo; i++) {
  		strInput += "旅行者 " + i +" : <input type=text name=traveler" + i + " size=25 /><br/><br/>";

	}

		inputBox.innerHTML = strInput; 
	}
//-->
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
					<li><a href="#">旅行商品購買</a><i class="icon-angle-right"></i></li>
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
						<h1>商品購買情報入力</h1>
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
				<form name="frm" action="./ProductServlet" method="post">
				<div class="col-lg-12">
				<input type="hidden" name="command" value="purchase_confirm" />
				<input type="hidden" name="productName" value="${choice.selectProductName }" />
				<input type="hidden" name="productMainNo" value="${choice.selectMainSeq }" />
				<input type="hidden" name="productSubNo" value="${choice.selectSubSeq }" />
				<input type="hidden" name="startDay" value="${choice.selectStartDay }" />
				<input type="hidden" name="endDay" value="${choice.selectEndDay }" />
				<input type="hidden" name="cost" value="${choice.selectCost }" />
				<input type="hidden" name="oilCost" value="${choice.selectOilCost }" />
				<input type="hidden" name="id" value="${user.purchaseID }" />
				<input type="hidden" name="name" value="${user.purchaseName }" />
				<input type="hidden" name="phone" value="${user.purchasePhone }" />
				<table border="0" align="center" width="80%">
					<tr>
						<td colspan="2" align="left"><br/><h3>購買商品内訳</h3></td>
					</tr>
					<tr>
						<td id="bline" width="15%" align="right"><h4>商品名 : </h4></td>
						<td id="bline" width="65%" align="left"><h4>&nbsp;&nbsp;${choice.selectProductName }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>ﾒｲﾝ商品番号 : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${choice.selectMainSeq }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>細部商品番号 : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${choice.selectSubSeq }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>出発日 : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${choice.selectStartDay }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>到着日 : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${choice.selectEndDay }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>金額 : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${choice.selectCost }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>油類税 : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${choice.selectOilCost }</h4></td>
					</tr>
					<tr>
						<td colspan="2"><br/></td>
					</tr>
					<tr>
						<td colspan="2" align="left"><br/><h3> 旅行商品購買弱冠</h3></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<br/>
						<textarea name="agreement" cols="80" rows="10" readonly="readonly">	This is TOBYTOUR purchase agreement. Do you really agree to this agreement ?</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="checkbox" name="checkAgreement" /><label for="checkAgreement"><h4>&nbsp;上記の内容を確認しこれに同意します。</h4></label>
						</td>
					</tr>	
					<tr>
						<td colspan="2"><br/></td>
					</tr>
					<tr>
						<td colspan="2" align="left"><br/><h3>注文者情報</h3></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>注文者 ID : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${user.purchaseID }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>注文者 名前 : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${user.purchaseName }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>注文者連絡先 : </h4></td>
						<td id="bline" align="left"><h4>&nbsp;&nbsp;${user.purchasePhone }</h4></td>
					</tr>
					<tr>
						<td id="bline" align="right"><h4>旅行者人員 :<br/>(本人含み)&nbsp;</h4></td>
						<td id="bline">&nbsp;&nbsp;
						<select name="travelerCount" onChange="addInput(this.value);">
						<option>選択してください</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						</select>&nbsp;&nbsp; 名</td>
					</tr>
					<tr>
						<td id="#line" colspan="2" align="left"><br/><h3>旅行者名前入力 (本人含み入力)</h3></td>
					</tr>
					<tr>
						<td id="inputBox" colspan="2">旅行者 1 : </h4><input type="text" name="traveler1" size="25" /><br/><br/> </td>
					</tr>
					<tr>
						<td id="line" colspan="2" align="center"><input type="submit" class="btn btn-medium btn-theme"  value ="注文する" />&nbsp;&nbsp;<input type ="button"  onclick="location.href='../product/ProductServlet?command=product_list'"  class="btn btn-medium btn-theme"  value ="キャンセル"/></td>
					</tr>	
					<tr>
						<td colspan="2"><br/><br/></td>
					</tr>						
				</table>
			</div>
			</form>
				<!-- divider -->
				<br/><br/>
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
