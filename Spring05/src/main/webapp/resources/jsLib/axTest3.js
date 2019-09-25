$(function(){
	$('#jsloginf').click(function(){
		$.ajax({
			type:'Post',
			url:'loginf',
			success:function(result){
				$('#resultArea').html(result);
			} // success
		}); //ajax 
	});//click
	
// JsonView_Ajax Login 처리	
	$('#jslogin').click(function(){
		$.ajax({
			type:'Post',
			url:'jslogin',
			data: {
				id:$('#id').val(),
				password:$('#password').val()
			},
			success:function(data){
				if (data.code==200) {
					//로그인 후 home 새로고침
					location.reload();
					//$('#resultArea').html('');
					alert("~~ 로그인 성공 ~~");
				}else if (data.code==201) {
					alert("~~ 로그인 실패 ~~");
				}
			} // success
		}); // ajax
	}); // click	

// JsonView_Ajax bDetail 처리 (미리보기)?
	$('.ct').hover(function() {
		var index=$(this).attr('id');
		var seq=$('#seq'+index).html(); 
		console.log('속성 추출 Test index=>'+index);
		console.log('속성 추출 Test seq=>'+seq);
		$.ajax({
			type:'Get',
			data: {
				seq:seq },
			url:'jsbdetail',
			success:function(data){
				$('.result').html('');
				$('#result'+index).html(data.content);
			} // success
		}); // ajax
		
		}, function() {
			var index=$(this).attr('id');
			$('#result'+index).html('');
	}); // hover
	
	
}); // ready