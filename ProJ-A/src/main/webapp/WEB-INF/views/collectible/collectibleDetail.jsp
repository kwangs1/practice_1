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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link rel="stylesheet" href="${contextPath}/resources/board.css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<form name="form1" method="post">
<h1>　</h1>
			<input type="hidden" name="member_id" value="${memberInfo.member_id}" />								
	<div style="text-align:center" >
			<img width="180" height="154" id="myImg"
				  src="${contextPath}/thumbnails.do?goods_id=${collectible.goods_id}&fileName=${collectible.goods_fileName}">
				 <p style="color:silver;">이미지 클릭 시 원본 이미지를 보실 수 있습니다.</p>
	</div>
		<!-- The Modal -->
		<div id="myModal" class="modal">
			<span class="close">&times;</span> 
			<img class="modal-content" id="img01">
			<div id="caption"></div>
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
		</table>
		</form>

<br/><br/>
 <form name="replyForm" method="post" > 
    <input type="hidden" id="rno" name="rno" value="${reply.rno}"/>
 	<input type="hidden" id="goods_id" name="goods_id" value="${collectible.goods_id}" />
    <input type="hidden" id="writer" name="writer" value="${memberInfo.member_name}"/>

  <div class="addreply">
   			<div class="col-sm-10">						
					<input type="text" name="content" id="content"  placeholder="내용을 입력해주세요." />
 					 <input type="button" class="replyWriteBtn" style='cursor:pointer;' value="작성"/>
			</div>		
  </div>

	<a style='cursor:pointer;'
	      	 href='<c:url value='/collectible/collectibleList.do'/>'>▶목록으로</a>
<table>
	 <c:choose>
			<c:when test="${empty replyList }">
				<p style="text-align:center;">등록된 댓글이 없습니다.</p>
			</c:when>
		<c:otherwise>
		<c:forEach var="item" items="${replyList}">
		<tr>
			<td>작성자&#124; ${item.writer}</td>
        	<td>작성 날짜 &#124; <fmt:formatDate value="${item.regdate}" pattern="yyyy-MM-dd" />
        	</td>
        </tr>
        	<tr>
			<td>내용 &#124; ${item.content}  	  		   
   		</td>
			</tr>
		<c:if test="${item.writer == memberInfo.member_name }">
			<tr>
				<td>
				 <button type="button" class="update_reply_btn">수정</button> 
   				<button type="button"style='cursor:pointer;' 
	      	onClick="fn_remove_reply('${contextPath}/reply/removeReply.do?rno=${item.rno }&goods_id=${collectible.goods_id }')">삭제</button>	
	      		</td>		
			</tr>
		</c:if>
		</c:forEach>
		</c:otherwise>
		</c:choose>		


		</table>
  </form>



<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script  src="${contextPath}/resources/board.js"></script>

</body>
</html>