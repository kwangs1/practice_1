<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="goDetailUrl" value="${contextPath}/admin/video/adminVideoDetail.do?vno=${video.vno}" />
<c:set var="key" value="${fn:substring(video.v_addr,17,100) }" />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
*{
margin:0 auto;
}
table td {
  width:155px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #fff;
  }
table tr td input{
	border:none;
}
a {
  text-decoration-line: none;
}
.note{
background-color:transparent;
 border: none;
}
.note:focus{
outline: none;
}
</style>
</head>
<body>
<form method="get"  action="${contextPath}/admin/video/adminVideoDetail.do">
<h1>　</h1>
  <table>
  <tr>
   <td>
    <input type=text style="font-size:2.5em; font-weight:700; color:#000;"
    value="${video.v_title }" name="v_title"  disabled />
   </td>
  </tr>

<tr>
<td>
    <iframe width="1000" height="720" src="https://www.youtube.com/embed/${key}" 
    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; 
    		encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
    </iframe>
     <textarea class="note" rows="20" cols="80"  name="v_note"  disabled>${video.v_note }</textarea>
     </td>
</tr>

    <tr id="tr_btn">
	<td>
 	      	<a style='cursor:pointer;'
	      	 href="javascript:history.back();">목록으로</a>							
	</td>
	</tr>
  </table>
  </form>
  
  <form name="readForm" role="form" method="post">
  	<input type="hidden" id="vno" name="bno" value="${video.vno}" />
  	<input type="hidden" id="page" name="page" value="${scri.page}"> 
  	<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
  	<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  	<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
</form>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
 <script type="text/javascript">
 function fn_remove_vno(url,vno){
	 var form = document.createElement("form");
	 form.setAttribute("method", "get");
	 form.setAttribute("action", url);
     var vnoInput = document.createElement("input");
     vnoInput.setAttribute("type","hidden");
     vnoInput.setAttribute("name","vno");
     vnoInput.setAttribute("value", vno);
	 
     form.appendChild(vnoInput);
     document.body.appendChild(form);
     form.submit();
 
 }
 </script>
</body>
</html>