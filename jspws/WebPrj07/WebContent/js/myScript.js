//생성자 함수  : 객체가 만들어짐
	function Student(name, kor, eng, mat) {
		//Field
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}
	
	//method
	Student.prototype.getSum = function(){
		return this.kor  + this.eng + this.mat;
	}
	Student.prototype.getAvg = function() {
		return this.getSum()/3;
	}
	Student.prototype.toString = function(){
		var msg ='';
		msg += '이름 : ' + this.name + '<br>';
		msg += '총점 : ' + this.getSum() + '<br>';
		msg += '평균 : ' + this.getAvg() + '<br>';
		return msg;
	}
	
	window.onload = function(){
		var s1 = new Student('은영1',100,100,100);
		var s2 = new Student('은영2',100,70,60);
		var s3 = new Student('은영3',100,90,100);
		var s4 = new Student('은영4',100,0,100);
		var s5 = new Student('은영5',100,85,90);
		
		console.log(s1);
		var studs = [];
		studs.push(s1);
		studs.push(s2);
		studs.push(s3);
		studs.push(s4);
		studs.push(s5);
		
		var msg ='';
		
		for(var i in studs){
			msg += '<div>'
			msg += studs[i].toString();	
			msg += '</div>'
		}
		//출력
		var divs = document.getElementsByTagName('div');
		divs[0].innerHTML = msg;
		//스타일 지정
		var innerDivs = document.querySelectorAll('div > div');
		console.log(innerDivs);
		innerDivs.forEach(function(value, index, array) {
			var div = value;
			div.style.border='1px solid blue';
			div.style.margin='10px';
			div.style.padding='10px';
			div.style.width='400px';
			div.style.float='left';
			div.style.borderRadius='10px';
			
		});
	}