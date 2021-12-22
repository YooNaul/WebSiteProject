<%@page import="utils.JSFunction"%>
<%@page import="model2.mvc.MemberDAO"%>
<%@ page import="model2.mvc.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
String id = request.getParameter("id");
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
String phone1 = request.getParameter("phone1");
String phone2 = request.getParameter("phone2");
String phone3 = request.getParameter("phone3");
String email1 = request.getParameter("email1");
String email2 = request.getParameter("email2");
String zipcode = request.getParameter("zipcode");
String address1 = request.getParameter("address1");
String address2 = request.getParameter("address2");

MemberDTO dto = new MemberDTO();
dto.setName(name);
dto.setId(id);
dto.setTel1(tel1);
dto.setTel2(tel2);
dto.setTel3(tel3);
dto.setPhone1(phone1);
dto.setPhone2(phone2);
dto.setPhone3(phone3);
dto.setEmail1(email1);
dto.setEmail2(email2);
dto.setZipcode(zipcode);
dto.setAddress1(address1);
dto.setAddress2(address2);

//	DB 연결
MemberDAO dao = new MemberDAO(application);
//	수정 처리
int affected = dao.updateMember(dto);
//	자원 해제
dao.close();

if (affected == 1)
{	//	수정에 성공한 경우 수정된 내용을 확인하기 위해 상세보기 페이지로 이동
	response.sendRedirect("InfoEdit.jsp");
}
else
{	//	수정에 실패한 경우 뒤로 이동
	JSFunction.alertBack("수정하기에 실패하였습니다", out);
}
%>