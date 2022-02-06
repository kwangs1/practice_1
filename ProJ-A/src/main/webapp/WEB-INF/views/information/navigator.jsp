<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script src="http://maps.googleapis.com/maps/api/js"></script><!-- 구글 지도API -->
<meta charset="UTF-8">
<title>오시는 길</title>
<style>
h1,p{
	text-align:center;
}
#content{
	width:50%; 
	padding: 40px;
	margin: 0 auto;
}
#googleMap{
	margin:0 auto;
}
.tableColRow1{
	width:50%;
	margin-top: 10px;
	border-collapse: collapse; 
	border: 0; 
	border-spacing: 0;
	border-top: 3px solid #333; 
	border-bottom: 1px solid #d2d2d2; 
	height:130px; 
	display: table-cell;
}
.divstyle{
	float:left;
	width:150px;
}
.div_box{
	width:100%; 
	margin-bottom:100px;
	padding: 40px;
}
.tdstyle{
	padding:15px; 
	width:0.5%;
}
.tdstyle{
	text-align:center;
}
.fontstyle{
	font-size:20px; 
	font-weight:700;
	text-align:left;
}
.titPage02{  
	font-size: 160%;  
	line-height: 1.1; 
	color: #333; 
	margin: 100px 0 50px 0;
}
.tableColRow {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
    text-align:center;
  }
