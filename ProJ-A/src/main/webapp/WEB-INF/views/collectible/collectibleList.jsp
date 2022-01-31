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
.page_wrap {
	width:80%;
	margin:0 auto;
	text-align:center;
	font-size:0;
	position : absolute;
	bottom : 0;
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
		 <div class="search" align="center">
    <select name="searchType">
      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
    </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>

    <button id="searchBtn" type="button">검색</button>

  </div>
  <br/><br/>
	<div class="gallery">
		<c:choose>
				<c:when test="${empty collectible }">

					<p style="text-align:center;">조회된 상품이 없습니다.</p>

				</c:when>
				<c:otherwise>
		<c:forEach var="item" items="${collectible}">
			<div class="collectible">
			<h1>　</h1>
					<a href='<c:url value='/collectible/collectibleDetail.do?goods_id=${item.goods_id}
										&page=${scri.page }
	      	 							&perPageNum=${scri.perPageNum }
	      	 							&searchType=${scri.searchType}
	      	 							&keyword=${scri.keyword}'/>'>${Notice.title }
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
				<c:if test="${pageMaker.prev }">
					<a  href='<c:url value="/collectible/collectibleList.do${pageMaker.makeSearch(pageMaker.startPage - 1) }"/>'>
					<i class="fa fa-chevron-left"></i>◀</a>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
					<a href='<c:url value="/collectible/collectibleList.do${pageMaker.makeSearch(pageNum)}"/>'><i
							class="fa">${pageNum }</i></a>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
					<a href='<c:url value="/collectible/collectibleList.do${pageMaker.makeSearch(pageMaker.endPage + 1)}"/>'>
					<i class="fa fa-chevron-right">▶</i></a>
				</c:if>
			</div>
			</div>
	</div>
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
    $('#searchBtn').click(function() {
      self.location = "collectibleList.do" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
    });
  });   
</script>

</body>
</html>