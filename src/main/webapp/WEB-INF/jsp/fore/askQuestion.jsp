<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>

 
<script>
$(function(){
     
    $("#addForm").submit(function(){
        if(!checkEmpty("content","问题内容"))
            return false;
        return true;
    });
    
});

function category1(){
	var c1id = $("#c1id").val();
    $("#c2id").empty();
    page = "Cascading_menu?c1id="+c1id;
    if(c1id !=null){
         $.ajax({
        		url :page,
        		type : 'post',
        		dataType : 'json',                
                async : false,
                //contentType: "application/json; charset=utf-8",
                success :function(data) {
                    console.log(data);                  
                       if(data!=null){
                    	   //var c2s = ${c2s};
                           $("#c2id").prepend("<option value='-1'>请选择</option>");
                            $.each(data,function(i,item){  
                            	$.each(item,function(j,val){
                                      $("#c2id").append("<option value="+val.id+">二级分类id："+val.id+"二级分类名"+val.name+"</option>");                                                                         
                            	 })
                            }); 
                       }                                                    
                }

         })
    }else{
        alert("请选择一级分类！！");
    }
}


 
</script>

 
<title>新增问题</title>
<style>
#addQuestionPage{

	margin: 80px;
	padding: 10px;

}
#panel-warning{
	width:500px;
	height:400px;
}
</style>
<div id="addQuestionPage">
    <br>
    <br>     
    <div id="panel-warning" class="panel panel-warning addDiv">
      <div class="panel-heading">新增问题</div>
      <div class="panel-body">
            <form method="post" id="addForm" action="fore_question_add" enctype="multipart/form-data" style="line-height:30px">
                <table class="addTable">
                    <tr>
                        <td>提问</td>
                        <td><input id="content" name="content" type="text" class="form-control" value="问题内容" style="width:200%"></td>
                    </tr>    
     				
                    <tr>
						<td>一级分类选择</td>
						<td>
                        	<select id="c1id" name="c1id" onchange="category1();">
	        					<option value="-1">请选择</option>
	        					<c:forEach items="${cs}" var="c">
					            	<option value="${c.id}">${c.name }</option>
					       		</c:forEach>
				    		</select>
				    	</td>
						
                    </tr>
					
                    <tr>
                    	<td>二级分类选择</td>
                    	<!-- <td><input id="c2id" name="c2id" type="number" class="form-control" value="二级分类ID" style="width:200%"></td>  -->   
                    	<td>
                        	<select id="c2id" name="c2id">
	        					<option value="-1">请选择</option>
				    		</select>
				    	</td>               	
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
      </div>
    </div>
     
</div>
 
<%@include file="../include/fore/footer.jsp"%>