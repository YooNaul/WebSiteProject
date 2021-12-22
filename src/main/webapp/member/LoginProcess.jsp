<%@page import="model2.mvc.MemberDAO"%>
<%@page import="utils.JSFunction"%>
<%@page import="utils.CookieManager"%>
<%@page import="model2.mvc.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
String save_check = request.getParameter("save_check");

String oracleDriver = application.getInitParameter("OracleDriver");
String oracleURL = application.getInitParameter("OracleURL");
String oracleId = application.getInitParameter("OracleId");
String oraclePwd = application.getInitParameter("OraclePwd");

MemberDAO dao = new MemberDAO(oracleDriver, oracleURL, oracleId, oraclePwd);
MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);

dao.close();

if (memberDTO.getId() != null)
{
	if ((save_check != null) && save_check.equals("Y"))
	{
		CookieManager.makeCookie(response, "loginId", userId, 86400);
	}
	else
	{
		CookieManager.deleteCookie(response, "loginId");
	}
	
	session.setAttribute("userId", memberDTO.getId());
	session.setAttribute("userName", memberDTO.getName());
	response.sendRedirect("../main/main.jsp");
}
else
{
	JSFunction.alertLocation("일치하는 정보가 없습니다.", "./login.jsp", out);
	/* request.getRequestDispatcher("../member/login.jsp").forward(request, response); */
}
%>