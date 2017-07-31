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
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="../temp/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <script type="text/javascript" src="./js/product.js"></script>
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini" >
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
    <!-- Content Header (Page header) -->
    <section class="content-header">
	<br/>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> メイン</a></li>
        <li><a href="#">商品管理</a></li>
        <li class="active">メイン商品登録</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="invoice">
    <form name="frm" method="post" action="./ProductServlet?command=finish_add">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            <i class="fa fa-globe"></i> メイン商品登録
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <thead>
            </thead>
            <tbody>
            <tr>
            	<th>カテゴリ登録</th>
            	<td>
                  <select name='Step1' onchange='changes1Step(value)'>
					<option>--Step 1--</option>
					<option value="일본">日本</option>
				  </select>
                </td>
            </tr>
            <tr>
            	<th>商品名</th>
            	<td colspan="2"><input type="text" class="form-control" placeholder="商品名を入力してください" name="productname" size="50"></textarea></td>
            </tr>
            <tr>
            	<th>商品説明</th>
            	<td><textarea class="form-control" placeholder="商品の説明を入力してください" cols="63" rows="5" name="productstatement"></textarea></td>
            </tr>
            <tr>
            	<th>出発曜日</th>
            	<td>
            		<div class="checkbox" >
            		  <label>
                      	<input type="checkbox" name="depday" value="月" />
                     	月
                      </label>&nbsp;
                       <label>
                      	<input type="checkbox" name="depday" value="火" />
                      	火
                      </label>&nbsp;
                       <label>
                      	<input type="checkbox" name="depday" value="水" />
                      	水
                      </label>&nbsp;
                       <label>
                      	<input type="checkbox" name="depday" value="木" />
                      	木
                      </label>&nbsp;
                        <label>
                      	<input type="checkbox" name="depday" value="金" />
                      	金
                      </label>&nbsp;
                       <label>
                      	<input type="checkbox" name="depday" value="土" />
                      	土
                      </label>&nbsp;
                       <label>
                      	<input type="checkbox" name="depday" value="日" />
                      	日
                      </label>
            		</div>
            	</td>
            </tr>
            <tr>
					<th>商品画像</th>
					<td><input type="button" class="btn btn-default"  value="アップロード" onclick="upLoad_product()"></td>
			</tr>
			<tr>
					<th>商品に含まれるもの</th>
					<td><textarea class="form-control" placeholder="商品に含まれるものを入力してください"  rows="5" cols="70" name="includelist"></textarea></td>
			</tr>
			<tr>
					<th>商品別に含まれるもの</th>
					<td><textarea class="form-control" placeholder="商品を含まない内容を入力してください"  rows="5" cols="70" name="excludelist"></textarea></td>
			</tr>
			<tr>
					<th>選択経費</th>
					<td><textarea class="form-control" placeholder="選択経費を入力してください"  rows="5" cols="70" name="choicecost"></textarea></td>
			</tr>
			<tr>
					<th>専門家推薦の説明</th>
					<td><textarea class="form-control" placeholder="専門家推薦の説明内容を入力してください"  rows="5" cols="70" name="recommendcomment"></textarea></td>
			</tr>
			<tr>
					<th>旅行日程（1日目）</th>
					<td><textarea class="form-control" placeholder="旅行日程1日目の内容を入力してください"  rows="5" cols="70" name="day1"></textarea></td>
			</tr>
			<tr>
					<th>旅行日程（2日目）</th>
					<td><textarea class="form-control" placeholder="旅行日程2日目の内容を入力してください"  rows="5" cols="70" name="day2"></textarea></td>
			</tr>
			<tr>
					<th>旅行日程（3日目）</th>
					<td><textarea class="form-control" placeholder="旅行日程3日目の内容を入力してください"  rows="5" cols="70" name="day3"></textarea></td>
			</tr>
			<tr>
					<th>旅行日程（4日目）</th>
					<td><textarea class="form-control" placeholder="旅行日程4日目の内容を入力してください"  rows="5" cols="70" name="day4"></textarea></td>
			</tr>
			<tr>
					<th>旅行日程（5日目）</th>
					<td><textarea class="form-control" placeholder="旅行日程5日目の内容を入力してください"  rows="5" cols="70" name="day5"></textarea></td>
			</tr>
			<tr>
					<th>宿泊ホテル名 </th>
					<td><input type="text" class="form-control" placeholder="ホテル名を入力してください"" name="hotelname" size="5" /></td>
			</tr>
			<tr>
					<th>ホテル画像</th>
					<td><input type="button" class="btn btn-default" value="アップロード" onclick="upLoad_hotel()" /></td>
			</tr>
			<tr>
					<th>ホテルの説明</th>
					<td>
						<textarea name="hotelinfo" class="form-control" rows="7" cols="60">
国/都市 : 
アドレス : 
電話/ファックス : 
ホームページ : 
総客室数 : 
ホテルの場所 : 
チェックイン/アウト時間 :
	 					</textarea>
					</td>
			</tr>
			<tr>
				<th>ホテル設備</th>
				<td><textarea name="subinfo"  placeholder="ホテル設備の内容を入力してください" class="form-control" rows="5" cols="60"></textarea></td>
			</tr>
			<tr>
				<th>客室設備</th>
				<td><textarea name="roominfo" placeholder="ホテルの客室設備内容を入力してください" class="form-control" rows="5" cols="60"></textarea>
			</tr>
			<tr>
				<th>旅行時<br/>留意事項</th>
				<td><textarea name="caution"  placeholder="旅行時の留意事項の内容を入力してください"  class="form-control"  rows="5" cols="70"></textarea></td>
			</tr>
			<tr>
				<th>旅行商品<br/>規約</th>
				<td><textarea name="agreement"  placeholder="旅行商品種別についてを入力してください"  class="form-control"  rows="5" cols="70"></textarea></td>
			</tr>
			<tr>
				<th>旅行地<br/>安全情報</th>
				<td><textarea name="safeinfo"  placeholder="旅行安全情報の内容を入力してください"  class="form-control"  rows="5" cols="70"></textarea></td>
			</tr>
			<tr>
				<th>商品の<br/>保険および決済方法</th>
				<td><textarea name="insurunce"  placeholder="商品の保険および決済方法の内容を入力してください"  class="form-control"  rows="5" cols="70"></textarea></td>
			</tr>
			<tr>
				<th>緊急時<br/>緊急連絡案内</th>
				<td><textarea name="helpphone" placeholder="緊急連絡先に関連する情報を入力してください"  class="form-control"  rows="5" cols="70"></textarea>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"  class="btn btn-default" value="登録" /><input type="button" class="btn btn-default" value="登録を解除する"
				onclick='location.href="./ProductServlet?command=product_list"'/></td>
			</tr>
            </tbody>
          </table>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
      </form>
    </section>
    <!-- /.content -->
    <div class="clearfix"></div>
  </div>
  
   <!-- /.content-wrapper -->
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
<!-- FastClick -->
<script src="../temp/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../temp/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../temp/dist/js/demo.js"></script>
<script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1');
    //bootstrap WYSIHTML5 - text editor
    $(".textarea").wysihtml5();
  });
</script>
</body>
</html>

 