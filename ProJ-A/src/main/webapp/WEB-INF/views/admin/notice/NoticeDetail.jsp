<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
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
</style>
</head>
<body>
<form method="get"  action="${contextPath}/admin/notice/NoticeDetail.do">
<h1>　</h1>
  <table>
  <tr>
   <td>
    <input type=text style="font-size:2.5em; font-weight:700; color:#000;"
    value="${notice.title }" name="title"  disabled />
   </td>
  </tr>
 
  <tr>
    <td>부서명 &#124; <input type=text value="${notice.department}"  name="department"   disabled /> 
    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    전화번호 &#124; <input type=text value="${notice.tel }"  name="department"   disabled /></td>
  </tr>
   
   <tr>
   <td>작성자 &#124; <input type=text value="${notice.writer }"  name="department"   disabled />
   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   작성일 &#124; <input type=text value="<fmt:formatDate value="${notice.regdate}" />" disabled />
   조회수 &#124;&nbsp;&nbsp;&nbsp;${notice.hit }
   </td>
   
   </tr>
   
   <tr>
   <td>
     <textarea rows="20" cols="80"  name="content" disabled >${notice.content }</textarea>
   </td>  
   </tr>
    <tr  id="tr_btn"    >
   <td>
        <c:if test="${isLogOn == true and memberInfo.member_id =='admin' }">
   <a style='cursor:pointer;' onClick="fn_remove_bno" 
   		href='<c:url value="/admin/notice/removeNotice.do?bno=${notice.bno }&page=${scri.page }
   														&perPageNum=${scri.perPageNum }"/>'> 삭제</a>      	
   <a style='cursor:pointer;' 
   		href='<c:url value="/admin/notice/modifyNoticeForm.do?bno=${notice.bno }&page=${scri.page }&perPageNum=${scri.perPageNum }"/>'> 수정</a>
	    </c:if>	    
	    <br>
	      	<a style='cursor:pointer;'
	      	 href='<c:url value='/admin/notice/noticeList.do?page=${scri.page }
	      	 							&perPageNum=${scri.perPageNum }
	      	 							&searchType=${scri.searchType}
	      	 							&keyword=${scri.keyword}'/>'>목록으로</a>
   </td>
  </tr>
  </table>
  </form>
  <form name="readForm" role="form" method="post">
  	<input type="hidden" id="bno" name="bno" value="${notice.bno}" />
  	<input type="hidden" id="page" name="page" value="${scri.page}"> 
  	<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
  	<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  	<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
</form>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
 <script type="text/javascript">
 function fn_remove_bno(url,bno){
	 var form = document.createElement("form");
	 form.setAttribute("method", "get");
	 form.setAttribute("action", url);
     var bnoInput = document.createElement("input");
     bnoInput.setAttribute("type","hidden");
     bnoInput.setAttribute("name","bno");
     bnoInput.setAttribute("value", bno);
	 
     form.appendChild(bnoInput);
     document.body.appendChild(form);
     form.submit();
 
 }
 </script>
</body>
</html>