$(function(){
// 1. Login Form  
   $('#aloginf').click(function(){
      $.ajax({
         type:'Post',
         url:'loginf',
         success:function(result){
            $('#resultArea').html(result);
         } // success
      }); // ajax
   }); // click
// Login 처리   
   $('#alogin').click(function(){
      $.ajax({
         type:'Post',
         url:'login',
         data: {
            id:$('#id').val(),
            password:$('#password').val()
         },
         success:function(result){
            $('#resultArea').html(result);
         } // success
      }); // ajax
   }); // click
   
// 2. Mouse Pointer 모양   
// $('.textLink').hover(function(){..},function(){..});
//                   => function1이 mouse 왔을때, function2 는  mouse 떠날때
   $('.textLink').hover(function(){
      $(this).css({
            color: "gray",
            cursor: "pointer"}); // css종료
   },function(){
      $(this).css({
            color: "red",
            cursor: "default"}); // css종료
   }); //hover     
   
// 4. boardList
   $('#ablist').click(function(){
      $.ajax({
         type:'Get',
         url:'ablist',
         success:function(result){
            $('#resultArea').html(result);
         } // success
      }); // ajax
   }); // click   
   
// 5. Join Form  
   $('#ajoinf').click(function(){
      $.ajax({
         type:'Post',
         url:'joinf',
         success:function(result){
            $('#resultArea').html(result);
         } // success
      }); // ajax
   }); // click
   
// Join 처리   
// Data 처리방법
// 1. Form 의 serialize()
// => 직렬화 : multipart 타입은 제외 시켜야 함.
// 2. 특정 변수에 담기
// -> {...}
// 3. FormData() 객체
// -> append ...
   
   $('#ajoin').click(function(){    
      var formData = new FormData(document.getElementById('myForm'));
       $.ajax({
         type:'Post',
         url:'mjoin',
         data: formData,
         //mimeType:"multipart/form-data",
         processData:false,
         contentType:false,
         success:function(result){
            $('#resultArea').html(result);
         } // success
      }); // ajax
   }); // click   
   
//   id:$('#id').val(),
//   password:$('#password').val(),
//   name:$('#name').val(),
//   lev:$('#lev').val(),
//   birthd:$('#birthd').val(),
//   pay:$('#pay').val(),
//   weight:$('#weight').val()   
   
/*// 6. PopUpLogin
   $('#ploginf').click(function(){
      open('ploginf','_blank',
      'toolbar=no,menubar=yes,scrollbars=yes,resizable=yes,width=600,height=500');
   }); // click   
*/   
 //7. popup으로 계산기
// 6. PopUpLogin
   $('#pcalc').click(function(){
      open('pcalc','_blank',
      'toolbar=no,menubar=yes,scrollbars=yes,resizable=yes,width=600,height=500');
   }); // click  
   
}) // ready