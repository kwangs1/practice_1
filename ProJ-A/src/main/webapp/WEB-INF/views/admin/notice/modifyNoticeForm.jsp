<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myspring.Art.Admin.notice.VO.NoticeVO" %>
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
<form method="post"  action="${contextPath}/admin/notice/modifyNotice.do?bno=${notice.bno}&page=${scri.page }&perPageNum=${scri.perPageNum }">
<h1>　</h1>
  <table>
  <tr>
   <td>
    <input type=text id="title" name="title" style="font-size:2.5em; font-weight:700; color:#000; background-color:#D6E6F0;"
    value="${notice.title}" />
   </td>
  </tr>
 
  <tr>
    <td>부서명 &#124; <input type=text id="department" name="department" value="${notice.department}" disabled /> 
    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    전화번호 &#124; <input type=text  id="tel" name="tel" value="${notice.tel }" disabled /></td>
  </tr>
   
   <tr>
   <td>작성자 &#124; <input type=text value="${notice.writer }"  id="writer" disabled />
   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   </td>
   </tr>
   
   <tr>
   <td>
     <textarea rows="20" cols="80"  id="content" name="content"  style=" background-color:#D6E6F0;">${notice.content }</textarea>
   </td>  
   </tr>
    <tr>
   <td>
  	 <input type="hidden" name="bno" value="${notice.bno }">
	 <input type="hidden" name="page" value="${scri.page }">
	 <input type="hidden" name="perPageNum" value="${scri.perPageNum }">
	 <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
  	 <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
	   <input type=button value="▶수정반영하기" style='cursor:pointer;' onClick="fn_enable(this.form)">
	    	<a style='cursor:pointer; color:black'
	      	 href='<c:url value='/admin/notice/noticeList.do?page=${scri.page }
	      	 							&perPageNum=${scri.perPageNum }
	      	 							&searchType=${scri.searchType}
	      	 							&keyword=${scri.keyword}'/>'>▶수정취소</a>
   </td>
  </tr>
  </table>
  </form>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
 <script type="text/javascript">
 function fn_enable(obj){
	 var update = confirm('게시글을 수정 하시겠습니까?');
	 
	 if(update){
		 alert("수정 되었습니다.");
		 
		 document.getElementById("title").disabled=false;
		 document.getElementById("department").disabled=true;
		 document.getElementById("tel").disabled=true;
		 document.getElementById("writer").disabled=true;
		 document.getElementById("content").disabled=false;

		 obj.submit();
	 }else{
		 alert('수정이 취소되었습니다.');
		 
			location.reload(true);
			location.href = location.href;

			history.go(0);
	 }

 }

 </script>
</body>
</html>