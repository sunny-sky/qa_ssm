<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navitagorDiv">
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<!-- <img style="margin-left:10px;margin-right:0px" class="pull-left" src="img/site/govern" height="45px"> -->
		<a class="navbar-brand" href="#nowhere">问答后台</a>
		
		<a class="navbar-brand" href="admin_category_list">一级分类管理</a>
		<a class="navbar-brand" href="admin_category2_list">二级分类管理</a>
		<a class="navbar-brand" href="admin_user_list">用户管理</a>
		<a class="navbar-brand" href="admin_rptproblem_list">举报管理</a>
		

		<a class="navbar-brand"  >管理员<b>${user.name}</b>,您好</a>
		<a class="navbar-brand" href="adminLogin">退出登陆</a>

		
		
	</nav>
</div>