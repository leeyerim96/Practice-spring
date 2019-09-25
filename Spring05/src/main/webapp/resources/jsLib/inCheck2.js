
   
   var iCheck=false ;
   var pCheck=false ;
   var nCheck=false ;   
   var ppCheck=false;
   var wCheck=false;
   var bCheck=false;
   var idCheck=false;
   var pwCheck=false;


   $(function() {
      
         
        
       var password='';
       // password
       $('#password').focusout(function() {
          password=$('#password').val();
          var pLength=password.length;
          if(password.length<1){
        	  $('#pMessage').text('비밀번호를 입력해주세요');
              $('#password').focus();  
              pCheck=false ;
          }
          else if (password.replace(/(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{6,50}$/g,'').length>0) {
               $('#pMessage').text('숫자, 특문 각 1회 이상, 영문은 2개 이상 사용하여 6자리 이상 입력하세요.');
               $('#password').focus();  
               pCheck=false ;
          }else {
               pCheck=true ;
               $('#pMessage').text('') ;
            } 
        }); // password
        
       // password2 와 동일성 확인 기능 추가
       $('#password2').focusout(function() {
          var password2=$('#password2').val();
          //alert("*****pw1,pw2"+password+','+password2);
         
          if (password!=password2) {
               $('#pwMessage').text('password1, 2가 다릅니다~~\정확하게 입력하세요 ~~~');
               $('#password2').focus() ;   
               pwCheck=false;
          }else{
        	  pwCheck=true;
        	  $('#pwMessage').text('');
          };
       
       });// password2
       
       
       
       var name='';
       // name
       $('#name').focusout(function() {
          name=$('#name').val();
          if (name.length<2) {
                $('#nMessage').text('Name을  2글자 이상 정확하게 입력 하세요 ~~') ;
               $('#name').focus() ;   
               nCheck=false ;
          }else if (name.replace(/[가-힣.a-z]/gi,'').length>0) {
                $('#nMessage').text('Name을  한글과 영문으로만 정확하게 입력 하세요 ~~') ;
               $('#name').focus() ;   
               nCheck=false ;
          }else {
               nCheck=true ;
               $('#nMessage').text('') ;
            } 
        }); // name
       
 
       
       // birthday
       $('#birthday').focusout(function() {
          var birthday=$('#birthday').val();
         
          if (weight.length<1 || $.isNumeric(weight)==false) {
                $('#bMessage').text('birthday를 정확하게 입력하세요.') ;
               $('#birthday').focus() ;   
               bCheck=false ;   
              
          }else  {
               bCheck=true ;
               $('#bMessage').text('') ;
            } 
        }); // birthday
       
       
       // pay
       var pay='';
       $('#pay').focusout(function() {
    	 
          pay=$('#pay').val();
          var paLength=pay.length ;
          if (pay.length<1) {
               $('#ppMessage').text('pay를 정확하게 입력하세요 ') ;
               $('#pay').focus() ;   
               ppCheck=false ;
          } else if($.isNumeric(pay)==false || pay.replace('.','').length < paLength) {
        	$('#ppMessage').text('pay 를 정수로 정확하게 입력하세요 ~~~') ;	
    		$('#pay').focus();
    		ppCheck=false ;
          }else {
               ppCheck=true ;
               $('#ppMessage').text('') ;
            }
        }); // pay
           
       // weight
       $('#weight').focusout(function() {
          var weight=$('#weight').val();
            
          if (weight.length<1 || $.isNumeric(weight)==false) {
                $('#wMessage').text('weight를 정확하게 입력하세요.') ;
               $('#weight').focus() ;   
               wCheck=false ;   
               
          }else if(parseFloat(weight)<20 || parseFloat(weight)>200){
      
                $('#wMessage').text('weight의 값이 범위를 벗어납니다.') ;
                $('#weight').focus() ; 
                wCheck=false ;   
                   
          }else  {
               wCheck=true ;
               $('#wMessage').text('') ;
            } 
        }); // weight
           
           
      }) // ready   
      
   // 3) 전체적으로 입력 오류 가 없음을 확인하고 submit 여부를 판단하는 function
      function insertCheck() {
	   	 alert('iCheck'+iCheck+pCheck+nCheck+ppCheck+wCheck+pwCheck+lCheck);
         if (iCheck==true && pCheck==true && nCheck==true && ppCheck==true && wCheck==true && pwCheck==true ) 
             return true;   // submit 진행
         else {
            alert('입력 자료에 오류가 있습니다.~~\n확인 후 전송 버튼을 누르세요 ~~') ;
            return false ; // submit 무효화
         }
      }; // inputCheck

   
   
   