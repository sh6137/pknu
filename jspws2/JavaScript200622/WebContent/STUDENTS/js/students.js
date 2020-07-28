/**
 * 20200630
 */
//0. ajax common function
	var setAjax = function (strURL, strType, strData, strDataType) {
		
		$ajax({
			url : strURL,
			type : strType,
			data : strData,
			datatype : strDataType,
			success: function(index, item){
				alert(item[0].sid);
				return item;
			}
			,
			error : function(){
				alert("error");
			}
		})
		.done(
				function() {
					alert(2);
				}
		)
	}
//1.학생조회함수



var getList = function (strURL, strType, strData, strDataType) {
	var studentList = setAjax(strURL, strType, strData, strDataType);
	var strHTML = "";
	$.each(studentList,
		function (index,item) {
		
		strHTML+="<div id = 'rows'>";
		strHTML+=	"<div id = 'sid' class='sTd'>";
		strHTML+=			item.sid ;
		strHTML+=	"</div>"
		strHTML+=	"<div id = 'sname' class='sTd'>";
		strHTML+=			item.sname;
		strHTML+=	"</div>";
		strHTML+=	"<div id ='sage'class='sTd'>";
		strHTML+=			item.sage;
		strHTML+=	"</div>";
		strHTML+="</div>";
		}
			
	);
	
}

//1.학생조회함수
var getList_arr = function (arrParams) {
	var studentList = setAjax(arrParams[0], arrParams[1], arrParams[2], arrParams[3]);
	var strHTML = "";
	$.each(studentList,
		function (index,item) {
		
		strHTML+="<div id = 'rows'>";
		strHTML+=	"<div id = 'sid' class='sTd'>";
		strHTML+=			item.sid ;
		strHTML+=	"</div>"
		strHTML+=	"<div id = 'sname' class='sTd'>";
		strHTML+=			item.sname;
		strHTML+=	"</div>";
		strHTML+=	"<div id ='age'class='sTd'>";
		strHTML+=			item.sage;
		strHTML+=	"</div>";
		strHTML+="</div>";
		}
			
	);
	return strHTML;
}

//1.학생조회함수 - 객체
var getList_arr = function (objParams) {
	var studentList = setAjax(objParams.strURL,
			objParams,strType, objParams.strData,
			objParams.strDataType);
	var strHTML = "";
	$.each(studentList,
		function (index,item) {
		
		strHTML+="<div id = 'rows'>";
		strHTML+=	"<div id = 'sid' class='sTd'>";
		strHTML+=			item.sid ;
		strHTML+=	"</div>"
		strHTML+=	"<div id = 'sname' class='sTd'>";
		strHTML+=			item.sname;
		strHTML+=	"</div>";
		strHTML+=	"<div id ='age'class='sTd'>";
		strHTML+=			item.sage;
		strHTML+=	"</div>";
		strHTML+="</div>";
		}
			
	);
	return strHTML;
}


