<%@page import="model2.mvc.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDAO dao = new MemberDAO();
int rst = 0;
String id = (String)request.getParameter("id");
rst = dao.idCheck(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(rst == 1) {
%>
<h4>아이디가 이미 존재합니다</h4>
<%}else{ %>
<h4>아이디 사용 가능합니다.</h4>
<%} %>
</body>
</html>