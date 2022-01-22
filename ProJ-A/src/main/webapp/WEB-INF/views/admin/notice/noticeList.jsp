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
</style>

</head>
<body>
<h1>　</h1>
	<table class="con1_search" align="center">
		<tr>
			<td>검색</td>
			<td colspan="2" style="width: 50px;"><input type="date"
				id='searchStartDate' style="width: 100%;" /></td>
			<td>~</td>
			<td><input type="date" id='searchEndDate' style="width: 100%;" /></td>
			<td><button id="view_button" onclick="searchData()" style="cursor:pointer;">
			<img src="${contextPath}/resources/image/search.png"></button></td>
		</tr>
	</table>
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
		<c:forEach var="Notice" items="${NoticeList}" >
			<tr align="center">
			<td>${Notice.bno}</td>
			<td style=" color:green;"><a href="${contextPath}/admin/notice/NoticeDetail.do?bno=${Notice.bno}">${Notice.title}</a></td>
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


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

/* 검색부 date onChange 함수 설정 */
	var startDate;
   	var endDate;
   	
   	$('#searchStartDate').change(function (){
           var date = $('#searchStartDate').val();
           startDate = date;
       });
   	$('#searchEndDate').change(function (){
           var date = $('#searchEndDate').val();
           endDate = date;
       });
   	

	/* 조회버튼 클릭시 기능 구현 */
	view_button.onclick = function() {
		if (startDate == null && endDate == null) {
			alert("조회할 날짜를 선택해주세요!");
		} else if (startDate == null) {
			alert("시작일을 입력해주세요!");
		}else if(endDate == null){
			alert("종료일을 입력해주세요!");
		}else if (startDate > endDate) {
			alert("종료일은 시작일보다 커야합니다!");
		} else {

			const URLSearch = new URLSearchParams(location.search);
			URLSearch.set('startDate', startDate);
			URLSearch.set('endDate', endDate);
			const newParam = URLSearch.toString();

			window.open(location.pathname + '?' + newParam, '_self');
		}
	}
</script>
</body>
</html>