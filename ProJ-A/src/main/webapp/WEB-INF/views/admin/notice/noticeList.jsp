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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<style>
table.ListTb {
  border-collapse: separate;
  border-spacing: 1px;
  text-align: center;
  line-height: 1.5;
  margin: 0 auto;
}
table.ListTb th {
  width:155px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 3px solid #ccc;
  background:#fff;
}
table.ListTb td {
  width: 155px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  }
a{
text-decoration-line: none;
}
a:hover{
text-decoration-line: underline;
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
<form role="form" method="get">
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
	<table class="ListTb">
		<thead class="w3-container w3-flat-clouds">
		<tr>
			<td>번호</td>
  			<td>제목</td>
			<td>부서명</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="Notice" items="${list}" >
			<tr align="center">
			<td>${Notice.bno}</td>
			<td style=" color:green;">
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
	<c:if test="${isLogOn == true and memberInfo.member_id =='admin' }">
		<a href="${contextPath }/admin/notice/addNewNoticeForm.do"><p align="center">글쓰기</p></a>
	</c:if>
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