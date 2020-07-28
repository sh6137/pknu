

var getSido = function(){
	
		var strHTML = "";
	
		$.ajax({
			
			url : "./Datas/getSido.jsp",
			type : "post",
			//data : "",
			datatype : "json",
			success : function(datas){
				$.each(datas,
						function(index, item){
							strHTML += "<option value='" + item.com_id + "'>" + item.com_val + "</option>"
						}
				);
				
				$("#sido").html(strHTML);
			}
			,
			error : function(){
				
			}
			
		});
	
} 



var getGugun = function(){
	
	var strHTML = "";

	$.ajax({
		
		url : "./Datas/getGugun.jsp",
		type : "post",
		data : "in_Sido=" + $("#sido").val(),
		datatype : "json",
		success : function(datas){
			strHTML += "<select id='sGugun'>"
			$.each(datas,
					function(index, item){
						strHTML += "<option value='" + item.com_id + "'>" + item.com_val + "</option>"
					}
			);
			strHTML += "</select>"
			
			$("#gugun").html(strHTML);
		}
		,
		error : function(){
			
		}
		
	});

} 




	var getAddr = function(selectedVal, lvl, objID){
		
		var strHTML = "";
		
		$.ajax({
			url : "./Datas/getAddr.jsp",
			type : "get",
			data : "addr=" + selectedVal + "&lvl=" + lvl,
			datatype : "json",
			success : function(datas){
				
				strHTML += "<select id='addr" + lvl + "' name='addr" + lvl + "'>";
				strHTML += "<option value='-'>선택하세요</option>"
				$.each(
						datas,
						function(index, item){
							strHTML += "<option value='" + item.val + "'>" + item.txt + "</option>";
						}
				);
				strHTML += "</select>";
					
				$("#" + objID).html(strHTML);
			}
			,
			error : function(){
				alert("err");
			}
		});
		
	}
	
	
	
	
	
	//학생학과 가져오기
	var getDept = function(selectedVal, lvl, objID){
		
		var strHTML = "";
		
		$.ajax({
			url : "./Datas/getDept.jsp",
			type : "get",
			data : "dept=" + selectedVal + "&lvl=" + lvl,
			datatype : "json",
			success : function(datas){
				
				strHTML += "<select id='dept" + lvl + "' name='dept" + lvl + "'>";
				strHTML += "<option value='-'>선택하세요</option>"
				$.each(
						datas,
						function(index, item){
							strHTML += "<option value='" + item.val + "'>" + item.txt + "</option>";
						}
				);
				strHTML += "</select>";
					
				$("#" + objID).html(strHTML);
			}
			,
			error : function(){
				alert("err");
			}
		});
		
	}	
	
	
	var getStudentsList = function(selSearch, txtSearch, objid){
		
		var strHTML = "";
		$.ajax({
			
			url : "./Datas/getStudents.jsp",
			type : "post",
			data : "selSearch=" + selSearch + "&txtSearch=" + txtSearch,
			datatype : "json",
			success : function(datas){
				
				$.each(
						datas,
						function(index, item){
							
							strHTML += "<div class='list'>";
							strHTML += "<div class='cid'>" + item.stu_id + "</div>";
							//strHTML += "<div class='cname'>" + item.stu_name + "</div>
			strHTML += "<div class='cname'><input type='text' id='sName' value='" + item.stu_name + "' /></div>"
							strHTML += "<div class='ctel'>" + item.stu_tel + "</div>";
							strHTML += "<div class='caddr'>" + item.stu_addr + "</div>";
							strHTML += "<div class='cdept'>" + item.stu_dept + "</div>";
							strHTML += "</div>";
							
						}
				);
				
				$("#" + objid).html(strHTML);
				
			}
			,
			error : function(){
				alert("바보야 !!!!");
			}
			
		});
		
	}
	
	
	
	
	



