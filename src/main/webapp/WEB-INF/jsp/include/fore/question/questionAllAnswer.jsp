<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>



$(function(){	
	$(".userlikebutton").each(function(){
		$(this).click(function(){
			var page = "userlike_taggle";
			aid = $(this).attr("id");
			$.ajax({
					url:page,
					type : 'post',
					data:{"aid":aid},
					dataType:'json',
					success:function(data){

						if("success"==data.status){
							
							$("#"+aid).html("已赞");
							$("#userLikeNum"+aid).html(data.num);
						}
						else{
							$("#"+aid).html("点赞");
							$("#userLikeNum"+aid).html(data.num);
						}
					}});
		});
		
	});
	
});
</script>
	
<div class="questionAllAnswerDiv" >
	<div class="questionAllAnswerTopPart">
		<a href="#nowhere" class="questionAnswerTopPartSelectedLink selected">所有回答 <span class="questionAllAnswerTopAnswerLinkNumber">${answerNum}</span> </a>
	</div>
	
	
	<div class="productParamterPart">
		

		<c:forEach items="${answers}" var="a">
			<div class="productReviewItem">
	
				<div class="productReviewItemDesc">
					<div class="productReviewItemContent">
						${a.content}						
					</div>
					<div class="productReviewItemDate">${a.creationtime}</div>
				</div>
				<div class="productReviewItemUserInfo">				
					${a.user.anonymousName}<span class="userInfoGrayPart">（匿名）</span>
				</div>
				<div style="height:20;line-height: 4;">
					<div style="height:20">点赞数 <span id="userLikeNum${a.id}"  class="redColor boldWord"> ${a.likenumber}</span></div>
					<a id="userlikelink${a.id}" class="userlikelink" style="float:right;display:block;"><button id="${a.id}" type="button" class="btn btn-primary userlikebutton" >${a.userLikeStatus}</button></a>											
					<p><a href="forereply?aid=${a.id}" style="float:right;display:block;"><button type="button" class="btn btn-primary" >评论</button></a></p>
				</div>
				<div style="clear:both"></div>		
			</div>
		</c:forEach>

		<div style="clear:both"></div>
	</div>
	
	
</div>

	
	


