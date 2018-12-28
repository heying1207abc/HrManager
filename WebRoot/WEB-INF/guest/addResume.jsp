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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
</head>

<body>
<div class="top"><div class="global-width"><img src="Images/logo.gif" class="logo" /></div></div>
<jsp:include page="../../common/hrTop.jsp" />
<div class="main"><div class="global-width">
	
	<jsp:include page="../../common/left.jsp" />
    <div class="action">
    	<div class="t">填写简历</div>
   		<div class="pages">
   		 <form id="form1" name="form1" method="post" action="resumeAdd.action">
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <caption>基本信息</caption>
                  <input type="hidden" name="userid" value="${loginUser.id }"/>
                  <tr>
                    <td width="50%">填 写 人：<input type="text" name="name"/></td>
                    <td width="50%">性     别：<input type="radio" name="gender" value="男" checked="checked"/>男
                    <input type="radio" name="gender" value="女"/>女</td>
                  </tr>
                  <tr>
                    <td>出生日期：<input type="text" name="birthday"/>
                    </td>
                    <td>最高学历<select name="education">
                    	<option value="小学">小学</option>
                    	<option value="中学">中学</option>
                    	<option value="大专">大专</option>
                    	<option value="本科">本科</option>
                    	<option value="硕士">硕士</option>
                    	<option value="博士">博士</option>
                    </select></td>
                  </tr>
                </table>
                <p>&nbsp;</p>
                <table width="90%" border="0" cellspacing="0" cellpadding="0" id="tabItem" class="addform-base addform-item">
               	<caption>学习经历</caption>
                  <thead id="experience"><tr>
                    <td>开始年份</td>
                    <td>结束年份</td>
                    <td>学校</td>
                    <td>备注</td>
                    <td>操作</td>
                    </tr>
                  </thead>
                  <tr id="trItem">
                    <td><select id="beginDate" name="beginDate" width="111px">
                    	
                    </select></td>
                    <td><select id="endDate" name="endDate" width="111px">
                    	
                    </select></td>
                    <td><input type="text" name="school"/></td>
                    <td><input type="text" name="remark"/></td>
                    <td><img src="Images/edit.gif" width="16" height="16" /> <img src="Images/delete.gif" width="16" height="16" /></td>
                  </tr>
                    
                  <!--表单提交行-->
                  <tr>
                    <td colspan="4" class="submit">
                    <input type="submit" name="button" id="button" value="保 存" class="submit_01" />                   
                    <input type="button" name="button" id="btnAddDetail" value="添加明细" class="submit_01" />
                    </td>
                   </tr>  
                   
                </table>   
                </form> 
                <script type="text/javascript">
                for(var year=1990;year<=2020;year++){
                	$("#beginDate").append($("<option value='"+year+"'>"+year+"</option>"));
                	$("#endDate").append($("<option value='"+year+"'>"+year+"</option>"));
                }
                </script>
                <script type="text/javascript">
                	$tr=$("#trItem").clone();
                	//$tr.attr("id","tr"+$tr.attr("rowIndex"));
                	$("#btnAddDetail").click(function(){
                		$tr.insertAfter($("#trItem"));
                	});
                </script>
        </div>
    </div>
</div></div>

<div class="copyright">Copyright  &nbsp;   &copy;  &nbsp; 2018~2020 贺莹</div>

</body>
</html>