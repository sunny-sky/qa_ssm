<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<div class="questionAnswerDiv" >
	<div class="questionAnswerTopPart">
		<a href="#nowhere" class="questionAnswerTopPartSelectedLink selected">所有回答 <span class="productDetailTopReviewLinkNumber">${answerNum}</span> </a>
	</div>
	
	
	<div class="productParamterPart">
		<div class="productParamter">问题回答：</div>
		
		<div class="productParamterList">
			<c:forEach items="${answers}" var="a">
				<span>${a.content} </span>
			</c:forEach>
		</div>
		<div style="clear:both"></div>
	</div>
	
	
</div>
	
	


