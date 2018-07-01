<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="searchProducts">

	<c:forEach items="${qs}" var="q">
	<div class="questionUnit" >
		
		<span class="questionPrice">回答数：<fmt:formatNumber type="number" value="${q.answerNum}" /></span>
		<a class="questionLink" href="forequestion?qid=${q.id}">
				${fn:substring(q.content, 0, 50)}
		</a>

	

		<div class="show1 productInfo">
			<span class="monthDeal ">关注问题人数： <span class="productDealNumber">${q.cltProblemNum}</span></span>

		</div>

	</div>
	</c:forEach>
	<c:if test="${empty qs}">
	<div class="noMatch">没有满足条件的问题</div>
		</c:if>

		<div style="clear:both"></div>
	</div>