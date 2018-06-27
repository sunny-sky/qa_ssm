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
	<span>亲爱的用户：</span>
	<span><b>${user.name}</b>，您好！</span>
</div>

<div>
	<table class="table table-striped table-bordered table-hover  table-condensed" style="width:70%;margin: 0 auto;text-align: center;"  >
	  <caption style="text-align:center"><h4>用户所提问题</h4></caption>
	  <tr>
	     <th>问题ID</th>
	     <th>问题内容</th>
	     <th>查看详情</th>
	  </tr>
	  <tbody>
		  <c:forEach items="${qs}" var="q">
			 <tr>			 
			    <td>${q.id }</td> 
			    <td>${q.content }</td>  
			    <td><a href="forequestion?qid=${q.id}"><button>查看详情</button></a></td>  			  
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
	  <caption style="text-align:center"><h4>用户的回答</h4></caption>
	  <tr>
	     <th>回答ID</th>
	     <th>回答内容</th>
	     <th>功能</th>	     
	  </tr>
	  <tbody>
		  <c:forEach items="${as }" var="a">
		     <tr>
		        <td>${a.id }</td> 
		        <td>${a.content }</td>
		        <td><a href="forequestion?qid=${a.qid}"><button>查看详情</button></a></td>  
		     </tr>
		  </c:forEach>	 	 
	  </tbody>
	</table>	
</div>
<div>
	<table class="table table-striped table-bordered table-hover  table-condensed" style="width:50%;margin: 0 auto;text-align: center;">
	  <caption style="text-align:center"><h4>用户收藏问题</h4></caption>
	  <tr>
	     <th>收藏问题ID</th>
	     <th>问题内容</th>
	     <th>功能</th>	     
	  </tr>
	  <tbody>
		  <c:forEach items="${cps }" var="cp">
		     <tr>
		        <td>${cp.question.id }</td> 
		        <td>${cp.question.content }</td>
		        <td><a href="forequestion?qid=${cp.question.id}"><button>查看详情</button></a></td>  
		     </tr>
		  </c:forEach>	 	 
	  </tbody>
	</table>	
</div>
<div>
	<table class="table table-striped table-bordered table-hover  table-condensed" style="width:50%;margin: 0 auto;text-align: center;">
	  <caption style="text-align:center"><h4>用户点赞的回答</h4></caption>
	  <tr>
	     <th>回答ID</th>
	     <th>回答内容</th>
	     <th>对应问题</th>
	     <th>功能</th>	     
	  </tr>
	  <tbody>
		  <c:forEach items="${uls }" var="ul">
		     <tr>
		        <td>${ul.answer.id }</td> 
		        <td>${ul.answer.content }</td>
		        <td>${ul.answer.qid }</td>
		        <td><a href="forequestion?qid=${ul.answer.qid}"><button>查看详情</button></a></td>  
		     </tr>
		  </c:forEach>	 	 
	  </tbody>
	</table>	
</div>