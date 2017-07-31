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
  <title>TOBYTOUR ADMINISTRATOR</title>
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
  <!-- iCheck -->
  <link rel="stylesheet" href="../temp/plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="../temp/plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="../temp/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="../temp/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="../temp/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="../temp/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
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
  
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       TOBYTOUR ADMINISTRATOR DASHBOARD
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
    	     <!-- Small boxes (Stat box) -->
      <div class="row">
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3>${getOrder }<sup style="font-size: 20px">件</sup></h3>
              <p>チェグンイル週間、新しい注文</p>
            </div>
            <div class="icon">
              <i class="ion ion-bag"></i>
            </div>
            <a href="../order/OrderServlet?command=order_list" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-green">
            <div class="inner">
              <h3><fmt:formatNumber value="${getSales }" groupingUsed="true"/><sup style="font-size: 20px">円</sup></h3>
              <p>チェグンイル週間売上高</p>
            </div>
            <div class="icon">
              <i class="ion ion-stats-bars"></i>
            </div>
            <a href="../analysis/AnalysisServlet?command=analysis_sales" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>${getMember }<sup style="font-size: 20px">名</sup></h3>
              <p>チェグンイル週間の新規加入者数</p>
            </div>
            <div class="icon">
              <i class="ion ion-person-add"></i>
            </div>
            <a href="../analysis/AnalysisServlet?command=analysis_new_member" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-red">
            <div class="inner">
              <h3>${getVisitor }<sup style="font-size: 20px">回</sup></h3>
              <p>チェグンイル週間の合計訪問者数</p>
            </div>
            <div class="icon">
              <i class="ion ion-pie-graph"></i>
            </div>
            <a href="../analysis/AnalysisServlet?command=analysis_counter" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
      </div>
        <!-- ./col -->
       <!-- Main row -->
      <div class="row">
        <!-- Left col -->
        <section class="col-lg-7 connectedSortable">
          <div class="box box-primary">
            <div class="box-header with-border">
              <i class="glyphicon glyphicon-pencil"></i><h3 class="box-title"> お知らせリスト</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered">
                  	<c:forEach var="notice" items="${noticeList}" begin="0" end="4" step="1">
  						<tr>
   							<td align="center">${notice.noticeSeq}</td>
   							<td align="center"><a href="../faq/NoticeServlet?command=notice_view&seq=${notice.noticeSeq}">${notice.noticeTitle}</a></td>
   							<td align="center"><fmt:formatDate value="${notice.noticeWriteDate}" type="DATE" pattern="yyyy. MM. dd" /> </td>
   						</tr>
 					 </c:forEach>
              	</table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
          <!-- /request_board -->
           <div class="box box-primary">
            <div class="box-header with-border">
              <i class="glyphicon glyphicon-search"></i><h3 class="box-title"> お問い合わせリスト</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered">
                  	<c:forEach var="request" items="${requestList}" begin="0" end="4" step="1">
  						<tr>
   							<td align="center">${request.requestSeq}</td>
   							<td align="center"><a href="../faq/RequestServlet?command=request_update_form&seq=${request.requestSeq}">${request.requestTitle}</a></td>
   							<td align="center">
   							<fmt:formatDate value="${request.requestWriteDate}" type="DATE" pattern="yyyy. MM. dd" />
   							</td> 
  						 </tr>
 					 </c:forEach>
              	</table>
            </div>
            <!-- /.box-body -->
          </div>
       
        </section>
       
        <section class="col-lg-5 connectedSortable">
		  		     
		   <!-- TO DO List -->
          <div class="box box-primary">
            <div class="box-header">
              <i class="ion ion-clipboard"></i>

              <h3 class="box-title">To Do List</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
             	<form action="../main/MainServlet?command=updateMemo" method="post">
						<center><textarea name="memoContent"  class="form-control"  rows="5">${memoContent }</textarea></center><br/>
				<button type="submit" class="btn btn-default pull-right" value="セーブ"><i class="fa fa-plus"></i>セーブ</button></form>
            </div>
          </div>
          <!-- /.box -->

           <!-- Calendar -->
          <div class="box box-solid bg-green-gradient">
            <div class="box-header">
              <i class="fa fa-calendar"></i>

              <h3 class="box-title">Calendar</h3>
              <!-- tools box -->
              <div class="pull-right box-tools">
                <!-- button with a dropdown -->
                <div class="btn-group">
                  <button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-bars"></i></button>
                  <ul class="dropdown-menu pull-right" role="menu">
                    <li><a href="#">Add new event</a></li>
                    <li><a href="#">Clear events</a></li>
                    <li class="divider"></li>
                    <li><a href="#">View calendar</a></li>
                  </ul>
                </div>
                <button type="button" class="btn btn-success btn-sm" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-success btn-sm" data-widget="remove"><i class="fa fa-times"></i>
                </button>
              </div>
              <!-- /. tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <!--The calendar -->
              <div id="calendar" style="width: 100%"></div>
            </div>
            <!-- /.box-body -->
           
              <!-- /.row -->
            </div>
          </div>
          <!-- /.box -->
        </section>
        <!-- right col -->
      </div>
      <!-- /.row (main row) -->

    </section>
    <!-- /.content -->         
    </section>

    <!-- /.content -->
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
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="../temp/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="../temp/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../temp/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="../temp/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="../temp/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../temp/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="../temp/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../temp/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../temp/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../temp/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="../temp/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../temp/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../temp/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../temp/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../temp/dist/js/demo.js"></script>
</body>
</html>
