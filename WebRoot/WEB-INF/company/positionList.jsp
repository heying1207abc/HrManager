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
    	<div class="t">职位列表</div>
   		<div class="pages">
   		 <form id="form1" name="form1" method="post" action="">
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <caption>职位列表</caption>
                  <tr>
                  <td colspan="4">部门：
                 
                  <select id="deptId" width="111px">
                   <c:forEach items="${deptList }" var="dept">
                   <option value="${dept.id }">${dept.deptName }</option>
                  </c:forEach>
                  </select></td>
                  </tr>
                  <tr>
                    <td>职位序号</td>
                    <td>职位名称</td>
                    <td>创建时间</td>
                    <td>操作</td>
                    </tr>
                 
                  <c:forEach items="${positionList }" var="position" varStatus="vs">
                  <tr>
                    <td>${vs.count }</td>
                    <td>${position.positionName }</td>
                    <td><fmt:formatDate value="${position.createtime }" pattern="yyyy-MM-dd"/></td>
                    <td><a href="positionEditOper.action?id=${position.id }"><img src="Images/edit.gif" width="16" height="16" /></a><a href="deletePosition.action?id=${position.id }"> <img src="Images/delete.gif" width="16" height="16" /></a></td>
                  </tr>  
                  </c:forEach>
                </table>   
                </form> 
                
        </div>
    </div>
</div></div>

<div class="copyright">Copyright  &nbsp;   &copy;  &nbsp; 2018~2020 贺莹</div>
<script type="text/javascript">
	$("#deptId").change(function(){
		var index=this.selectedIndex;
		$opt=$(this.options[index]);
		location.href="positionListOper.action?deptid="+($opt.val());
	});
</script>
</body>
</html>
