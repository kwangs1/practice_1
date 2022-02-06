<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KS Gallery</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.mySlides {display:none}
.w3-left, .w3-right, .w3-badge {cursor:pointer}
.w3-badge {height:13px;width:13px;padding:0}
</style>
</head>
<!-- page 영역 : Wrapper : header과 main, footer영역을 포함.-->
<div id="page">
	<!--Content 영역-->
<div id="content">
	<div class="w3-content w3-display-container" style="max-width:100%">
	<a href="${contextPath}/admin/video/adminVideoDetail.do?vno=27">
		<img class="mySlides" src="${contextPath }/resources/image/Art.jpg" style="width:100%">
	</a>
	<a href="${contextPath}/admin/video/adminVideoDetail.do?vno=25">
		<img class="mySlides" src="${contextPath }/resources/image/Art2.jpg" style="width:100%">
	</a>

		<img class="mySlides" src="${contextPath }/resources/image/Art3.jpg" style="width:100%">

	
	<div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width:100%">
    	<div class="w3-left w3-hover-text-khaki" onclick="plusDivs(-1)">&#10094;</div>
   		 <div class="w3-right w3-hover-text-khaki" onclick="plusDivs(1)">&#10095;</div>
    	<span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span>
    	<span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
    	<span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
  	</div>
	</div>
</div>
</div>
<script type="text/javascript">
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" w3-white", "");
  }
  x[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " w3-white";
}


window.onload = pageLoad;//웹 페이지가 실행될때 pageLoad()함수를 호출하여 실행
function pageLoad(){
	notShowPop = getCookieValue();//notShowPop의 쿠기 값을 getCookieValue()를 호출하여 얻는다
	if(notShowPop != "true"){
		//notShowPop의 값이 true가 아니면 팝업창을 나타낸다
		window.open("http://localhost:8090/Art/main/popUp.do"
				,"pop","width=400, height=500, history=no, resizeable=no,status=no, scrollbars=yes, menubar=no")
	}
}

function getCookieValue(){
	var result = "false";
	if(document.cookie != ""){
		//document의 cookie 속성으로 쿠키 정보를 문자열로 가져온 후 세미클론으로 분리해 각각의 쿠키를 얻는다
		cookie = document.cookie.split(";")
		for(var i=0; i<cookie.length; i++){
			element = cookie[i].split("=");
			value = element[0];
			value = value.replace(/^\s*/,'');//정규식을 이용해 쿠키 이름 문자열의 공백을 제거
			if(value == "notShowPop"){
				result = element[1];//쿠키이름이 notShowPop이면 해당하는 쿠키 값을 가져와 반환
			}
		}
	}
	return result;
}


</script>

</body>
</html>