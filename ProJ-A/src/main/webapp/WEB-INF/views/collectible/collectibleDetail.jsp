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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
#myImg {
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
}

#myImg:hover {opacity: 0.7;}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
  margin: auto;
  display: block;
  width: 80%;
  max-width: 700px;
}

/* Caption of Modal Image */
#caption {
  margin: auto;
  display: block;
  width: 80%;
  max-width: 700px;
  text-align: center;
  color: #ccc;
  padding: 10px 0;
  height: 150px;
}

/* Add Animation */
.modal-content, #caption {  
  -webkit-animation-name: zoom;
  -webkit-animation-duration: 0.6s;
  animation-name: zoom;
  animation-duration: 0.6s;
}

@-webkit-keyframes zoom {
  from {-webkit-transform:scale(0)} 
  to {-webkit-transform:scale(1)}
}

@keyframes zoom {
  from {transform:scale(0)} 
  to {transform:scale(1)}
}

/* The Close Button */
.close {
  position: absolute;
  top: 15px;
  right: 35px;
  color: #f1f1f1;
  font-size: 40px;
  font-weight: bold;
  transition: 0.3s;
}

.close:hover,
.close:focus {
  color: #bbb;
  text-decoration: none;
  cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px){
  .modal-content {
    width: 100%;
  }
}
.addreply{
	text-align:center;
}
.rating{
text-align:center;
}
.btn-like {
  color: transparent;
  text-shadow: 0 0 2px rgba(255,255,255,.7), 0 0 0 #000;
}
.btn-like:hover {
  text-shadow: 0 0 0 #ea0;
}
.btn-like.done {
  color: inherit;
  text-shadow: 0;
}
.btn-like.done:hover {
  color: transparent;
  text-shadow: 0 0 0 #777;
}
</style>
</head>
<body>
<form name="form1" method="post">
<h1>　</h1>
			<input type="hidden" name="member_id" value="${memberInfo.member_id}" />								
	<div style="text-align:center">
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

	<br><br>
<form name="ratingForm" method="post">
	<input type="hidden" id="member_id" name="member_id" value="${memberInfo.member_id}"readonly/>
	<input type="hidden" id="goods_id" name="goods_id" value="${collectible.goods_id}"readonly/>
<table class="rating">

<tr>
	<td>
		<label><input type="checkbox" class='checkbox-test' name="good" id="good" value="1" checked>만족</label>	
		<label><input type="checkbox" class='checkbox-test' name="usually" id="usually" value="1">보통</label>
		<label><input type="checkbox" class='checkbox-test' name="bad"  id="bad" value="1">불만족</label>
	<c:if test = "${empty rating and not empty memberInfo.member_id}">
		<button type ="button" class="btn_goods" data-id="${collectible.goods_id}" >평가하기</button>
	</c:if>
	<c:if test = "${not empty rating }">
		<button type ="button" data-id="${collectible.goods_id}" >수정하기</button>
	</c:if>
	</td>
</tr>
</table>
</form>

<br/><br/>
 <form name="replyForm" method="post" > 
 	<input type="hidden" name="goods_id" value="${collectible.goods_id}" />

  <div class="addreply">
    <label for="writer">댓글 작성자</label><input type="text" id="writer" name="writer" value="${memberInfo.member_name}"readonly/>
    <br/>
    <label for="content">댓글 내용</label><input type="text" id="content" name="content" />
 	 <button type="button" class="replyWriteBtn" style='cursor:pointer;'>작성</button> 
  </div>
	<a style='cursor:pointer;'
	      	 href='<c:url value='/collectible/collectibleList.do'/>'>목록으로</a>
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
				 <button type="button" class="replyUpdateBtn" data-rno="${item.rno}">수정</button> 
   				<button type="button"style='cursor:pointer;' 
	      	onClick="fn_remove_reply('${contextPath}/collectible/removeReply.do?rno=${item.rno }&goods_id=${collectible.goods_id }')">삭제</button>	
	      		</td>		
			</tr>
		</c:if>
		</c:forEach>
		</c:otherwise>
		</c:choose>		


		</table>

</form>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById("myImg");
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
img.onclick = function(){
  modal.style.display = "block";
  modalImg.src = this.src;
  captionText.innerHTML = this.alt;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none";
}

$(".replyWriteBtn").on("click", function(){
	  var formObj = $("form[name='replyForm']");
	  var isLogOn = "${memberInfo.member_id}"
			if(isLogOn == ""){
				alert("로그인 후 댓글 작성이 가능하십니다.!");
			window.location.href="${contextPath}/member/loginForm.do"; 
			}else if(replyForm.content.value==""){
				alert("내용을 입력하세요.");
				return replyForm.content.focus();		
			}
			else{
	  			formObj.attr("action", "${contextPath}/collectible/replyWrite.do");
	  			formObj.submit();
			}
	});


$(".replyUpdateBtn").on("click", function(){
	location.href = "${contextPath}/collectible/modifyReplyForm.do?goods_id=${collectible.goods_id}"
					+ "&rno="+$(this).attr("data-rno");
});

function fn_remove_reply(url,rno){
	 var form = document.createElement("form");
	 form.setAttribute("method", "post");
	 form.setAttribute("action", url);
    var RnoInput = document.createElement("input");
    RnoInput.setAttribute("type","hidden");
    RnoInput.setAttribute("name","rno");
    RnoInput.setAttribute("value", rno);
	 
    form.appendChild(RnoInput);
    document.body.appendChild(form);
    form.submit();

}
$(".btn_goods").on("click", function(){
	  var formObj = $("form[name='ratingForm']");
	  var isLogOn = "${memberInfo.member_id}";

	  
			if(isLogOn == ""){
				alert("로그인 후 평가 가능하십니다.!");
			window.location.href="${contextPath}/member/loginForm.do"; 
			}else if(isLogOn == 'admin'){
				alert("관리자는 평가할 수 없습니다.");	
			}
			else{
				alert("평가 완료!");
	  			formObj.attr("action", "${contextPath}/rating/ratingWrite.do");
	  			formObj.submit();
			}
	});
	
$(".checkbox-test").click(function () {
	  let chekObj = document.getElementsByClassName("checkbox-test");
	  let lenth = chekObj.length;
	  let checked = 0;
	  let checkboxTest;
	  
	  for (i = 0; i < lenth; i++) {
	    if (chekObj[i].checked === true) {
	      checked += 1;
	      checkboxTest = chekObj[i].getAttribute("id");
	      console.log(checkboxTest);
	  		}
	    }
	  if (checked >= 2){
	    alert("체크 해제 후 한 가지만 선택해 주세요");
	    return false;
	  }
	});
	
	//name 에 있는 value 값 가져오기위해 선언
$("input:checkbox[name=good]:checked").each(function(){
	var checkVal = $(this).val();
})
$("input:checkbox[name=usually]:checked").each(function(){
	var checkVal = $(this).val();
})
$("input:checkbox[name=bad]:checked").each(function(){
	var checkVal = $(this).val();
})

</script>
</body>
</html>