function gopage(){
	if(frm.c_part.value==""){
		alert("제휴구분을 선택하셔야 합니다.");
		frm.c_part.focus();
	}
	else{
		frm.method="post";
		frm.action="./contentok.do";
		frm.captcha.value = "testcon";
		frm.submit();
	}
}