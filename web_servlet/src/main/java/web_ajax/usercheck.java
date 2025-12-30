package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class usercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[][] companyUsers = {
            {"user01", "pass111!", "테크노솔루션", "김철수", "123-45-67890"},
            {"alpha_biz", "alpha99@!", "알파소프트", "이영희", "234-56-78901"},
            {"global_trade", "gt7788#", "글로벌무역", "박준호", "345-67-89012"},
            {"nature_farm", "nf123456", "네이처팜", "최미경", "456-78-90123"},
            {"blue_ocean", "blue!@#", "블루오션기획", "정태양", "567-89-01234"},
            {"smart_factory", "sf9876", "스마트공방", "강산아", "678-90-12345"},
            {"k_design", "kd_7410", "케이디자인", "조현우", "789-01-23456"},
            {"mega_corp", "mc0000**", "메가코퍼레이션", "윤지민", "890-12-34567"},
            {"fast_logis", "fl_9988", "신속로지스", "한상원", "901-23-45678"},
            {"dream_edu", "dream_77", "드림에듀케이션", "임수아", "012-34-56789"}
    };
	
	PrintWriter pw = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("access-control-allow-origin", "*");
		response.addHeader("access-control-allow-credentials", "true");
		this.pw = response.getWriter();
		try {
			String part = request.getParameter("part");
			String data = request.getParameter("data");
			if(part.equals("1")) {
				System.out.println(data);
			}
			else if(part.equals("2")) {
				System.out.println(data);
			}
			else {
				this.pw.print("error");
			}	
		} catch (Exception e) {
			this.pw.print("error");
		} finally {
			this.pw.close();
		}
	}
}
