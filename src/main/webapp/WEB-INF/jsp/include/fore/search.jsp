<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>

<a href="${contextPath}">
	<img id="logo" src="img/site/qa.gif" class="logo" width="290" height="130">
</a>

<form action="foresearch" method="post" >
	<div class="searchDiv">
		<input name="keyword" type="text" value="${param.keyword}" placeholder="《Java Web从入门到精通》 ">
		<button  type="submit" class="searchButton">搜索问题</button>
		<div class="searchBelow">
			<c:forEach items="${cs}" var="c" varStatus="st">
				<c:if test="${st.count>=5 and st.count<=8}">
						<span>
							<a href="forecategory?cid=${c.id}">
									${c.name}
							</a>
							<c:if test="${st.count!=8}">
								<span>|</span>
							</c:if>
						</span>
				</c:if>
			</c:forEach>
		</div>
	</div>
</form>
<a href="askQuestion"><button  type="button" >去提问</button></a>
