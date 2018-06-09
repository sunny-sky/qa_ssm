

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
	$(function(){
	    $("button.questionContent").click(function(){
	        var rpid = $(this).attr("rpid");
	        $("tr.questionContentTR[rpid="+rpid+"]").toggle();
	    });
	});

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
				<th width="280px">操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${rps}" var="rp">
				<tr>
					<td>${rp.id}</td>
					<td>${rp.user.name}</td>
					<td>${rp.qid}</td>
					<td>${rp.note}</td>
										<td>
						<button rpid=${rp.id} class="questionContent btn btn-primary btn-xs">查看详情</button>
				
							<a href="admin_rptproblem_delete?id=${rp.id}">
								<button class="btn btn-primary btn-xs">忽视举报</button>
							</a>

					</td>
				</tr>
				<tr class="questionContentTR"  rpid=${rp.id}>
					<td colspan="10" align="center">

						<div  class="questionContent">
							<table width="800px" align="center" class="questionContentTable">
								<%-- <c:forEach items="${rp.question}" var="rpq"> --%>
									<tr>
										<%-- <td align="left">
											<img width="40px" height="40px" src="img/productSingle/${oi.product.firstProductImage.id}.jpg">
										</td> --%>

										<td>
											<a href="forequestion?qid=${rp.question.id}">
												<span>问题：${rp.question.content}</span>
											</a>
										</td>
										<td align="right">

											<span class="text-muted">一级分类id：${rp.question.c1id}</span>
										</td>
										<td align="right">

											<span class="text-muted">二级分类id：${rp.question.c2id}</span>
										</td>

									</tr>
							<%-- 	</c:forEach> --%>

							</table>
						</div>

					</td>
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
