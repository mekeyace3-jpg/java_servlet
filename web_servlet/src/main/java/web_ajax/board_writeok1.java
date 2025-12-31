package web_ajax;

import java.io.FilePermission;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.AccessController;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
)
public class board_writeok1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		System.out.println(content);
		Part file1 = request.getPart("file1");
		Part file2 = request.getPart("file2");
		Part file3 = request.getPart("file3");
		PrintWriter pw = response.getWriter();
		String filetype[] = {"bmp","jpeg","jpg","png","svg","webp"}; 
		String url = request.getServletContext().getRealPath("/upload/");	//웹 저장 경로
		System.out.println(url);
		if(file1.getSize() > 2097152 || file2.getSize() > 2097152 || file3.getSize() > 2097152) {
			pw.write("<script>"
					+ "alert('파일은 최대 2MB 이하로만 첨부 됩니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		else {
			ArrayList<String> savecheck = new ArrayList<String>();
			int w = 0;
			while(w < filetype.length) {
				if(file1.getContentType().contains(filetype[w]) == true) {
					file1.write(url+file1.getSubmittedFileName());
					savecheck.add("ok");
				}
				if(file2.getContentType().contains(filetype[w]) == true) {
					file2.write(url+file2.getSubmittedFileName());
					savecheck.add("ok");
				}
				if(file3.getContentType().contains(filetype[w]) == true) {
					file3.write(url+file3.getSubmittedFileName());
					savecheck.add("ok");
				}
				w++;
			}
						
			pw.write("<script>"
					+ "alert('파일 총" + savecheck.size() +"개가 등록 되었습니다.');"
					+ "alert('정상적으로 게시판이 등록 되었습니다.');"
					+ "location.href='http://naver.com';"
					+ "</script>");
		}
		pw.close();
		/*
		System.out.println(file1.getSize());	//파일용량
		System.out.println(file2.getContentType());		//파일 속성
		System.out.println(file3.getSubmittedFileName());	//파일명
		*/
	}

}
