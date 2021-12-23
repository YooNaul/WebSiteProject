<%@page import="model1.board.BoardDAO"%>
<%@page import="model1.board.BoardDTO"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//파일이 저장될 디렉토리의 물리적 경로 얻어오기
String saveDirectory = application.getRealPath("/Uploads");
//업로드 할 파일의 최대용량 설정(만약 파일이 2개라면 둘을 합친 용량으로 설정)
int maxPostSize = 1024 * 1024 * 100;
//인코딩 방식 설정
String encoding = "UTF-8";

try {
	/*  
	앞에서 준비한 객체를 통해 MultipartRequest객체를 생성한다.
	객체가 생성됨과 동시에 첨부한 파일은 서버에 업로드 된다.
	만약 예외가 발생한다면 용량 초과가 대부분이다.
	*/
	MultipartRequest mr = new MultipartRequest(request, saveDirectory,
			maxPostSize, encoding);
	
	/*  
	파일명이 한글이면 서버에서 문제를 일으키는 경우가 있으므로
	영문자 숫자로 변경하는것이 좋다. 아래에서는 현재 날짜와서 시간을 통해
	생성된 문자열을 파일명으로 설정한다.
	*/
	//mr객체를 통해 서버에 저장된 파일명을 가져온다.
	String fileName = mr.getFilesystemName("attachedFile");
	//파일명에서 .의 위치를 파악한 후 확장자를 따낸다.
	String ext = fileName.substring(fileName.lastIndexOf("."));
	//현재날짜와 시간 및 밀리세컨즈까지 이용해서 파일명으로 사용할 문자열을 만든다.
	String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
	//확장자와 파일명을 합쳐서 저장할 파일명을 만들어준다.
	String newFileName = now + ext;
	
	//기존의 파일명을 새로운 파일명으로 변경한다.
	File oldFile = new File(saveDirectory + File.separator + fileName);
	File newFile = new File(saveDirectory + File.separator + newFileName);
	oldFile.renameTo(newFile);
	
	//파일을 제외한 나머지 폼값을 받는다. 이때 request객체를 통해 받는것이
	//아니므로 주의해야 한다.
	String writer = mr.getParameter("writer");
	String title = mr.getParameter("title");
	String content = mr.getParameter("content");
	String postpass = mr.getParameter("postpass");
	
	
	//DTO객체 생성및 폼값 설정
	BoardDTO dto = new BoardDTO();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	dto.setOfile(fileName);
	dto.setSfile(newFileName);
	dto.setPostpass(postpass);
	
	
	//DAO객체 생성 및 insert 처리
	BoardDAO dao = new BoardDAO(application);
	dao.insertPicFile(dto);
	dao.close();
	
	//문제가 없다면 파일리스트로 이동한다.
	response.sendRedirect("sub04.jsp");
}
catch (Exception e) {
	e.printStackTrace();
	//예외가 발생하면 request영역에 메세지를 저장한 후 메인으로 포워드 한다.
	request.setAttribute("errorMessage", "파일 업로드 오류");
	request.getRequestDispatcher("sub0_picwrite.jsp").forward(request, response);
}
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