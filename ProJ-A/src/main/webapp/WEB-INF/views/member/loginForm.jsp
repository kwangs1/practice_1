<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	 isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<c:if test='${not empty message }'>
<script>
window.onload=function()
{
  result();
}

function result(){
	alert("아이디나  비밀번호가 틀립니다. 다시 로그인해주세요");
}
</script>
</c:if>
<style>
*{
margin:0; 
padding:0;
}
.loginbox{
width:330px;
height:320px;
border:1px solid #ccc;
margin:0 auto;
padding:0 auto;
bax-sizing:border-box;
}
.loginbox h1{
width:100%;
height:40px;
font-size:28px;
color:#ff9900;
border-bottom:1px solid #ff9900;
padding-left:40px;
box-sizing:border-box;
}
#loginid,#loginpw{
width:200px;
height:25px;
border:1px solid #999;
box-sizing:border-box;
margin-bottom:10px;
margin-top:10px;
}
.labelid{font-size:14px; color:#666; margin-left:15px; margin-right:22px;}
.labelpw{font-size:14px; color:#666; margin-left:15px; margin-right:8px;}
.search{
width:100%;
height:40px;
border-bottom:1px dashed #999;
box-sizing:border-box;
line-height:40px;
text-align:center;
margin-bottom:20px;
}
.search span{font-size:11px; color:#999;}
.search a{
font-size:12px;
text-decoration:none;
background-color:#333;
color:#fff;
padding:3px 5px;
border-radius:3px;
margin-left:5px;
}
.btnwrap{width:100%; text-align:center;}
.btnwrap label{position:absolute; left:-999em;}
.btnwrap a{
width:129px;
height:35px;
background-color:#999;
text-decoration:none;
display:inline-block;
border-radius:3px;
color:#fff;
font-size:14px;
font-weight:bold;
line-height:35px;
}
#loginbtn{
width:129px;
height:35px;
border:none;
background-color:#ff9900;
border-radius:3px;
color:#fff;
font-size:14px;
font-weight:bold;
position:relative;
top:1px;
}
</style>
</head>
<body>
	<div class="loginbox">
		<h1>Login</h1>
		<form action="${contextPath }/member/login.do" method="post">
			<label for="loginid" class="labelid">아이디</label>
      		<input type="text" name="member_id" id="loginid" ><br>
      		<label for="loginpw" class="labelpw">비밀번호</label>
      		<input type="password" name="member_pw" id="loginpw" >
		<div class="search">
			<span class="text">아이디 또는 비밀번호를 잊으셨나요?</span>
			<a href="#">ID/PW 찾기</a>
		</div>
		<div class="btnwrap">
			<a href="${contextPath}/member/memberForm.do">회원가입</a>
			<input type="submit" id="loginbtn" value="로그인" />
			<label for="loginbtn">로그인 버튼</label>
		</div>
		</form>
	</div>

</body>
</html>