<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContent.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.main_goods {
	width: auto; 
	padding-top: 7px; 
	font-size: 0.75em;
}
.main_goods .collectible {
	background-position: right; 
	border: 2px solid rgb(255, 255, 255); 
	border-image: none; width: 188px; 
	height: 250px; text-align: center; 
	float: left; 
	background-repeat: repeat-y;
}
.main_goods .collectible img {
	margin: 5px 0px 0px;
}
.main_goods .collectible:hover {
	border: 2px solid rgb(255, 0, 0); 
	border-image: none; 
	background-image: none;
}
.main_goods .collectible .title {
	margin: 0px; 
	padding: 2px 0px;
}
.main_goods .collectible .author {
	margin: 0px; 
	padding: 2px 0px;
}
.main_goods .collectible .title {
	font-weight: bold;
}
</style>
</head>
<body>
<div class="main_goods">
   <c:set  var="goods_count" value="0" />
	<c:forEach var="item" items="${collectibleMap.collectible }">
	   <c:set  var="goods_count" value="${goods_count+1 }" />
		<div class="collectible">
<%-- 			<a href="${contextPath}/collectilbe/collectibleList.do?goods_id=${item.goods_id }">
			<img class="link"  src="${contextPath}/resources/image/1px.gif"> 
			</a> --%>
				<img width="121" height="154" 
				     src="${contextPath}/Art/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">

			<div class="title">${item.goods_title }</div>
			<div class="author"> ${item.goods_author}</div>
		</div>
	   <c:if test="${goods_count==15   }">
         <div class="book">
           <font size=20> <a href="#">more</a></font>
         </div>
     </c:if>
  </c:forEach>
</div>
</body>
</html>