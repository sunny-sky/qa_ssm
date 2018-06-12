<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${empty param.categorycount}">
	<c:set var="categorycount" scope="page" value="100"/>
</c:if>

<c:if test="${!empty param.categorycount}">
	<c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>

<div class="homepageCategoryProducts">
	<c:forEach items="${cs}" var="c" varStatus="stc">
		<c:if test="${stc.count<=categorycount}">
			<div class="eachHomepageCategoryProducts">
				<div class="left-mark"></div>
				<span class="categoryTitle">${c.name}</span>
				<br>
				<c:forEach items="${c.questions}" var="q" varStatus="st">
					<c:if test="${st.count<=5}">
						<div class="questionItem" >
							<a href="forequestion?qid=${q.id}">${q.id}</a>
							<a class="questionItemDescLink" href="forequestion?qid=${q.id}">
								<span class="questionItemDesc">[热搜]
								${fn:substring(q.content, 0, 20)}<br/>
								共有回答：${q.answerNum}个<br/>
								共收藏：${q.userLikeNum}次
								</span>
						    </a>
							
						</div>
					</c:if>				
				</c:forEach>
				<div style="clear:both"></div>
			</div>
		</c:if>
	</c:forEach>
	
	
	

</div>