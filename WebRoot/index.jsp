<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
</head>

<body>
<div class="top"><div class="global-width"><img src="Images/logo.gif" class="logo" /></div></div>
<jsp:include page="common/hrTop.jsp" />
<div class="main"><div class="global-width">
	<jsp:include page="common/left.jsp" />
	
    <div class="action">
    	<div class="t">公司信息</div>
   		<div class="pages">
        	<!--增加报销单 区域 开始-->
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <caption>基本信息</caption>
                  <tr>
                    <td width="36%">上海XXX科技有限公司</td>
                    <td width="64%">创建时间：1998年12月 </td>
                  </tr>
                 
                </table>
                <p>&nbsp;</p>
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-item">
                
                  <thead><tr>
                    <td>公司简历</td>
                    </tr>
                  </thead>
                 <tr>
                 	<td>上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司上海XXX科技有限公司</td>
                 </tr>
                 <tr>
                 	<td>创建时间：1998年12月创建时间：1998年12月创建时间：1998年12月创建时间：1998年12月创建时间：1998年12月</td>
                 </tr>
                  <tfoot><tr>
                    <td>公司简历</td>
                    </tr>
                  </tfoot>
                </table>  
        </div>
    </div>
</div></div>

<div class="copyright">Copyright  &nbsp;   &copy;  &nbsp; 2018~2020 贺莹</div>

</body>
</html>