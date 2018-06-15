<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<div class="answerDiv">
	<div class="reviewQuestionInfoDiv">		
		<div class="answerQuestionInfoRightDiv">
			<div class="answerQuestionInfoRightText">
				${q.content}
			</div>
			<table class="answerQuestionInfoTable">
				<tr>
					<td width="75px">回答数:</td>
					<td><span class="answerQuestionInfoTableNum"><fmt:formatNumber type="number" value="${q.answerNum}" /></span> 个 </td>
				</tr>
				<tr>
					<td>收藏数:</td>
					<td><span class="answerQuestionInfoTableNum">${q.cltProblemNum}</span> 次</td>
				</tr>
			</table>
			
			<div class="answerQuestionInfoRightBelowDiv">
				<span class="answerQuestionInfoRightBelowText" >现在查看的是 您所回答问题的信息
于<fmt:formatDate value="${q.creationtime}" pattern="yyyy年MM月dd"/>提出该问题 </span>
			
			</div>
		</div>
		<div style="clear:both"></div>
	</div>
	<div class="answerStasticsDiv">
		<div class="answerStasticsLeft">
				<div class="answerStasticsLeftTop"></div>
				<div class="answerStasticsLeftContent">累计回答 <span class="answerStasticsNumber"> ${q.cltProblemNum}</span></div>
				<div class="answerStasticsLeftFoot"></div>
		</div>
		<div class="answerStasticsRight">
			<div class="answerStasticsRightEmpty"></div>
			<div class="answerStasticsFoot"></div>
		</div>
	</div>		
	
	<c:if test="${param.showonly==true}">
	<div class="answerDivlistReviews">
		<c:forEach items="${answers}" var="a">
			<div class="answerDivlistReviewsEach">
				<div class="answerDate"><fmt:formatDate value="${a.createTime}" pattern="yyyy-MM-dd"/></div>
				<div class="answerContent">${a.content}</div>
				<div class="answerUserInfo pull-right">${a.user.name}<span class="answerUserInfoAnonymous">(匿名)</span></div>
			</div>
		</c:forEach>
	</div>
	</c:if>
	
	<c:if test="${param.showonly!=true}">
		<div class="makeAnswerDiv">
		<form method="post" action="foredoreview">
			<div class="makeAnswerText">其他用户，需要你的回答哦！</div>
			<table class="makeAnswerTable">
				<tr>
					<td class="makeAnswerTableFirstTD">回答问题</td>
					<td><textarea name="content"></textarea></td>
				</tr>
			</table>
			<div class="makeAnswerButtonDiv">
				<input type="hidden" name="userid" value="${user.name}">
				<input type="hidden" name="qid" value="${q.id}">
				<button type="submit">提交评价</button>
			</div>
		</form>
		</div>	
	</c:if>

</div>