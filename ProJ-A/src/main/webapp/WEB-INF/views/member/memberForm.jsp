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
/* 중복아이디 존재하지 않는경우 */
.id_input_re_1 {
	color: green;
	display: none;
}
/* 중복아이디 존재하는 경우 */
.id_input_re_2 {
	color: red;
	display: none;
}
.final_id_ck {
	display: none;
}
/* 비밀번호 확인 일치 유효성검사 */
.pwck_input_re_1{
    color : green;
    display : none;    
}
.pwck_input_re_2{
    color : red;
	display : none;    
}
.final_pw_ck {
	display: none;
}
</style>
</head>
<body>
	<form action="${contextPath}/member/addMember.do" method="post" name="frm" class="joinForm">
	   <div class="header">
            <p>회원가입</p>
        </div>
        
     
        <div class="textForm">
            <input type="text"  name="member_id"  id="member_id" class="id" placeholder="아이디">
            <span class="id_input_re_1">사용 가능한 아이디입니다.</span>
			<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
			<span class="final_id_ck">아이디를 입력해주세요.</span>
        </div>
			
        <div class="textForm">
            <input type="password" name="member_pw" id="member_pw" class="pw" placeholder="비밀번호">
            <span class="final_pw_ck">비밀번호를 입력해주세요.</span>
        </div>
        <div class="textForm">
            <input type="password" class="pwck" placeholder="비밀번호 재확인">
			<span class="pwck_input_re_1">비밀번호가 일치합니다.</span>
            <span class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
        </div>
        <div class="textForm">
            <input type="text" name="member_name" id="member_name" class="name" placeholder="이름">
        </div>
  
        <div class="textForm">
            <select  name="member_gender" id="member_gender" class="gender">
                <option value="choice">성별 선택</option>
                <option value="man">남자</option>
                <option value="woman">여자</option>
            </select>
        </div>
        <div class="textForm">      
            <input type="text" placeholder="이메일" name="email" id="email" class="email" placeholder="이메일">
        </div>
        
        <div class="textForm">
            <input type="text" class="cellphoneNo" placeholder="전화번호" name="tel" id="tel">
        </div>
    
        <div class="textForm">
			<input  type="text" id="zipcode" name="zipcode" size="10" > <a
				href="javascript:execDaumPostcode()" class="zipcode">우편번호검색</a> <br>
				<input type="text" id="roadAddress" name="roadAddress" class="zipcode" placeholder="지번"><br>
				<input type="text" id="jibunAddress" name="jibunAddress" class="zipcode" placeholder="도로명"><br>
				<input type="text" name="namujiAddress" class="zipcode" placeholder="나머지 주소" />
				<span id="guide" style="color: #999"></span>
		</div>
        
        <input type="submit" class="btn" value="J O I N"/>
        
</form>	
    </body>
			

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
//유효성 검사 통과유무 변수
var idCheck = false; //아이디
var idckCheck = false; //중복검사
var pwCheck = false; //비번
var pwckCheck = false;//비번확인

//id 중복검사
$('.id').on("propertychange change keyup paste input" , function(){
	/* console.log("keyup test"); */
	var id = $('.id').val(); //.id_input에 입력되는 값
	var data = {id : id} //컨트롤러에 넘길 데이터 이름 : 데이터(.id_input에 입력되는 값)
	
	$.ajax({
		type : "POST",
		url : "${contextPath}/member/IdCheck.do",
		data : data,
		success : function(result){
			//console.log("성공여부:" + result);
			if(result != 'fail'){
				$('.id_input_re_1').css("display","inline-block");
				$('.id_input_re_2').css("display","none");	
				idchCheck=true;
			}else{
				$('.id_input_re_2').css("display","inline-block");
				$('.id_input_re_1').css("display","none");	
				idckCheck = false;
			}
		}//success 끝
	});//ajax 끝
});// function 끝

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
/* 우편번호 검색API */
function execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function(data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
      var extraRoadAddr = ''; // 도로명 조합형 주소 변수

      // 법정동명이 있을 경우 추가한다. (법정리는 제외)
      // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
      if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
        extraRoadAddr += data.bname;
      }
      // 건물명이 있고, 공동주택일 경우 추가한다.
      if(data.buildingName !== '' && data.apartment === 'Y'){
        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
      }
      // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
      if(extraRoadAddr !== ''){
        extraRoadAddr = ' (' + extraRoadAddr + ')';
      }
      // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
      if(fullRoadAddr !== ''){
        fullRoadAddr += extraRoadAddr;
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
      document.getElementById('roadAddress').value = fullRoadAddr;
      document.getElementById('jibunAddress').value = data.jibunAddress;

      // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
      if(data.autoRoadAddress) {
        //예상되는 도로명 주소에 조합형 주소를 추가한다.
        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
        document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

      } else if(data.autoJibunAddress) {
          var expJibunAddr = data.autoJibunAddress;
          document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
      } else {
          document.getElementById('guide').innerHTML = '';
      }  
    }
  }).open();

}

</script>
</body>
</html>