<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>

<style>
#container {
	margin: 40px auto;
	width: 100%;
}

ul.tabs {
	list-style: none;
	margin: 0px;
	padding: 0px;
	width: 100%;
	height: 32px;
	border-bottom-color: skyblue;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	float: left;
}

ul.tabs li {
	border-width: 1px;
	border-style: solid;
	border-color: skyblue;
	margin: 0px 1px;
	padding: 0px;
	border-image: none;
	height: 31px;
	line-height: 31px;
	overflow: hidden;
	float: left;
	border-top-left-radius: 7px;
	border-top-right-radius: 7px;
	background-color: rgb(245, 245, 245);
}

ul.tabs li a {
	padding: 0px 20px;
	color: rgb(0, 0, 0);
	font-size: 12px;
	font-weight: bold;
	text-decoration: none;
	display: block;
}

ul.tabs li a:hover {
	background-color: skyblue;
}

ul.tabs li.active {
	background: rgb(255, 255, 255);
	border-color: skyblue;
	border-bottom-width: 2px;
	border-bottom-style: solid;
}

ul.tabs li.active a:hover {
	background: rgb(255, 255, 255);
	border-color: rgb(255, 0, 0) rgb(255, 0, 0) rgb(255, 255, 255);
	border-bottom-width: 2px;
	border-bottom-style: solid;
}

.tab_container {
	background: rgb(255, 255, 255);
	width: 100%;
	clear: both;
	border-top-color: currentColor;
	border-top-width: medium;
	border-top-style: none;
	float: left;
}

.tab_content {
	padding: 10px 10px 20px;
	line-height: 1.8em;
	font-size: 0.75em;
	min-height: 400px;
}

.tab_content h4 {
	background-position: left top;
	margin: 10px 0px;
	padding: 20px 0px 5px 35px;
	height: 30px;
	color: rgb(255, 255, 255);
	letter-spacing: 4px;
	font-family: "NanumGothic", Serif;
	font-size: 16px;
	font-weight: bold;
	background-repeat: no-repeat;
}

.tab_content p {
	margin: 10px 0px 0px;
}

.tab_content img {
	margin: 10px;
	padding: 5px;
}

.tab_content .writer {
	margin: 10px 0px;
	padding: 5px;
	color: rgb(0, 0, 0);
	font-size: 1.2em;
	font-weight: bold;
	border-bottom-color: skyblue;
	border-bottom-width: 1px;
	border-bottom-style: solid;
}
</style>
</head>

<body>
	<form action="${contextPath}/admin/video/addNewVideo.do" method="post" enctype="multipart/form-data">
		<div class="tab_container">
			<!-- 내용 들어 가는 곳 -->
			<div class="tab_container" id="container">
				<ul class="tabs">
					<li><a href="#tab1">작품 등록</a></li>
				</ul>
				<div class="tab_container">
					<div class="tab_content" id="tab1">
						<table>

							<tr>
								<td>작품명</td>
								<td><input name="title" type="text" size="40" /></td>
							</tr>
							<tr>
								<td>작품내용</td>
								<td>
								 <textarea rows="20" cols="60"  name="note"  id="i_note" /></textarea></td>
							</tr>
							<tr>
								<td align="right">영상파일 첨부</td>

								<td align="left"><input type="button" value="영상파일 추가"
									onClick="fn_addFile()" /></td>
								<td>
									<div id="video"></div>
								</td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="clear"></div>

			<table>
				<tr>
					<td align=center>
					 <input type="button" value="상품 등록하기" onClick="fn_add_new_video(this.form);">
					</td>
				</tr>
			</table>

		</div>
	</form>
	
<script type="text/javascript">
  var cnt=0;
  function fn_addFile(){
	  if(cnt == 0){
		  $("#video").append("<br>"+"<input  type='file' name='video' id='f_video' />");	  
	  }
  }
  
  
  function fn_add_new_video(obj){
		 fileName = $('#f_video').val();
		 if(fileName != null && fileName != undefined){
			 obj.submit();
		 }else{
			 alert("영상을 첨부해야 합니다.");
			 return;
		 }
		 
	}
  function goPage() { 
	  location.href="${contextPath}/collectible/collectibleList.do"; 
	}
</script>    
</body>
</html>