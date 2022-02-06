<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>

<body>
<div>
	<div>
		<h3>공지 사항</h3>
		<div>- Github 주소 : <a href="https://github.com/kwangs1/ProJect-A" target="_blank">클릭</a></div>
		<div>- 새로운 기능이 추가되었습니다.</div>

	</div>
	<br><br><br><br>
	<div>
		<input type=checkbox onClick="setPopUpStart(this)">오늘 더이상 팝업창 띄우지 않기
	</div>			
</div>


<script type="text/javascript">

	function setPopUpStart(obj){
		if(obj.checked ==true){
			var exprieDate = new Date();
			exprieDate.setMonth(exprieDate.getMonth()+1);//쿠키 유효 시간을 한달로 설정
			document.cookie = "notShowPop=" + "ture" + ";path=/; expires=" + exprieDate.toGMTString();
			//오늘 더이상 팝업창 띄우지 않기에 체크하면 not ShowPop 쿠키값을 true로 설정하여 재접속시 팡업창을 나타내지 않는다
			window.close();
			}
	}
</script>
</body>
</html>