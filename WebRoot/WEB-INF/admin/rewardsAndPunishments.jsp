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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
				<div class="t">奖惩信息</div>
				<div class="pages">
					<form id="form1" name="form1" method="post"
						action="getRewardsAndPunishments.action">
						<table border="0" cellspacing="0" cellpadding="0"
							class="addform-base">
							<caption>奖惩信息查询</caption>
							<tr>
								<td>部门：<select name="deptid" id="deptId" width="111px">
										<c:forEach items="${deptList }" var="dept">
											<option value="${dept.id }">${dept.deptName }</option>
										</c:forEach>
								</select></td>
								<td>职位：<select name="postionid" id="positionId" width="111px">
								</select></td>
								</td>
								<td>奖惩开始时间：<input class="Wdate" type="text" name="rewardsBeginTime" onClick="WdatePicker()"/></td>
								<td>奖惩结束时间：<input class="Wdate" type="text" name="rewardsEndTime" onClick="WdatePicker()"/></td>
							</tr>
							<tr><td colspan="4"><input type="submit" value="查询"/></td></tr>							
						</table>
						</form>
						<table border="0" cellspacing="0" cellpadding="0" width="100%"
							class="addform-base">
							<caption>员工信息</caption>							
							<tr>
								<td>员工</td>
							</tr>	
							<c:forEach items="${empList }" var="employee">
								<tr>
									<td>${employee.empName }</td>
								</tr>
								
									<tr>
										<td >
										<table width="100%" border="1" cellpadding="0" cellspacing="0">
											<tr><td>时间</td><td>原因</td><td>金额</td></tr>
											<fmt:formatDate value="${rewardsandpunishment.rewardsandpunishmentstime }" pattern="yyyy-MM-dd"/>
											<c:forEach items="${employee.rewardsandpunishments }" var="rewardsandpunishment">
											<tr><td></td><td>${rewardsandpunishment.reason }</td>
											<c:if test="${rewardsandpunishment.money>0 }">											
											<td><span style="color:red">${rewardsandpunishment.money }</span></td>
											</c:if>
											<c:if test="${rewardsandpunishment.money<0 }">											
											<td><span>${rewardsandpunishment.money }</span></td>
											</c:if>
											</tr>
											</c:forEach>
										</table>
										</td>
									</tr>
							</c:forEach>						
						</table>
					

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
