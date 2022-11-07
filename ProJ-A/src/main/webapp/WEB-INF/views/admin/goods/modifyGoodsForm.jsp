<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="euc-kr"
	isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="goods"  value="${goodsMap.goods}"  />
<c:set var="imageFileList"  value="${goodsMap.imageFileList}"  />


</HEAD>
<style>

</style>
<BODY>
<form  name="frm_mod_goods"  method=post >
<DIV class="clear"></DIV>
	<!-- 내용 들어 가는 곳 -->
	<DIV id="container">
			<DIV>
				<table >
			<tr >
				<td >상품이름</td>
				<td><input name="goods_title" type="text" size="40"  value="${goods.goods_title }"/></td>
				<td>
				 <input  type="button" value="수정반영"  onClick="fn_modify_goods('${goods.goods_id }','goods_title')"/>
				</td>
			</tr>
			
			<tr>
				<td >등록번호</td>
				<td><input name="goods_no" type="text" size="40" value="${goods.goods_no }" /></td>
								<td>
				 <input  type="button" value="수정반영"  onClick="fn_modify_goods('${goods.goods_id }','goods_no')"/>
				</td>
				
			</tr>
			<tr>
				<td >작가</td>
				<td><input name="goods_author" type="text" size="40" value="${goods.goods_author }" /></td>
			     <td>
				  <input  type="button" value="수정반영"  onClick="fn_modify_goods('${goods.goods_id }','goods_author')"/>
				</td>
				
			</tr>
			<tr>
				<td >제작년도</td>
				<td><input name="goods_year" type="text" size="40" value="${goods.goods_year }" /></td>
				<td>
				 <input  type="button" value="수정반영"  onClick="fn_modify_goods('${goods.goods_id }','goods_year')"/>
				</td>
				
			</tr>
			
			<tr>
				<td >재료 및 기법</td>
				<td><input name="goods_stuff" type="text" size="40" value="${goods.goods_stuff }" /></td>
				<td>
				 <input  type="button" value="수정반영"  onClick="fn_modify_goods('${goods.goods_id }','goods_stuff')"/>
				</td>
				
			</tr>
			
			
			<tr>
				<td >작품 규격</td>
				<td><input name="goods_standard" type="text" size="40" value="${goods.goods_standard }" /></td>
				<td>
				 <input  type="button" value="수정반영"  onClick="fn_modify_goods('${goods.goods_id }','goods_standard')"/>
				</td>

			</tr>

			<tr>
				<td >내용</td>
				<td>
				  <input  name="goods_note"  type="text" size="40" value="${goods.goods_note }" />
				</td>
				<td>
				 <input  type="button" value="수정반영"  onClick="fn_modify_goods('${goods.goods_id }','goods_note')"/>
				</td>

			</tr>
						<tr>
							<td>작품종류</td>
							<td><select name="goods_status">
									<option value="collectible">작품</option>
							</select></td>
						</tr>
				</table>	
			</DIV>
			
			
<DIV>
	<form id="FILE_FORM" method="post" enctype="multipart/form-data">
		<h4>상품이미지</h4>
			<table>
				<tr>
					<c:forEach var="item" items="${imageFileList }"  varStatus="itemNum">
			        <c:choose>
			            <c:when test="${item.fileType=='main_image' }">			    
			    <tr>
		
		<td>메인 이미지</td>
			<td>
				<input type="file"  id="main_image"  name="main_image"  onchange="readURL(this,'preview${itemNum.count}');" />
				<input type="hidden"  name="image_id" value="${item.image_id}"  />
			<br>
			</td>
			
			<td>
				<img  id="preview${itemNum.count }"   width=200 height=200 src="${contextPath}/download.do?goods_id=${item.goods_id}&fileName=${item.fileName}" />
			</td>
			
			<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td>
				<input  type="button" value="수정"  onClick="modifyImageFile('main_image','${item.goods_id}','${item.image_id}','${item.fileType}')"/>
				  
			</td> 
				</tr>
			 </c:when>
			  </c:choose>		
			    </c:forEach>
			    </tr>			    
	</table>
	<input type="button" value="수정 완료" onClick="javascript:history.back();" />
	</form>
	</DIV>
	</DIV>
					
</form>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<c:choose>
<c:when test='${not empty goods.goods_status}'>
<script>
window.onload=function()
{
	init();
}

function init(){
	var frm_mod_goods=document.frm_mod_goods;
}
</script>
</c:when>
</c:choose>
<script type="text/javascript">
function fn_modify_goods(goods_id, attribute){
	var frm_mod_goods=document.frm_mod_goods;
	var value="";
	if(attribute=='goods_title'){
		value=frm_mod_goods.goods_title.value;
		location.reload();
	}else if(attribute=='goods_no'){
		value=frm_mod_goods.goods_no.value;
		location.reload();
	}else if(attribute=='goods_author'){
		value=frm_mod_goods.goods_author.value;
		location.reload();
	}else if(attribute=='goods_year'){
		value=frm_mod_goods.goods_year.value;
		location.reload();
	}else if(attribute=='goods_stuff'){
		value=frm_mod_goods.goods_stuff.value;
		location.reload();
	}else if(attribute=='goods_standard'){
		value=frm_mod_goods.goods_standard.value;
		location.reload();
	}else if(attribute=='goods_note'){
		value=frm_mod_goods.goods_note.value;
		location.reload();
	}

	$.ajax({
		type : "post",
		async : false, //false인 경우 동기식으로 처리한다.
		url : "${contextPath}/admin/goods/modifyGoodsInfo.do",
		data : {
			goods_id:goods_id,
			attribute:attribute,
			value:value
		},
		success : function(data, textStatus) {
			if(data.trim()=='mod_success'){
				alert("상품 정보를 수정했습니다.");
				window.location.reload();
			}else if(data.trim()=='failed'){
				alert("다시 시도해 주세요.");	
			}
			
		},
		error : function(data, textStatus) {
			alert("에러가 발생했습니다."+data);
		},
		complete : function(data, textStatus) {
			//alert("작업을완료 했습니다");
			
		}
	}); //end ajax	
}



  function readURL(input,preview) {
	//  alert(preview);
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#'+preview).attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
  }  
  
  function modifyImageFile(fileId,goods_id, image_id,fileType){
    // alert(fileId);
	  var form = $('#FILE_FORM')[0];
      var formData = new FormData(form);
      formData.append("fileName", $('#'+fileId)[0].files[0]);
      formData.append("goods_id", goods_id);
      formData.append("image_id", image_id);
      formData.append("fileType", fileType);
      
      $.ajax({
        url: '${contextPath}/admin/goods/modifyGoodsImageInfo.do',
        processData: false,
        contentType: false,
        data: formData,
        type: 'POST',
	      success: function(result){
	         alert("이미지를 수정했습니다!");
	       }
      });
  }
</script>
	
</BODY>