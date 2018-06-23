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
			$.post(
					page,
					{"aid":aid},					
					function(result){
						if("success"==result){
							$("#"+aid).html("已赞");

						}
						else{
							$("#"+aid).html("点赞");						
						}
				});
		});
		
	});
	
	$(".productParamter").ready(function(){

		var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                    	$(".userlikebutton").each(function(){
                    		var page = "userlike_get";
                			aid = $(this).attr("id");
                			$.post(
                					page,
                					{"aid":aid},
                					function(result){
                						if("YES"==result){
                							$("#"+aid).html("已赞");
                						}
                						else{
                							$("#"+aid).html("点赞");						
                						}
                			});	
                    		
                    	})	
                    	/* alert("success");
                    	$(".userlikebutton").each(function(){
                    		
		                    	var page = "userlike_taggle";
		            			aid = $(this).attr("id");
		            			alert(aid);
		            			page = page+"?aid="+aid,
		            			$.post(
		            					page,
		            					{"aid":aid},
		            					function(result){
		            						if("success"==result){
		            							alert(aid);
		            							$("#"+aid).html("已赞");
		
		            						}
		            						else{
		            							alert(aid);
		            							$("#"+aid).html("点赞");						
		            						}
            							}
		            			);
		            			
                    	})    */                     
                    }
                    else{
                        $(".userlikebutton").each(function(){
                        	aid = $(this).attr("id");
                        	$("#"+aid).html("登陆后解锁点赞功能");
                        }
                    )}
                }
        );
        return false;
	});	
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
					<a id="userlikelink${a.id}" class="userlikelink"><button id="${a.id}" type="button" class="btn btn-primary userlikebutton" >点赞</button></a>											
					<a href="forereply?aid=${a.id}"><button type="button" class="btn btn-primary">评论</button></a>	
				</div>
				<div style="clear:both"></div>		
			</div>
		</c:forEach>

		<div style="clear:both"></div>
	</div>
	
	
</div>

	
	


