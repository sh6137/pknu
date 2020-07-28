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

<style>
	body{padding:0px;}
	#wrap{width:100%;height:625px; clear:both;}
	.grpcommon{width:40%;height:625px; border:1px solid #aaaaaa;
				 float:left;background-color:#eeeeee;padding:10px;}
	.common{width:60%;height:625px; border:1px solid #aaaaaa; float:left;
			background-color:#eeeeee;padding:10px;}

</style>


<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript" src="../easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/datagrid-filter.js"></script>

<script>

	$(document).ready(
	
		function(){
			
		}
	
	);
	
	
			var editIndex = undefined;
			
	        function endEditing(){
	        	
	            if (editIndex == undefined){return true}
	            if ($('#dg').datagrid('validateRow', editIndex)){
	                $('#dg').datagrid('endEdit', editIndex);
	                editIndex = undefined;
	                return true;  //수정이 끝났어 --> 커서가 수정하는 로우에서 빠져나왔다.
	            } else {
	                return false;
	            }
	        }
	        //니가 수정을 끝냈냐
	
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
	        	 
	        	if(row.status != "P"){
	        		row.status = "U";
	        	}
	        	
	        	if(row.status == "P"){
	        		row.grp_id = "";
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
	        
	        function reject(){
	        	            $('#dg').datagrid('rejectChanges');
	        	            editIndex = undefined;
	                }
	        
	        function removeit(){
	        	            if (editIndex == undefined){return}
	        	            $('#dg').datagrid('cancelEdit', editIndex)
	        	                    .datagrid('deleteRow', editIndex);
	        	            editIndex = undefined;
	        	        }
	        
	        function save(){
	        	if (endEditing()){
	        			        		
	        		var rows = $('#dg').datagrid('getChanges');
	        		/*
	        			[
	        				{grp_id : "", grp_name : "", status : "P"},
	        				{grp_id : "", grp_name : "", status : "U"},
	        				{grp_id : "", grp_name : "", status : ""},
	        				{grp_id : "", grp_name : "", status : "U"}
	        			]
	        		*/
	        		
	        		var appendRows = [];
	        		var updateRows = [];
	        		var deleteRows = [];
	        		
	        		for(var i=0 ;i<rows.length;i++){
	        			
	        			//1.추가
	        			if(rows[i].status == "P"){
	        				appendRows.push(rows[i]);
	        			}
	        			//2.수정
	        			else if(rows[i].status == "U"){
	        				updateRows.push(rows[i]);
	        			}
	        			//3.삭제
	        			else{
	        				deleteRows.push(rows[i]);
	        			}
	        		}
	        		
	        	    $('#dg').datagrid('acceptChanges');
	        	    
	        	    var appendJsons = JSON.stringify(appendRows);
	        	    var updateJsons = JSON.stringify(updateRows);
	        	    var deleteJsons = JSON.stringify(deleteRows);
	        	    
	        	    grpSaveAjax(appendJsons, updateJsons, deleteJsons);
	        	    
	        	    
	        	    
	            }

	        }
	        
	        function getChanges(){
	        	var rows = $('#dg').datagrid('getChanges');
	        	alert(rows.length+' rows are changed!');
	        }


			function grpSaveAjax(appendJsons, updateJsons, deleteJsons){
				
				$.ajax({
					url : "./Datas/saveGrpCom.jsp",
					type : "post",
					data : "append=" + appendJsons + "&update=" + updateJsons + "&delete=" + deleteJsons,
					datatype : "json",
					success : function(datas){
						$('#dg').datagrid();
					}
					,
					error : function(){
						
					}
				});
				
			}
			
			function onSelect(index, row){
				
				var selectedGrpID = row.grp_id;
				
				$("#dg2").datagrid({
						url:'./Datas/getCommons.jsp?grp_id=' + selectedGrpID,
        				method:'get'
				});
			}
			
			
			//////////////////////////////////////////////////////////////////////////////////////
			var editIndex2 = undefined;
			
	        function endEditing2(){
	        	
	            if (editIndex2 == undefined){return true}
	            if ($('#dg2').datagrid('validateRow', editIndex2)){
	                $('#dg2').datagrid('endEdit', editIndex2);
	                editIndex2 = undefined;
	                return true;  //수정이 끝났어 --> 커서가 수정하는 로우에서 빠져나왔다.
	            } else {
	                return false;
	            }
	        }
			
	        function onClickCell2(index, field){
      	            if (editIndex2 != index){
      	                if (endEditing2()){
      	                    $('#dg2').datagrid('selectRow', index)
      	                            .datagrid('beginEdit', index);
      	                    var ed = $('#dg2').datagrid('getEditor', {index:index,field:field});
      	                    if (ed){
      	                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
      	                    }
      	                    editIndex2 = index;
      	                } else {
      	                    setTimeout(function(){
      	                        $('#dg2').datagrid('selectRow', editIndex2);
      	                    },0);
      	                }
      	            }
      	        }	
			
	        function onEndEdit2(index, row){
	        	
	        	if(row.status != "P"){
	        		row.status = "U";
	        		row.parent_id = "";
	        	}
	        	
	        	if(row.status == "P"){
	        		
	        		row.com_id = "";
	        	}
	        }
	        
	        function append2(){
   	            if (endEditing2()){
   	                //$('#dg2').datagrid('appendRow',{status:'P'});
   	                editIndex2 = selectedRow.index;
   	                
   	                
   	                $('#dg2').datagrid('insertRow',{
								index: editIndex2 + 1,	// index start with 0
								row: {
									grp_id: selectedRow.grp_id,
									com_id: '',
									com_val : '',
									com_lvl : selectedRow.com_lvl + 1,
									parent_id : selectedRow.com_id,
									status : 'P'
								}
							});
   	                /*
   	               editIndex2 = $('#dg2').datagrid('getRows').length-1;
   	                $('#dg2').datagrid('selectRow', editIndex2)
   	                        .datagrid('beginEdit', editIndex2);
   	                */
   	                
   	             	
   	             	$('#dg2').datagrid('selectRow', editIndex2 + 1)
   	             			 .datagrid('beginEdit', editIndex2 + 1);
   	            }
   	        }	        
	        
	        
	        var selectedRow = {};
	        
	        function onSelect2(index, row){
	        	selectedRow.index = index;
	        	selectedRow.com_lvl = Number(row.com_lvl);
	        	selectedRow.grp_id = row.grp_id;
	        	selectedRow.com_id = row.com_id
	        }
	        
	        function reject2(){
	            $('#dg2').datagrid('rejectChanges');
	            editIndex2 = undefined;
       		 }
	        
	        function removeit2(){
	            if (editIndex2 == undefined){return}
	            $('#dg2').datagrid('cancelEdit', editIndex2)
	                    .datagrid('deleteRow', editIndex2);
	            editIndex2 = undefined;
	        }
	        
	        function save2(){
	        	
	        	var appendRows = [];
	        	var updateRows = [];
	        	var deleteRows = [];
	        	
	        	var jsonDatas = {};
	        	
	        	if (endEditing2()){ 
	        		
	        		var rows = $('#dg2').datagrid('getChanges');
	        		
	       //{grp_id : "", com_id : "", com_val : "", com_lvl : 2, parent_id : "" , status : "U"}
	        		$.each(rows,
	        			function(index, item){
	        			
	        				if(item.status == "P"){
	        					appendRows.push(item);
	        					//[{}, {}]
	        				}
	        				else if(item.status == "U"){
	        					updateRows.push(item);
	        					//[{}, {}, {}]
	        				}
	        				else{
	        					deleteRows.push(item);
	        					//[{}, {}, {}]
	        				}
	        			
	        			}		
	        		); //each
	        		
	        		jsonDatas.appended = appendRows;
	        		jsonDatas.updated = updateRows;
	        		jsonDatas.deleted = deleteRows;
	        		/*
	        		{
	        			appended : [{}, {}],
	        			updated : [{}, {}, {}],
	        			deleted : [{}, {}, {}]
	        		}
	        		
	        		*/
	        		$('#dg').datagrid('acceptChanges');
	        		var strJSON = JSON.stringify(jsonDatas);
	        		grpSaveAjax2(strJSON);
	        		//alert(strJSON);
	        		
	        	} //if
	        	
	        } //function
	        
	        
			function grpSaveAjax2(JsonDatas){
				
				$.ajax({
					url : "./Datas/saveCommon.jsp",
					type : "post",
					data : "jsonDatas=" + JsonDatas,
					datatype : "json",
					success : function(datas){
						$('#dg2').datagrid();
					}
					,
					error : function(){
						
					}
				});
				
			}
	        
	        
			

</script>

</head>
<body>
	<div id="wrap">
		<div id="grpcommon" class="grpcommon">
		
			<table id="dg" class="easyui-datagrid" title="공통코드 관리" style="width:100%;height:600px"
	            data-options="singleSelect:true,collapsible:true,
	            				url:'./Datas/getGrpCode.jsp',
	            				method:'get',
	            				onClickCell: onClickCell,
                				onEndEdit: onEndEdit,
                				onSelect : onSelect,
	            				toolbar : '#toolbar01'
	            				
	            				">
		        <thead>
		            <tr>
		                <th data-options="field:'grp_id',width:'40%'">GRP코드</th>
		                <th data-options="field:'grp_name',width:'50%', editor:'textbox'">GRP이름</th>	
		                <th data-options="field:'status',width:'10%'"></th>	
		            </tr>
		        </thead>
	   		</table>
			
		</div>
		<div id=common" class="common">

			<table id="dg2" class="easyui-datagrid" title="공통코드 관리" style="width:100%;height:600px"
	            data-options="singleSelect:true,collapsible:true,
	            				onClickCell: onClickCell2,
	            				onEndEdit: onEndEdit2,
	            				onSelect : onSelect2,
	            				toolbar : toolbar02
	            				
	            				">
		        <thead>
		            <tr>
		                <th data-options="field:'grp_id',width:'20%'">GRP코드</th>
		                <th data-options="field:'com_id',width:'20%'">COM코드</th>	
		                <th data-options="field:'com_val',width:'30%', editor:'textbox'">COM이름</th>	
		                <th data-options="field:'com_lvl',width:'7%', editor:'textbox'">단계</th>	
		                <th data-options="field:'parent_id',width:'16%'"></th>
		                <th data-options="field:'status',width:'7%'"></th>	
		            </tr>
		        </thead>
	   		</table>


		</div>
	</div>
	
	<div id="toolbar01" style="height:auto">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">추가</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">삭제</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="save()">저장</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">취소</a>
    </div>	
    
	<div id="toolbar02" style="height:auto">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append2()">추가</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit2()">삭제</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="save2()">저장</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject2()">취소</a>
    </div>	    
	
	
</body>
</html>