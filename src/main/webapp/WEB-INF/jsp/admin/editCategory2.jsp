<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>



<title>编辑二级分类</title>


<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;

            return true;
        });
    });

</script>

<div class="workingArea">

	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li class="active">编辑分类</li>
	</ol>

	<div class="panel panel-warning editDiv">
		<div class="panel-heading">编辑分类</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="admin_category2_update"  enctype="multipart/form-data">
				<table class="editTable">
					<tr>
						<td>分类名称</td>
						<td><input  id="name" name="name" value="${c.name}" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>分类图片</td>
						<td>
							<input id="categoryPic" accept="image/*" type="file" name="image" />
						</td>
					</tr>
					<tr>
                        <td>一级分类id</td>
                        <td>
                        	<select id="c1id" name="c1id" >
	        					<option value="-1">请选择</option>
	        					<c:forEach items="${cs}" var="c">
					            	<option value="${c.id}">${c.name }</option>
					       		</c:forEach>
				    		</select>
				    	</td>
                    </tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="id" value="${c2.id}">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>