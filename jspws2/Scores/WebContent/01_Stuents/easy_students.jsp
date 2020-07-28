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
							singleSelect : true,
							onClickCell : onClickCell()
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
	
	 function acceptit(){
         if (endEditing()){
             $('#dg').datagrid('acceptChanges');
         }
     }
     function reject(){
         $('#dg').datagrid('rejectChanges');
         editIndex = undefined;
     }
     function getChanges(){
         var rows = $('#dg').datagrid('getChanges');
         alert(rows.length+' rows are changed!');
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
            			sortName : 'stu_name',
            			sortOrder : 'asc',
            			onClickCell:onClickCell       			
            			">
        <thead>
            <tr>
            	<th data-options="field:'ck',checkbox:true"></th>
                <th data-options="field:'stu_id',width:80">아이디</th>       
                <th data-options="field:'stu_name',width:100">이름</th>
                <th data-options="field:'stu_tel',width:100,align:'right'">연락처</th>
                <th data-options="field:'addr1',width:80,align:'right'">시, 도</th>
                <th data-options="field:'addr2',width:80">구, 군</th>
                <th data-options="field:'addr3',width:80,align:'center'">동, 면</th>
                <th data-options="field:'addr4',width:80,align:'center'">기타</th>
                <th data-options="field:'dept1',width:100,align:'center'">단과대학</th>
                <th data-options="field:'dept2',width:100,align:'center'">학과</th>
              
            </tr>
        </thead>
    </table>
    
    <table class="easyui-datagrid" title="Basic DataGrid" style="width:800px;height:250px"
            data-options="
            			singleSelect:true,
            			collapsible:true,
            			url:'./Datas/getSelStudent.jsp',
            			method:'get'
            			">
        <thead>
            <tr>
                
                <th data-options="field:'stu_id',width:80, sortable:true" >아이디</th>
                <th data-options="field:'stu_name',width:100,
                formatter:function(value,row){
                            return row.stu_name;
                        },
                editor : {
                   type:'combobox',
                   options:{
                      valueField:'stu_name',
                      textField:'stu_name',
                      method:'get',
                      url:'./Datas/getStudents.jsp',
                      required:true
                      
                   }
                   
                
                
                }
                
                ">이름</th>
                <th data-options="field:'stu_tel',width:100,align:'right'">연락처</th>
                <th data-options="field:'stu_name',width:100,
                formatter:function(value,row){
                            return row.stu_name;
                        },
                editor : {
                   type:'combobox',
                   options:{
                      valueField:'stu_name',
                      textField:'stu_name',
                      method:'get',
                      url:'./Datas/getStudents.jsp',
                      required:true
                      
                   }
                   
                
                
                }
                
                ">시, 도</th>
                <th data-options="field:'addr2',width:80">구, 군</th>
                <th data-options="field:'addr3',width:80,align:'center'">동, 면</th>
                <th data-options="field:'addr4',width:80,align:'center'">기타</th>
                <th data-options="field:'dept1',width:100,align:'center'">단과대학</th>
                <th data-options="field:'dept2',width:100,align:'center'">학과</th>
              
            </tr>
        </thead>
    </table>    
    
    
    <div id="tb">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">Remove</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">Save</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut',disabled:true">Cut</a>
        <a href="#" class="easyui-linkbutton">Text Button</a>

	</div>

</body>
</html>