<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<div class="productDetailDiv" >
	<div class="productDetailTopPart">
		<a href="#nowhere" class="productDetailTopPartSelectedLink selected">所有回答 <span class="productDetailTopReviewLinkNumber">${p.reviewCount}</span> </a>
	</div>
	
	
	<div class="productParamterPart">
		<div class="productParamter">问题回答：</div>
		
		<div class="productParamterList">
			<c:forEach items="${pvs}" var="pv">
				<span>${pv.property.name}:  ${fn:substring(pv.value, 0, 10)} </span>
			</c:forEach>
		</div>
		<div style="clear:both"></div>
	</div>
	
	
</div>

