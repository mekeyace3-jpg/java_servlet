package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//@MultipartConfig : buffered 역활
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,		//한개의 파일 전송 크기 : 2MB (Temp)
	maxFileSize = 1024 * 1024 * 3,			//파일 한개당 최대 크기 : 3MB
	maxRequestSize = 1024 * 1024 * 100		//파일 전체 용량 : 100MB
)
public class fileok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		try {
			Part mfile = request.getPart("mfile");
			String filename = mfile.getSubmittedFileName();
			long filesize = mfile.getSize();
			String file = mfile.getName();
			System.out.println(file);
			System.out.println(filename);
			System.out.println(filesize);
			//request.getServletContext() : was의 전체 경로를 설정하는 class 입니다.
			//getRealPath(디렉토리명) : web 디렉토리를 말합니다.
			String url = request.getServletContext().getRealPath("/upload/");
			mfile.write(url + filename);
			
			pw.write("<script>"
					+ "alert('해당 파일을 올바르게 저장 하였습니다.');"
					+ "location.href='../ajax/file.html';"
					+ "</script>");
			pw.close();
		} catch (Exception e) {
			
		}
		
	}

}
