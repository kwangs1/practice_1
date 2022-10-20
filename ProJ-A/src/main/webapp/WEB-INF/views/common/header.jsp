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
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${contextPath}/resources/main.css">

<title>header</title>
</head>
	
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">
    
    <!-- page First Navigation -->
    <nav class="navbar navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="${contextPath }/main/main.do">
                <img src="${contextPath }/resources/image/logo.svg" alt="">
            </a>
            <div class="socials">
                <c:choose>
                    <c:when test="${isLogOn == true and not empty memberInfo }">
                        <a href="${contextPath}/member/logout.do" onClick="cookieRemove()">▶로그아웃</a>
                        <a href="${contextPath}/member/memberInfo.do">▶마이페이지</a>
                    </c:when>
                    <c:otherwise>
                    <a href="${contextPath }/member/loginForm.do">▶로그인</a> 
                    <a href="${contextPath }/member/memberForm.do">▶회원가입</a> 
                    </c:otherwise>
                </c:choose><br>
                <c:if test="${isLogOn == true and memberInfo.member_id =='admin' }">
                    <a href="${contextPath}/admin/goods/adminGoodsMain.do">▶작품관리</a>
                    <a href="${contextPath}/admin/video/adminVideoMain.do">▶프로그램 관리</a>
                    <a href="${contextPath}/admin/notice/noticeList.do">▶공지사항관리</a>
                </c:if>
            </div>
        </div>
    </nav>
    <!-- End Of First Navigation -->

    <!-- Page Second Navigation -->
    <nav class="navbar custom-navbar navbar-expand-md navbar-light bg-primary sticky-top">
        <div class="container">
            <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> 이용안내 </a>


						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href="${contextPath}/information/navigator.do">오시는 길</a>
								
							<a class="dropdown-item"
								href="${contextPath}/information/preview.do">관람 안내</a>
						<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href="${contextPath}/information/grouptour.do">단체관람 안내</a>
						</div>
					</li>

					<li class="nav-item">
                        <a href="${contextPath}/admin/video/videoListView.do" class="nav-link">프로그램</a>
                    </li>
                    <li class="nav-item">
                        <a href="${contextPath}/collectible/collectibleList.do" class="nav-link">소장품</a>
                    </li>
                    <li class="nav-item">
                        <a href="${contextPath}/admin/notice/noticeList.do" class="nav-link">공지사항</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End Of Page Second Navigation -->
    
        <!-- page-header -->
    <%-- <header class="page-header" style="background: url(${contextPath }/resources/image/header.jpg) no-repeat center top fixed"></header> --%>
    <!-- end of page header -->

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $(".navbar .nav-link").on('click', function(event) {

        if (this.hash !== "") {

            event.preventDefault();

            var hash = this.hash;

            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 700, function(){
                window.location.hash = hash;
            });
        } 
    });
});

function cookieRemove() {
    // 변수를 선언한다.
    var date = new Date();
    date.setDate(date.getDate() - 1);
    var willCookie = "";
    willCookie += "CookieName=Value;";
    willCookie += "Expires=" + date.toUTCString();
    // 쿠키를 집어넣는다.
    document.cookie = willCookie;
    window.location.reload();
   }
</script>

</body>
</html>