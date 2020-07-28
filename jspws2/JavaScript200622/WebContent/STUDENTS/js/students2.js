

	var getList_obj  = function(objParams){
		
		//1. ajax 연결해서 데이터 가져오기
		$.ajax({
			
			url : objParams.strURL,
			type : objParams.strType,
			data : objParams.strData,
			datatype : objParams.strDataType,
			
			success : function(datas){
				
				var strHTML = "";
				$.each(datas,
						function(index,item){
							strHTML += "<div id='rows'>";
							strHTML += 	"<div id='sid' class='sTd'>";
							strHTML += 	item.sid
							strHTML += 	"</div>";
							strHTML += 	"<div id='sname' class='sTd'>";
							strHTML += 	item.sname
							strHTML += 	"</div>";
							strHTML += 	"<div id='sage' class='sTd'>";
							strHTML += 	item.sage
							strHTML += 	"</div>";
							strHTML += "</div>";
						}
				);
				
				$(objParams.objHTML).html(strHTML);
				
			}
			,
			error : function(){
				
			}
			
			
		})
		.done(
				function(){
					
				}
		);
		
		//2. html을 잘만들어서 리턴
		
	} 