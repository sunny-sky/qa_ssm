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
    
    $(".addAnswerLink").click(function(){
    	var page = "forecheckLogin";
        $.get(
                page,
                function(result){
                    if("success"==result){
                    	var qid = ${q.id};
                    	var addAnswerpage = "addAnswer"+'?qid='+qid;                  	
                  		window.open(addAnswerpage)                    			
                    }
                    else{
                        $("#loginModal").modal('show');                     
                    }
                }
        );      
        return false;
    });
    
    
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
                                    	var num = Number($(".cltProblemNum").text());
                                    	num = 1 + num;
                                        $(".addCltpButton").html("已收藏");
                                        $(".cltProblemNum").text(num);
                                    }
                                    else{
                                    	var num = Number($(".cltProblemNum").text());
                                    	num = num - 1;
                                    	$(".addCltpButton").html("收藏问题"); 
                                    	$(".cltProblemNum").text(num);
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
        var password1 = $("#password1").val();
         
        if(0==name.length||0==password1.length){
            $("span.errorMessage").html("请输入账号密码");
            $("div.loginErrorMessageDiv").show();           
            return false;
        }
        var password = $.md5(password1);
         
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


<div class="imgAndInfo">

    <div class="infoInimgAndInfo">
        <div class="questionTitle">${q.content}</div>
        <div class="questionAnswerAndCltp">
            <div>回答数 <span class="redColor boldWord"> ${answerNum}</span></div>   
            <div>收藏数 <span class="redColor boldWord cltProblemNum"> ${cltProblemNum}</span></div>   
            <div>提问时间： <span class="redColor boldWord">${q.creationtime}</span></div> 
        </div>
        
       
        <div class="cltproblemDiv">
            <a class="addCltpLink" href="#nowhere"><button type="button" class="btn btn-primary addCltpButton" data-toggle="modal" data-target="#loginModal">
				${cltButton}</button>
			</a>
			<a class="addAnswerLink" href="addAnswer" target="_blank"><button type="button" class="btn btn-success addAnswerButton">去回答问题</button></a>
			<a  href="fore_addRptQuestion?qid=${q.id}" ><button type="button" class="btn btn-warning">举报该问题</button></a>         
        </div>
       
    </div>
     
    <div style="clear:both"></div>
     
</div>
