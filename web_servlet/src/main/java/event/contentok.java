package event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class contentok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String captcha = request.getParameter("captcha");
		this.pw = response.getWriter();
		try {
			//외부에서 강제로 접근하여 데이터를 보낼 경우
			if(captcha.equals("") || !captcha.equals("testcon")) {
				this.pw.write("<script>"
						+ "alert('올바른 접근이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {	//보안코드가 맞을 경우 DB 연결
				this.con = new dbconfig().info();
				String c_part = request.getParameter("c_part");
				String c_corp = request.getParameter("c_corp");
				String c_name = request.getParameter("c_name");
				String c_email = request.getParameter("c_email");
				String c_tel = request.getParameter("c_tel");
				String c_text = request.getParameter("c_text");
				String c_agree = request.getParameter("c_agree");
				if(c_agree == null) {	//개인정보 수신 동의를 안할 경우 null처리 되므로 "N" 변경
					c_agree = "N";
				}
				String query = "insert into contents values ('0',?,?,?,?,?,?,?,now())";
				this.ps = this.con.prepareStatement(query);
				this.ps.setString(1, c_part);
				this.ps.setString(2, c_corp);
				this.ps.setString(3, c_name);
				this.ps.setString(4, c_email);
				this.ps.setString(5, c_tel);
				this.ps.setString(6, c_text);
				this.ps.setString(7, c_agree);
				Integer result = this.ps.executeUpdate();	//insert,delete,update
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('정상적으로 제휴문의가 등록 되었습니다.');"
							+ "location.href='./event.html';"
							+ "</script>");
				}
				else {
					this.pw.write("<script>"
							+ "alert('올바른 접근이 아니어서 다시 입력 부탁 드립니다.');"
							+ "history.go(-1);"
							+ "</script>");
				}
				
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

}
