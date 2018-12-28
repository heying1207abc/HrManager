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
    	<div class="t">招聘信息</div>
   		<div class="pages">
   		 <form id="form1" name="form1" method="post" action="">
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <caption>招聘信息</caption>
                  <thead><tr>
                    <td>职位</td>
                    <td>创建时间</td>
                    <td>操作</td>
                    </tr>
                  </thead>
                  <c:forEach items="${recruitList }" var="recruit" varStatus="vs">
                  <tr>
                    <td>${vs.count }</td>
                    <td><a onclick="test(this)">${recruit.postion}</a></td>
                    <td><fmt:formatDate value="${recruit.publishdate }" pattern="yyyy-MM-dd"/></td>
                    <td><a href="recruitDetailOper.action?id=${recruit.id }"><img src="Images/search.gif" width="16" height="16" alt="查看详情"/></a></td>
                  </tr> 
                  <c:if test="${loginUser.type=='admin' }">
                  <tr>
                  	<td colspan="4">
                  		<div style="display: none">
                  			<table width="100%" border="1" cellpadding="0" cellspacing="0">
                  				<tr>
                  					<th>姓名</th><th>性别</th><th>学历</th><th>是否已阅</th><th>面试时间</th>
                  					<th>操作</th>
                  					<c:forEach items="${recruit.resumes }" var="resume">
                  						<tr>
                  							<td>${resume.name }</td>
                  							<td>${resume.gender }</td>
                  							<td>${resume.education }</td>
                  							<td>${resume.consult }</td>
                  							
                  							<td><fmt:formatDate value="${resume.interviewTime }" pattern="yyyy-MM-dd HH:mm"/></td>
                  							<td>
                  							<c:if test="${resume.consult=='N' }">
                  							<a href="detailResume.action?resumeId=${resume.id }&recruitId=${recruit.id }">简历详情</a>
                  							</c:if>
                  							</td>
                  						</tr>
                  					</c:forEach>
                  				</tr>
                  			</table>
                  		</div>
                  	</td>
                  </tr> 
                  </c:if>
                  </c:forEach>
                </table> 
                <c:if test="${loginUser.type=='guest' }">
                <p>&nbsp;</p>
                <div style="text-align: center;">
                <a href="recruitList.action?pageNum=1">第一页</a> <a href="recruitList.action?pageNum=${pageNum-1 }">上一页</a> <a href="recruitList.action?pageNum=${pageNum+1 }">下一页</a> <a href="recruitList.action?pageNum=${count }">最末页</a> 
                </div>  
                </c:if>
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
