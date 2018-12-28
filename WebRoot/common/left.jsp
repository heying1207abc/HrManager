<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="nav" id="nav">
    	<div class="t"></div>
    	<dl class="open">
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">公司介绍</dt>
            <dd><a href="index.jsp" target="_self">首页</a></dd>
            <c:if test="${empty loginUser }">
            <dd><a href="register.jsp" target="_self">注册</a></dd>
            </c:if>
            <dd><a href="login.jsp" target="_self">登录</a></dd>
        </dl>
        <c:if test="${loginUser.type=='admin' }">
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">部门管理</dt>
            <dd><a href="deptAddOper.action">添加部门信息</a></dd>
            <dd><a href="deptListOper.action">查看部门信息</a></dd>
        </dl>
         <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">职位管理</dt>
            <dd><a href="postionAddOper.action">添加职位信息</a></dd>
            <dd><a href="positionListOper.action">查看职位信息</a></dd>
        </dl>
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">员工管理</dt>
            <dd><a href="">添加员工信息</a></dd>
            <dd><a href="employeeList.action">查看员工信息</a></dd>
            <dd><a href="">员工调岗</a></dd>
             <dd><a href="">员工离职</a></dd>
        </dl>
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">考勤薪资</dt>
            <dd><a href="">统计考勤</a></dd>
            <dd><a href="rewardsAndPunishments.action">奖惩</a>
            <dd><a href="">薪资结算</a></dd>
        </dl>
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">招聘管理</dt>
            <dd><a href="recruitAddOper.action">添加招聘信息</a></dd>
            <dd><a href="adminRecuritList.action">查看招聘信息</a></dd>           
        </dl>
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">培训管理</dt>
            <dd><a href="">添加培训信息</a></dd>
            <dd><a href="">查看培训信息</a></dd>
        </dl>
        </c:if>
        <c:if test="${loginUser.type=='employee' }">
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">部门</dt>
            <dd><a href="">查看部门及职位信息</a></dd>
        </dl>
        
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">员工管理</dt>
            <dd><a href="">查看员工信息</a></dd>
        </dl>
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">考勤及奖惩管理</dt>
            <dd><a href="attendaceDisplay.action">考勤打卡</a></dd>
            <dd><a href="">查看奖惩信息</a></dd>
            <dd><a href="">工资明细信息</a></dd>
        </dl>
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">培训管理</dt>
            <dd><a href="">查看培训信息</a></dd>
        </dl>
        </c:if>
        <c:if test="${loginUser.type=='guest' }">
        <dl>
        	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">个人简历</dt>
            <dd><a href="recruitList.action">查看招聘信息</a></dd>
            <dd><a href="addResume.action">填写个人简历</a></dd>
            <dd><a href="getNotice.action?userId=${loginUser.id }">查看面试通知</a></dd>
        </dl>
        </c:if>
        
    </div>
