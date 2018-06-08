<!-- 模仿天猫整站ssm 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
</script>

<title>举报管理</title>


<div class="workingArea">
	<h1 class="label label-info" >举报管理</h1>

	<br>
	<br>

	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
			<tr class="success">
				<th>ID</th>
				<th>用户名</th>
				<th>问题id</th>
				<th>备注</th>

			</tr>
			</thead>
			<tbody>
			<c:forEach items="${rps}" var="rp">
				<tr>
					<td>${rp.id}</td>
					<td>${rp.user.name}</td>
					<td>${rp.qid}</td>
					<td>${rp.note}</td>

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
