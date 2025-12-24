package web_servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mname=request.getParameter("mname");
		String memail=request.getParameter("memail");
		
		String message="";
		if(mname.equals("홍길동") && memail.equals("hong@nate.com")) {
			message="hong_gildong";
		}
		else {
			message="해당 정보가 확인되지 않습니다";
		}
		request.setAttribute("msg",message);
		request.setAttribute("part", "id");  //form 2개이기 때문에 나눠서 보여지도록 설정함
		
		RequestDispatcher rd=request.getRequestDispatcher("./result.jsp");
		rd.forward(request, response);
	}
}
