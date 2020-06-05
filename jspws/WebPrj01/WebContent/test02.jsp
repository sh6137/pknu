<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Click Me Get Time</title>
<style type="text/css">
	#box{
		width:200px;
		height:200px;
		background-color: 'yellow';
		border: 1px solid;
	}
</style>
<script type="text/javascript">
	function btnClick(){
		var today = new Date();
		alert(today);
		document.getElementById('demo').innerHTML = today;
		
	}
	function bulb_onoff(press){
		if (press == 'on') {
			
		}
	}
	function chgBgColor(bgColor) {
		var box = document.getElementById();
		box.style.backgroundColor
	}
</script>

</head>
<body>
		<button onclick="alert(2)">Click Me Get Time</button>
		<div id = "demo"></div>
		<button id ="btnOn" onclick="bulb_onoff(on)">on</button>
		<button id ="btnOff" onclick="bulb_onoff(off)">off</button>
		<hr>
		<button id ="btnVisible" onclick = "imgView(1)">Visible</button>
		<button id ="btnInVisible" onclick = "imgView(0)">InVisible</button>
		<hr>
		<button id = "btnBgColorBlue" onclick = "chgBgColor('blue')">blue</button>
		<button id = "btnBgColorRed" onclick = "chgBgColor('red')">Red</button>
		<div id = "box">fgfdsgdfg</div>
</body>
</html>