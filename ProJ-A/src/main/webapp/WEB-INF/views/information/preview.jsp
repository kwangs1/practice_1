<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관람안내</title>
<style>
ul{
   list-style:none;
   }
#content{
	margin: 0 auto;
	text-align:center;
}
img{
	width:100%;
	height:200px;
}
.titPage02{  
	font-size: 160%;  
	line-height: 1.1; 
	color: #333; 
	margin: 100px 0 50px 0;
}
.content{
	float:left;
}
 .color_green{
 	color:#337c29; font-size:1.2em; font-weight:700;
 }
 .active{
float: left; 
text-align: center; 
display:inline-block;
font-size:1.0em; 
font-weight:700;
 }
.active a{
  text-decoration-line: none;
 }
.warp{
  width: 300px;
  margin-left: auto;
  margin-right: auto;
}
.active a:hover{
background-color:#999;
}
</style>
</head>
<body>
	<img alt="banner" src="${contextPath }/resources/image/banner.png">
	<ul class="warp">
	<li class="active" ><a href="${contextPath }/information/preview.do">관람안내　</a></li>
	<li class="active"><a href="${contextPath }/information/navigator.do">오시는길　</a></li>
	<li class="active"><a href="${contextPath }/information/grouptour.do">단체관람 안내</a></li>
	</ul>
	<div class="content">
		<h1 class="titPage02">관람시간</h1>
	<ul>
		<li>&#164;화~일 : <span class="color_green">10:00 ~ 18:00</span></li>
		<li>&#164;휴관일 : <span class="color_green">월요일(월요일이 공휴일이면 화요일 휴관), 예)1월 1일</span></li>
		<li>※입장은 전시 종료 30분전 마감됩니다.</li>
		<li>※전시작품 교체 등에 따른 임시휴관일은 별도 공지합니다.</li>
	</ul>
	
		<h1 class="titPage02">관람요금</h1>
	<ul>
		<li><span class="color_green">무료(기획전ㆍ특별전 등 일부 전시유료)</span><br>
			&#164;기획ㆍ특별展은 전시에 따라 별도의 관람료가 책정됩니다.</li>
		<li><span class="color_green">관람료 면제대상</span></li>
		<li>보호자 동반 7세 미만의 어린이, 65세 이상경로<br>
		&#164;장애인,국가유공자,독립유공자,다자녀가정 등(관련증 소지자)<br>
		&#164;※자세한 사항은 미술관 운영 조례 제5조의2항 참조 
		<a href="http://www.elis.go.kr/newlaib/laibLaws/h1126/laws_list_new.jsp?lawsNum=26000010001016" style="color:skyblue">
					바로가기</a></li>
	</ul>
	
			<h1 class="titPage02">도스튼 운영</h1>
	<ul>
		<li><span class="color_green">운영기간</span> : 미술관 자체 전시 기간중 ※ 도슨트 운영 시간은 미술관 사정에 따라 변경될 수 있으니 전화 및 홈페이지(공지사항)를 통해 확인하시기 바랍니다. </li>
		<li><span class="color_green">운영시간</span><br>
			&#164;평일(화~금) 15:00 ▷ 일 1회<br>
			&#164;주말(토, 일) 11:00 / 15:00 ▷ 일 2회</li>
		<li><span class="color_green">출발장소</span> : 미술관 1층 또는 2층 로비<br>
		※ 전시해설 운영 시 사전 동의없는 사진촬영 및 녹음이 불가함을 알려드립니다.<br>
		※ 수시해설 문의<br>
		&#164;학교, 공공기관, 단체(40명 이상) 수시해설 문의는 최소 일주일전까지 유선으로 해주시기 바랍니다.<br>
		&#164;그 외 도슨트 수시해설은 정규 운영시간을 이용하시기 바랍니다.<br>
		&#164;도슨트 관련 문의(055-000-0000)</li>
	</ul>
	
</div>
</body>
</html>