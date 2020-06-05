<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
   window.onload = function() {
	   var div1 = document.getElementById('div1');
	   var msg  = '';
	   
	   //          0 1 2 3 4567890123 4 567890123 
	   var str1 = '대한민국1234aBCde한글 12English  12\nenglish';
	   msg +=  "str1:"         + str1                    + '<br>';
	   msg += '문자열길이:'    +  str1.length            + '<br>'; // unicode
	   msg += '대문자로:'      + str1.toUpperCase()      + '<br>';
	   msg += '소문자로:'      + str1.toLowerCase()      + '<br>';
	   msg += '한글의 위치는:' + str1.indexOf('한글')    + '<br>';
	   var pos1 =  str1.indexOf('12'); 
	   msg += '앞에서 찾을때 12의 위치는:'  
	          +  pos1   + '<br>';    // 4
	   msg += '앞에서 찾을때 두번째 12의 위치는:'  
	          + str1.indexOf('12', pos1+1 )    + '<br>';  // 16
	   msg += '뒤에서 찾을때 12의 위치는:'  
	          + str1.lastIndexOf('12')    + '<br>';   // 27	  
	   msg += '문자열 추출(substring)' + str1.substring(8, 15)   + '<br>';        
	   msg += '문자열 추출(substr)'    + str1.substr(8, 7 )   + '<br>';        
	   
	   msg += '문자열 교체(replace)'   + str1.replace('English', '영어' )   + '<br>';
	   // 정규식 이용하여 여러번 교체가능하게 한다  \
	   //  교체할 문자열 앞뒤로  /교체할 문자열/옵션 
	   //  g  : global match) (모든 바꾸기)
	   //  i  : ignore case	   
	   //  m  : multi line	   
	   msg += '문자열 교체(replace)'   + str1.replace(/English/gim, '영어' )   + '<br>';
	  //             01234567890       
	   var  str2  = "HELLO wORLD";	   
	   msg  += '문자추출:'     + str2.charAt(6) + '<br>' ; 
	   msg  += '문자코드추출:' + str2.charCodeAt(6) + '<br>' ;
	   msg  += '문자추출:'     + str2[6] + '<br>' ;  // str2[6] = 'W'; (불가능)
	   var str3     = 'a_b_c_d_e_f_g';
	   var str3_arr = str3.split('_'); 
	   msg  += '문자열을 배열로:'   + str3_arr + '|' 
	        + str3_arr[3] + '<br>' ; 
	   
	   div1.innerHTML  = msg;
	          
	          
	   
   }
</script>
</head>
<body>
 <h2>문자열 조작함수들</h2>
 <div id="div1"></div>
</body>
</html>