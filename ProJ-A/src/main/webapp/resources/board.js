/**
 * 게시판 관련 JS
 */


// Get the modal
var modal = document.getElementById("myModal");

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById("myImg");
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
img.onclick = function(){
  modal.style.display = "block";
  modalImg.src = this.src;
  captionText.innerHTML = this.alt;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none";
} 

//댓글 작성

$(document).on("click", ".replyWriteBtn",function(){
	var Content = $('#content').val();
	var Writer = $('#writer').val();
	var goods_id = $('#goods_id').val();
	
			if(Writer == ""){
				alert("로그인 후 댓글 작성이 가능하십니다.!");
			}			
			if(Writer != "" && Content == ""){
				alert("내용을 입력해주세요.");
			}

			
			var paramData = JSON.stringify(
					{"content": Content
					,"writer" : Writer
					,"goods_id" : goods_id
			});
			var headers = {"Content-Type":"application/json"
				,"X-HTTP-Method-Override":"POST"};
			
			$.ajax({
				url:"../reply/replyWrite.do"
				,headers : headers
				,data : paramData
				,type : 'POST'
				,dataType : 'text'
				,success:function(result){
					window.location.reload();
				}
				,error:function(error){
					console.log("에러:" + error);
					console.log(paramData);
				}
			});//end ajax
			
	});

//댓글 수정 팝업
$(document).on('click', ' .update_reply_btn', function(e){
	e.preventDefault();
	
	var rno = $(this).attr('data-rno');
	var goods_id = $('#goods_id').val();
	var name = $('#writer').val();
	
	let popUrl = "../collectible/getUpdateReply.do?rno=" + rno + "&goods_id=" + goods_id + "&name=" + name;
	let popOption = "width = 490px, height=490px, scrollbars=yes" 

		window.open(popUrl,"리뷰 수정",popOption);
});


//댓글 삭제
function fn_remove_reply(url,rno){
	 var form = document.createElement("form");
	 form.setAttribute("method", "post");
	 form.setAttribute("action", url);
    var RnoInput = document.createElement("input");
    RnoInput.setAttribute("type","hidden");
    RnoInput.setAttribute("name","rno");
    RnoInput.setAttribute("value", rno);
	 
    form.appendChild(RnoInput);
    document.body.appendChild(form);
    form.submit();
}

