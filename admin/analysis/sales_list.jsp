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
<input type="hidden" name="salesDay1" value="${salesDay1 }" />
<input type="hidden" name="salesDay2" value="${salesDay2 }" />
<input type="hidden" name="salesDay3" value="${salesDay3 }" />
<input type="hidden" name="salesDay4" value="${salesDay4 }" />
<input type="hidden" name="salesDay5" value="${salesDay5 }" />
<input type="hidden" name="salesDay6" value="${salesDay6 }" />
<input type="hidden" name="salesDay7" value="${salesDay7 }" />
<input type="hidden" name="salesCost1" value="${salesCost1 }" />
<input type="hidden" name="salesCost2" value="${salesCost2 }" />
<input type="hidden" name="salesCost3" value="${salesCost3 }" />
<input type="hidden" name="salesCost4" value="${salesCost4 }" />
<input type="hidden" name="salesCost5" value="${salesCost5 }" />
<input type="hidden" name="salesCost6" value="${salesCost6 }" />
<input type="hidden" name="salesCost7" value="${salesCost7 }" />
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
       　 売上げ現況
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">統計</a></li>
        <li class="active">売上高の統計</li>
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
   				 var salesDay1 = document.frm.salesDay1.value; 
   				 var salesDay2 = document.frm.salesDay2.value;
   				 var salesDay3 = document.frm.salesDay3.value;
  				 var salesDay4 = document.frm.salesDay4.value;
  				 var salesDay5 = document.frm.salesDay5.value;
  				 var salesDay6 = document.frm.salesDay6.value;
  				 var salesDay7 = document.frm.salesDay7.value;
  				 var salesCost1 = document.frm.salesCost1.value; 
  				 var salesCost2 = document.frm.salesCost2.value; 
  				 var salesCost3 = document.frm.salesCost3.value; 
  				 var salesCost4 = document.frm.salesCost4.value; 
  				 var salesCost5 = document.frm.salesCost5.value; 
  				 var salesCost6 = document.frm.salesCost6.value; 
   				 var salesCost7 = document.frm.salesCost7.value;
                 var container = document.getElementById('chart-area'),
     			   data = {
         			   categories: [salesDay1,salesDay2,salesDay3,salesDay4,salesDay5, salesDay6, salesDay7],
          			series: [
            	    {
                	    name: '売上高',
               		     data: [salesCost1, salesCost2, salesCost3, salesCost4, salesCost5, salesCost6, salesCost7]
               		 },
          			  ]
      				  },
       				 options = {
          			 chart: {
                	 width: 700,
                	 height: 400,
                	 title: '最近1週間の売上高',
                	 format: '1000'
            		},
           			 yAxis: {
                	title: '売上高',
             	    max: '1000000'
           			 },
          			xAxis: {
               		title: '日付別'
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
					<th>日</th>
					<th>トータルの売上高</th>
				</tr>
          	</thead>
            <tbody>
            <tr>
               <c:forEach var="count" items="${salesList }">
					<tr class="record">
						<td><fmt:formatDate value="${count.paymentDay }"/></td>
						<td>${count.totalCost }</td>
					</tr>
					</c:forEach>
				<tr>
				
					<td colspan="2" align="center">
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
       						 <li><a href="./AnalysisServlet?command=analysis_sales&page=${(numPageGroup-2)*pageGroupSize+1 }">[前]</a></li>
  						</c:if>
	   					<c:forEach var="i" begin="${startPage}" end="${endPage}">
    	  					 <li><a href="./AnalysisServlet?command=analysis_sales&page=${i}">[						
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
