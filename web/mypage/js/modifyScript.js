function modify_check() {
	if (document.frm.address.value.length == 0) {
		alert("주소를 입력하세요.");
		return false;
	}
	if (document.frm.phone.value.length == 0) {
		alert("연락처를 입력하세요.");
		return false;
	}
	return true;
}

// 비밀번호 확인 체크
function pass_check() {
	if (document.frm2.pass.value == document.frm2.pass2.value) {
		return true;
	} else {
		alert("비밀번호를 다시 확인해 주세요.");
		return false;
	}
	return false;
}