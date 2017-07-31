<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>
<%@page import="com.admin.dto.ProductDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	
    body {
    font-family: "Nanum Gothic", sans-serif;
	} 
	#bline {border-bottom:1px dotted  #CCCCCC; }
	#btn-style{
	border : solid 0px #ffffff;
	border-radius : 6px;
	moz-border-radius : 6px;
	font-size : 20px;
	color : #ffffff;
	padding : 5px 17px;
	background-color : #6baaed;
   }
</style>
<script>
$(function() {
  $( "#startdate, #enddate, #duedate" ).datepicker({
    dateFormat: 'yy-mm-dd',
    prevText: '前の月',
    nextText: '来月',
    monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
    monthNamesShort: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
    dayNames: ['日','月','火','水','木','金','土'],
    dayNamesShort: ['日','月','火','水','木','金','土'],
    dayNamesMin: ['日','月','火','水','木','金','土'],
    showMonthAfterYear: true,
    changeMonth: true,
    changeYear: true,
    yearSuffix: '年'
  });
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>詳細商品登録</title>
<script type="text/javascript" src="./js/product.js"></script>
</head>
<body>
	<form name="frm" action="./ProductServlet">
		<input type="hidden" name="command" value="product_sub_insert" />
		<input type="hidden" name="seq" value="${seq }" />
		<table border="0" align="center">
			<tr>
				<td colspan="4"><h4>詳細商品登録</h4>
			</tr>
			<tr>
				<td id="bline">出発日</td>
				<td id="bline"> <input type="text" name="start_date" id="startdate" readonly="readonly"></td>
				<td id="bline">到着日</td>
				<td id="bline"> <input type="text" name="end_date" id="enddate" readonly="readonly"></td>
			</tr>
			<tr>
				<td id="bline">航空会社</td>
				<td  id="bline" colspan="3"><input type="text" name="airline" size="10" /></td>
			</tr>
			<tr>
				<td id="bline">コスト</td>
				<td id="bline" colspan="3"><input type="text" name="cost" size="10" />円</td>
			</tr>
			<tr>
				<td id="bline">油類税</td>
				<td id="bline" colspan="3"><input type="text" name="oilcost" size="10" />円</td>
			</tr>
			<tr>
				<td id="bline">数量</td>
				<td id="bline" colspan="3"><input type="text" name="qty" size="10" />軒</td>
			</tr>
			<tr>
				<td id="bline">販売期間</td>
				<td id="bline" colspan="3"><input type="text" name="due_date" id="duedate" readonly="readonly">まで</td>
			</tr>
			<tr>
				<td colspan="4"><center><input type="submit" id="btn-style" value="登録" />&nbsp;&nbsp;<input type="button" id="btn-style" onclick="javascript:window.close();" value="キャンセル" /></center></td>
			</tr>
		</table>
	</form>
</body>
</html>