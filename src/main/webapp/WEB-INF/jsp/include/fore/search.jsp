<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>

<script>
$(function(){
/* 	$(".askQuestionButton").removeAttr("disabled"); */
	$(".askQuestionLink").click(function(){
	    var page = "forecheckLogin";
	    $.get(
	            page,
	            function(result){
	                if("success"==result){
	                	location.href= $(".askQuestionLink").attr("href");
	                }
	                else{
	                    $("#loginModal").modal('show');                     
	                }
	            }
	    );      
	    return false;
	});
	$("button.loginSubmitButton").click(function(){
	    var name = $("#name").val();
	    var password = $("#password").val();
	     
	    if(0==name.length||0==password.length){
	        $("span.errorMessage").html("请输入账号密码");
	        $("div.loginErrorMessageDiv").show();           
	        return false;
	    }
	     
	    var page = "foreloginAjax";
	    $.get(
	            page,
	            {"name":name,"password":password},
	            function(result){
	                if("success"==result){
	                    location.reload();
	                }
	                else{
	                    $("span.errorMessage").html("账号密码错误");
	                    $("div.loginErrorMessageDiv").show();                       
	                }
	            }
	    );          
	    
	    return true;
	});
});
</script>

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

