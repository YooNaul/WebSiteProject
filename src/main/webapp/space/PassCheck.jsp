<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function validateForm(form) {
	if (form.pass.value == "") {
		alert("패스워드를 입력하세요.");
		form.pass.focus();
		return false;
	}
}
</script>
</head>
<body>
<h2>파일 첨부형 게시판 - 패스워드확인(Password)</h2>
<form name="writeFrm" method="post"
 	action="deleteProcess.jsp" onsubmit="return validateForm(this);">

<input type="hidd en" name="idx" value="${ param.idx }" />

<table border="1" width="90%">
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="pass" style="width:100px" />
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit">작성 완료</button>
			<button type="reset">RESET</button>
			<button type="button" onclick="location.href='sub03.jsp';">
				목록 바로가기</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>
