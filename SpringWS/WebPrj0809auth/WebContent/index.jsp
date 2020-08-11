<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style>
	body { margin:0px; }
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script>
	
	$(function() {
		
		
		$.ajax({
			
			url:"./datas/getMainMenus.jsp",
			type:"GET",
			datatype:"JSON", // 받아올 데이터 타입
			success:function(datas) {
				var strHTML = '';
				strHTML += '<tr>';
				strHTML += '<td width="20%"></td>';
				$.each(datas, function(index, item){
					
					strHTML += '<td width="20%">';
					strHTML += '<a href="javascript:getSubMenus(\'' + item.menuid + '\')">' + item.menuname + '</a></td>';
					
				});
				
				strHTML += '</tr>';
				
				$('#mainMenu').append(strHTML);
				
			},
			error:function() {
				alert('mainmenu err');
			}
			
			
		});
		
	})
	
	function getSubMenus(mainmenuID) {
		
		$.ajax({
			
			url:"./datas/getSubMenus.jsp",
			type:"GET",
			data:"mainmenuID=" + mainmenuID,
			datatype:"JSON", // 받아올 데이터 타입
			success:function(datas) {
				var strHTML = '';
				$.each(datas, function(index, item){
					
					var lvl = (item.menulvl - 2) * 30 + 'px';
					
					strHTML += '<div style="padding-left:' + lvl + '">';
					strHTML += '<a href="./js/01_menus/' + item.pfilename + '" target="mainBody">';
					strHTML += item.menuname;
					strHTML += '</a>';
					strHTML += '</div>';
					
				});
				
				
				$('#subMenus').html(strHTML);
				
			},
			error:function() {
				alert('submenu err');
			}
			
			
		});
		
	}
	

</script>
</head>
<body>
	<!-- top menu 포함 -->
	<table border="1" width="100%" height="40" align="center" id="mainMenu">
	</table>
	<table border="1" width="100%" height="100%" align="center">
		<tr>
			<td width="20%">
				<div id="subMenus"></div>
			</td>
			<td width="80%" height="100%">
				<iframe style="width:100%; height:100%; border:3px solid red;" name="mainBody" ></iframe>
			</td>
		</tr>
	</table>
</body>
</html>