<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<style>

</style>
</head>
<body>
<h1> </h1>
<br><br>
	<form method="get">	
	<h1 align="center">회원 ID/PW 찾기</h1>
	<br>
	<div align="center">
		이름 &#124;
		<input name="member_name" id="member_name" type="text" size="20" />
	</div>
	<br>
	
	<div align="center">
		이메일 &#124;<input size="10px" type="text" name="email1" id="email1" class="mail_input"/> 
			@ <input size="10px" type="text"name="email2" id="email2" class="mail_input"/> 
			<select name="email2" id="email2"  onChange="" title="직접입력">
				<option value="non">직접입력</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="naver.com">naver.com</option>
				<option value="yahoo.co.kr">yahoo.co.kr</option>
				<option value="hotmail.com">hotmail.com</option>
				<option value="paran.com">paran.com</option>
				<option value="nate.com">nate.com</option>
				<option value="google.com">google.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="empal.com">empal.com</option>
				<option value="korea.com">korea.com</option>
				<option value="freechal.com">freechal.com</option>
			</select>
		</div>
		<br>
	
	<div class="mail_check_input_box" align="center">
		인증번호 &#124;<input class="mail_check_input" />
		 <input type="button" value="전송" class="mail_check_button" align="center" />
	</div>
	<br>
	
	<div align="center">
			<input type="button"  value="확인" >
			<input  type="button"  value="취소" onClick="history.go(-1)">
	</div>
</form>	

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(".mail_check_button").click(function(){
	var email1 =$(".mail_input").val();
	var email2 =$(".mail_input").val();
	
	$.ajax({
		type:"GET",
		url:"mailCheck.do?email1=&email2="+email1+email2
	});
});
</script>
</body>
</html>