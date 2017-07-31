function check(){
	if(document.frm.id.value.length==0){
		alert("ID를 입력하세요.");
		return false;
	}
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}
function check_search_id(){
	if(document.frm.name.value.length==0){
		alert("이름을 입력하세요.");
		return false;
	}
	if(document.frm.phone.value.length==0){
		alert("연락처를 입력하세요.");
		return false;
	}
	if(document.frm.birth.value.length==0){
		alert("생년월일을 입력하세요.");
		return false;
	}
	return true;
}
function check_search_pass(){
	if(document.frm.id.value.length==0){
		alert("ID를 입력하세요.");
		return false;
	}
	if(document.frm.phone.value.length==0){
		alert("연락처를 입력하세요.");
		return false;
	}
	if(document.frm.birth.value.length==0){
		alert("생년월일을 입력하세요.");
		return false;
	}
	return true;
}