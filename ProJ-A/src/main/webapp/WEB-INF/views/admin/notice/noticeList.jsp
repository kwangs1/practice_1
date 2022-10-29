<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<style>
.container {
	width: 1200px;
}

table {
	border: 0;
	margin-left:auto; 
    margin-right:auto;
}

table caption {
	display: none;
}

.bbsList {
	display: table;
	clear: both;
	width: 1200px;
	border-collapse: collapse;
}

.bbsList th {
	border-color: #333333;
	background: #fcfcfc;
	padding: 10px 0 10px 0;
	text-align: center;
	border-top-width: 2px;
	border-bottom-width: 1px;
	border-top-style: solid;
	border-bottom-style: solid;
	font-weight: 400;
}

.bbsList .body td {
	text-align: center;
	padding: 5px 9px 5px 9px;
	border-bottom-color: #eeeeee;
	border-bottom-width: 1px;
	border-bottom-style: solid;
}

a {
	text-decoration-line: none;
	color:black;
}

a:hover {
	text-decoration-line: underline;
	color:black;
}

.page_wrap {
	text-align: center;
	font-size: 0;
}

.page_nation {
	display: inline-block;
}

.page_nation .none {
	display: none;
}

.page_nation a {
	display: block;
	margin: 0 3px;
	float: left;
	border: 1px solid #e6e6e6;
	width: 28px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	background-color: #fff;
	font-size: 13px;
	color: #999999;
	text-decoration: none;
}
button{
    padding: 0;
	border: none;
	background: none;
}
</style>

</head>
<body>
<form role="form" method="get">
<h1>　</h1>
<div class="search" align="center">
    <select name="searchType">
      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
    </select>

    <input type="text" class="tbox" title="검색어를 입력해주세요" placeholder="검색어를 입력해주세요" 
    	name="keyword" id="keywordInput" value="${scri.keyword}"/>

    <button id="searchBtn" type="button">검색</button>


	     &nbsp; &nbsp; &nbsp; &nbsp;
    	<c:if test="${isLogOn == true and memberInfo.member_id =='admin' }">
		<a href="${contextPath }/admin/notice/addNewNoticeForm.do"> ▶작성하기</a>
	</c:if>
 </div>
 <br>

  <div id="container" >
	<table class="bbsList">
		<thead class="head">
		<tr>
			<th></th>
			<th>번호</th>
  			<th>제목</th>
			<th>부서명</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		</thead>
		<tbody class="body">
		<c:forEach var="Notice" items="${list}" >
			<tr align="center">
		<td>
		<c:choose>
			<c:when test="${Notice.pin == 0}"> ● </c:when>
			<c:when test="${Notice.pin == 1}">
		<img src="${contextPath}/resources/image/notice.png" alt="공지사항" width="40px" height="40px">
			</c:when>
		</c:choose>
		</td>
			<td>${Notice.bno}</td>
			<td>
			<a href='<c:url value='/admin/notice/NoticeDetail.do?bno=${Notice.bno }
										&page=${scri.page }
	      	 							&perPageNum=${scri.perPageNum }
	      	 							&searchType=${scri.searchType}
	      	 							&keyword=${scri.keyword}'/>'>${Notice.title }</a>
			</td>
			<td>${Notice.department}</td>
			<td>${Notice.regdate}</td>
			<td>${Notice.hit}</td>
			</tr>	
		</c:forEach>
		</tbody>
	</table>
</div>

			<div class="page_wrap">
  				<div class="page_nation">
				<c:if test="${pageMaker.prev }">
					<a  href='<c:url value="/admin/notice/noticeList.do${pageMaker.makeSearch(pageMaker.startPage - 1) }"/>'>
					<i class="fa fa-chevron-left"></i>◀</a>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
					<a href='<c:url value="/admin/notice/noticeList.do${pageMaker.makeSearch(pageNum)}"/>'><i
							class="fa">${pageNum }</i></a>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
					<a href='<c:url value="/admin/notice/noticeList.do${pageMaker.makeSearch(pageMaker.endPage + 1)}"/>'>
					<i class="fa fa-chevron-right">▶</i></a>
				</c:if>
			</div>
			</div>
			
</form>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
    $('#searchBtn').click(function() {
      self.location = "noticeList.do" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
    });
  });   
</script>
</body>
</html>