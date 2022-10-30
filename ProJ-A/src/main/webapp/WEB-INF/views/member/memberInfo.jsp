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
	<form class="Info">
	   <div class="header">
            <p>마이페이지</p>
        </div>   
        <a href="${contextPath}/member/MemberModify.do?member_id=${memberInfo.member_id}">▶회원정보 변경</a>
        <a href="${contextPath}/member/MemberModify_Pw.do?member_id=${memberInfo.member_id}">▶비밀번호 변경</a>
		
		<div class="textForm">
            <input type="text" name="member_id" class="id" value="${memberInfo.member_id }"  disabled>
        </div>
        
        <div class="textForm">
            <input type="text" name="member_name" class="name" value="${memberInfo.member_name }"  disabled>
        </div>
        
        <div class="textForm">      
            <input type="text" placeholder="이메일" name="email" id="email" class="email" value="${memberInfo.email }"disabled>
        </div>
        
        <div class="textForm">
            <input type="text" class="cellphoneNo"  name="tel" value="${memberInfo.tel }"disabled>
        </div>
    
        <div class="textForm">
			<input  type="text" value="${memberInfo.zipcode }" name="zipcode" size="10" > <a
				href="javascript:execDaumPostcode()" class="zipcode">우편번호검색</a> <br>
				<input type="text" value="${memberInfo.roadAddress }" name="roadAddress" class="zipcode" placeholder="지번"><br>
				<input type="text" value="${memberInfo.jibunAddress }" name="jibunAddress" class="zipcode" placeholder="도로명"><br>
				<input type="text" value="${memberInfo.namujiAddress }" name="namujiAddress" class="zipcode" placeholder="나머지 주소" />
				<span id="guide" style="color: #999"></span>
		</div>
</form>	
    </body>
			
</body>
</html>