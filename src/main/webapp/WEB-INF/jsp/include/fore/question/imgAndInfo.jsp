<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
 
$(function(){
    var stock = ${p.stock};
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
     
    $(".addCartButton").removeAttr("disabled");
    $(".addCartLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var pid = ${p.id};
                        var num= $(".productNumberSetting").val();
                        var addCartpage = "foreaddCart";
                        $.get(
                                addCartpage,
                                {"pid":pid,"num":num},
                                function(result){
                                    if("success"==result){
                                        $(".addCartButton").html("已加入购物车");
                                        $(".addCartButton").attr("disabled","disabled");
                                        $(".addCartButton").css("background-color","lightgray")
                                        $(".addCartButton").css("border-color","lightgray")
                                        $(".addCartButton").css("color","black")
                                         
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
    $(".buyLink").click(function(){
        var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                        var num = $(".productNumberSetting").val();
                        location.href= $(".buyLink").attr("href")+"&num="+num;
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
        
       
        <div class="buyDiv">
            <a href="#nowhere" class="addCartLink"><button class="addCartButton"><span class="glyphicon glyphicon-shopping-cart"></span>收藏该问题</button></a>
        </div>
    </div>
     
    <div style="clear:both"></div>
     
</div>