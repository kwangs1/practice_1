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

<style>
  textarea {
    width: 100%;
    height: 6.25em;
    border: none;
    resize: none;
  }
</style>
</head>
<body>

	<br />
	<br />
	<form name="updateForm" method="post">
		<table>
			<tbody>
				<tr>
					<td><input type="hidden" name="goods_id"
						value="${collectible.goods_id}" /> <input type="hidden" id="rno"
						name="rno" value="${reply.rno}" /> 작성자 &#124; <input type=text
						value="${memberInfo.member_name}" disabled /></td>
				<tr>
					<td>내용 &#124; <textarea id="content" name="content" placeholder="내용을 입력해주세요."></textarea>
						<button type="submit" class="update_btn">저장</button>
						<button type="submit" class="cancel_btn">취소</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		//댓글 수정
		$(".update_btn").on("click", function(e) {

			var rno = '${reply.rno}';
			var goods_id = '${collectible.goods_id}';
			var member_id = '${memberInfo.member_name}';
			var content = $('#content').val();

			var paramData = JSON.stringify({
				"goods_id" : goods_id,
				"rno" : rno,
				"member_id" : member_id,
				"content" : content
			});

			var headers = {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			};

			$.ajax({
				headers : headers,
				data : paramData,
				type : 'POST',
				url : '${contextPath}/reply/updateReply.do',
				success : function(result) {
					opener.parent.location.reload();
					window.close();
				},
				error : function(error) {
					console.log("에러:" + error);
				}
			});

		});

		$(".cancel_btn").on("click", function(e) {
			window.close();
		});
	</script>
</body>
</html>