


	var getCollege = function(vID){
		
		$.ajax({
			
			url : "./Datas/college_list.jsp",
			type : "get",
			data : "",
			datatype : "json",
			success : function(datas){
				
				var strHTML = "<option value=''>선택하세요</option>";
				$.each(datas,
						
						function(index, item){
							strHTML += "<option value='" + item.com_id + "'>" + item.com_val + "</option>"
						}
						
				);
				
				$("#" +  vID).html(strHTML);
			}
			,
			error : function(){
				alert("error");
			}
			
		});
		
		
	} //
	
	
	
	var getDept = function(selectedValue, vID){
		//alert(selectedValue + " -- " + vID);
		
		$.ajax({
			url : "./Datas/dept_list.jsp",
			type : "get",
			data : "selectedCollege=" + selectedValue,
			datatype : "json",
			success : function(datas){
				
				var strHTML = "<option value=''>선택하세요</option>";
				$.each(datas,
						function(index, item){
							strHTML += "<option value='" + item.com_id + "'>" + item.com_val + "</option>"
						}
				);
				
				$("#" + vID).html(strHTML);
				
				
			}
			,
			error : function(){
				alert("error");
			}
		});
	} //
	
	
	var getStudents = function(selectedValue, vID){
		//alert(selectedValue + " -- " + vID);
		
		$.ajax({
			url : "./Datas/getStudents.jsp",
			type : "get",
			data : "selectedDept=" + selectedValue,
			datatype : "json",
			success : function(datas){
				
				var strHTML = "<option value=''>선택하세요</option>";
				$.each(datas,
						function(index, item){
							strHTML += "<option value='" + item.stu_id + "'>" + item.stu_name + "</option>"
						}
				);
				
				$("#" + vID).html(strHTML);				
				
			}
			,
			error : function(){
				alert("error");
			}
		});
		
	}
	
	
	var getYear = function(vID){
		
		$.ajax({
			url : "./Datas/getYears.jsp",
			data : "",
			type : "get",
			datatype : "json",
			success : function(datas){
				
				var strHTML = "";
				
				$.each(datas, 
						function(index,item){
							strHTML += "<option value='" + item.syear + "'>" + item.syear + "</option>";
						}
				);
				
				$("#" + vID).html(strHTML);
				
				$("#" + vID).val(datas[0].tyear);
			}
			,
			error : function(){
				alert("에러다 메롱!!!!");
			}
		});
		 
	}
	
	
	
	var getSubjects = function(stu_id, syear, ssemester, vID){
		
		$.ajax({
			url : "./Datas/getSubjects.jsp",
			data : "stu_id=" + stu_id + "&syear=" + syear + "&ssemester=" + ssemester,
			type : "get",
			datatype : "json",
			success : function(datas){
				
				var strHTML = "<option value=''>선택하세요</option>";
				
				$.each(
						datas,
						function(index, item){
							strHTML += "<option value='" + item.sub_id + "'>" + item.sub_name + "</option>"
						}
				);
				
				$("#" + vID).html(strHTML);
				
			}
			,
			error : function(){
				
			}
		});
		
	}
	
	
	
	
	
	
	
	
	