package web_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class password extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    String mid=request.getParameter("mid");
	    String username=request.getParameter("username");
	    
	    String message="";
	    if(mid.equals("hong_gildong")&& username.equals("홍길동")) {
	    	message="a123456";
	    }else {
	    	message="해당 사용자의 정보를 확인하지 못하였습니다";
	  
	    }
	    request.setAttribute("msg", message);
	    request.setAttribute("part", "pw");  //form 2개이기 때문에 나눠서 보여지도록 설정함
	    
	    RequestDispatcher rd=request.getRequestDispatcher("./result.jsp");
	    rd.forward(request, response);
	}
	
	

}
