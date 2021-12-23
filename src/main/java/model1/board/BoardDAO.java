package model1.board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoardDAO extends JDBConnect {

	
	public BoardDAO(ServletContext application) {
		//내장객체를 톨해 web.xml에 작성된 컨텍스트 초기화 파라미터를 얻어온다.
		super(application);
	}
	/*
	board테이블에 저장된 게시물의 개수를 카운트하기 위한 메서드.
	카운트 한 결과값을 통해 목록에서 게시물의 순번을 출력한다.
	 */
	public int selectCount(Map<String, Object> map) {
		//카운트 변수
		int totalCount = 0;
		//쿼리문 작성
		String query = "SELECT COUNT(*) FROM proboard";
		//검색어가 있는 경우 where절에 like를 동적으로 추가한다.
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " "
					+ " LIKE '%" +map.get("searchWord") + "%'";
		}
		
		try {
			//정적쿼리문(?가 없는 쿼리문) 실행을 위핸 Statement객체 생성
			stmt = con.createStatement();
			//select 쿼리문을 실행 후 ResultSet객체를 반환받음
			rs = stmt.executeQuery(query);
			//커서를 이동시켜 결과데이터를 읽음
			rs.next();
			//결과값을 변수에 저장
			totalCount = rs.getInt(1);
		}
		catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		
		return totalCount;
	}
	//공지게시판 출력실행 쿼리문
	public List<BoardDTO> noticeList(Map<String, Object> map){
		
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		
		String query = "SELECT * FROM ( "
				+ "    		SELECT Tb.*, ROWNUM rNum FROM ( "
				+ "				SELECT * FROM proboard WHERE tablename='notice' ";
		//검색어가 있는 경우 where절을 추가한다.
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " "
					+ " LIKE '%" +map.get("searchWord") + "%'";
		}
			query += " 		ORDER BY idx DESC "
				+ "	  ) Tb "
				+ " ) "
				+ "	WHERE rNum BETWEEN ? AND ?";
		
		try {
			
			//쿼리 실행을 위한 prepared객체 생성
			psmt = con.prepareStatement(query);
			//인파라미터설정 : 구간을 위한 start, end를 설정
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
		
			
			rs = psmt.executeQuery();
			
			//추출된 결과에 따라 반복한다.
			while (rs.next()) {
				//하나의 레코드를 읽어서 DTO객체에 저장한다.
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setTablename(rs.getString("tablename"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisicount(rs.getInt("visicount"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setPostpass(rs.getString("postpass"));
				
				
				//리스트 컬렉션에 DTO객체를 추가한다.
				bbs.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회중 예외 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	
	//자유게시판 출력실행 쿼리문
	public List<BoardDTO> freeboardList(Map<String, Object> map){
		
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		
		String query = "SELECT * FROM ( "
				+ "    		SELECT Tb.*, ROWNUM rNum FROM ( "
				+ "				SELECT * FROM proboard WHERE tablename='freeboard' ";
		//검색어가 있는 경우 where절을 추가한다.
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " "
					+ " LIKE '%" +map.get("searchWord") + "%'";
		}
		query += " 		ORDER BY idx DESC "
				+ "	  ) Tb "
				+ " ) "
				+ "	WHERE rNum BETWEEN ? AND ?";
		
		try {
			
			//쿼리 실행을 위한 prepared객체 생성
			psmt = con.prepareStatement(query);
			//인파라미터설정 : 구간을 위한 start, end를 설정
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
		
			
			rs = psmt.executeQuery();
			
			//추출된 결과에 따라 반복한다.
			while (rs.next()) {
				//하나의 레코드를 읽어서 DTO객체에 저장한다.
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setTablename(rs.getString("tablename"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisicount(rs.getInt("visicount"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setPostpass(rs.getString("postpass"));
				
				
				//리스트 컬렉션에 DTO객체를 추가한다.
				bbs.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회중 예외 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	//사진게시판 출력실행 쿼리문
	public List<BoardDTO> picboardList(Map<String, Object> map){
		
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		
		String query = "SELECT * FROM ( "
				+ "    		SELECT Tb.*, ROWNUM rNum FROM ( "
				+ "				SELECT * FROM proboard WHERE tablename='picboard' ";
		//검색어가 있는 경우 where절을 추가한다.
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " "
					+ " LIKE '%" +map.get("searchWord") + "%'";
		}
		query += " 		ORDER BY idx DESC "
				+ "	  ) Tb "
				+ " ) "
				+ "	WHERE rNum BETWEEN ? AND ?";
		
		try {
			
			//쿼리 실행을 위한 prepared객체 생성
			psmt = con.prepareStatement(query);
			//인파라미터설정 : 구간을 위한 start, end를 설정
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
		
			
			rs = psmt.executeQuery();
			
			//추출된 결과에 따라 반복한다.
			while (rs.next()) {
				//하나의 레코드를 읽어서 DTO객체에 저장한다.
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setTablename(rs.getString("tablename"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisicount(rs.getInt("visicount"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setPostpass(rs.getString("postpass"));
				
				
				//리스트 컬렉션에 DTO객체를 추가한다.
				bbs.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회중 예외 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	//정보자료실 출력실행 쿼리문
	public List<BoardDTO> infoboardList(Map<String, Object> map){
		
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		
		String query = "SELECT * FROM ( "
				+ "    		SELECT Tb.*, ROWNUM rNum FROM ( "
				+ "				SELECT * FROM proboard WHERE tablename='infoboard' ";
		//검색어가 있는 경우 where절을 추가한다.
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " "
					+ " LIKE '%" +map.get("searchWord") + "%'";
		}
		query += " 		ORDER BY idx DESC "
				+ "	  ) Tb "
				+ " ) "
				+ "	WHERE rNum BETWEEN ? AND ?";
		
		try {
			
			//쿼리 실행을 위한 prepared객체 생성
			psmt = con.prepareStatement(query);
			//인파라미터설정 : 구간을 위한 start, end를 설정
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
		
			
			rs = psmt.executeQuery();
			
			//추출된 결과에 따라 반복한다.
			while (rs.next()) {
				//하나의 레코드를 읽어서 DTO객체에 저장한다.
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setTablename(rs.getString("tablename"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisicount(rs.getInt("visicount"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setPostpass(rs.getString("postpass"));
				
				
				//리스트 컬렉션에 DTO객체를 추가한다.
				bbs.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회중 예외 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	
	/*
	목록에 출력할 게시물을 오라클로부터 추출하기 위한 쿼리문 실행 (페이지 처리 없음)
	 */
	public List<BoardDTO> selectList(Map<String, Object> map) {
		
		/*
		board테이블에서 select한 결과데이터를 저장하기 위한 리스트 컬렉션.
		여러가지 List컬렉션 중 동기화가 보장되는 Vector를 사용한다.
		 */
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		/*
		목록에 출력할 게시물을 추출하기 위한 쿼리문으로 항상 일련번호의
		역순(내림차순)으로 정렬해야 한다. 게시판의 목록은 최근 게시물이
		제일 앞에 노출되기 때문이다.
		 */
		String query = "SELECT * FROM proboard ";
		//검색어가 있는 경우 where절을 추가한다.
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " "
					+ " LIKE '%" +map.get("searchWord") + "%'";
		}
		query += " ORDER BY idx DESC ";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			//추출된 결과에 따라 반복한다.
			while (rs.next()) {
				//하나의 레코드를 읽어서 DTO객체에 저장한다.
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setTablename(rs.getString("tablename"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisicount(rs.getInt("visicount"));
				dto.setDowncount(rs.getInt("downcount"));
				
				
				//리스트 컬렉션에 DTO객체를 추가한다.
				bbs.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회중 예외 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	
	
	//사용자가 입력한 내용을 board테이블에 insert 처리하는 메서드
	public int insertWrite(BoardDTO dto) {
		//입력결과 확인용 변수
		int result = 0;
		
		try {
			//인파라미터가 있는 쿼리문 작성(동적쿼리문)
			String query = "INSERT INTO proboard ( "
					+ " idx,writer,title,content,tablename,postdate,visicount) "
					+ " VALUES ( "
					+ " seq_proboard.NEXTVAL, ?, ?, ?, 'freeboard', sysdate, 0)";
			//동적쿼리문 실행을 위해 prepared객체 생성
			psmt = con.prepareStatement(query);
			//순서대로 인파라미터 설정
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			//쿼리문 실행 : 입력에 성공한다면 1이 반환된다. 실패시 0반환
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	//상세보기를 위해 특정 일련번호에 해당하는 게시물을 인출한다.
	public BoardDTO selectView(String idx) {
		BoardDTO dto = new BoardDTO();
		//join을 이용해서 user_info테이블의 name컬럼을 가져온다.
		String query = " SELECT * FROM proboard where idx=? ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			//일련번호는 중복되지 않으므로 if문에서 처리하면 된다.
			if (rs.next()) {//ResultSet에서 커서를 이동시켜 레코드를 읽은 후
				// DTO객체에 레코드의 내용을 추가한다.
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));//날짜타입이므로 getDate()사용함.
				dto.setWriter(rs.getString("writer"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setVisicount(rs.getInt("visicount"));
			}
		}
		catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
	//게시물의 조회수를 1증가 시킨다.
	public void updateVisiCount(String idx) {
		//visicount 컬럼을 number 타입이므로 덧셈이 가능하다.
		String query = "UPDATE proboard SET "
				+ " visicount=visicount+1 "
				+ " WHERE idx=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}
	//게시물 수정 : 수정할 내용을 DTO객체에 저장후 매개변수로 전달
	public int updateEdit(BoardDTO dto) {
		int result = 0;
		
		try {
			//update를 위한 쿼리문
			String query = "UPDATE proboard SET "
					+ " title=?, content=? "
					+ " WHERE idx=?";
			//prepared객체 생성
			psmt = con.prepareStatement(query);
			//인파라미터 설정
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getIdx());
			//쿼리 실행
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	//DTO객체를 받아 게시물 삭제처리
	public int deletePost(BoardDTO dto) {
		int result = 0;
		
		try {
			//쿼리문 작서
			String query = "DELETE FROM proboard WHERE idx=?";
			//prepared객체 생성 및 인파라미터 설정
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getIdx());
			//쿼리실행
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}

	//게시판의 페이징 처리를 위한 메서드
	public List<BoardDTO> selectListPage(Map<String, Object> map) {
		
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		//3개의 쿼리문을 통한 페이지 처리
		String query = "SELECT * FROM ( "
				+ "    		SELECT Tb.*, ROWNUM rNum FROM ( "
				+ "				SELECT * FROM proboard ";
		
		//검색 조건 추가 (검색어가 있는 경우에만 where절이 추가됨)
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField")
					+ " LIKE '%" +map.get("searchWord") + "%'";
		}
		query += " 		ORDER BY idx DESC "
				+ "	  ) Tb "
				+ " ) "
				+ "	WHERE rNUM BETWEEN ? AND ?";
		/* JSP에서 계산된 게시물의 구간을 인파라미터로 처리함 */
		
		try {
			//쿼리 실행을 위한 prepared객체 생성
			psmt = con.prepareStatement(query);
			//인파라미터설정 : 구간을 위한 start, end를 설정
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			//쿼리문 실행
			rs = psmt.executeQuery();
			//select한 게시물의 개수만큼 반복
			while (rs.next()) {
				//한 행(게시물 하나)의 데이터를 DTO에 저장
				BoardDTO dto = new BoardDTO();	
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setWriter(rs.getString("writer"));
				dto.setVisicount(rs.getInt("visicount"));
				
				bbs.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회중 예외 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	
	//파일 및 게시물 입력
		public int insertFile(BoardDTO dto) {
			int applyResult = 0;
			try {
				//1.쿼리문 작성
				String query = "INSERT INTO proboard ( "
						+ "	idx, writer, title, content, tablename, ofile, sfile, postdate, visicount, downcount, postpass  ) "
						+ " VALUES ( "
						+ " seq_proboard.nextval, ?, ?, ?, 'infoboard', ?, ?, sysdate, 0, 0, ?) ";
				//2.prepared객체생성 및 인파라미터 설정
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getWriter());
				psmt.setString(2, dto.getTitle());
				psmt.setString(3, dto.getContent());
				psmt.setString(4, dto.getOfile());
				psmt.setString(5, dto.getSfile());
				psmt.setString(6, dto.getPostpass());
				//3.쿼리실행
				applyResult = psmt.executeUpdate();
			}
			catch (Exception e) {
				System.out.println("INSERT중 예외 발생");
				e.printStackTrace();
			}
			return applyResult;
		}
		//파일 및 게시물 입력
		public int insertPicFile(BoardDTO dto) {
			int applyResult = 0;
			try {
				//1.쿼리문 작성
				String query = "INSERT INTO proboard ( "
						+ "	idx, writer, title, content, tablename, ofile, sfile, postdate, visicount, downcount, postpass  ) "
						+ " VALUES ( "
						+ " seq_proboard.nextval, ?, ?, ?, 'picboard', ?, ?, sysdate, 0, 0, ?) ";
				//2.prepared객체생성 및 인파라미터 설정
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getWriter());
				psmt.setString(2, dto.getTitle());
				psmt.setString(3, dto.getContent());
				psmt.setString(4, dto.getOfile());
				psmt.setString(5, dto.getSfile());
				psmt.setString(6, dto.getPostpass());
				//3.쿼리실행
				applyResult = psmt.executeUpdate();
			}
			catch (Exception e) {
				System.out.println("INSERT중 예외 발생");
				e.printStackTrace();
			}
			return applyResult;
		}
		
		//파일 목록 출력
		public List<BoardDTO> myFileList() {
			List<BoardDTO> fileList = new Vector<BoardDTO>();
			
			//레코드를 일련번호의 내림차순으로 정렬
			String query = "SELECT * FROM proboard ORDER BY idx DESC";
			try {
				psmt = con.prepareStatement(query);
				rs = psmt.executeQuery();
				//ResultSet의 객체수만큼 반복
				while (rs.next()) {
					BoardDTO dto = new BoardDTO();
					dto.setIdx(rs.getString(1));
					dto.setWriter(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setTablename(rs.getString(4));
					dto.setOfile(rs.getString(5));
					dto.setSfile(rs.getString(6));
					dto.setPostdate(rs.getDate(7));
					//각 레코드를 List컬렉션에 추가
					fileList.add(dto);
				}
			}
			catch (Exception e) {
				System.out.println("SELECT시 예외 발생");
				e.printStackTrace();
			}
			return fileList;
		}
		
		
		//패스워드 검증을 위해 해당 게시물이 존재하는지 확인
		public boolean confirmPassword(String pass, String idx) {
			boolean isCorr = true;
			try {
				//패스워드와 일련번호를 통해 조건에 맞는 게시물이 있는지 확인
				String sql = "SELECT COUNT(*) FROM proboard WHERE postpass=? AND idx=?";
				psmt = con.prepareStatement(sql);
				//인파라미터 설정
				psmt.setString(1, pass);
				psmt.setString(2, idx);
				rs = psmt.executeQuery();
				//커서 이동을 위한 next() 호출. count() 함수는 항상 결과를 반환하므로
				//if문은 별도로 필요하지 않다.
				rs.next();
				if (rs.getInt(1) == 0) {//결과가 없을때 false로 처리
					isCorr = false;
				}
			}
			catch(Exception e) {
				isCorr = false;//예외가 발생하면 확인이 안되므로 false로 처리
				e.printStackTrace();
			}
			return isCorr;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
