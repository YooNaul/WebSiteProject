package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
public class CookieManager
{ 
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime)
	{
		Cookie cookie = new Cookie(cName, cValue);	//	생성자를 통해 쿠키 생성(쿠키명, 쿠키값)
		cookie.setPath("/");						//	경로 설정
		cookie.setMaxAge(cTime);					//	유효 기간
		response.addCookie(cookie);					//	응답 헤더에 추가하여 전송
	}

	public static String readCookie(HttpServletRequest request, String cName)
	{	
		String cookieValue = "";

		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			for (Cookie c : cookies)				//	쿠키의 갯수만큼 반복
			{
				String cookieName = c.getName();	//	쿠키명을 얻어온다.
				if (cookieName.equals(cName))		//	일치하는 쿠키명이 있다면
				{
					cookieValue = c.getValue();		//	쿠키값을 얻어온 후 
				}
			}
		}
		return cookieValue;							//	반환한다.
	}
	//	쿠키 삭제
	public static void deleteCookie(HttpServletResponse response, String cName)
	{
		makeCookie(response, cName, "", 0);
	}
}