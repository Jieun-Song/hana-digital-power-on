/**
 * board.js
 */

function bw_check(){
	$board_name = jQeury.trim($('#board_name').val()); // jQuery는 $를 의미한다
	if($board_name.length == 0){
		window.alert('글쓴이를 입력하세요!');
		$('#board_name').val(''); //글쓴이 입력필드 초기화
		$('#board_name').focus(); //입력필드로 포커스 이동
		return false;
	}
	
	if($.trim($("#board_title").val()) ==""){
		alert("글제목을 입력하세요!");
		$('#board_title').val("").focus();//매서드 체이닝
		return false;
	}
	
	if($.trim($('#board_pwd').val()).length == 0){
		alert('비밀번호를 입력하세요!');
		$('#board_pwd').val('').focus();
		return false;
	}
	
	if($.trim($('#board_cont')).val() == ''){
		alert('글내용을 입력하세요!');
		$('#board_cont').val('').focus();
		return false;
	}
}