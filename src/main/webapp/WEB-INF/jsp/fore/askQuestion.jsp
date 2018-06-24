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
						<td><input id="c1id" name="c1id" type="text" class="form-control" value="一级分类ID" style="width:200%"></td>
						
                    </tr>
					
                    <tr>
                    	<td>二级分类选择</td>
                    	<td><input id="c2id" name="c2id" type="text" class="form-control" value="二级分类ID" style="width:200%"></td>                   	
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