<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<script>
$(function(){
     
    $("#addForm").submit(function(){
        if(!checkEmpty("name","分类名称"))
            return false;
        if(!checkEmpty("category2Pic","分类图片"))
            return false;
        return true;
    });
});
 
</script>
 
<title>二级分类管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >二级分类管理</h1>
    <br>
    <br>
     
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>图片</th>
                    <th>二级分类名称</th>
                    <th>一级分类id</th>
                    <th>一级分类名称</th>
                    <th>属性管理</th>
                    <th>产品管理</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${c2s}" var="c2">
                 
                <tr>
                    <td>${c2.id}</td>
                    <td><img height="40px" src="img/category2/${c2.id}.jpg"></td>
                    <td>${c2.name}</td>
                    <td>${c2.category.id}</td>
                    <td>${c2.category.name}</td>
                         
                    <td><a href="admin_property_list?cid=${c2.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>                   
                    <td><a href="admin_product_list?cid=${c2.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>                  
                    <td><a href="admin_category2_edit?id=${c2.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category2_delete?id=${c2.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>
     
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
     
    <div class="panel panel-warning addDiv">
      <div class="panel-heading">新增分类</div>
      <div class="panel-body">
            <form method="post" id="addForm" action="admin_category2_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>二级分类名称</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>分类图片</td>
                        <td>
                            <input id="category2Pic" accept="image/*" type="file" name="image" />
                        </td>
                    </tr>
                    <tr>
                        <td>一级分类id</td>
                        <td><input  id="c1id" name="c1id" type="text" class="form-control"></td>
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
 
<%@include file="../include/admin/adminFooter.jsp"%>