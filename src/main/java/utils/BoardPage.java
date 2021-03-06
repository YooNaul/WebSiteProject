package utils;

//	게시물 목록 하단에 페이지 번호를 출력하기 위한 클래스
public class BoardPage
{	//	매개변수(전체 게시물 갯수, 한페이지 게시물 갯수, 한블럭당페이지 갯수, 현재 페이지 번호, 
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl)
	{
		String pagingStr = "";
		
		//	전체 페이지 계산
		int totalPages = (int)(Math.ceil(((double) totalCount / pageSize)));
		
		//	페이지 블럭의 첫번째 수를 계산
		int pageTemp = (((pageNum-1) / blockPage) * blockPage) + 1;
		
		//	이전 블럭으로 바로가기 링크(첫번째 블럭에서는 숨김처리)
		if (pageTemp != 1)
		{
			pagingStr += "<a href='"+ reqUrl +"?pageNum=1'>[첫 페이지]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='"+ reqUrl +"?pageNum="+ (pageTemp - 1) +"'>[이전 블록]</a>";
		}
		
		//	각 페이지로 바로가기 링크(blockPage 수만큼 출력)
		int blockCount = 1;
		while (blockCount <= blockPage && pageTemp <= totalPages)
		{
			if (pageTemp == pageNum)
			{	//	현재 페이지는 링크를 걸지 않음
				pagingStr += "&nbsp;"+ pageTemp +"&nbsp;";
			}
			else
			{
				pagingStr += "&nbsp;<a href='"+ reqUrl +"?pageNum="+ pageTemp +"'>"+ pageTemp +"</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}
		
		//	다음 블럭으로 바로가기 링크
		if (pageTemp <= totalPages)
		{
			pagingStr += "<a href='"+ reqUrl +"?pageNum="+ pageTemp +"'>[다음 블록]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='"+ reqUrl +"?pageNum="+ totalPages +"'>[마지막 페이지]</a>";
		}
		
		return pagingStr;
	}
}
