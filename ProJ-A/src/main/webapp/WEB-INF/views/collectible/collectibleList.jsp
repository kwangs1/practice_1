<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	border-image: none; 
	width: 188px; 
	height: 250px; 
	text-align: center; 
	float: left; 
	background-repeat: repeat-y;
}
.main_goods .collectible img {
	margin: 0 auto;
}
.main_goods .collectible:hover {
	-webkit-transform:scale(1.2);
    -moz-transform:scale(1.2);
    -ms-transform:scale(1.2);   
    -o-transform:scale(1.2);
    transform:scale(1.2);
    overflow: hidden; 
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
 	 		<a href="javascript:DetailPop()" >
				<img width="121" height="154" 
				     src="${contextPath}/Art/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
			</a>

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

 <script>
	function DetailPop(){
		var url = "${contextPath}/Art/collectible/collectibleDetail.do?goods_id=";
		var name = "DetailPopUp";
		var option = "width= 700 , height= 500 ,top= 100, left= 200, scrollbars=yes"
		window.open(url, name, option);
	}
</script>
</body>
</html>