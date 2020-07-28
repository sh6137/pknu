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
<script type="text/javascript" src="../easyui/datagrid-filter.js"></script>

<script>

		var editIndex = undefined;
        function endEditing(){
            if (editIndex == undefined){return true}
            if ($('#dg').datagrid('validateRow', editIndex)){
                $('#dg').datagrid('endEdit', editIndex);
                editIndex = undefined;
                return true;
            } else {
                return false;
           }
        }



		    function onClickCell(index, field){
	            if (editIndex != index){
	                if (endEditing()){
	                    $('#dg').datagrid('selectRow', index)
	                            .datagrid('beginEdit', index);
	                    var ed = $('#dg').datagrid('getEditor', {index:index,field:field});
	                    if (ed){
	                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
	                    }
	                    editIndex = index;
	                } else {
	                    setTimeout(function(){
	                        $('#dg').datagrid('selectRow', editIndex);
	                    },0);
	                }
	            }
	        }
			function onEndEdit(index, row){
	            
	            var ed = $(this).datagrid('getEditor', {
	               index: index,
	               field: 'stu_id'
	               });
	            
	            row.stu_name = $(ed.target).combobox('getText');
	                    
	            var ed2 = $(this).datagrid('getEditor', {
	                index: index,
	                field: 'sub_id'
	            });
	            
	            row.sub_name = $(ed2.target).combobox('getText');
	            
	            if(row.status != "P") {
	               row.status = "U";   
	            }
	        
	        }

	        function append(){
	        	            if (endEditing()){
	        	                $('#dg').datagrid('appendRow',{status:'P'});
	        	                editIndex = $('#dg').datagrid('getRows').length-1;
	        	                $('#dg').datagrid('selectRow', editIndex)
	        	                        .datagrid('beginEdit', editIndex);
	        	            }
	        	        }
	        
	        function removeit(){
	        	            if (editIndex == undefined){return}
	        	            $('#dg').datagrid('cancelEdit', editIndex)
	        	                    .datagrid('deleteRow', editIndex);
	        	            editIndex = undefined;
	        	        }

	        
	        function acceptit(){
	        	            if (endEditing()){
	        	                $('#dg').datagrid('acceptChanges');
	        	            }
	        	        }

	        function getChanges(){
	        	            var rows = $('#dg').datagrid('getChanges');
	        	            alert(rows.length+' rows are changed!');
	        	        }
	        
	        function reject(){
	        	            $('#dg').datagrid('rejectChanges');
	        	            editIndex = undefined;
	        	        }
	        

</script>


<!-- url: '../01_Stuents/Datas/getTimeList.jsp', -->
</head>
<body>
<table id="dg" class="easyui-datagrid" title="학생별 시간표 리스트" style="width:100%;height:300px"
            data-options="
                iconCls: 'icon-edit',
                singleSelect: true,
                url: '../Students',
                method: 'get',
                onClickCell: onClickCell,
                onEndEdit: onEndEdit,
                toolbar : '#tb'
            ">
            
			<thead>
            <tr>
                <th data-options="field:'stu_id',width:'20%',
                        formatter:function(value,row){
                            return row.stu_name;
                        },
                        editor:{
                            type:'combobox',
                            options:{
                                valueField:'stu_id',
                                textField:'stu_name',
                                method:'get',
                                url:'../01_Stuents/Datas/getStuCom.jsp',
                                required:true
                            }
                        }">학생</th>
                
                <th data-options="field:'sub_id',width:'20%',
                        formatter:function(value,row){
                            return row.sub_name;
                        },
                        editor:{
                            type:'combobox',
                            options:{
                                valueField:'sub_id',
                                textField:'sub_name',
                                method:'get',
                                url:'../01_Stuents/Datas/getSubCom.jsp',
                                required:true
                            }
                        }">과목</th>
                <th data-options="field:'do_year', width:'15%', align:'right', editor:'textbox'">년도</th>
                <th data-options="field:'semester',width:'15%', align:'right', editor:{type:'numberbox',options:{precision:2}}">학기</th>
                <th data-options="field:'reg_date',width:'25%', align:'center', editor:'textbox'">신청날짜</th>
         
         		<th data-options="field:'o_do_year', hidden:true, align:'center', editor:'textbox'"></th>
                <th data-options="field:'o_semester',hidden:true, align:'center', editor:'textbox'"></th>
                <th data-options="field:'o_reg_date',hidden:true, align:'center', editor:'textbox'"></th>
                <th data-options="field:'o_do_year', hidden:true, align:'center', editor:'textbox'"></th>
                <th data-options="field:'o_semester',hidden:true, align:'center', editor:'textbox'"></th>
                <th data-options="field:'status',width: '15%', align:'center', editor:'textbox'">상태</th>          
               
            
            </tr>
        </thead>
            
</table>            


	<div id="tb" style="height:auto">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="acceptit()">Accept</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
    </div>








</body>
</html>