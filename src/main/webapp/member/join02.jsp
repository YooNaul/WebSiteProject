<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/global_head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
//미기입 팝업
function validateForm(form) {
	if (form.name.value == "") {
		alert("이름을 입력하세요.");
		form.name.focus();
		return false;
	}
	if (form.id.value == "") {
		alert("아이디를 입력하세요.");
		form.id.focus();
		return false;
	}
	if (form.password.value == "") {
		alert("비밀번호를 입력하세요.");
		form.password.focus();
		return false;
	}
	if (form.password2.value == "") {
		alert("비밀번호 확인을 입력하세요.");
		form.password2.focus();
		return false;
	}
	//비밀번호 다름 팝업
	if (form.password.value != form.password2.value) {
		alert("비밀번호가 서로 다릅니다");
		return false;
	}
	if (form.tel1.value == "") {
		alert("전화번호를 입력하세요.");
		form.tel1.focus();
		return false;
	}
	if (form.tel2.value == "") {
		alert("전화번호를 입력하세요.");
		form.tel2.focus();
		return false;
	}
	if (form.tel3.value == "") {
		alert("전화번호를 입력하세요.");
		form.tel3.focus();
		return false;
	}
	if (form.phone1.value == "") {
		alert("핸드폰번호를 입력하세요.");
		form.phone1.focus();
		return false;
	}
	if (form.phone2.value == "") {
		alert("핸드폰번호를 입력하세요.");
		form.phone2.focus();
		return false;
	}
	if (form.phone3.value == "") {
		alert("핸드폰번호를 입력하세요.");
		form.phone3.focus();
		return false;
	}
	if (form.email_1.value == "") {
		alert("이메일을 입력하세요.");
		form.email_1.focus();
		return false;
	}
	
	if (form.addr1.value == "") {
		alert("주소를 입력하세요.");
		form.addr1.focus();
		return false;
	}
	if (form.addr2.value == "") {
		alert("주소를 입력하세요.");
		form.addr2.focus();
		return false;
	}
	if (!checkId(form.id.value)) {
		return false;
	}
	if (!checkPassword(form.id.value, form.password1.value,form.password2.value)) {
        return false;
    }
	return true;
}
<!-- 아이디 유효성 -->
function checkId(id) {
    
    var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
    if (!idRegExp.test(id)) {
        alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다");
        form.id.value = "";
        form.id.focus();
        return false;
    }
    return true;
}

<!-- 비밀번호 유효성 -->
function checkPassword(id, password1, password2) {
    
    var password1RegExp = /^[a-zA-z0-9]{4,12}$/; //비밀번호 유효성 검사
    if (!password1RegExp.test(password1)) {
        alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
        form.password1.value = "";
        form.password1.focus();
        return false;
    }

    //아이디와 비밀번호가 같을 때..
    if (id == password1) {
        alert("아이디와 비밀번호는 같을 수 없습니다!");
        form.password1.value = "";
        form.password2.value = "";
        form.password2.focus();
        return false;
    }
    return true;
}
//이메일 선택
function inputEmail(frm){
	var domain = frm.last_email_check2.value;
	    if(domain==''){
	        frm.email1.value='';
	        frm.email2.value='';
	    }
	    else if(domain=='1'){
	        frm.email2.readOnly = false;
	        frm.email2.value='';
	        frm.email2.focus();
	    }
	    else{
	        frm.email2.value=domain;
	        frm.email2.readOnly=true;
	    }
}

//아이디 중복체크
function id_check_person() {
	
	var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
    if (!idRegExp.test(id)) {
        alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다");
        form.id.value = "";
        form.id.focus();
        return false;
    }
	var url = "idCheck.jsp?id=" + id;
	window.opwn()
}
	
