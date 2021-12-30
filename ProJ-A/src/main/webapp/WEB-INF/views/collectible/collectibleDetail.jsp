<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContent.request.contextPath }" />
<c:set var="collectible" value="${collectibleMap.CollectibleVO}" />
<c:set var="imageList" value="${collectibleMap.imageList}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<div id="goods_image">
		<figure>
			<img src="${contextPath}/Art/thumbnails.do?goods_id=${collectible.goods_id}&fileName=${collectible.goods_fileName}">
		</figure>
	</div>
	<div id="detail_table">
		<table>
			<tbody>
				<tr class="dot_line">
					<td class="fixed">작품명</td>
					<td class="active">${collectible.goods_title}</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">등록번호</td>
					<td class="active">${collectible.goods_no}</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">작가</td>
					<td class="active">${collectible.goods_author}</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">제작년도</td>
					<td class="active">${collectible.goods_year}</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">재료 및 기법</td>
					<td class="active">${collectible.goods_stuff}</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">작품규격</td>
					<td class="active">${collectible.goods_standard}</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">내용</td>
					<td class="active">${collectible.goods_note}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>