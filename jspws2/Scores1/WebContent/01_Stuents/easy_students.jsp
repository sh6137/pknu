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
<script type="text/javascript" src="/easyui/datagrid-filter.js"></script>
<script type="text/javascript" src="../js/students.js?v=1"></script>

<script>
	$(document).ready(
		function(){
			$("#btnSearch").click(
				function(){
					$('#dg').datagrid({
						    url:'./Datas/getSelStudent.jsp?stu_id=' + $("#stu_id").val(),
						    singleSelect:true,
						    rowStyler : function(index, row){
	            				
	            				if(row.stu_name.indexOf('홍') == -1){
	            					return 'background-color:pink;'
	            				}
	            				
	            			}
							,
							checkOnSelect : true,
							selectOnCheck : false,
							singleSelect : true
						});

				}		
			);
			

					
			
			
		}		
	);
	
	
	var toolbar = [{
		            text:'추가',
		            iconCls:'icon-add',
		            handler:function(){alert('add')}
		        },'-',{
		            text:'복사',
		            iconCls:'icon-cut',
		            handler:function(){alert('cut')}
		        },'-',{
		            text:'저장',
		            iconCls:'icon-save',
		            handler:function(){alert('save')}
		        }];
	
	
	
	
	
	
	
	
	
	
	        
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
	                  field: 'addr3'
	              });
	              row.txt = $(ed2.target).combobox('getText');	
			              
		        }
	
	
	
	
				function acceptit(){
		        if (endEditing()){
		        	var rows = $('#dg').datagrid('getChanges');
		        	
		        	for(var i=0;i<rows.length;i++){
		        			var j = JSON.stringify(rows[i]);
		        			alert(j);
		        	}
		  
		        	
		        	
		        	
		                $('#dg').datagrid('acceptChanges');
		            }
		        }
				
		        function reject(){
		            $('#dg').datagrid('rejectChanges');
		            editIndex = undefined;
		        }
		        
		        function getChanges(){
		        	
		            var rows = $('#dg').datagrid('getChanges');
		            //alert(rows[0].stu_name);
		        }
	
	
	

	
	
</script>

</head>
<body>
    <h2>Basic DataGrid</h2>
    <p>The DataGrid is created from markup, no JavaScript code needed.</p>
    <div style="margin:20px 0;"></div>
    <div >
    	<input class="easyui-textbox" name="stu_id" id="stu_id"/>
    	<input type="button" id="btnSearch" value="검색" />
    </div>
    <table id="dg" class="easyui-datagrid" title="Basic DataGrid" style="width:800px;height:250px"
            data-options="
            			singleSelect:false,
            			collapsible:true,
            			url:'./Datas/getSelStudent.jsp',
            			method:'get',
            			rownumbers : true,
            			
            			rowStyler : function(index, row){
            				
            				if(row.stu_name.indexOf('홍') == -1){
            					return 'background-color:blue;'
            				}
            				
            			}
            			,
            			checkOnSelect : true,
            			selectOnCheck : true,
            			toolbar : '#tb',
            			
            			onClickCell : onClickCell,
            			onEndEdit: onEndEdit
            			      			
            			">
        <thead>
            <tr>
            	<th data-options="field:'ck',checkbox:true"></th>
                <!-- <th data-options="field:'stu_id',width:80">아이디</th> -->       
                <th data-options="field:'stu_id',width:100,
                	formatter:function(value,row){
                			
                            return row.stu_name;
                        },
                
                	editor:{
                            type:'combobox',
                            options:{
                                valueField:'stu_id',
                                textField:'stu_name',
                                method:'get',
                                url:'./Datas/getSelStudent.jsp',
                                required:true
                           }
                      }">이름</th>
                <th data-options="field:'stu_tel',width:100,align:'right', editor:'textbox'">연락처</th>
                <th data-options="field:'addr3',width:100,
                	formatter:function(value,row){
                	 		
                           return row.addr3_val;
                        },
                
                	editor:{
                            type:'combobox',
                            options:{
                                valueField:'val',
                                textField:'txt',
                                method:'get',
                                url:'./Datas/getAddr.jsp?addr=&lvl=1',
                                required:true
                           }
                      }">시, 도</th>
                <th data-options="field:'addr1',width:80">구, 군</th>
                <th data-options="field:'addr1',width:80,align:'center'">동, 면</th>
                <th data-options="field:'addr4',width:80,align:'center'">기타</th>
                <th data-options="field:'dept1',width:100,align:'center'">단과대학</th>
                <th data-options="field:'dept2',width:100,align:'center'">학과</th>
              
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