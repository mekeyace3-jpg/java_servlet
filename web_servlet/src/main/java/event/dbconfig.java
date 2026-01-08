package event;

import java.sql.Connection;

//Database를 Servlet에서 사용할 수 있도록 Database정보를 셋팅하는 Model
public class dbconfig {
	
	public Connection info() throws Exception{
		//mysql version별로 Driver 항목을 적용
		//com.mysql.cj.jdbc.Driver => 5.7x ~ 10
		//com.mysql.jdbc.Driver => 5.1 ~ 5.5x
		String db_driver = "com.mysql.cj.jdbc.Driver";
		//데이터베이스 연결 서버 정보
		String db_url = "jdbc:mysql://localhost:3306/website";
		//데이터베이스 가상 사용자의 아이디 및 패스워드
		String db_user = "hong";
		String db_pass = "a12356";
		
		return null;
	}
	
}
