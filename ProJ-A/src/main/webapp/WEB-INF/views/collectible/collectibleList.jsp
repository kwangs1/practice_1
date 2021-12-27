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
.main_goods .goods {
	background-position: right; 
	border: 2px solid rgb(255, 255, 255); 
	border-image: none; width: 188px; 
	height: 250px; text-align: center; 
	float: left; 
	background-image: url("../imgs/vline_grey.gif"); 
	background-repeat: repeat-y;
}
.main_goods .goods img {
	margin: 5px 0px 0px;
}
.main_goods .goods:hover {
	border: 2px solid rgb(255, 0, 0); 
	border-image: none; 
	background-image: none;
}
.main_goods .goods .title {
	margin: 0px; 
	padding: 2px 0px;
}
.main_goods .goods .author {
	margin: 0px; 
	padding: 2px 0px;
}
.main_goods .book .title {
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="main_goods">
		<c:set var="goods_count" value="0" />
		<c:forEach var="item" items="${goodsMap.collectible }">
			<div class="goods">
				<a href="#">
					<img class="link" src ="${contextPath}/resources/image/1px.gif" >
				</a>
				
				<img width="121" height="154" src="${contextPath}/thumbnails.do?goods_id= ${item.goods_id}& fileName= ${item.goods_file1Name}">
				<div class="title">${item.goods_title }</div>
				<div class="author">
					<fmt:formatNumber  value="${item.goods_author}" type="number" var="goods_price" />
		          	${goods_author}
				</div>
			</div>
			<c:if test="${goods_count==15}">
         	 <div class="collectible">
           		<font size=20> <a href="#">more</a></font>
        	 </div>
        	</c:if>
		</c:forEach>
	</div>
</body>
</html>