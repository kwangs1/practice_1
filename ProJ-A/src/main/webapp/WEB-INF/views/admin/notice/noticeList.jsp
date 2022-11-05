<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">

<link rel="stylesheet" href="${contextPath}/resources/noticeList.css">

</head>
<body>
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
 </div>
	     &nbsp; &nbsp; &nbsp; &nbsp;
    	<c:if test="${memberInfo.member_id =='admin' }">
		<a href="${contextPath }/admin/notice/addNewNoticeForm.do">&nbsp;&nbsp;▶작성하기</a>
	</c:if>
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
			<c:when test="${Notice.pin == 0}">ㅇ</c:when>
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
			<br>

<table class="rating">
   	<tr>
   		<th>
   			<strong>이 페이지에서 제공하는 정보에 만족하십니까?</strong>
   			&nbsp; &nbsp; &nbsp; &nbsp;
			평균 : <fmt:formatNumber value="${ratingAvg }" pattern="0.0" />점
			참여 : ${getRating }명
		</th>
	</tr>
	<tr>
		<td>
			<input type="radio"  name="rating" value="5" checked/>	
			<label for="verygood">매우만족</label>
			&nbsp;
			<input type="radio"  name="rating" value="4" />
			<label for="good">만족</label>
			&nbsp;	
			<input type="radio" name="rating" value="3" />
			<label for="soso">보통</label>
			&nbsp;	
			<input  type="radio" name="rating" value="2" />
			<label for="bad">불만</label>
			&nbsp;	
			<input  type="radio" name="rating" value="1" />
			<label for="verybad" >매우불만</label>
			
		<c:if test="${memberInfo.member_id != 'admin' }">
			<input type="submit" class="ratingBtn" value="평점 주기"/>
		</c:if>	
			
	</td>
	</tr>
   </table>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
/* 페이징 */
$(function(){
    $('#searchBtn').click(function() {
      self.location = "noticeList.do" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
    });
  });   
  
//평가하기
$(document).on('click','.ratingBtn', function(){	
	
	var type = ${findRating};
	var member_id = '${memberInfo.member_id}';
	var rating = $('input:radio[name=rating]:checked').val();
	
	if(member_id == ""){
		alert("로그인 후 이용 가능합니다.");
		location.href = '${contextPath}/member/loginForm.do';
		return;
	}else if(type > 0){
		alert("중복 등록 하실 수 없습니다.");
		return;
	}

	var Data = JSON.stringify({
			"member_id": member_id
			,"rating" : rating
	});
	
	var headers = {"Content-Type":"application/json"
		,"X-HTTP-Method-Override":"POST"};
	
	$.ajax({
		url:"${contextPath}/rating/RatingCheck.do"
		,headers : headers
		,data : Data
		,dataType : 'text'
		,type : 'POST'
		,success:function(result){
			window.location.reload();
		}
		,error:function(error){
			console.log("에러:" + error);
		}
	});//end ajax
});//end on

</script>
</body>
</html>