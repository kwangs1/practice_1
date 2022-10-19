<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단체관람안내</title>
<style>
.div_box{
	width:50%; 
	padding: 40px;
	margin: 0 auto;
}
.tableColRow1{
	width:50%;
	margin-top: 10px;
	border-collapse: collapse; 
	border: 0; 
	border-spacing: 0;
	border-top: 5px solid #333; 
	border-bottom: 5px solid #333; 
	height:130px; 
	display: table-cell;
}
 .color_black{
 	color:#000; font-size:1.2em; font-weight:700;
 }
  .color_red{
 	color:red; font-size:1.2em; font-weight:700;
 }
  .color_green{
 	color:#337c29; font-size:1.2em; font-weight:700;
 }
 .titPage02{  
	font-size: 160%;  
	line-height: 1.1; 
	color: #333; 
	margin: 100px 0 50px 0;
}
 .text-align{
 	text-align:left; 
 	padding-left:1%;
 	list-style:none;
 }
 .tdstyle2{
    width: 100%;
    border: 5px solid #c0c0c0;
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
	<div class="div_box">
		<div class="div_center">
				<table class="tableColRow1">
					<tbody>
						<tr>
							<td class="tdstyle"><img src="${contextPath }/resources/image/reserve_img01.jpg"></td>
							<td>▶부산현대미술관에서는 관람객들의 쾌적한 관람문화 조성 및 단체 관람의 편의를 위하여 단체관람 사전예약제를 실시하고 있습니다.<br><br>
								▶아래 안내 및 유의사항을 필독하시고 재밌고 유익한 관람 되시길 바랍니다.<br><br>
								<span class="color_red">※ 코로나19로인해 사회적 거리 두기 중에는 "단체관람"을 운영하지 않습니다.</span>
							</td>
						</tr>
					</tbody>
				</table>
		</div>
		
		<h1 class="titPage02">이용안내</h1>
		<ul class="text-align">
			<li><span class="color_black">인원기준 및 관람료</span></li>
			<li>&#164;인원 : 20명 이상 사전예약필수</li>
			<li>&#164;관람료 : 무료</li>
		</ul>
		<ul class="text-align">
			<li><span class="color_black">예약절차</span></li>
			<li><span class="color_green">단체예약신청 ></span> <span class="color_green">승인대기 ></span> <span class="color_green">승인페이지에서"승인"상태 및 승인 문자확인</span> </li>
			<li>&#164;단체관람시간 : 개관시간(오전10시)부터 1시간 단위로 지정가능</li>
			<li>&#164;기타사항 : 방문예정일로부터 최소 2일 전 신청하여야 하며, 예약일 1일 전까지 취소 가능합니다.</li>
		</ul>
		<ul class="text-align">
			<li><span class="color_black">단쳬예약문의 : 우리집(☎055-000-0000)</span></li>
			<li><a href="https://reserve.busan.go.kr/exprn/list?resveGroupSn=&progrmSn=&srchGugun=&srchResveInsttCd=35&srchBeginDe=&srchEndDe=&srchVal=" style="color:skyblue">단체관람 신청하기</a></li>
			<li>※ 단체관람 신청과 도슨트는 연계되어 있지 않으며, 도슨트 관련은 관람안내 페이지를 참고하여 주시기 바랍니다.</li>
		</ul>
		<ul class="text-align">
			<li><span class="color_black">유의사항</span></li>
			<li>&#164;20명 이상 단체의 경우, 질서유지 및 안전사고 예방을 위해 인솔자의 동행이 반드시 필요하며, 단체 관람 이전에 선생님 혹은 인솔자의 미술관 관람 예절에 대한 사전 지도 부탁드립니다. </li>
			<br>
			<table>
				<tbody>
					<tr>
						<td class="tdstyle2">
						※ 퇴관 시 일반인관람 편의를 위해 관람을 마친 후 야외로 퇴장바랍니다.<br>
						※ 유치원 단체 관람 유의 사항
  						- 유치원 단체는 자유 관람만 가능합니다. 안전사고 예방을 위하여 학생과 선생님의 비율을 7:1의 비율로 하여 관람하여 주시기 바랍니다.
  						</td>
					</tr>
				</tbody>
			</table>
			<br><br>
			<li><span class="color_black">▶사전교육</span></li>
			<li>&#164;소리를 낮춰주세요<br>
				-전시실에서는 작은 소리도 크게 울려서, 타인에게 방해가 될 수 있습니다.</li>
			<li>&#164;눈으로만 감상해주세요<br>
				-전시작품에 기대거나 만져서 작품이 훼손되지 않도록 도와주세요.</li>
			<li>&#164;사진촬영은 문의하세요.<br>
				-전시장에서 사진 촬영 시에는 관리원에게 사전 문의 하세요</li>
			<li>&#164;음식물은 반입하지 말아주세요<br>
				-껌, 사탕, 음료 포함 음식물은 반입하거나 먹을 수 없습니다.</li><br><br>
				
			<li><span class="color_black">▶기타 유의사항</span></li>
			<li>&#164;사전예약을 하지 않았을 시 같은 시간에 관람 인원이 많을 경우 전시실 입장을 대기할 수 있습니다.</li>
			<li>&#164;미술관 관람 예절을 지키지 않을 경우 관람에 통제를 받을 수 있습니다.</li>
			<li>&#164;미술관 내에서 단체관람객이 도시락으로 식사할 수 있는 공간은 제공되지 않습니다.</li>
			<li>&#164;허가되지 않은 외부인의 전시해설 및 외부기기는 사용하실 수 없습니다.</li>
			<li>&#164;전시장 난간에 기대면 위험하오니 기대지 맙시다.</li>
			<li>※ 상기 관람예절을 지키지 않을 경우 부득이하게 퇴관을 조치할 수 있습니다.</li>
		</ul>
	</div>	
</body>
</html>