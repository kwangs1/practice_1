<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<style>
.gallery .collectible{
	background-position: right; 
	border-image: none; 
	width: 300px; 
	height: 250px; 
	text-align: center; 
	float: left; 
	background-repeat: repeat-y;
}
div.desc {
	padding: 15px;
	text-align: center;
}

.gallery .collectible:hover {
	-webkit-transform: scale(1.2);
	-moz-transform: scale(1.2);
	-ms-transform: scale(1.2);
	-o-transform: scale(1.2);
	transform: scale(1.2);
	overflow: hidden;
}
.link {
	width: 188px;
	height: 230px;
	display: block;
	position: absolute;
	z-index: 2;
}
 .color_black{
 	color:#000; 
 	font-size:1em; 
 	font-weight:700;
 	text-align:center;
 }
</style>
</head>
<body>
	<div class="gallery">
		<c:forEach var="item" items="${collectibleList}">
			<div class="collectible">
			<h1>　</h1>
				<a
					href="${contextPath}/collectible/collectibleDetail.do?goods_id=${item.goods_id }">
					<img class="link" src="${contextPath}/resources/image/1px.gif">
				</a> <img width="180" height="150"
					src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">

				<div class="color_black">${item.goods_title }</div>
				<div class="desc">${item.goods_author}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>