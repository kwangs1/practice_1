<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/joinForm.css">
<style>
.final_pw_ck {
	color : red;
	display: none;
}
.final_pwck_ck {
	color : red;
	display: none;
}
.pwck_input_re_1{
    color : green;
    display : none;    
}
.pwck_input_re_2{
    color : red;
	display : none;    
}
.update {
  position:absolute;
  width:400px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  top:40%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}

.update h2 {
  text-align: center;
  margin: 30px;
}
</style>
</head>
<body>
	<form name="form" method="post" class="update">
		<div class="header">
            <h2>비밀번호 수정</h2>
        </div>  
        <div class="textForm">
            <input type="password" name="member_pw" id="member_pw" class="pw" placeholder="비밀번호">
            <span class="final_pw_ck">비밀번호를 입력해주세요.</span>
        </div>
        <div class="textForm">
            <input type="password" class="pwck" placeholder="비밀번호 재확인">
            <span class="final_pwck_ck">비밀번호 확인을 입력해주세요.</span>
			<span class="pwck_input_re_1">비밀번호가 일치합니다.</span>
            <span class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
        </div>

			<input type="button" value="수정" id="btnUpdate" class="btn">

	</form>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
var pwCheck = false; //비번
var pwckCheck = false;//비번확인
var pwckcorCheck = false; //비번확인 일치 확인

	$(document).ready(function(){
		$('#btnUpdate').click(function(){
			var pw = $('.pw').val();
			var pwck = $('.pwck').val();
			
			//새 비밀번호 유효성 검사
			if(pw == ""){
				$('.final_pw_ck').css('display','block');
				pwCheck = false;
			}else{
				$('.final_pw_ck').css('display', 'none');
				pwCheck = true;
			}
			
			//새 비밀번호 확인 유효성 검사
			if(pwck == ""){
				$('.final_pwck_ck').css('display','block');
				pwckCheck = false;
			}else{
				$('.final_pwck_ck').css('display', 'none');
				pwckCheck = true;
			}
			
			
			if(pwCheck && pwckCheck){
				document.form.action = "${contextPath}/member/MemberModify_Pw.do?member_id=${memberInfo.member_id}";
				document.form.submit();
				alert("비밀번호 수정이 완료되었습니다. 재로그인 해주세요");	
			}
			
			return false;
		});
	});
	//pw 확인 일치 유효성 검사
	$('.pwck').on("propertychange change keyup paste input", function(){
	 
	    var pw = $('.pw').val();
	    var pwck = $('.pwck').val();
	    $('.final_pwck_ck').css('display', 'none');
	 
	    if(pw == pwck){
	        $('.pwck_input_re_1').css('display','block');
	        $('.pwck_input_re_2').css('display','none');
	        pwckcorCheck = true;
	    }else{
	        $('.pwck_input_re_1').css('display','none');
	        $('.pwck_input_re_2').css('display','block');
	        pwckcorCheck = false;
	    }        
	    
	});  
</script>
</body>
</html> 