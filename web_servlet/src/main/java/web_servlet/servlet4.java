package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//해당 class는 View가 없이 스크립트로 핸들링 후 다른 페이지로 이동
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해당 자바에서 javascript로 메세지를 출력하기 위해 한글 깨짐 방지
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String corp = request.getParameter("corp");
		if(corp.equals("")) {
			System.out.println("통신사 선택을 안함");
		}
		else {
			System.out.println(corp);		
		}
		//체크박스는 체크를 안할 경우 null으로 적용 되므로, equals를 절대 사용하지 못함
		String ck = request.getParameter("ck");
		PrintWriter pw = response.getWriter();
		try {
			if(ck == null) {	//checkbox를 적용시 필수조건이 아닐 경우는 다음과 같이 적용해야만 합니다.
				pw.write("<script>"
						+ "alert('자동 로그인이 무조건 체크 되어야 함');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {
				pw.write("<script>"
						+ "alert('PC방이나 공공장소에는 유의 하십시오');"
						/* + "location.href='http://naver.com';" */
						+ "</script>");
			}
		}catch (Exception e) {
			System.out.println("전송 오류 발생!!");
		}finally {
			pw.close();
		}
		
		//intern() : HTML에서 필수로 사용자가 무조건 입력하는 사항
		String no = request.getParameter("no").intern();
		String ag = request.getParameter("ag");
		
		if(no == "") {
			System.out.println("테스트");
		}
		
		System.out.println(no);		
	}

}
