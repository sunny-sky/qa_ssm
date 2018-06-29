<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>


<div class="questionAllAnswerDiv" >
	<div class="infoInimgAndInfo">
        <div class="questionTitle">${answer.content}</div>
    </div>
	<div class="questionAllAnswerTopPart">
		<a href="#nowhere" class="questionAnswerTopPartSelectedLink selected">回答评论 <span class="questionAllAnswerTopAnswerLinkNumber">${replyNum}</span> </a>
	</div>	
	<div class="productParamterPart">
		<div class="productParamter">问题评论：</div>
		

		<c:forEach items="${replys}" var="r">
			<div class="productReviewItem">
	
				<div class="productReviewItemDesc">
					<div class="productReviewItemContent">
						${r.content}						
					</div>
					<div class="productReviewItemDate">${r.creationtime}</div>
				</div>
				<div class="productReviewItemUserInfo">				
					${r.user.anonymousName}<span class="userInfoGrayPart">（匿名）</span>
				</div>
				<div>
					<button id="rptbutton" type="button" class="btn btn-danger">举报</button>
					
				</div>
				<div style="clear:both"></div>		
			</div>
		</c:forEach>

	<div style="clear:both"></div>
		<div id="panel-warning" class="panel panel-warning addDiv">
	      <div class="panel-heading">新增评论</div>
	      	<div class="panel-body">
	            <form method="post"  action="fore_reply_add" 
	            		enctype="multipart/form-data" style="line-height:30px" role="form">
	            	<div class="form-group">
	            		<label for="name">写评论</label>
	           			<textarea id="content" name="content" class="form-control" rows="3"></textarea>
	           			<input id="aid" name="aid" type="hidden" value="${answer.id}">
	           			<input id="userid" name="userid" type="hidden" value="${user.id}">
	           			<span>问题ID：${answer.id} 登陆用户ID：${user.id}</span>
	           			<button  class="btn btn-success submit">提交评论</button>
	           		</div>
	           	</form>
		           	
		      </div>
		            		
		</div>
	
	</div>
	
	
</div>