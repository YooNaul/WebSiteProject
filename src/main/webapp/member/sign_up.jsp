<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
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
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String oracleId = "musthave";
	String oraclePw = "1234";
	
	Connection con = null;
	PreparedStatement psmt = null;
	
	String sql = "INSERT INTO user_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection(url, oracleId, oraclePw);
		
		psmt = con.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, id);
		psmt.setString(3, password);
		psmt.setString(4, tel1);
		psmt.setString(5, tel2);
		psmt.setString(6, tel3);
		psmt.setString(7, phone1);
		psmt.setString(8, phone2);
		psmt.setString(9, phone3);
		psmt.setString(10, email1);
		psmt.setString(11, email2);
		psmt.setString(12, zipcode);
		psmt.setString(13, address1);
		psmt.setString(14, address2);
		
		int result = psmt.executeUpdate();
		
		if (result == 1) {
			response.sendRedirect("join_succes.jsp");
		}
		else {
			response.sendRedirect("join_fail.jsp");
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(con != null) con.close();
			if(psmt != null) psmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>