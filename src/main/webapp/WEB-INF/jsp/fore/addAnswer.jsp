<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/fore/header.jsp"%>
<%@include file="../include/fore/top.jsp"%>

<script>

</script>

<title>新增回答</title>

<style>

</style>

<div id="addAnswerPage">
    <br>
    <br> 
    <div id="panel-warning" class="panel panel-warning addDiv">
      <div class="panel-heading">新增问题</div>
      <div class="panel-body">
            <form method="post" id="addForm" action="fore_answer_add" 
            		enctype="multipart/form-data" style="line-height:30px" role="form">
            	<div class="form-group">
            		<label for="name">回答问题</label>
           			<textarea id="content" name="content" class="form-control" rows="3"></textarea>
           			<button type="submit" class="btn btn-success">提交回答</button>
           		</div>
           	</form>
      </div>
            		
    </div>

</div>