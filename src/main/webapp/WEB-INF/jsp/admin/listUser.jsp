

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
</script>

<title>用户管理</title>


<div class="workingArea">
	<h1 class="label label-info" >用户管理</h1>

	<br>
	<br>

	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
			<tr class="success">
				<th>ID</th>
				<th>用户名称</th>
				<th>性别</th>
				<th>生日</th>
				<th>邮箱</th>
				<th>用户状态</th>
				<th>加入黑名单</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${us}" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.name}</td>
					<td>${u.gender}</td>
					<td>${u.birthday}</td>
					<td>${u.email}</td>
					<td>${u.status}</td>
					<td><a deleteLink="true" href="admin_user_blacklist?id=${u.id}"><span class="glyphicon glyphicon-remove"></span></a>
					<a  href="admin_user_rmblacklist?id=${u.id}"><span class="glyphicon glyphicon-ok"></span></a></td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp" %>
	</div>


</div>

<%@include file="../include/admin/adminFooter.jsp"%>
