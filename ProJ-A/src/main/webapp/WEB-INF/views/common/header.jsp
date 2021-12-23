<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style>

div#title{
    float: left; /*box영역의 왼쪽으로 정렬, 다음에 오는 요소에 영향을 끼침, [title][logindisplay] */
    text-align:left;
    display:block;
 
}
 
#logindisplay {
   
    text-align:right;
    margin:10px;
    font-size:0.8em;
    display:block;
    color:white;
 
}
 
/*logindisplay영역의 링크 스타일 지정*/
#logindisplay a:link{
    color:black;
    text-decoration:none;
 
}
#logindisplay a:visited{
    color:black;
    text-decoration:none;
 
}
 
#logindisplay a:hover{
    background-color:white;
    color:black;
 
}
#logindisplay a:active{ /*링크를 클릭하는 순간 */
    color:silver;
    text-decoration:none;
 
}
 
#menucontainer{
    /*clear:both;*/
    margin-top:40px;
  
}
 
/*메뉴 모양 정의 */
 
ul#menu{
    text-align:center;
    list-style-type: none;
  	margin: 0;
  	padding: 0;
  	overflow: hidden;
}
 
ul#menu li{
    display:inline;
    list-style:none; /*리스트의 블릿기호 none */
}
ul#menu li a{
    padding:10px 20px;
    font-weight: bold;
    text-decoration:none;
    line-height:2.8em;
    color:#000;
}
ul#menu li a:hover{
   
    background-color:#fff;
    text-decoration:none;
}
ul#menu li a:active{
    text-decoration:none;
}
 
/* 제목 관련 스타일 */
h1, h2, h3, h4, h5, h6
{
    font-size: 1.5em;
}

/* dropdown */
li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li.dropdown {
  display: block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: inline;
  top: 0px;
}
</style>
</head>
<body>
	
	<!--header 영역 -->
	<div id="header">

		<!-- Site title Or logo -->
		<div id="title">
		<a href="${contextPath }/main/main.do">
		<img alt="logo" src="${contextPath }/resources/image/logo.png" style="height:150px">
		</a>
		</div>

		<!-- 로그인 영역 -->
		<div id="logindisplay">
			<a href="${contextPath }/member/login.do">로그인 |</a> 
			<a href="#">회원가입 |</a> 
			<a href="#">새소식 |</a> 
			<a href="#">사이트맵</a>
		</div>

		<!-- 메뉴 영역-->
		<div id="menucontainer">
			<ul id="menu">
				<li class="dropdown">
				<a href="javascript:void(0)" class="dropbtn">이용안내</a>
				<div class="dropdown-content">
				<a href="${contextPath }/information/preview.do">관람안내</a>
				<a href="${contextPath }/information/navigator.do">오시는길</a>
				<a href="${contextPath }/information/grouptour.do">단체관람 안내</a>
				</div>
				<li><a href="#">전시</a></li>
				<li><a href="#">책그림섬</a></li>
				<li><a href="#">교육프로그램</a></li>
				<li><a href="#">소장품</a></li>
				<li><a href="#">소식/참여</a></li>
				<li><a href="#">미술관소개</a></li>
				<li><a href="#">온라인예약</a></li>
			</ul>
		</div>

	</div>
</body>
</html>