<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
$(function(){
	$("div.ProductsAsideCategorys div.row a").each(function(){
		var v = Math.round(Math.random() *6);
		if(v == 1)
			$(this).css("color","#87CEFA");
	});
});

</script>
<c:forEach items="${cs}" var="c">
    <div cid="${c.id}" class="ProductsAsideCategorys">
      
        <c:forEach items="${c.category2sByRow}" var="c2s">
            <div class="row show1">
                <c:forEach items="${c2s}" var="c2">
                    <c:if test="${!empty c2.name}">
                        <a href="foreProduct?pid=${c2.id}">
                            <%-- <c:forEach items="${fn:split(c2.name, ' ')}" var="title" varStatus="st">
                                <c:if test="${st.index==0}"> --%>
                                    ${c2.name}
                                <%-- </c:if>
                            </c:forEach> --%>
                        </a>
                    </c:if>
                </c:forEach>
                <div class="seperator"></div>
            </div>       
        </c:forEach>
    </div>           
</c:forEach>
	
