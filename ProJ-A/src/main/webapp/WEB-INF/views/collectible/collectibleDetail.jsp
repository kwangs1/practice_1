<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
*{
margin:0 auto;
}
table td {
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #fff;
  }
table tr td input{
	border:none;
}
</style>
</head>
<body>
<form method="get"  action="${contextPath}/collectible/collectibleDetail.do">
<h1>　</h1>
	<div style="text-align:center">
			<img width="180" height="154"
				  src="${contextPath}/thumbnails.do?goods_id=${collectible.goods_id}&fileName=${collectible.goods_fileName}">
	</div>
		<table>
			<tbody>
				
				
				<tr>
					<td>제목</td>
					<td>${collectible.goods_title}</td>
				</tr>
				<tr>
					<td>등록번호</td>
					<td>${collectible.goods_no}</td>
				</tr>
				<tr>
					<td>작가</td>
					<td>${collectible.goods_author}</td>
				</tr>
				<tr>
					<td>제작년도</td>
					<td>${collectible.goods_year}</td>
				</tr>
				<tr>
					<td>재료   및 기법</td>
					<td>${collectible.goods_stuff}</td>
				</tr>
				<tr>
					<td>작품규격</td>
					<td>${collectible.goods_standard}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>${collectible.goods_note}</td>
				</tr>
			</tbody>
		</table>
</form>
</body>
</html>