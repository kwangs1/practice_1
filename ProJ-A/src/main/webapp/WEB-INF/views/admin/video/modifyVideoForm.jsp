<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="key" value="${fn:substring(video.v_addr,17,100) }" />
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
 
<form method="post" action="${contextPath}/admin/video/modifyVideo.do?vno=${video.vno}&page=${scri.page }&perPageNum=${scri.perPageNum }"
enctype="multipart/form-data" >
<div class="cnt_bbs">
 
<div class="bbs_write">
 <table>
  <tr>
   <td>
    <input type=text style="font-size:2.5em; font-weight:700; color:#000;"
    value="${video.v_title }" name="v_title" id="v_title"/>
   </td>
  </tr>
<tr>
<td>
      <iframe width="1000" height="720" src="https://www.youtube.com/embed/${key}" 
    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; 
    		encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
    </iframe>
                
      <textarea class="note" rows="20" cols="80"  name="v_note"  id="v_note" >${video.v_note }</textarea>
        </td>

</tr>
    <tr>
        <td>  
        </td>
    </tr>
  </table>
</div>    
 </br></br>
<div class="mt_20 t_r" align="center">
<input type=button value="수정반영하기" style='cursor:pointer;' onClick="fn_enable(this.form)">
<a style='cursor:pointer;'
	      	 href='<c:url value='/admin/video/adminVideoMain.do?page=${scri.page }
	      	 							&perPageNum=${scri.perPageNum }
	      	 							&searchType=${scri.searchType}
	      	 							&keyword=${scri.keyword}'/>'>수정취소</a>
</div>
</div>
</form>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>
<script type="text/javaScript">
function fn_enable(obj){
	 document.getElementById("v_title").disabled=false;
	 document.getElementById("v_addr").disabled=false;
	 document.getElementById("v_note").disabled=false;

	 obj.submit();
}
</script>
</body>
</html>