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
	height: 300px; 
	text-align: center; 
	float: left; 
	background-repeat: repeat-y;
}
.desc {
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
.gallery{
	width:80%;
	margin:0 auto;
}
.pageNum{
	position:absolute;
	bottom: 160px;
	left:45%;
}
.page_wrap {
	text-align:center;
	font-size:0;
 }
.page_nation {
	display:inline-block;
}
.page_nation .none {
	display:none;
}
.page_nation a {
	display:block;
	margin:0 3px;
	float:left;
	border:1px solid #e6e6e6;
	width:28px;
	height:28px;
	line-height:28px;
	text-align:center;
	background-color:#fff;
	font-size:13px;
	color:#999999;
	text-decoration:none;
}
</style>
</head>
<body>
<h1>　</h1>
	<div class="gallery">
		<c:choose>
				<c:when test="${empty collectible }">

					<p style="text-align:center;">조회된 상품이 없습니다.</p>

				</c:when>
				<c:otherwise>
		<c:forEach var="item" items="${collectible}">
			<div class="collectible">
			<h1>　</h1>
				<a href="${contextPath}/collectible/collectibleDetail.do?goods_id=${item.goods_id }">
					<img class="link" src="${contextPath}/resources/image/1px.gif"></a> 
					
					<img width="180" height="150"
					src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">

				<div class="color_black">${item.goods_title }</div>
				<div class="desc">${item.goods_author}</div>
			</div>
		</c:forEach>
		</c:otherwise>
		</c:choose>
	<div class="page_wrap">
  	<div class="page_nation">
	<c:forEach var="page" begin="1" end="10" step="1">
		<c:if test="${section >1 && page==1 }">
			<a
				href="${contextPath}/collectible/collectibleList.do?chapter=${section-1}&pageNum=${(section-1)*10 +1 }">&nbsp;
				&nbsp;</a>
		</c:if>
		<a
			href="${contextPath}/collectible/collectibleList.do?chapter=${section}&pageNum=${page}">${(section-1)*10 +page }
		</a>
		<c:if test="${page ==10 }">
			<a
				href="${contextPath}/collectible/collectibleList.do?chapter=${section+1}&pageNum=${section*10+1}">&nbsp;
				▶</a>
		</c:if>
	</c:forEach>
</div>
</div>
	</div>
	


</body>
</html>