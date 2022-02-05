<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>

<style>
#container {
	margin: 40px auto;
	width: 100%;
}
</style>
</head>

<body>
 
<div class="cnt_bbs">
<form:form commandName="videoVO" name="videoVO" method="post" enctype="multipart/form-data" 
	action="${contextPath}/admin/video/youtube/addAction.do" onsubmit="return frm_check();" >
 
<div class="bbs_write">
<table class="tb_write">
<caption>게시글 등록</caption>
<colgroup>
    <col style="width:25%;">
    <col style="width:75%;">
</colgroup>
<tbody>
    <tr>
        <th scope="row"><label for="v_title"> 제목 </label></th>
        <td>  
            <input type="text" name="v_title" id="v_title" style="width:100%"/>
        </td>
    </tr>
    <tr>
        <th scope="row">유튜브 주소 ID</th>
        <td>  
            <div>
                <span class="line_h35">https://youtu.be/  </span>
                <input type="text" name="v_addr" id="v_addr" style="width:150px"/>
            </div>  
            <p class="mt_10">*ID를 정확히 입력해야 Player 및 썸네일 이미지가 정상적으로 출력이 됩니다.</p>
            <p>유튜브 주소 ID를 입력하지 않으면 기존에 등록한 썸네일 이미지로 출력이 됩니다.</p>
                
        </td>
    </tr>
    <tr>
        <th scope="row"> 영상소개 </th>
        <td>  
            <textarea name="v_note" cols="100" rows="5" ></textarea>
        </td>
    </tr>
</tbody>
</table>
</div>    
 </br></br>
<div class="mt_20 t_r" align="center">
<input type="submit" class="tb_btn blueM"  value="등록" />
<a href="${contextPath}/admin/video/adminVideoMain.do"  class="tb_btn whiteM">목록</a>
</div>
</form:form>
</div>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>

<script type="text/javaScript">
 
function frm_check(){    
 
if (!confirm('등록하시겠습니까?')) {
return false;
}
}
</script>
</body>
</html>