.tdstyle2{
    border: 1px solid #444444;
    padding: 10px;
    width:50%;
  }
 .text-align{
 	padding-left:1%;
 	list-style:none;
 }
 .color_black{
 	color:#000; font-size:1.2em; font-weight:700;
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
<img alt="banner" src="${contextPath }/resources/image/banner.png" style="width:100%; height:250px;">
	<ul class="warp">
	<li class="active" ><a href="${contextPath }/information/preview.do">관람안내　</a></li>
	<li class="active"><a href="${contextPath }/information/navigator.do">오시는길　</a></li>
	<li class="active"><a href="${contextPath }/information/grouptour.do">단체관람 안내</a></li>
	</ul>
<div id="content">
	<h1 class="titPage02">교통안내</h1>
	<p>주소: 경상남도 김해시 분성로155(외동) 전화 000-000-0000</p>
	<div id="googleMap" style="width:80%; height:380px;"></div>
	
		<div class="div_box">
			<div class="divstyle">
				<p class="fontstyle">버스</p>
				<img src="${contextPath }/resources/image/traffic_ico01.gif" alt="버스아이콘">
			</div>
			<div class="div_center">
				<table class="tableColRow1">
					<tbody>
						<tr>
							<th scope="row" class="tdstyle"><span class="color_black">사상→수로왕릉</span>
							</th><td class="tdstyle">일반  2, 8, 9, 21, 1</td>
						</tr>
						<tr>
							<th scope="row" class="tdstyle"><span class="color_black"></span></th>
							<td class="tdstyle">마을  3, 7, 9, 9-1, 9-2, 12, 13, 14, 15, 16, 20, 21</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>	
		
		<div class="div_box">
			<div class="divstyle">
				<p class="fontstyle">지하철</p>
				<img src="${contextPath }/resources/image/traffic_ico03.gif" alt="지하철아이콘">
			</div>
			<div class="div_center">
				<table class="tableColRow1">
					<tbody>
						<tr>
							<th scope="row" class="tdstyle"><span class="color_black">김해경전철</span>
							</th>
							<td class="tdstyle">부산 지하철 1호선(대저) → 김해경전철 수로왕릉 하차</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="div_box">
			<div class="divstyle">
				<p class="fontstyle">셔틀버스</p>
				<img src="${contextPath }/resources/image/traffic_ico04.gif" alt="셔틀버스아이콘">
			</div>
			<div class="div_center">
				<table class="tableColRow1">
					<tbody>
						<tr>
							<th rowspan="2" class="tdstyle" scope="row">미술관→지하철 대저역(편도 운행)
							</th><td class="tdstyle">일 4회 운영(토요일 6회) ※단, 일ㆍ월요일(휴관일) 제외</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<h1 class="titPage02">주차안내</h1>
		<div class="div_center">
		<table class="tableColRow">
			<tbody>
				<tr>
					<th class="tdstyle2">주차요금</th><th class="tdstyle2">주차장 이용시간</th>
				</tr>
				<td class="tdstyle2">유료('19.8.1.~)<br>
					10분당 100원(1일 2400원)
					(대형,소형 동일)</td>
				<td class="tdstyle2">오전 9시 ~ 오후 7시까지
			(본관 연장운영일은 오후 10시까지 운영)</td><br><br>
			
			<tr>
					<td colspan="2" class="tdstyle2">승용차 요일제 적용  ※ 요일제 미참여 차량은 5부제 적용</td>
				</tr>
				<tr>
					<td colspan="2" style="color:red;">주말에는 주차장이 혼잡하오니, 대중교통을 이용하여 주시기 바랍니다.</td>
				</tr>
			</tbody>
		</table>
		</div>
		<ul class="text-align">
			<li><span class="color_black">※ 관련규정 :</span> 「부산광역시 주차장 설치 및 관리 조례」 제3조의2 </li>
		</ul>
		<ul class="text-align">
			<li><span class="color_black">※ 주차장 이용시 주의 사항</span></li>
			<li>&#164;공공기관 승용차 요일제 의무실시에 따라 미술관의 주차장 이용시 <span class="color_green">승용차 요일제에 해당 차량은 주차 금지</span>.</li>
			<li>&#164;요일제 미참여 차량은 5부제 적용  →  월 (1, 6번) / 화 (2, 7번) / 수 (3, 8번) / 목 (4, 9번) / 금 (5,0번) 차량입차 제한</li>
		</ul>
		<ul class="text-align">
			<li><span class="color_black">※ 제외 차량</span>  :  경차,  장애인사용 승용차,  긴급 · 보도용 · 외교용 · 군용 · 경호용자동차,  화물 · 특수 · 승합자동차 및 하이브리드자동차 등</li>
			<li>  → 「공공기관 에너지이용 합리화 추진에 관한 규정」 제17조 참조 </li>
		</ul>
		<ul class="text-align">
			<li><span class="color_black">※ 장애인 전용주차구역</span> <span class="color_green">장애인 이외 차량 주차 불가</span>. </li>
			<li>&#164;장애인 전용 주차구역 미부착 차량, 장애인 전용 주차구역 부착차량이나 장애인 미탑승 차량이 장애인전용주차구역에 주차한 경우 <span>과태료 10만원</span>, </li>
			<li>&#164;장애인전용주차구역에 주차를 방해하는 행위는 <span class="color_green">과태료 50만원 부과</span>.</li>
			<li>( 관련 근거  :  장애인· 노인· 임산부 등의 편의증진보장에 관한 법률 및 당해 법률 시행령 )</li>
		</ul>
	</div>
<script>
	function initialize(){
		var LatLng = new google.maps.LatLng(37.506736, 126.783362);
		var mapProp ={
				center: LatLng,
				zoom:16,
				mapTypeId:google.maps.MapTypeId.ROADMAP
		};
		/*LatLng: 내가 보고싶은 위치 선정
		  mapProp: 지도 속성을 어떻게 할지 작성
		  center: 위치 선정 적용
		  zoom:확대 단계
		  mapTypeid:맵 타입을 설정*/
	
	var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);//맵을 담기 위한 div를 생성 후 mapprop를 통해 맵 적용
		
	var marker = new google.maps.Marker({
		position: LatLng,
		map: map,
		//내가 선정한 위치 위에 marker(위치 찍기) , position:내 선정위치, map:내가 생성한맵
	})	
}
	google.maps.event.addDomListener(window, 'load', initialize);//domlistener를 추가하여 페이지 로드시 initalize()함수 실행 시키기
</script>
</body>
</html>