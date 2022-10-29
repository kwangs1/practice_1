<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page import = "java.util.Calendar" %>
<%
  String Date = new java.text.SimpleDateFormat("yyyy. MM. dd").format(new java.util.Date());
  String Today = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table td {
  width:155px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #fff;
  }
</style>
</head>
<body>
<h1>　</h1>
	<form method="post"   action="${contextPath}/admin/notice/addNewNotice.do">
	<table align="center">
	   <tr>
	       <td align="right">제목</td>
	       <td colspan="2"><input type="text" size="30"  maxlength="500" name="title" /></td>
	   </tr>
	   <tr>
	       <td align="right">부서명</td>
	       <td><select  name="department">
							<option>없음</option>
							<option value="학예연구실">학예연구실</option>
							<option value="현대미술관">현대미술관</option>
							<option value="홍보담당관">홍보담당관</option>
			</select>
			<input type="checkbox" name="pin" id="pin" value=1>메인공지사항
			</td>
	   </tr>
	   <tr>
	       <td align="right">전화번호</td>
	       <td colspan="2"><input type="text" size="15"  maxlength="500" name="tel" /></td>
	    </tr>
	    <tr>
	       <td align="right">작성자</td>
	       <td colspan=2  align="left">
	       	<input type="text" size="10" maxlength="100" name="writer" value="${memberInfo.member_name}"readonly/> 
	       </td>
	    </tr>
	    <tr>
	        <td align="right">내용</td>
	       <td colspan=2><textarea name="content" rows="10" cols="65" maxlength="4000"></textarea> </td>
	    </tr>
	    <tr>
	       <td><p>&nbsp;</p></td>
	       <td align="right"><input type="submit" value="작성"></td>
	    </tr>
	</table>
	</form>
</body>
</html>