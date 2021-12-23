<%@page import="utils.JSFunction"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileUtils"%>
<%@page import="model1.board.BoardDAO"%>
<%@page import="model1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String pass = request.getParameter("pass");
String idx = request.getParameter("idx");

BoardDTO dto = new BoardDTO();
dto.getPostpass();

BoardDAO dao = new BoardDAO(application);

dao.confirmPassword(pass, idx);

dao.deletePost(dto);


dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>