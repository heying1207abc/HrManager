<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人力资源管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function test() {
		var ctl = document.getElementById("displayTime");
		//alert(ctl);
		var now = new Date();
		var strNow = now.getFullYear() + "-" + (now.getMonth() + 1) + "-"
				+ now.getDate() + " " + now.getHours() + ":" + now.getMinutes()
				+ ":" + now.getSeconds();
		//alert(strNow);
		ctl.innerHTML = "<span style='color:red;'>" + strNow + "</span>"
		window.setInterval("test()", 1000);
	}
</script>
</head>

<body onload="test()">
	<div class="top">
		<div class="global-width">
			<img src="Images/logo.gif" class="logo" />
		</div>
	</div>
	<jsp:include page="../../common/hrTop.jsp" />
	<div class="main">
		<div class="global-width">
			<jsp:include page="../../common/left.jsp" />

			<div class="action">
				<div class="t">考勤打卡</div>
				<div class="pages">

					<table width="90%" border="0" cellspacing="0" cellpadding="0"
						class="addform-base">
						<caption>当前时间</caption>
						<tr>
							<td width="64%" id="displayTime"></td>
						</tr>

					</table>
					<p>&nbsp;</p>
					<table width="30%" border="0" cellspacing="0" cellpadding="0"
						class="addform-item">
						<tr>
							<td><input type="button" id="btn1" value="上班打卡"
								class="submit_01" onclick="up()" /></td>
							<td><input type="button" id="btn2" value="下班打卡"
								class="submit_01" onclick="off()" /></td>
						</tr>

					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 2018~2020
		贺莹</div>
	<script type="text/javascript">
		function up() {			
			$.ajax({
				type : "POST",
				url : "attendanceUpdate.action",
				success : function(msg) {
					alert("Data Saved: " + msg);
				}
			});
		}
		function off() {
			$.ajax({
				type : "POST",
				url : "attendanceUpdate2.action",
				success : function(msg) {
					alert("Data Saved: " + msg);
				}
			});
		}
	</script>
</body>
</html>