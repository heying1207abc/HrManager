<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
</head>

<body>
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
				<div class="t">招聘信息</div>
				<div class="pages">
					<form id="form1" name="form1" method="post" action="">
						<table width="90%" border="0" cellspacing="0" cellpadding="0"
							class="addform-base">
							<caption>招聘信息</caption>
							<tr>
								<td width="50%">部门：${recruitCustom.dept.deptName }</td>
								<td width="50%">职位：${recruitCustom.deptPosition.positionName
									}</td>
							</tr>
						</table>
						<p>&nbsp;</p>
						<table width="90%" border="0" cellspacing="0" cellpadding="0"
							id="tabItem" class="addform-base addform-item">
							<caption>职位名称</caption>
							<tr>
								<td>${recruitCustom.postion }</td>
							</tr>
							<tr>
								<td>要求条件:</td>
							</tr>
							<tr>
								<td>${recruitCustom.condition }</td>
							</tr>

							<!--表单提交行-->
							<tr>
								<td colspan="4" class="submit"><c:if
										test="${loginUser.type=='guest' }">
										<input type="button" name="button" id="btnSub" value="查看简历"
											class="submit_01" />
									</c:if> <c:if test="${loginUser.type=='admin' }">
										<input type="button" name="button" id="btnUpdate" value="修改招聘"
											class="submit_01" />
									</c:if></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 2018~2020
		贺莹</div>
	<script type="text/javascript">
		$("#btnSub").click(function() {
			location.href="resumeListByUserIdAndPage.action?userId="+${loginUser.id}+"&recruitId="+${recruitCustom.id};
		});
		$("#btnUpdate").click(function() {
			alert("update");
		});
	</script>
</body>
</html>
