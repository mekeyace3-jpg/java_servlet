package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* CORS를 정상적으로 요청을 받을 수 있도록 설정한 값 
		   access-control-allow-origin : 특정 도메인 및 모든 외부 Client 서버에서 접근을 허용해주는 사항
		   * : 모든 IP 및 도메인을 허락
		   "http://도메인" : 특정 도메인에 해당 되는 부분만 접속 허용
		   access-control-allow-credentials : 인증관련 사항을 정상적으로 외부에서 접근이 되도록 허용 (API-KEY)
		*/
		response.setHeader("access-control-allow-origin", "*");
		response.setHeader("access-control-allow-credentials", "true");
		
		//response.addHeader("access-control-allow-origin", "*");
		//response.addHeader("access-control-allow-credentials", "true");
		
		PrintWriter pw = response.getWriter();
		try {
			String data = "[50,20,30,40,50]";
			pw.print(data);
		} catch (Exception e) {
			pw.print("error");
		} finally {
			pw.close();
		}
	}
}
