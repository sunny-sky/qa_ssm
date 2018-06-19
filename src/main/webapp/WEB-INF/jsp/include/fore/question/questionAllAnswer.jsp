<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<div class="questionAllAnswerDiv" >
	<div class="questionAllAnswerTopPart">
		<a href="#nowhere" class="questionAnswerTopPartSelectedLink selected">所有回答 <span class="questionAllAnswerTopAnswerLinkNumber">${answerNum}</span> </a>
		<!-- <a href="#nowhere" class="questionAnswerTopAllAnswerLink">回答问题</a> -->
	</div>
	
	
	<div class="productParamterPart">
		<div class="productParamter">问题回答：</div>
		

		<c:forEach items="${answers}" var="a">
			<div class="productReviewItem">
	
				<div class="productReviewItemDesc">
					<div class="productReviewItemContent">
						${a.content}						
					</div>
					<div class="productReviewItemDate"><fmt:formatDate value="${a.creationtime}" pattern="yyyy-MM-dd"/></div>
				</div>
				<div class="productReviewItemUserInfo">
				
					${a.user.anonymousName}<span class="userInfoGrayPart">（匿名）</span>
				</div>			
				<div style="clear:both"></div>		
			</div>
		</c:forEach>

		<div style="clear:both"></div>
	</div>
	
	
</div>
	
	