</script>
<!-- 다음 우편번호 API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function zipFind(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.

            var frm = document.writeForm;
            frm.zipcode.value = data.zonecode;//12345(우편번호)
            frm.address1.value = data.address;//"서울시 금천구 가산동"(기본주소)
            frm.address2.focus();
        }
    }).open();
}
</script>
</head>
 <body>
	<div id="wrap">
		<%@ include file="../include/top.jsp" %>

		<img src="../images/member/sub_image.jpg" id="main_visual" />

		<div class="contents_box">
			<div class="left_contents">
				<%@ include file = "../include/member_leftmenu.jsp" %>
			</div>
			<div class="right_contents">
				<div class="top_title">
					<img src="../images/join_tit.gif" alt="회원가입" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;멤버쉽&nbsp;>&nbsp;회원가입<p>
				</div>

				<p class="join_title"><img src="../images/join_tit03.gif" alt="회원정보입력" /></p>
				<form name="writeForm" method="post" 
 					action="sign_up.jsp" onsubmit="return validateForm(this);">
				<table cellpadding="0" cellspacing="0" border="0" class="join_box">
					<colgroup>
						<col width="80px;" />
						<col width="*" />
					</colgroup>
					<tr>
						<th><img src="../images/join_tit001.gif" /></th>
						<td><input type="text" name="name" value="" class="join_input" /></td>
					</tr>
					<tr>
						<th><img src="../images/join_tit002.gif" /></th>
						<td><input type="text" name="id"  value="" class="join_input" />&nbsp;<a onclick="id_check_person();" style="cursor:hand;"><img src="../images/btn_idcheck.gif" alt="중복확인" onclick="return id_check_person();"/></a>&nbsp;&nbsp;<span>* 4자 이상 12자 이내의 영문/숫자 조합하여 공백 없이 기입</span></td>
					</tr>
					<tr>
						<th><img src="../images/join_tit003.gif" /></th>
						<td><input type="password" name="password" value="" class="join_input" />&nbsp;&nbsp;<span>* 4자 이상 12자 이내의 영문/숫자 조합</span></td>
					</tr>
					<tr>
						<th><img src="../images/join_tit04.gif" /></th>
						<td><input type="password" name="password2" value="" class="join_input" /></td>
					</tr>
					

					<tr>
						<th><img src="../images/join_tit06.gif" /></th>
						<td>
							<input type="text" name="tel1" value="" maxlength="3" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="tel2" value="" maxlength="4" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="tel3" value="" maxlength="4" class="join_input" style="width:50px;" />
						</td>
					</tr>
					<tr>
						<th><img src="../images/join_tit07.gif" /></th>
						<td>
							<input type="text" name="phone1" value="" maxlength="3" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="phone2" value="" maxlength="4" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="phone3" value="" maxlength="4" class="join_input" style="width:50px;" /></td>
					</tr>
					<tr>
						<th><img src="../images/join_tit08.gif" /></th>
						<td>
 
	<input type="text" name="email1" style="width:100px;height:20px;border:solid 1px #dadada;" value="" /> @ 
	<input type="text" id="email2" name="email2" style="width:150px;height:20px;border:solid 1px #dadada;" value="" readonly />
	<select name="last_email_check2" class="pass" id="last_email_check2" onchange="inputEmail(this.form);" >
		<option selected="" value="">선택해주세요</option>
		<option value="1" >직접입력</option>
		<option value="dreamwiz.com" >dreamwiz.com</option>
		<option value="empal.com" >empal.com</option>
		<option value="empas.com" >empas.com</option>
		<option value="freechal.com" >freechal.com</option>
		<option value="hanafos.com" >hanafos.com</option>
		<option value="hanmail.net" >hanmail.net</option>
		<option value="hotmail.com" >hotmail.com</option>
		<option value="intizen.com" >intizen.com</option>
		<option value="korea.com" >korea.com</option>
		<option value="kornet.net" >kornet.net</option>
		<option value="msn.co.kr" >msn.co.kr</option>
		<option value="nate.com" >nate.com</option>
		<option value="naver.com" >naver.com</option>
		<option value="netian.com" >netian.com</option>
		<option value="orgio.co.kr" >orgio.co.kr</option>
		<option value="paran.com" >paran.com</option>
		<option value="sayclub.com" >sayclub.com</option>
		<option value="yahoo.co.kr" >yahoo.co.kr</option>
		<option value="yahoo.com" >yahoo.com</option>
	</select>
	 
						<input type="checkbox" name="open_email" value="1">
						<span>이메일 수신동의</span></td>
					</tr>
					<tr>
						<th><img src="../images/join_tit09.gif" /></th>
						<td>
						<input type="text" name="zipcode" value=""  class="join_input" style="width:50px;" />
						<a href="javascript:;" title="새 창으로 열림" onclick="zipFind()" onkeypress="">[우편번호검색]</a>
						<br/>
						
						<input type="text" name="address1" value=""  class="join_input" style="width:550px; margin-top:5px;" /><br>
						<input type="text" name="address2" value=""  class="join_input" style="width:550px; margin-top:5px;" />
						
						</td>
					</tr>
				</table>
				
				<p style="text-align:center; margin-bottom:20px"><a href="../main/signup.jsp"><input type="image" src="../images/btn01.gif"/></a>&nbsp;&nbsp;<a href="#"><img src="../images/btn02.gif" /></a></p>
				</form>
			</div>
		</div>
		
		<%@ include file="../include/quick.jsp" %>
	</div>
	<%@ include file="../include/footer.jsp" %>
	
 </body>
</html>
