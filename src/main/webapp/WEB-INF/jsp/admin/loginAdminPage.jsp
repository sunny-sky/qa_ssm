<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
	<script src="js/jquery/2.0.0/jquery.min.js"></script>
	<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.md5.js" ></script>
	<link href="css/fore/style.css" rel="stylesheet">
	<title>后台登陆</title>
	<script>
	    $(function(){
	
	        <c:if test="${!empty msg}">
		        $("span.errorMessage").html("${msg}");
		        $("div.loginErrorMessageDiv").show();
	        </c:if>
	
	        $("form.loginForm").submit(function(){
	            if(0==$("#name").val().length||0==$("#password1").val().length){
	                $("span.errorMessage").html("请输入账号密码");
	                $("div.loginErrorMessageDiv").show();
	                return false;
	            }
	            var psw1 = $("#password1").val();
	            var psw = $.md5(psw1);
	            $("#password").val(psw);
	            return true;
	        });
	
	        $("form.loginForm input").keyup(function(){
	            $("div.loginErrorMessageDiv").hide();
	        });
	
	
	
	        
	    })
	</script>
</head>
	        <c:if test="${!empty msg}">
		        $("span.errorMessage").html("${msg}");
		        $("div.loginErrorMessageDiv").show();
	        </c:if>

<div id="loginDiv" style="position: relative;float:left">
	
	<form class="loginForm" action="adminLoginCheck" method="post">
		<div id="loginSmallDiv" class="loginSmallDiv"  style="left:200px">
			<div class="loginErrorMessageDiv">
				<div class="alert alert-danger" >
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
					<span class="errorMessage"></span>
				</div>
			</div>

			<div class="login_acount_text">账户登录</div>
			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-user"></span>
				</span>
				<input id="name" name="name" placeholder="管理员账号" type="text">
			</div>

			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-lock"></span>
				</span>
				<input id="password1" name="password1" type="password" placeholder="密码" type="text">
				<input id="password" name="password" type="hidden"  >
			</div>
			<span class="text-danger"></span><br><br>


			
			<div style="margin-top:20px">
				<button class="btn btn-block redButton" type="submit">登录</button>
			</div>
		</div>
	</form>


</div>	