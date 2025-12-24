package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		PrintWriter pw = res.getWriter();
		pw.write("<script>"
				+ "location.href='./servlet5.html';"
				+ "</script>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");	//이메일 중 도메인이 한글로 된 사항이 있음
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			/*
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String email = email1 + "@" + email2;
			System.out.println(email1);
			System.out.println(email2);
			*/
			String email = request.getParameter("email");
			PrintWriter pw = response.getWriter();
			String message = ""; //스크립트 언어를 적용하기 위한 변수
			if(email.equals("mekeyace@nate.com")) {
				message = "alert('이미 가입된 이메일 입니다.'); history.go(-1);";
			}
			else {
				message = "alert('인증번호 이메일을 발송 하였습니다.'); history.go(-1);";
			}
			//자바스크립트 태그를 이용하여 작동 시키는 코드
			pw.write("<script>" + message + "</script>");
	}

}
