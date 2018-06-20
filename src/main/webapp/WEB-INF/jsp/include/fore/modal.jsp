<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal" id="loginModal" tabindex="-1" role="dialog" >
	<div class="modal-dialog loginDivInProductPageModalDiv">
		<div class="modal-content">
			<div class="loginDivInProductPage">
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
					<input id="name" name="name" placeholder="用户名" type="text">
				</div>

				<div class="loginInput " >
							<span class="loginInputIcon ">
								<span class=" glyphicon glyphicon-lock"></span>
							</span>
					<input id="password" name="password"  type="password" placeholder="密码" type="text">
				</div>
				<span class="text-danger">请牢记自己的账号密码 </span><br><br>
				<div>
					<a href="#nowhere">忘记登录密码(未完成)</a>
					<a href="registerPage" class="pull-right">免费注册</a>
				</div>
				<div style="margin-top:20px">
					<button class="btn btn-block redButton loginSubmitButton" type="submit">登录</button>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog" >
	<div class="modal-dialog deleteConfirmModalDiv">
		<div class="modal-content">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title">确认删除？</h4>
			</div>
			<div class="modal-footer">
				<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
				<button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
			</div>
		</div>
	</div>
</div>



<div class="modal " id="replyModal" tabindex="-1" role="dialog" aria-labelledby="replyModalLabel">
<div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">评论区</h4>
          </div>
          <div class="modal-body">
          	<div>
          		<p>以往评论</p>
          		<p>${answer.content}</p>
          		<c:forEach items="${replys}" var="r">
          			<span class="text-success">${r.content}</span>
          			<div >				
					${r.user.anonymousName}<span class="userInfoGrayPart">（匿名）</span>
					</div>
          		</c:forEach>
          	</div>
          	<div>
            	<p>写评论</p>
            	<textarea class="form-control"></textarea>
            </div>
          </div>
          <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
            <button class="btn btn-primary" type="button">提交</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
</div>
