

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
				
				$("#" + objID).addClass("easyui-combobox");
			}
			,
			error : function(){
				alert("erreeeeegetAddr");
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
				alert("errgetDept");
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
							
							var str = item.comid1 + "-" + item.comid2 + "-" + item.comid3 + "-" + item.comid4;
							var obj = {comid1 : "", comid2 : "", comid3: "", comid4: ""};
							obj.comid1 = item.comid1
							obj.comid2 = item.comid2
							obj.comid3 = item.comid3
							obj.comid4 = item.comid4
							console.log(str);
							strHTML += "<div class='list'>";
							strHTML += "<div><input type='checkbox' id='chk" + index + "' name='chk' value='" + item.stu_id + "' class='cchk'/></div>"
							strHTML += "<div class='cid'>" + item.stu_id + "</div>";
							strHTML += "<div class='cname'>" + item.stu_name + "</div>";
			//strHTML += "<div class='cname'><input type='text' id='sName' value='" + item.stu_name + "' /></div>"
							strHTML += "<div class='ctel'>" + item.stu_tel + "</div>";
							//strHTML += "<div class='caddr' ondblclick='pop(\"" + str + "\")'>" + item.stu_addr + "</div>";
							strHTML += "<div class='caddr' ondblclick='pop(\"" + str + "\")'>" + item.stu_addr + "</div>";
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
	
	
	var pop = function(comIDs){
		
		//var arrComID = comIDs.split("-");
		
		window.open("./students_addr_update.jsp?param=" + comIDs,"","width:500px;height:50px");
	}
	
	

	//checkbox 전체 체크 및 해제
	var checkedFunc = function(num){
		
		//alert($(".cchk").length);
		
		/*
		$(".cchk").each(
				function(index, item){
					
					if(num == 1){
						$(".cchk").prop("checked", true)
					}
					else{
						$(".cchk").prop("checked", f)
					}
					
				}
		);
		*/
		if(num == 1){
			$(".cchk").prop("checked", true)
		}
		else{
			$(".cchk").prop("checked", false)
		}
		
		
		
	}//
	
	
	var delStudent = function(){
		var checkedObj =  $("input[type='checkbox']:checked");		
		
		 var stuIDArr = [];
		   for (var i = 0; i < checkedObj.length; i++) {
		      var obj = {};
		      obj.stu_id = checkedObj[i].value;
		      stuIDArr[i] = obj;
		   }

		var sendData = JSON.stringify(stuIDArr);

		
		$.ajax({
			url : "./Datas/delStudents.jsp",
			data : "jsonData="+ sendData,
			type : "post",
			datatype : "json",
			success: function(datas) {
				alert("aa");
				location.reload();
			},
			error : function() {
				alert("에러delstudent");
			}
			
			
		});
		console.log(results);
		
	}
	
	var modStudent = function(chkVal){
		location.href = "students_mod.jsp?chkVal=" + chkVal;
		alert(12321);
	}
	
	var getSelStudent = function(stu_id){
		var returnData = null;
		$.ajax({
			url : "./Datas/getSelStudent.jsp",
			data : "stu_id=" + stu_id,
			type : "get",
			datatype : "json",
			async : false,
			success : function(datas) {
				returnData = datas[0];
			}
			,
			error : function(){
				alert("getSelStudenterror");
			}
		});
		return returnData;
	}

	
	var getAddr2 = function(selectedVal, lvl, objID, sVal){
		
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
				
				$("#addr" + lvl.toString()).val(sVal);
				
			}
			,
			error : function(){
				alert("getAddr2");
			}
		});
		
	}
	
	//학생학과 가져오기
	var getDept2 = function(selectedVal, lvl, objID){
		
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
				alert("errgetDept");
			}
		});
		
	}	
	
