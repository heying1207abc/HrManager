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
				<div class="t">添加招聘信息</div>
				<div class="pages">
					<form id="form1" name="form1" method="post"
						action="addRecruit.action">
						<table border="0" cellspacing="0" cellpadding="0"
							class="addform-base">
							<caption>添加招聘信息</caption>
							<tr>
								<td>部门：</td>
								<td><select name="deptid" id="deptId">
										<c:forEach items="${deptList }" var="dept">
											<option value="${dept.id }">${dept.deptName }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>职位：</td>
								<td><select name="postionid" id="positionId">

								</select></td>
							</tr>
							<tr>
								<td>职位名称：</td>
								<td><input type="text" name="postion"/></td>
							</tr>
							<tr>
								<td>要求条件</td>
								<td><textarea rows=5 cols="80" name="condition"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="添加招聘" /></td>
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
		$("#deptId").change(function() {
			var deptId=$(this).val();
			$("#positionId option").remove();
			$.ajax({
				type : "POST",
				url : "getAllPositionByDept.action",
				data : "deptId="+deptId,
				success : function(msg,status,httpRequest) {
					var arrays=msg;
					for(var i=0;i<arrays.length;i++){
						$("#positionId").append("<option value='"+arrays[i].id+"'>"+arrays[i].positionName+"</option>");
					}
				}
			});
		});
	</script>
</body>
</html>
