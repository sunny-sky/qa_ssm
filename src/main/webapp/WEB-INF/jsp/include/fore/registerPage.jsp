<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<script type="text/javascript" src="js/jquery.md5.js" ></script>


<script>
    $(function(){

        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility","visible");
        </c:if>

        $(".registerForm").submit(function(){
            if(0==$("#name").val().length){
                $("span.errorMessage").html("请输入用户名");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#password1").val().length){
                $("span.errorMessage").html("请输入密码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#repeatpassword").val().length){
                $("span.errorMessage").html("请输入重复密码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if($("#password1").val() !=$("#repeatpassword").val()){
                $("span.errorMessage").html("重复密码不一致");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            	
            var psw1 = $("#password1").val();
            var psw = $.md5(psw1);
            $("#password").val(psw);
            
//            alert($("#password").val());
            
            
            

            return true;
        });
    })
</script>



<form method="post" action="foreregister" class="registerForm">


	<div class="registerDiv">
		<div class="registerErrorMessageDiv">
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
				<span class="errorMessage"></span>
			</div>
		</div>


		<table class="registerTable" >
			<tr>
				<td  class="registerTip registerTableLeftTD">设置会员名</td>
				<td></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">登陆名</td>
				<td  class="registerTableRightTD"><input id="name" name="name" placeholder="会员名一旦设置成功，无法修改" > </td>
			</tr>
			<tr>
				<td  class="registerTip registerTableLeftTD">设置登陆密码</td>
				<td  class="registerTableRightTD">登陆时验证，保护账号信息</td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">登陆密码</td>
				<td class="registerTableRightTD"><input id="password1" name="password1" type="password"  placeholder="设置你的登陆密码" > </td>
				<td><input id="password" name="password" type="hidden"  ></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">密码确认</td>
				<td class="registerTableRightTD"><input id="repeatpassword" type="password"   placeholder="请再次输入你的密码" > </td>
			</tr>

			<tr>
				<td class="registerTableLeftTD">性别</td>
				<td><input type="radio" value="男" name="gender" >男</td>
				<td><input type="radio" value="女"  name="gender" >女</td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">生日</td>
				<td class="registerTableRightTD"><input id="birthday" name="birthday"   placeholder="请输入你的生日，如：19990101" > </td>
			</tr>
			
			<tr>
				<td class="registerTableLeftTD">邮箱</td>
				<td class="registerTableRightTD"><input id="email" name="email"   placeholder="请输入你的邮箱，如：**@qq.com" > </td>
			</tr>

			<tr>
				<td class="registerTableLeftTD">地址</td>
				<td class="registerTableRightTD"><input id="address" name="address"   placeholder="请输入你的地址" > </td>
			</tr>
			
			<tr>
				<td class="registerTableLeftTD">个性签名</td>
				<td class="registerTableRightTD"><textarea cols="90" rows="8" id="signature" name="signature"   placeholder="请输入你的个性签名" > </textarea>
			</tr>			

			<tr>
				<td colspan="2" class="registerButtonTD">
					<a href="registerSuccess.jsp"><button>提   交</button></a>
				</td>
			</tr>
		</table>
	</div>
</form>