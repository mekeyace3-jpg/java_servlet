//동기화 통신으로 적용된 스크립트
function gopage(){	//회원가입 시 적용되는 함수
	return false;
}
function ajax_data() {	//아이디 중복체크	
	if(frm.userid.value==""){
		alert("아이디를 입력해 주세요!!");
		frm.userid.focus();
	}
	else{
		/* 동기화 통신 */
		var check = ajax_get(frm.userid.value,"3");
		console.log(check);
	}
}

function ajax_data2(){	//사업자 번호 중복체크
	if(frm.corpno.value==""){
		alert("사업자 번호를 입력해 주세요");
		frm.corpno.focus();
	}
	else{
		var check = ajax_get(frm.corpno.value,"2");
	}
}
//Back-end와 get 통신
/*
readyState : 숫자를 적용
0 (UNSENT)  : 객체 생성
1 (OPENED) : open(GET,PIST,PUT... 정상적으로 실행)
2 (HEADERS_RECEIVED) : 서버쪽에서 응답 결과만 체크
3 (LOADING) : 요청에 대한 처리 결과 (데이터 처리하고 있는 상황을 확인할 때)
4 (DONE): 요청된 데이터를 보낸 후 결과에 대한 값을 return
*/
function ajax_get(infodata,part){
	var pm = "";	//GET 전송에 대한 값을 어떻게 전송할 것인지 적용하는 변수
	
	if(part=="1"){	//아이디 
		pm = "?data="+infodata+"&part="+part;
	}
	else if(part=="2"){	//사업자 번호
		pm = "?data="+infodata+"&part="+part;
	}
		
	var data;		//결과값을 받는 변수 및 return 형태
	var ajaxs = new XMLHttpRequest();
	ajaxs.onreadystatechange = function(){
		if(ajaxs.readyState == 4 && ajaxs.status==200){
			 data = this.response;	//Backend에서 처리된 결과값을 받아서 변수에 이관
		}
	}
	/*
	동기화를 사용한 이유는 Back-end에 데이터 전송 후 return 결과를 받기 전에 javascript가 먼저 return을 시켜버림
	결과값이 없다는 undefined가 무조건 출력될 수 밖에 없음 왜?? 통신 전송에는 딜레이가 발생함
	*/
	ajaxs.open("GET","../web_ajax/usercheck.jsp"+pm,false);	//동기화 통신을 사용함 (딜레이 상황이 발생)
	ajaxs.send();
	return data; //결과값을 return 시킴			
}

