<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${contextPath}/resources/joinForm.css">
<style>
.Info {
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

.Info h2 {
  text-align: center;
  margin: 30px;
}
</style>
</head>
<body>
	<form method="post" class="Info" name="form" >
	   <div class="header">
            <h2>정보 수정</h2>
        </div>   
		
		<div class="textForm">
            <input type="text" name="member_id"  class="id" value="${memberInfo.member_id }"  disabled>
        </div>
        
        <div class="textForm">
            <input type="text" name="member_name" class="name" value="${memberInfo.member_name }"  disabled>
        </div>
        
        <div class="textForm">      
            <input type="text" placeholder="이메일" name="email" id="email" class="email" value="${memberInfo.email }">
        </div>
        
        <div class="textForm">
            <input type="text" class="cellphoneNo"  name="tel" value="${memberInfo.tel }">
        </div>
    
        <div class="textForm">
			<input  type="text" value="${memberInfo.zipcode }" name="zipcode" size="10" disabled> <a
				href="javascript:execDaumPostcode()" class="zipcode">우편번호검색</a> <br>
				<input type="text" value="${memberInfo.roadAddress }" name="roadAddress" class="zipcode" placeholder="지번" disabled><br>
				<input type="text" value="${memberInfo.jibunAddress }" name="jibunAddress" class="zipcode" placeholder="도로명" disabled><br>
				<input type="text" value="${memberInfo.namujiAddress }" name="namujiAddress" class="zipcode" placeholder="나머지 주소" disabled/>
				<span id="guide" style="color: #999"></span>
		</div>
		<input type="button" value="수정" id="btnUpdate" class="btn" />
</form>	

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#btnUpdate').click(function(){
		if(confirm("수정 하시겠습니까?")){
			document.form.action = "${contextPath}/member/MemberModify.do?member_id=${memberInfo.member_id}&member_name=${memberInfo.member_name}&zipcode=${memberInfo.zipcode}&roadAddress=${memberInfo.roadAddress}&jibunAddress=${memberInfo.jibunAddress}&namujiAddress=${memberInfo.namujiAddress}";
			document.form.submit();				
		}
	});
});
</script>
    </body>


</html>