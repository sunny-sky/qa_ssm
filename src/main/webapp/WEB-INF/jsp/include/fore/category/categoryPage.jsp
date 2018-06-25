<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title></title>    
<style>
th{
	 text-align:center;
}
</style>
<br>
<br>
<br>
<br>
<br>
<div style="font-size:40px;margin: 0 auto;width:70%">
	<span><b>一级分类：</b></span>
	<span><img height="40px" src="img/category/${c.id}.jpg"></span>
	<span class="text-primary">${c.name}相关信息</span>
</div>

<div>
	<table class="table table-striped table-bordered table-hover  table-condensed" style="width:70%;margin: 0 auto;text-align: center;"  >
	  <caption style="text-align:center"><h4>该一级分类下所属二级分类</h4></caption>
	  <tr>
	     <th>二级分类ID</th>
	     <th>名字</th>
	     <th>图标</th>
	     <th>功能</th>
	  </tr>
	  <tbody>
		  <c:forEach items="${c2s}" var="c2">
			 <tr>			 
			    <td>${c2.id }</td> 
			    <td>${c2.name }</td>  
			    <td><img height="40px" src="img/category2/${c2.id}.jpg"></td>
			    <td><a href="forecategory2?c2id=${c2.id}"><button>查看详情</button></a></td>  			  
			 </tr>
		  </c:forEach>	 	 
	  </tbody>
	</table>
</div>
<br>
<br><br>
<br>
<div>
	<table class="table table-striped table-bordered table-hover  table-condensed" style="width:50%;margin: 0 auto;text-align: center;">
	  <caption style="text-align:center"><h4>该一级分类下所属问题</h4></caption>
	  <tr>
	     <th>问题ID</th>
	     <th>问题内容</th>
	     <th>功能</th>	     
	  </tr>
	  <tbody>
		  <c:forEach items="${qs }" var="q">
		     <tr>
		        <td>${q.id }</td> 
		        <td>${q.content }</td>
		        <td><a href="forequestion?qid=${q.id}"><button>查看详情</button></a></td>  
		     </tr>
		  </c:forEach>	 	 
	  </tbody>
	</table>	
</div>