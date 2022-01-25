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
.page_nation .arrow {
	border:1px solid #ccc;
}
.page_nation .pprev {
	background:#f8f8f8 url('image/page_pprev.png') no-repeat center center;
	margin-left:0;
}
.page_nation .prev {
	background:#f8f8f8 url('image/page_prev.png') no-repeat center center;
	margin-right:7px;
}
.page_nation .next {
	background:#f8f8f8 url('image/page_next.png') no-repeat center center;
	margin-left:7px;
}
.page_nation .nnext {
	background:#f8f8f8 url('image/page_nnext.png') no-repeat center center;
	margin-right:0;
}
.page_nation a.active {
	background-color:#42454c;
	color:#fff;
	border:1px solid #42454c;
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
		<c:forEach var="Notice" items="${list}" >
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
			<div class="page_wrap">
  				<div class="page_nation">
				<c:if test="${pageMaker.prev }">
					<a class="arrow next" href='<c:url value="/admin/notice/noticeList.do?page=${pageMaker.startPage-1 }"/>'></a>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="pageNum">
					<a href='<c:url value="/admin/notice/noticeList.do?page=${pageNum }"/>'><i
							class="fa">${pageNum }</i></a>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
					<a class="arrow nnext" href='<c:url value="/admin/notice/noticeList.do?page=${pageMaker.endPage+1 }"/>'></a>
				</c:if>
			</div>
			</div>


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