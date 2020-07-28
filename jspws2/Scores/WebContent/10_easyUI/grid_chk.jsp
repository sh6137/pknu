<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="../easyUI/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyUI/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyUI/demo.css">
	<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script type="text/javascript" src="../easyUI/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyUI/jquery.min.js"></script>
	<script src="../js/students.js"></script>
	<script>
		$(document).ready(){
				function () {
					$("#btnSearch").click(
						function() {
							$('#dg').datagrid({
								
							url : './Datas/getSelStudent.jsp?stu_id'+$("#stu_id").val(),
							singleSelect:true
							
							});
						}	
					);
				}
		};
	</script>

</head>
<body>

	<h2>CheckBox Selection on DataGrid</h2>
    <p>Click the checkbox on header to select or unselect all selections.</p>
<div style="margin:20px 0;"></div>
    <div>
    	<input class = "easyui-textbox" name="stu_id" id = "stu_id">
    	<input type = "button" value="검색">
    </div>
    <table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:500px"
            data-options="
            singleSelect:true,
            collapsible:true,
            <!-- url:'./Datas/getSelStudent.jsp', -->
            url:'../01_Stuents/Datas/getStudents.jsp',
            rownumbers :true,
            sortName : 'addr1',
            rowStyler : function(index,row){
            	if(row.str_name.indexOf('홍')==-1){
            		return 'background-color:blue;'
            	}
            }
            method:'get'">
        <thead>
            <tr>
            	<th data-options="field:'ck',checkbox:true"></th>
                <th data-options="field:'stu_id',width:80">ID</th>
                <th data-options="field:'stu_name',width:100">이름</th>
                <th data-options="field:'stu_tel',width:120,align:'right'">연락처</th>
                <th data-options="field:'stu_addr',width:200,align:'right'">시,도</th>
                <th data-options="field:'stu_dept',width:200">구,군</th>
                <th data-options="field:'comid1',width:80,align:'center'">동,면</th>
                <th data-options="field:'comid2',width:80,align:'center'">기타</th>
                <th data-options="field:'comid3',width:100,align:'center'">단과대학</th>
                <th data-options="field:'comid4',width:100,align:'center'">학과</th>
            </tr>
        </thead>
    </table>
    <div style="margin:10px 0;">
        <span>Selection Mode: </span>
        <select onchange="$('#dg').datagrid({singleSelect:(this.value==0)})">
            <option value="0">Single Row</option>
            <option value="1">Multiple Rows</option>
        </select><br/>
        SelectOnCheck: <input type="checkbox" checked onchange="$('#dg').datagrid({selectOnCheck:$(this).is(':checked')})"><br/>
        CheckOnSelect: <input type="checkbox" checked onchange="$('#dg').datagrid({checkOnSelect:$(this).is(':checked')})">
    </div>

</body>
</html>