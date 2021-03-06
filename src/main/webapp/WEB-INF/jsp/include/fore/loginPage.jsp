<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>


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



        var left = window.innerWidth/2+162;
        $("div.loginSmallDiv").css("left",left);
    })
</script>


<div id="loginDiv" style="position: relative">

	<div class="simpleLogo">
		<img id="simpleLogo" class="simpleLogo" src="img/site/simplelogo.jpg">
	</div>


	<img id="loginBackgroundImg" class="loginBackgroundImg" src="img/site/background.png">

	<form class="loginForm" action="forelogin" method="post">
		<div id="loginSmallDiv" class="loginSmallDiv">
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
				<input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">
			</div>

			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-lock"></span>
				</span>
				<input id="password1" name="password1" type="password" placeholder="密码" type="text">
				<input id="password" name="password" type="hidden"  >
			</div>
			<span class="text-danger">请牢记自己的账号密码</span><br><br>


			<div>
				<a class="notImplementLink" href="#nowhere">忘记登录密码</a>
				<a href="registerPage" class="pull-right">免费注册</a>
			</div>
			<div style="margin-top:20px">
				<button class="btn btn-block redButton" type="submit">登录</button>
			</div>
		</div>
	</form>


</div>	