<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<div class="top"><div class="global-width"><img src="Images/logo.gif" class="logo" /></div></div>
<jsp:include page="../../common/hrTop.jsp" />
<div class="main"><div class="global-width">
	
	<jsp:include page="../../common/left.jsp" />
    <div class="action">
    	<div class="t">员工列表</div>
   		<div class="pages">
   		 <form id="form1" name="form1" method="post" action="">
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <caption>员工列表</caption>
                  <thead><tr>
                    <td>员工序号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>入职时间</td>
                    <td>部门</td>
                    <td>职位</td>
                    <td>状态</td>
                    <td>操作</td>
                    </tr>
                  </thead>
                  <c:forEach items="${employeeList }" var="employee" varStatus="vs">
                  <tr>
                    <td>${vs.count }</td>
                    <td>${employee.empName }</td>
                    <td>${employee.gender }</td>
                    <td><fmt:formatDate value="${employee.hirdate }" pattern="yyyy-MM-dd"/></td>
                    <td>${employee.dept.deptName }</td>
                    <td>${employee.position.positionName }</td>
                    <td>${employee.state.state }</td>
                    <td>
                    <a href="employeeEditOper.action?id=${employee.id }"><img src="Images/edit.gif" alt="调岗" width="16" height="16" /></a>
                    <a href="#"> <img src="Images/delete.gif" alt="离职" width="16" height="16" /></a></td>
                  </tr>  
                  </c:forEach>
                </table>   
                </form> 
                
        </div>
    </div>
</div></div>

<div class="copyright">Copyright  &nbsp;   &copy;  &nbsp; 2018~2020 贺莹</div>


</body>
</html>
