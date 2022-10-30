<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

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
  textarea {
    width: 100%;
    height: 6.25em;
    border: none;
    resize: none;
  }
  /* 버튼 테두리 제거 */
  .LikeBtn{
    padding: 0;
	border: none;
	background: none;
  }
  .LikeBtn img{
  	width : 30px ;
  	height :30px ;
  }
  .addReply textarea{
  	background-color:#FAF0E6;
  	vertical-align: middle;
  	}
  .replyWriteBtn{
  	width: 50px;
  	height: 90px;
	vertical-align: middle;
  	padding: 0;
	border: none;
	background-color: #DCDCDC;
  }	
  .replyWriteBtn:hover{
    cursor: pointer;  
    
  }
 .reply tr td{
 	border:none;
	}
 .replyList{
 	float: left;
 }
 #replyBtn{
 	padding: 0;
	border: none;
	background: none;
 }
</style>
</head>
<body>
	<form name="form1" method="post">
		<h1></h1>
		<input type="hidden" name="member_id" value="${memberInfo.member_id}" />
		<div style="text-align: center">
			<img width="300" height="154"
				src="${contextPath}/thumbnails.do?goods_id=${collectible.goods_id}&fileName=${collectible.goods_fileName}">
		</div>
		<!-- The Modal -->
		<div id="myModal" class="modal">
			<span class="close">&times;</span> <img class="modal-content"
				id="img01">
				
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
					<td>재료 및 기법</td>
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
		<button type="button" class="LikeBtn"  >
			<img class="likeImg" src="${contextPath}/resources/image/like.png"  id="Like" > ${getLike}</button>
			<br><br>
					<a style='cursor: pointer;'
			href='<c:url value='/collectible/collectibleList.do'/>'>▶목록으로</a>
	</form>	
		

	<br />
	<br />
	<form name="replyForm" method="post">
		<input type="hidden" id="rno" name="rno" value="${reply.rno}" />
		 <input type="hidden" id="goods_id" name="goods_id" value="${collectible.goods_id}" /> 
		 <input type="hidden" id="writer" name="writer" value="${memberInfo.member_name}" />
		 
		<div class="addreply" align="center">
			<div class="col-sm-10">
				<textarea style="width:50%" name="content" id="content" placeholder="내용을 입력해주세요."></textarea>
				<input type="button"
					class="replyWriteBtn" value="작성" />
			</div>
		</div>
		
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />

		<div class="replyList">
		<table class="reply">
			<c:choose>
				<c:when test="${empty replyList }">
					<p style="text-align: center;">등록된 댓글이 없습니다.</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="item" items="${replyList}">
						<tr>
							<td>${item.writer}&#10024;
							&nbsp;
							<fmt:formatDate value="${item.regdate}"
									pattern="yyyy-MM-dd" />
						&nbsp;		
						<c:if test="${item.writer == memberInfo.member_name }">
								
									<button type="button" class="update_reply_btn" id="replyBtn"
										data-rno='${item.rno}'>▶수정</button>
									<button type="button"  id="replyBtn"
										onClick="fn_remove_reply('${contextPath}/reply/removeReply.do?rno=${item.rno }&goods_id=${collectible.goods_id }')">▶삭제</button>
								
						</c:if>
									<br>&nbsp; &#9997; ${item.content}						
							</td>
						</tr>

					</c:forEach>
				</c:otherwise>
			</c:choose>
	</table>
</div>
	</form>



	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	//좋아요
	var likeval = ${findLike};


		let goods_id = ${collectible.goods_id};
		let member_id = '${memberInfo.member_id}';
		let like_type = 1;
		
		
		if(likeval > 0){
			$('.likeImg').attr('src','${contextPath}/resources/image/like2.png')
			$('.LikeBtn').click(function(){
				$.ajax({
					type : 'post'
				   ,url : '${contextPath}/like/likeDown.do'
				   ,contentType: 'application/json'
				   ,data : JSON.stringify({
					   "goods_id" : goods_id,
					   "member_id" :member_id,
					   "like_type" : like_type
				   }),
				 success : function(data){
					 location.reload();
				 	}
				});//end ajax
			})
		}else{
			$('.LikeBtn').click(function() {
				if(member_id == ""){
					alert("로그인 후 이용 가능합니다.");
					return;
				}
				$.ajax({
					type :'post',
					url : '${contextPath}/like/likeUp.do',
					contentType: 'application/json',
					data : JSON.stringify(
							{
								   "goods_id" : goods_id,
								   "member_id" :member_id,
								   "like_type" : like_type
							}		
						),
					success : function(data) {
						location.reload();
					}
				})//end ajax
			})	
	}

		//댓글 작성

		$(document).on("click", ".replyWriteBtn",function(){
			var Content = $('#content').val();
			var Writer = $('#writer').val();
			var goods_id = $('#goods_id').val();
			
					if(Writer == ""){
						alert("로그인 후 댓글 작성이 가능하십니다.!");
					}			
					if(Writer != "" && Content == ""){
						alert("내용을 입력해주세요.");
					}

					
					var paramData = JSON.stringify(
							{"content": Content
							,"writer" : Writer
							,"goods_id" : goods_id
					});
					var headers = {"Content-Type":"application/json"
						,"X-HTTP-Method-Override":"POST"};
					
					$.ajax({
						url:"${contextPath}/reply/replyWrite.do"
						,headers : headers
						,data : paramData
						,type : 'POST'
						,dataType : 'text'
						,success:function(result){
							window.location.reload();
						}
						,error:function(error){
							console.log("에러:" + error);
							console.log(paramData);
						}
					});//end ajax
					
			});

		//댓글 수정 팝업
		$(document).on('click', ' .update_reply_btn', function(e){
			e.preventDefault();
			
			var rno = $(this).attr('data-rno');
			var goods_id = $('#goods_id').val();
			var name = $('#writer').val();
			
			let popUrl = "${contextPath}/collectible/getUpdateReply.do?rno=" + rno + "&goods_id=" + goods_id + "&name=" + name;
			let popOption = "width = 490px, height=490px, scrollbars=yes" 

				window.open(popUrl,"리뷰 수정",popOption);
		});


		//댓글 삭제
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
	</script>
</body>
</html>