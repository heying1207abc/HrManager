<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人力资源管理系统</title>
<style type="text/css">
*{ margin:0; padding:0;}
body{ font:12px 宋体; background:#4BB8EF url(images/bg.gif) repeat-x;}
img{ border:0;}

.login-top{ width:100%; height:186px; margin:147px auto 0; background:url(Images/login_01.gif) no-repeat center 0;}
.login-area{ width:100%; height:140px; margin:0 auto; background:url(Images/login_02.gif) no-repeat center 0;}
	.login-area form{ width:290px; margin:0 auto;}
	.login-area label{ clear:left; float:left; margin-top:13px; width:60px; font:600 14px 宋体;}
	.login-area input{ width:200px; height:16px; margin-top:11px; border:1px #767F94 solid; font:12px/16px 宋体;}
		input.login-register{ width:204px; height:34px; border:0; background:url(Images/login_register.gif) no-repeat 90px 1px; *margin-top:5px;}
.login-copyright{ width:100%; height:30px; margin:18px auto 0; background:url(Images/copyright.gif) no-repeat center 0;}

</style>
</head>

<body>
<div class="login-top"></div>
<div class="login-area">
	<form action="register.action" method="post">
    	<label>用&nbsp;户&nbsp;名：</label><input type="text" name="username" />
        <label>密&nbsp;&nbsp;码：</label><input type="password" name="password" />
        
        <input type="submit" class="login-register" value=""/>
    </form>
</div>
<div class="login-copyright"></div>
</body>
</html>