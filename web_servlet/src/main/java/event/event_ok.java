package event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class event_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter pw = null;
	Connection con = null;	//데이터 베이스 연결을 하기 위한 class
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		String enm = request.getParameter("enm");
		String etel = request.getParameter("etel");
		String email = request.getParameter("email");
		String epw = request.getParameter("epw");	//사용자가 직접 입력한 패스워드
		String echaracter = request.getParameter("echaracter");
		String agree1 = request.getParameter("agree1");
		String agree2 = request.getParameter("agree2");
		String agree3 = request.getParameter("agree3");
		
		try {
			this.con = new dbconfig().info();	//Database 실제 연결
			
			String repass = new repass_word().repass(epw);	//사용자 패스워드를 MD5 변환
			
			//SQL에 적용하는 쿼리문을 작성합니다.
			String query = "insert into event values "
					+ "('0','"+enm+"','"+etel+"','" +email+"','"+repass+"','"+echaracter+"',"
					+ "'"+agree1+"','"+agree2+"','"+agree3+"',now());";
			
			//Statement : Database에 대한 내용을 실행 하기 위한 Interface
			//createStatement() : 일반적인 쿼리문을 작성하는 방식 (정적쿼리문)
			//prepareStatement() : 보안을 기준으로 SQL 쿼리문을 작성하는 방식 (동적쿼리문)
			//select : 배열형태 => executeQuery()
			//insert,update,delete : 결과값이 숫자  => executeUpdate()
			Statement st = this.con.createStatement();
			Integer result = st.executeUpdate(query);	//쿼리문을 실행하고 결과를 return 합니다.
			
			//return 받은 결과를 조건문에 맞는 문법으로 출력
			if(result > 0) {
				this.pw.write("<script>"
						+ "alert('해당 이벤트에 정상적으로 신청 되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {
				this.pw.write("<script>"
						+ "alert('데이터베이스 오류로 인하여 현재 서비스 신청이 되지 않습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			st.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("데이터 베이스 접속 오류!!");
		} finally {
			try {
				this.con.close();
				this.pw.close();
			}catch (Exception e) {
				System.out.println("DB서버 오류로 인하여 정상적인 종료가 되지 않습니다.");
			}
		}
	}

}
