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
    	<div class="t">面试信息</div>
   		<div class="pages">
   		 <form id="form1" name="form1" method="post" action="">
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <caption>面试信息</caption>
                  <thead><tr>
                  	<th>序号</th>
                    <th>职位</th>
                    <th>创建时间</th>
                    <th>面试时间</th>
                    <th>操作</th>
                    </tr>
                  </thead>
                  <c:forEach items="${recruitList }" var="recruit" varStatus="vs">
                  <tr>
                    <td>${vs.count }</td>
                    <td>${recruit.postion}</td>
                    <td><fmt:formatDate value="${recruit.publishdate }" pattern="yyyy-MM-dd"/></td>
                   
                    <c:forEach items="${recruit.resumes }" var="resume">
                    <td align="left">
	                    <c:if test="${resume.consult!='N' }">
	                    	<span style="color: red;"><fmt:formatDate value="${resume.interviewTime }" pattern="yyyy-MM-dd HH:mm"/></span>
	                    </c:if>
	                     <c:if test="${resume.consult=='N' }">
	                    	还没有面试通知
	                    </c:if>
	                  </td>
                    
                     <c:if test="${resume.consult!='N' }">
                    <td>
                    
                    <a href="okInterview.action?resumeId=${resume.id }&userId=${loginUser.id }&recruitId=${recruit.id}" >确认面试</a>
                  
                    </td>
                      </c:if>
                    </c:forEach>
                  </tr>                  
                  </c:forEach>
                </table>                
                </form> 
                
        </div>
    </div>
</div></div>

<div class="copyright">Copyright  &nbsp;   &copy;  &nbsp; 2018~2020 贺莹</div>

<script type="text/javascript">
		function test(ctl){
			var div=ctl.parentNode.parentNode.nextSibling.nextSibling.cells[0].firstChild.nextSibling;
			if(div.style.display=="none"){
				div.style.display="block";
			}else{
				div.style.display="none";
			}
		}
	</script>
</body>
</html>
