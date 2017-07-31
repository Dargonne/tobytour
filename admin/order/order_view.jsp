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

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  <form name="frm" method="post" action="./OrderServlet">
<input type="hidden" name="command" value="order_view" />
<input type="hidden" name="seq" value="${orderView.viewPurchaseSeq }" />
    <!-- Content Header (Page header) -->
    <section class="content-header">
	<br/>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> メイン</a></li>
        <li><a href="#">注文管理</a></li>
        <li class="active">注文状況を見る</li>
      </ol>
    </section>
    <section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
      			<div class="callout callout-info">
        			<h4>注意!</h4>
        			注文状況の登録を手動で作成することができませんので、ご利用のお客様発生正式に注文申請をしていただく必要があります。<br/>
       				このページは、決済完了の切り替えのみ可能です。 
      			</div>
        </div>
        <!-- /.col -->
      </div>
      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <tbody>
			<tr>
				<th>注文番号</th>
				<td>${orderView.viewPurchaseSeq }
			</tr>
			<tr>
				<th>注文商品コード</th>
				<td>${orderView.viewPurchaseProductCode}</td>
			</tr>
			<tr>
				<th>注文者 ID</th>
				<td>${orderView.viewPurchaseID }</td>
			</tr>
			<tr>
				<th>旅行者の人員</th>
				<td>${traveler } 人</td>
			</tr>
			<tr>
				<th>合計お支払い額</th>
				<td>${orderView.viewPurchaseTotalCost }円</td>
			</tr>
			<tr>
				<th>決済日</th>
				<td>${orderView.viewPurchasePaymentDate }</td>
			</tr>
			<tr>
				<th>お支払い方法</th>
				<td>
					<c:if test="${orderView.viewPurchasePaymentMeasure == 0}">
       					 	[口座振込]
  						</c:if>
  						<c:if test="${orderView.viewPurchasePaymentMeasure == 1}">
       					 	[カード決済]
  					</c:if>
				</td>
			</tr>
			<tr>
				<th>入金するかどうか</th>
				<td>
					<c:if test="${orderView.viewPurchasePaymentResult == 0}">
       					 	[入金待機]
  					</c:if>
  					<c:if test="${orderView.viewPurchasePaymentResult == 1}">
       					 	[入金完了]
  					</c:if>
				</td>
			</tr>
			<tr>
				<th>入金完了日</th>
				<td><fmt:formatDate value="${orderView.viewPurchasePaymentDate }"/></td>
			</tr>
			<tr>				
				<th>キャンセルするかどうか</th>
				<td>
					<c:if test="${orderView.viewPurchaseCancelStatus == 0}">
       					 	[X]
  					</c:if>
  					<c:if test="${orderView.viewPurchaseCancelStatus == 1}">
       					 	[O]
  					</c:if>
				</td>
			</tr>
            <tr>
            	<td colspan="2">
            		<c:if test="${orderView.viewPurchasePaymentResult == 0 }">
            		<div class="box-footer clearfix">
						<ul class="pagination pagination-sm no-margin pull-right">
						<li><a href="./OrderServlet?command=order_payment_change&seq=${orderView.viewPurchaseSeq }">決済完了の承認</a></li>
 						<li><a href="./OrderServlet?command=order_list">リスト</a></li>
 						</ul>
 					</div>
					</c:if>
					<c:if test="${orderView.viewPurchasePaymentResult == 1 }">
            		<div class="box-footer clearfix">
						<ul class="pagination pagination-sm no-margin pull-right">
 						<li><a href="./OrderServlet?command=order_list">リスト</a></li>
 						</ul>
 					</div>
					</c:if>
            	</td>
            </tr>
            </tbody>
            </table>
         </div>
     </div>
      </form>
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
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="../temp/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../temp/bootstrap/js/bootstrap.min.js"></script>
<!-- PACE -->
<script src="../temp/plugins/pace/pace.min.js"></script>
<!-- SlimScroll -->
<script src="../temp/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../temp/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../temp/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../temp/dist/js/demo.js"></script>
<!-- page script -->
<script type="text/javascript">
	// To make Pace works on Ajax calls
	$(document).ajaxStart(function() { Pace.restart(); });
    $('.ajax').click(function(){
        $.ajax({url: '#', success: function(result){
            $('.ajax-content').html('<hr>Ajax Request Completed !');
        }});
    });
</script>
</body>
</html>
   


				
			