<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="top ">
	<a href="forehome">
		<span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-home redColor"></span>
		问答首页
	</a>

	<span>Hi，欢迎来参与问答</span>

	<c:if test="${!empty user}">
		<a href="loginPage">${user.name}</a>
		<a href="forelogout">退出</a>
	</c:if>

	<c:if test="${empty user}">
		<a href="loginPage">请登录</a>
		<a href="registerPage">免费注册</a>
	</c:if>


	<span class="pull-right">
			<a href="forePersonalCenter">个人中心</a>
	</span>		
			


</nav>



