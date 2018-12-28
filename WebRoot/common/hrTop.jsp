<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hrTop.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="status">
<div class="global-width"><span class="usertype">
<c:if test="${empty loginUser.type }">
<a href="login.jsp">【登录】</a>&nbsp;<a href="register.jsp">【注册用户】</a>
</span>
</c:if>
<c:if test="${loginUser.type=='admin' }">
【登录角色：部门经理】</span>${loginUser.username }你好！欢迎访问人力资源管理系统！
</c:if>
<c:if test="${loginUser.type=='employee' }">
【登录角色：员工】</span>${loginUser.username }你好！欢迎访问人力资源管理系统！
</c:if>
<c:if test="${loginUser.type=='guest' }">
【登录角色：用户】</span>${loginUser.username }你好！欢迎访问人力资源管理系统！
</c:if>
</div></div>

  </body>
</html>
