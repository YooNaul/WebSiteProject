<%@ page import="utils.JSFunction"%>
<%@ page import="model2.mvc.MemberDAO"%>
<%@ page import="model2.mvc.MemberDTO"%>
<%@ include file="./IsLoggedIn.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String userId = (String)session.getAttribute("userId");
MemberDAO dao = new MemberDAO(application);
MemberDTO dto = dao.viewMember(userId);
%>
<%@ include file="../include/global_head.jsp" %>

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
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;멤버쉽&nbsp;>&nbsp;회원정보수정<p>
				</div>
				
				<!-- 회원 정보 입력(수정) -->
				<form action="./MemberEditProcess.jsp" name="editForm" method="post">
				<p class="join_title"><img src="../images/join_tit03.gif" alt="회원정보입력" /></p>
				<table cellpadding="0" cellspacing="0" border="0" class="join_box">
					<colgroup>
						<col width="80px;" />
						<col width="*" />
					</colgroup>
					<tr>
						<th><img src="../images/join_tit001.gif" /></th>
						<td><input type="text" name="name" value="<%= dto.getName() %>" class="join_input" /></td>
					</tr>
					<tr>
						<th><img src="../images/join_tit002.gif" /></th>
						<td><input type="text" name="id"  value="<%= userId %>" class="join_input" readonly/>&nbsp;</td>
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
							<input type="text" name="tel1" value="<%= dto.getTel1() %>" maxlength="3" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="tel2" value="<%= dto.getTel2() %>" maxlength="4" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="tel3" value="<%= dto.getTel3() %>" maxlength="4" class="join_input" style="width:50px;" />
						</td>
					</tr>
					<tr>
						<th><img src="../images/join_tit07.gif" /></th>
						<td>
							<input type="text" name="phone1" value="<%= dto.getPhone1() %>" maxlength="3" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="phone2" value="<%= dto.getPhone2() %>" maxlength="4" class="join_input" style="width:50px;" />&nbsp;-&nbsp;
							<input type="text" name="phone3" value="<%= dto.getPhone3() %>" maxlength="4" class="join_input" style="width:50px;" />
						</td>
					</tr>
					<tr>
						<th><img src="../images/join_tit08.gif" /></th>
						<td>
							<input type="text" name="email1" style="width:100px;height:20px;border:solid 1px #dadada;" value="<%= dto.getEmail1() %>" /> @ 
							<input type="text" name="email2" style="width:150px;height:20px;border:solid 1px #dadada;" value="<%= dto.getEmail2() %>" readonly />
							<select name="last_email_check2" onChange="email_input(this);" class="pass" id="last_email_check2" >
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
							<span>이메일 수신동의</span>
						</td>
					</tr>
					<tr>
						<th><img src="../images/join_tit09.gif" /></th>
						<td>
							<input type="text" name="zipcode" value="<%= dto.getZipcode() %>"  class="join_input" style="width:50px;" />
							<a href="javascript:;" title="새 창으로 열림" onclick="zipFind('zipFind', '<?=$_Common[bbs_path]?>member_zipcode_find.php', 590, 500, 0);" onkeypress="">[우편번호검색]</a><br/>
							<input type="text" name="address1" value="<%= dto.getAddress1() %>"  class="join_input" style="width:550px; margin-top:5px;" /><br>
							<input type="text" name="address2" value="<%= dto.getAddress2() %>"  class="join_input" style="width:550px; margin-top:5px;" />
						</td>
					</tr>
				</table>
				
				<!-- 확인 / 취소 -->
				<p style="text-align:center; margin-bottom:20px">
					<a><input type="image" src="../images/btn01.gif"/></a>&nbsp;&nbsp;
					<a href="../main/main.jsp"><img src="../images/btn02.gif" /></a>
				</p>
				</form>
				
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
 </body>
</html>
