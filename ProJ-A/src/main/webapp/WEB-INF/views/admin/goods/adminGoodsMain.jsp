<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="utf-8">
<style>
*{
margin:0 auto;
padding:0 auto;
}
.list_view {
	width: 80%; 
	color: rgb(51, 51, 51); 
	font-size: 0.8em; 
	margin-top: 20px; 
	border-top-color: rgb(51, 51, 51); 
	border-top-width: 2px; 
	border-top-style: solid; 
	border-collapse: collapse;
}

.list_view tr {
	margin: 0px; 
	padding: 10px 0px; 
	border-bottom-color: rgb(153, 153, 153); 
	border-bottom-width: 1px; 
	border-bottom-style: dotted; 
}

  .list_view td {
	margin: 0px; 
	padding: 10px 0px; 
	border-bottom-color: rgb(153, 153, 153); 
	border-bottom-width: 1px; 
	border-bottom-style: dotted;
	border: 1px solid #444444;
}
#search {
	width:100px;
	margin:auto;
	display:block;
	
}
</style>
</head>
<body>
<h1>　</h1>
	<form  method="post">	
</form>	
<DIV class="clear"></DIV>
<TABLE class="list_view">
		<TBODY align=center >
			<tr>
			<td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
				<td>제목</td>
				<td>등록번호</td>
				<td>작가</td>
				<td>제작년도</td>
				<td>재료 및 기법</td>
				<td>작품규격</td>
				<td>내용</td>
			</tr>
   <c:choose>
     <c:when test="${empty newGoodsList }">			
			<TR>
		       <TD colspan=8 class="fixed">
				  <strong>조회된 상품이 없습니다.</strong>
			   </TD>
		     </TR>
	 </c:when>
	 <c:otherwise>
     <c:forEach var="item" items="${newGoodsList }">
			 <TR>       
			 <td><input type="checkbox" name="content" value="${item.goods_id}"/></td>
				<TD>
				  <strong>${item.goods_title}</strong>
				</TD>
				<TD >
				    <strong>${item.goods_no} </strong>
				</TD>
				<TD >
				    <strong>${item.goods_author} </strong>
				</TD>
				<TD>
					<strong>${item.goods_year}</strong> 
				</TD>
				<TD>
					<strong>${item.goods_stuff}</strong> 
				</TD>
				<TD>
					<strong>${item.goods_standard}</strong> 
				</TD>
				<TD>
					<strong>${item.goods_note}</strong> 
				</TD>
				
			</TR>
	</c:forEach>
	</c:otherwise>
  </c:choose>
           <tr>
             <td colspan=8 class="fixed">
                 <c:forEach   var="page" begin="1" end="10" step="1" >
		         <c:if test="${section >1 && page==1 }">
		          <a href="${contextPath}/admin/goods/adminGoodsMain.do?chapter=${section-1}&pageNum=${(section-1)*10 +1 }">&nbsp; &nbsp;</a>
		         </c:if>
		          <a href="${contextPath}/admin/goods/adminGoodsMain.do?chapter=${section}&pageNum=${page}">${(section-1)*10 +page } </a>
		         <c:if test="${page ==10 }">
		          <a href="${contextPath}/admin/goods/adminGooodsMain.do?chapter=${section+1}&pageNum=${section*10+1}">&nbsp; next</a>
		         </c:if> 
	      		</c:forEach> 
     
		</TBODY>
		
	</TABLE>

<DIV id="search">
	<form action="${contextPath}/admin/goods/addNewGoodsForm.do">
		<input   type="submit" style='cursor:pointer; border:none;' value="상품 등록하기">
	</form>
</DIV>

<script>
function selectAll(selectAll){
    const checkbox = document.getElementsByName('content');
    checkbox.forEach((checkbox) => {
        checkbox.checked = selectAll.checked;
    })
}

</script>
</body>
</html>