<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
$(function(){
	$(".userlikelink").click(function(){
		var page = "userlike_taggle";
		var aid = "<%=aid%>";
		page = page+"?aid="+aid;
		$.post(
			page,
			{"aid":aid},
			
			function(result){
				if("success"==result){
					aid = <%=session.getAttribute("aid")%>
					var tid = "userlikebutton";
					tid = tid+"aid"+aid;
					$("#"+tid).html("已赞");
					alert("已赞");
					/* $(tid).css("background-color","lightgray")
                    $(tid).css("border-color","lightgray")
                    $(tid).css("color","black") */
				}
				else{
						aid = <%=session.getAttribute("aid")%>
						var tid = "userlikebutton";
						tid = tid+"aid"+aid;
						$("#"+tid).html("点赞");
						alert("点赞");
					/* $(tid).css("background-color","gray")
                    $(tid).css("border-color","gray")
                    $(tid).css("color","white") */
					
				}			
		
			});
	})
});
</script>
	
<div class="questionAllAnswerDiv" >
	<div class="questionAllAnswerTopPart">
		<a href="#nowhere" class="questionAnswerTopPartSelectedLink selected">所有回答 <span class="questionAllAnswerTopAnswerLinkNumber">${answerNum}</span> </a>
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
				<div>
					<a id="userlikelink" class="userlikelink"><button id="userlikebuttonaid${a.id}" type="button" class="btn btn-primary">点赞</button></a>	
					<%-- <a id="userlikelink" href="userlike_taggle?aid=${a.id}"><button id="userlikebutton" type="button" class="btn btn-primary">点赞</button></a> --%>	
					<input type="hidden" id="valueofaid" name="valueofaid" value="${a.id}">
					<% String aid = "${a.id}";%> 
					<a href="forereply?aid=${a.id}"><button type="button" class="btn btn-primary">评论</button></a>	
				</div>
				<div style="clear:both"></div>		
			</div>
		</c:forEach>

		<div style="clear:both"></div>
	</div>
	
	
</div>

	
	


