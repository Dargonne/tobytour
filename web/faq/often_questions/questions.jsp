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
<link href="../../temp/css/bootstrap.min.css" rel="stylesheet" />
<link href="../../temp/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="../../temp/css/jcarousel.css" rel="stylesheet" />
<link href="../../temp/css/flexslider.css" rel="stylesheet" />
<link href="../../temp/css/style.css" rel="stylesheet" />

<!-- Theme skin -->
<link href="../../temp/skins/default.css" rel="stylesheet" />

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
                   	 <a class="navbar-brand" href="../../main/WebMainServlet?command=main_page"><span>T</span>obyTOUR</a>
               	 </div>
                	<div class="navbar-collapse collapse">
                 	   <ul class="nav navbar-nav">
                        <li class="active"><a href="../../main/WebMainServlet?command=main_page">Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">Product <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../../product/ProductServlet?command=product_list">日本</a></li>
                            </ul>
                        </li>
						<li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">MY PAGE <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
								<li><a href="../../mypage/MainServlet?command=mypage_form">マイページ</a></li>
                                <li><a href="../../mypage/ModifyServlet?command=modify_main">情報修正</a></li>
								<li><a href="../../mypage/WebRequestServlet?command=request_list">1:1お問い合わせ</a></li>
								<li><a href="../../mypage/MemberOutServlet?command=member_out_form">会員脱退</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">FAQ <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
								<li><a href="../../faq/notice/WebNoticeServlet?command=notice_list">公知事項</a></li>
                                <li><a href="../../faq/often_question/WebFaqListServlet?command=faq_list">しきりにする質問</a></li>
                            </ul>
                        </li>
                        <li><a href="../../login/LoginServlet?command=logout">Log-Out</a></li>
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
                    <a class="navbar-brand" href="../../main/WebMainServlet?command=main_page"><span>T</span>obyTOUR</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="../../main/WebMainServlet?command=main_page">Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">Product <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="../../product/ProductServlet?command=product_list">日本</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">FAQ <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
								<li><a href="../../faq/notice/WebNoticeServlet?command=notice_list">公知事項</a></li>
                                <li><a href="../../faq/often_question/WebFaqListServlet?command=faq_list">しきりにする質問</a></li>
                            </ul>
                        </li>
                        <li><a href="../../login/LoginServlet?command=login_form">Log-In</a></li>
					    <li><a href="../../register/RegisterServlet?command=register_form">REGISTER</a></li>
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
					<li><a href="#">よく問う質問</a><i class="icon-angle-right"></i></li>
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
						<h2>よく問う質問</h2>
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
					<!-- Bootstrap FAQ - START -->
					<div class="container">
				    <div class="alert alert-warning alert-dismissible" role="alert">
        				<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
       					このﾒﾆｭｰは TobyTourを 利用しながら お客様が よく問う質問 を 集めた項目なのに他の質問があったら <strong>&nbsp;ﾏｲﾍﾟｰ> 1:1 お問い合わせ&nbsp;</strong> 項目を利用してください。
    				</div>
				    <br />
				    <div class="panel-group" id="accordion">
			        <div class="faqHeader">主要な疑問</div>
     				   <div class="panel panel-default">
         				   <div class="panel-heading">
               				 <h4 class="panel-title">
                   				 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">会員加入方法はどうするるんですか?</a>
               				 </h4>
          				  </div>
          			  <div id="collapseOne" class="panel-collapse collapse in">
                	  <div class="panel-body">
                  		 会員加入は右上段に <strong>REGISTER</strong> ﾒﾆｭｰを利用してくださって ID とかﾊﾟｽﾜｰﾄﾞ 以外に 個人情報 (名前,生年月日,性別,連絡先 など )を入力すればいいです。
              		  </div>
           			 </div>
        		</div>
        		<div class="panel panel-default">
            		<div class="panel-heading">
                		<h4 class="panel-title">
                   			 <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTen">会員加入をしないで商品を購買することができますか?</a>
                		</h4>
           			 </div>
           		  <div id="collapseTen" class="panel-collapse collapse">
                	<div class="panel-body">
                    	残念ながら私に TOBYTOURは <strong>会員制で運営</strong>なっていて 会員登録なしには商品を購買できません. お客様にもっとよいｻｰﾋﾞｽを提供するために会員制で運営しておりますのでこの点了承願います。 
               		</div>
           		 </div>
      		 </div>
        	<div class="panel panel-default">
            	<div class="panel-heading">
               		 <h4 class="panel-title">
                   	 <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseEleven">会員脱退はどうすればいいですか?</a>
               		 </h4>
            </div>
            <div id="collapseEleven" class="panel-collapse collapse">
                <div class="panel-body">
                   　 ﾛｸﾞｲﾝ後<strong>&nbsp;MY PAGE > 会員脱退&nbsp;</strong>&nbsp;ﾒﾆｭｰと移動して護身確認のためのﾊﾟｽﾜｰﾄﾞ確認されれば削除がかのうです. 会員を脱退しとこれまでの情報はすべてさくじょされますのでご注意下さい。
                </div>
           		 </div>
       		 </div>
       		 <div class="faqHeader">商品購買</div>
      		  <div class="panel panel-default">
           		 <div class="panel-heading">
               	 <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">商品購買ばどのようにするんですか?</a>
              	 </h4>
           	 </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                   TOBYTOURで 販売される全ての商品は上段ﾒﾆｭｰの <strong>PRODUCT > 地域</strong>別ﾒﾆｭｰを参考にして希望の商品選択など出発日を通じて購買を進めばいいです。 
                </div>
            </div>
        	</div>
        	<div class="panel panel-default">
            	<div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">旅行商品を望む通りにあわせられますか?</a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    現在まではTOBYTOURで企画した商品だけを販売します。もしお客様が行こうとする旅行地があれば 積極的に反映して商品を企画するようにします。
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFive">旅行商品について割引が可能ですか?</a>
                </h4>
            </div>
            <div id="collapseFive" class="panel-collapse collapse">
                <div class="panel-body">
                  　 現在 TOBYTOURで 販売される商品は他の同じ業界対して最低価格で販売されています。 1:1のと問い合わせや電話相談をくだされば親切に返事致します。
                </div>
            </div>
        </div>
        <div class="faqHeader">商品の取り消しや払い戻し</div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">購入した商品をｷｬﾝｾﾙするにはどうしなければなりませんか?</a>
                </h4>
            </div>
            <div id="collapseFour" class="panel-collapse collapse">
                <div class="panel-body">
                    商品購買の取り消しをお望みでしたら <strong>LOGIN > MYPAGE</strong>で購買した内容を見ることができます。
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven">購買取り消しに対する払い戻しの手続きはどうなりますか?</a>
                </h4>
            </div>
            <div id="collapseSeven" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul>
                    	<li>払い戻しの受付された航空券は航空会社-クレジットカード会社(ｶｰﾄﾞ決済時)確認を経てまた払い戻しされるまで数段階を経ることになるので少なくとも2週間~1ヶ月ぐらいかかります。</li>
                    	<li>クレジットカードの払い戻しは決済したカードの口座に払い戻しされており該当月に決済するカード代金がある場合決済する代金から差し引かれて請求されない場合もあり、 
							払い戻しの時点によって先に決済した航空料金を支払った後ﾍﾟﾅﾙﾃｨを除外した。 
							残りの金額が還付される場合があります。(お客様カード代金決済日と戻しの受付日によって異なる)</li>
						<li>現金で払い戻しした場合航空社審査後旅行会社で航空券の金額が払い戻しされればお客様の口座に送金が行われます。(所用期間2~3週)</li>
						<li>ﾍﾟﾅﾙﾃｨはｶｰﾄﾞ決済した場合、現金で入金してくれなければ払い戻し業務が進行されます。<br/>
							 払い戻しの時点によって払い戻し手数料が間違ってしまうｹｰｽがあるのであらかじめ確認して余裕のあるように要請してください。</li>    
                    </ul>
                </div>
            </div>
        	</div>
   		 </div>
		</div>
		<style>
  		  .faqHeader {
     		   font-size: 27px;
    		    margin: 20px;
  		  }

   		 .panel-heading [data-toggle="collapse"]:after {
       		 font-family: 'Glyphicons Halflings';
      		 content: "\e072"; /* "play" icon */
        	 float: right;
        	 color: #F58723;
        	 font-size: 18px;
        	 line-height: 22px;
       		 /* rotate "play" icon from > (right arrow) to down arrow */
       		 -webkit-transform: rotate(-90deg);
      		 -moz-transform: rotate(-90deg);
        	-ms-transform: rotate(-90deg);
        	-o-transform: rotate(-90deg);
       		 transform: rotate(-90deg);
   		 }

   		 .panel-heading [data-toggle="collapse"].collapsed:after {
        	/* rotate "play" icon from > (right arrow) to ^ (up arrow) */
        	-webkit-transform: rotate(90deg);
        	-moz-transform: rotate(90deg);
        	-ms-transform: rotate(90deg);
        	-o-transform: rotate(90deg);
        	transform: rotate(90deg);
       		color: #454444;
   		 }
		</style>

		<!-- Bootstrap FAQ - END -->
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
<script src="../../temp/js/jquery.js"></script>
<script src="../../temp/js/jquery.easing.1.3.js"></script>
<script src="../../temp/js/bootstrap.min.js"></script>
<script src="../../temp/js/jquery.fancybox.pack.js"></script>
<script src="../../temp/js/jquery.fancybox-media.js"></script>
<script src="../../temp/js/google-code-prettify/prettify.js"></script>
<script src="../../temp/js/portfolio/jquery.quicksand.js"></script>
<script src="../../temp/js/portfolio/setting.js"></script>
<script src="../../temp/js/jquery.flexslider.js"></script>
<script src="../../temp/js/animate.js"></script>
<script src="../../temp/js/custom.js"></script>
</body>
</html>