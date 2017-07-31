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
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>TOBYTOUR ADMINISTRATOR PAGE</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../temp/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Morris charts -->
  <link rel="stylesheet" href="../temp/plugins/morris/morris.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../temp/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../temp/dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" type="text/css" href="./js/chart/dist/chart.min.css" />
  <link rel="stylesheet" type="text/css" href="./js/chart/css/sample.css" />
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<form name="frm">
<input type="hidden" name="visitDay1" value="${visitDay1 }" />
<input type="hidden" name="visitDay2" value="${visitDay2 }" />
<input type="hidden" name="visitDay3" value="${visitDay3 }" />
<input type="hidden" name="visitDay4" value="${visitDay4 }" />
<input type="hidden" name="visitDay5" value="${visitDay5 }" />
<input type="hidden" name="visitDay6" value="${visitDay6 }" />
<input type="hidden" name="visitDay7" value="${visitDay7 }" />
<input type="hidden" name="visitCount1" value="${visitCount1 }" />
<input type="hidden" name="visitCount2" value="${visitCount2 }" />
<input type="hidden" name="visitCount3" value="${visitCount3 }" />
<input type="hidden" name="visitCount4" value="${visitCount4 }" />
<input type="hidden" name="visitCount5" value="${visitCount5 }" />
<input type="hidden" name="visitCount6" value="${visitCount6 }" />
<input type="hidden" name="visitCount7" value="${visitCount7 }" />
<div class="wrapper">

 <header class="main-header">
      <!-- Logo -->
    <a href="../main/MainServlet?command=main_page" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><font color="white">T</font></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><font color="white">TobyTour</font></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <img src="../temp/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <!-- end message -->
                </ul>
              </li>
              <li class="footer"><a href="#">See All Messages</a></li>
            </ul>
          </li>
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="../login/LoginServlet?command=logout_action">
             ログアウト
            </a>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>

   <!-- =============================================== -->

 <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <ul class="sidebar-menu">
        <li class="header">主要メニュー</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>商品管理</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../product/ProductServlet?command=product_list"><i class="fa fa-circle-o"></i>登録商品目録</a></li>
            <li><a href="../product/ProductServlet?command=product_add"><i class="fa fa-circle-o"></i>メイン商品登録</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>注文管理</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../order/OrderServlet?command=order_list"><i class="fa fa-circle-o"></i>注文の現況を見る</a></li>
          </ul>
        </li>
		<li class="treeview">
          <a href="#">
            <i class="fa fa-laptop"></i>
            <span>会員管理</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../member/MemberServlet?command=member_list"><i class="fa fa-circle-o"></i>会員リストを見る</a></li>
          </ul>
        </li>
		<li class="treeview">
          <a href="#">
            <i class="fa fa-table"></i> <span>掲示板(顧客)管理</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../faq/NoticeServlet?command=notice_list"><i class="fa fa-circle-o"></i>公知事項</a></li>
            <li><a href="../faq/RequestServlet?command=request_list"><i class="fa fa-circle-o"></i>1対1門の現況</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>統計</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../analysis/AnalysisServlet?command=analysis_counter"><i class="fa fa-circle-o"></i>訪問者数の現況</a></li>
            <li><a href="../analysis/AnalysisServlet?command=analysis_new_member"><i class="fa fa-circle-o"></i>新規会員の現況</a></li>
            <li><a href="../analysis/AnalysisServlet?command=analysis_sales"><i class="fa fa-circle-o"></i>売上現状</a></li>
          </ul>
        </li>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- =============================================== -->
 <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
         訪問者数の現状
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">統計</a></li>
        <li class="active">訪問者数の統計</li>
      </ol>
    </section>
    <section class="invoice">
      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <tbody>
            <tr>
            	<td>
            				<div id="chart-area"></div>
			<script src="./js/chart/lib/code-snippet.min.js"></script>
			<script src="./js/chart/lib/effects.min.js"></script>
			<script src="./js/chart/lib/raphael-min.js"></script>
			<script src="./js/chart/dist/chart.min.js"></script>
			<script src="./js/chart/js/sample.js"></script>
			<script>		
   				 var visitDay1 = document.frm.visitDay1.value; 
   				 var visitDay2 = document.frm.visitDay2.value;
   				 var visitDay3 = document.frm.visitDay3.value;
  				 var visitDay4 = document.frm.visitDay4.value;
  				 var visitDay5 = document.frm.visitDay5.value;
  				 var visitDay6 = document.frm.visitDay6.value;
  				 var visitDay7 = document.frm.visitDay7.value;
  				 var visitCount1 = document.frm.visitCount1.value; 
  				 var visitCount2 = document.frm.visitCount2.value; 
  				 var visitCount3 = document.frm.visitCount3.value; 
  				 var visitCount4 = document.frm.visitCount4.value; 
  				 var visitCount5 = document.frm.visitCount5.value; 
  				 var visitCount6 = document.frm.visitCount6.value; 
   				 var visitCount7 = document.frm.visitCount7.value;
                 var container = document.getElementById('chart-area'),
     			   data = {
         			   categories: [visitDay1,visitDay2,visitDay3,visitDay4,visitDay5, visitDay6, visitDay7],
          			series: [
            	    {
                	    name: '訪問者数',
               		     data: [visitCount1, visitCount2, visitCount3, visitCount4, visitCount5, visitCount6, visitCount7]
               		 },
          			  ]
      				  },
       				 options = {
          			 chart: {
                	 width: 700,
                	 height: 400,
                	 title: '最近一週間訪問者数の統計',
                	 format: '1,000'
            		},
           			 yAxis: {
                	title: '訪問者数',
             	    max: '100'
           			 },
          			xAxis: {
               		title: '曜日別'
          			},
            		series: {
                	stackType: 'normal',
              		showDot: true
           			 },
          			tooltip: {
               			grouped: true
           			 }
       				 };
    				tui.chart.areaChart(container, data, options);
			</script>
            	
            	</td>
            </tr>
            </tbody>
            </table>
         </div>
          <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
          	<thead>
          		<tr>
					<th>訪問日</th>
					<th>訪問数</th>
				</tr>
          	</thead>
            <tbody>
            <tr>
               <c:forEach var="count" items="${counterAllList}">
					<tr class="record">
						<td><fmt:formatDate value="${count.visitDay }"/></td>
						<td>${count.visitCount }</td>
					</tr>
					</c:forEach>
				<tr>
				
					<td colspan="3" align="center">
						<c:if test="${count > 0}">
   							<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
  							<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}"/>
   							<c:set var="endPage" value="${startPage + pageGroupSize-1}"/>
     					 <c:if test="${endPage > pageCount}" >
     						<c:set var="endPage" value="${pageCount}" />
   						</c:if>
   						<div class="box-footer clearfix">
							<ul class="pagination pagination-sm no-margin pull-right">
   						<c:if test="${numPageGroup > 1}">						
       						 <li><a href="./AnalysisServlet?command=analysis_counter&page=${(numPageGroup-2)*pageGroupSize+1 }">[前]</a></li>
  						</c:if>
	   					<c:forEach var="i" begin="${startPage}" end="${endPage}">
    	  					 <li><a href="./AnalysisServlet?command=analysis_counter&page=${i}">[						
         								 <c:if test="${currentPage == i}">
      										 </c:if>
      					  				${i}]
      						 </a></li>
   						</c:forEach>
	  					 <c:if test="${numPageGroup < pageGroupCount}">
    	    				<li><a href="./AnalysisServlet?command=member_count_list&page=${numPageGroup*pageGroupSize+1}">[次]</a></li>
   						</c:if>
   						</ul>
   					</div>
					</c:if>
				</td>
            </tr>
            </tbody>
            </table>
         </div>
     </div>
   </section>
     <!-- /.content -->
    <div class="clearfix"></div>
  </div>
 <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.0
    </div>
    <strong>Copyright &copy; 2016 <a href="#">TOBY TOUR PROJECT</a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">

    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
    </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
    
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- jQuery 2.2.3 -->
<script src="../temp/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../temp/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../temp/plugins/morris/morris.min.js"></script>
<!-- FastClick -->
<script src="../temp/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../temp/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../temp/dist/js/demo.js"></script>
<!-- page script -->

</form>
</body>
</html>
