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
<title>footer</title>
<style>
#footer{   
    clear:both;
    color:#000;
    text-align: center; /* 내용 가운데 정렬*/
    margin:0;
    padding:10px 0;  /* 상하:10px  좌우:0  안쪽 여백 지정*/
    line-height: normal;
    font-size: .9em;
    /* body에 지정한 스타일 " font-size: 0.75em;" 먼저 적용되고 이것을 상속받아서
        footer에서 0.75em이 1이 된다 그래서 0.9em을 하면 body에서 기본으로 적용한 글자크기보다
        작은것을 볼수있다. */
 
}
</style>
</head>
<body>
	<!--footer 영역-->
		<div id="footer">Copyright KS Gallery 2021 All right reserved.</div>
</body>
</html>