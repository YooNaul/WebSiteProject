<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script type="text/javascript">
function validateForm(form) {
	if (form.title.value == "") {
		alert("제목을 입력하세요.");
		form.title.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("작성자를 입력하세요.");
		form.name.focus();
		return false;
	}
	if (form.postpass.value == "") {
		alert("비밀번호를 입력하세요.");
		form.postpass.focus();
		return false;
	}
	if (form.content.value == "") {
		alert("내용을 입력하세요.");
		form.content.focus();
		return false;
	}
	if (form.attachedFile.value == "") {
		alert("사진을 등록하세요.");
		return false;
	}
}
</script>

 <body>
	<center>
	<div id="wrap">
		<%@ include file="../include/top.jsp" %>

		<img src="../images/space/sub_image.jpg" id="main_visual" />

		<div class="contents_box">
			<div class="left_contents">
				<%@ include file = "../include/space_leftmenu.jsp" %>
			</div>
			<div class="right_contents">
				<div class="top_title">
					<img src="../images/space/sub01_title.gif" alt="공지사항" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린공간&nbsp;>&nbsp;공지사항<p>
				</div>
				<div>

 		<form enctype="multipart/form-data"  method="post" action="PicUploadProcess.jsp">
                <table class="table table-bordered">
                <colgroup>
                    <col width="20%"/>
                    <col width="*"/>
                </colgroup>
                <tbody>
                    
                    <tr>
                        <th class="text-center" 
                            style="vertical-align:middle;">제목</th>
                        <td colspan="10">
                            <input type="text" class="form-control" name="title"/>
                        </td>
                    </tr>
                    <tr>
                        <th class="text-center" 
                            style="vertical-align:middle;">작성자</th>
                        <td>
                            <input type="text" class="form-control" name="writer"/>
                        </td>
                        <th class="text-center" 
                            style="vertical-align:middle;">비밀번호</th>
                        <td>
                            <input type="password" class="form-control" name="postpass"/>
                        </td>
                    </tr>
                    <tr>
                        <th class="text-center" 
                            style="vertical-align:middle;">내용</th>
                        <td colspan="10">
                            <textarea rows="5" class="form-control" name="content"></textarea>
                        </td>
                    </tr>
                   <tr>
                        <th class="text-center" 
                            style="vertical-align:middle;">첨부파일</th>
                        <td colspan="10">
                            <input type="file" class="form-control" name="attachedFile"/>
                        </td>
                    </tr>
                </tbody>
                </table>

                <!-- 각종버튼 -->
                <div class="row mb-3">
                    <div class="col d-flex justify-content-end">
                    	<button type="submit" class="btn btn-danger" >작성완료</button>
                        <button type="button" class="btn btn-warning" onclick="location.href='sub04.jsp';">목록보기</button>
                        <button type="reset" class="btn btn-dark">다시쓰기</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


				</div>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>


	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>