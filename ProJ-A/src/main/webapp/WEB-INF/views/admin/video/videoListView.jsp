<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
*{
magin:0 auto;
padding:0 auto;
}
.video .list{
	background-position: right; 
	border-image: none; 
	width: 300px; 
	height: 300px; 
	text-align: center; 
	float: left; 
	background-repeat: repeat-y;
}
.video .list:hover {
	-webkit-transform: scale(1.2);
	-moz-transform: scale(1.2);
	-ms-transform: scale(1.2);
	-o-transform: scale(1.2);
	transform: scale(1.2);
	overflow: hidden;
}
 .color_black{
 	color:#000; 
 	font-size:1em; 
 	font-weight:700;
 	text-align:center;
 }
.video{
	width:80%;
	margin:0 auto;
	padding-top : 10px;
	overflow : hidden;
}
.page_wrap {
	width:80%;
	margin:0 auto;
	text-align:center;
	font-size:0;
	position : absolute;
	bottom : 0px;
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
	border:1px solid #999;
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
      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
    </select>

        <input type="text" class="tbox" title="검색어를 입력해주세요" placeholder="검색어를 입력해주세요" 
    	name="keyword" id="keywordInput" value="${scri.keyword}"/>
    	
    <button id="searchBtn" type="button">검색</button>

  </div>
  <br/><br/>
	<div class="video">
		<c:forEach var="item" items="${videolist}">
		<c:set var="key" value="${fn:substring(item.v_addr,17,100) }" />
		<c:choose>
				<c:when test="${empty item.v_addr}">
					<p style="text-align:center;">조회된 상품이 없습니다.</p>
				</c:when>
				<c:otherwise>
			<div class="list">
			<h1>　</h1>
					<a href='<c:url value='/admin/video/adminVideoDetail.do?vno=${item.vno}
										&page=${scri.page }
	      	 							&perPageNum=${scri.perPageNum }
	      	 							&searchType=${scri.searchType}
	      	 							&keyword=${scri.keyword}'/>'>
					<img src="https://img.youtube.com/vi/${key}/mqdefault.jpg" alt="유튜브 동영상 이미지입니다." width="180" height="150"></a> 

				<div class="color_black">${item.v_title }</div>
			</div>
		</c:otherwise>
		</c:choose>
		</c:forEach>
<div class="page_wrap">
  				<div class="page_nation">
				<c:if test="${pageMaker.prev }">
					<a  href='<c:url value="/admin/video/videoListView.do${pageMaker.makeSearch(pageMaker.startPage - 1) }"/>'>
					<i class="fa fa-chevron-left"></i>◀</a>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
					<a href='<c:url value="/admin/video/videoListView.do${pageMaker.makeSearch(pageNum)}"/>'><i
							class="fa">${pageNum }</i></a>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
					<a href='<c:url value="/admin/video/videoListView.do${pageMaker.makeSearch(pageMaker.endPage + 1)}"/>'>
					<i class="fa fa-chevron-right">▶</i></a>
				</c:if>
			</div>
			</div>
	</div>
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
    $('#searchBtn').click(function() {
      self.location = "videoListView.do" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
    });
  });   
</script>

</body>
</html>