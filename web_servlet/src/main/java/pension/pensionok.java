package pension;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pensionok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con = null;
	PreparedStatement ps = null;	//? 형태로 select,update,delete,insert
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Frontend에서 배열로 생성하여 보내면 받는 상황 , 기준으로 문자형태로 받게 됨
		String person = request.getParameter("person");
		System.out.println(person);

	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.con = new db_pension().info();
			int w = 0;
			while(w < 10) {
			String query = "insert into notice values ('0',?,?,?,now())";
				this.ps = this.con.prepareStatement(query);
				this.ps.setString(1, "공지사항" + w);
				this.ps.setString(2, "관리자" + w);
				this.ps.setString(3, "내용" + w);
				this.ps.executeUpdate();
			w++;
			}
		} catch (Exception e) {
		
		} finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
}
