<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
 
$(function(){
    $(".productNumberSetting").keyup(function(){
        var num= $(".productNumberSetting").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
     
    $(".increaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        num++;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
    $(".decreaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        --num;
        if(num<=0)
            num=1;
        $(".productNumberSetting").val(num);
    });
     
    $(".addCltpButton").removeAttr("disabled");
    $(".addCltpLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var qid = ${q.id};
                        var addCltppage = "foreaddCltp";
                        $.get(
                                addCltppage,
                                {"qid":qid},
                                function(result){
                                    if("success"==result){
                                        $(".addCltpButton").html("已收藏");
                                        $(".addCltpButton").attr("disabled","disabled");
                                        $(".addCltpButton").css("background-color","lightgray")
                                        $(".addCltpButton").css("border-color","lightgray")
                                        $(".addCltpButton").css("color","black")
                                         
                                    }
                                    else{
                                         
                                    }
                                }
                        );                          
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
     
    $("img.smallImage").mouseenter(function(){
        var bigImageURL = $(this).attr("bigImageURL");
        $("img.bigImg").attr("src",bigImageURL);
    });
     
    $("img.bigImg").load(
        function(){
            $("img.smallImage").each(function(){
                var bigImageURL = $(this).attr("bigImageURL");
                img = new Image();
                img.src = bigImageURL;
                 
                img.onload = function(){
                    $("div.img4load").append($(img));
                };
            });     
        }
    );
});
 
</script>


<div class="imgAndInfo">

    <div class="infoInimgAndInfo">
        <div class="questionTitle">${q.content}</div>
        <div class="productSaleAndReviewNumber">
            <div>回答数 <span class="redColor boldWord"> ${answerNum}</span></div>   
            <div>点赞数 <span class="redColor boldWord"> ${userLikeNum}</span></div>    
        </div>
        
       
        <div class="cltproblemDiv">
            <a class="addCltpLink" href="#nowhere"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal">
				收藏问题</button>
			</a>         
          
        </div>
    </div>
     
    <div style="clear:both"></div>
     
</div>