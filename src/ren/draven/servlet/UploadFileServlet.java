/* UploadFileServlet.java */
package ren.draven.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadFile")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取文件部件 part
		Part part = req.getPart("upfile");

		// 获取请求的信息
		String name = part.getHeader("content-disposition");
		System.out.println(name);

		String root = req.getServletContext().getRealPath("/upload");
		System.out.println(root);

		// 文件类型后缀
		String str = name.substring(name.lastIndexOf("."), name.length() - 1);
		System.out.println(str);
		// 新的路径文件名
		String uploadPath = "d:/upload";
		// String filename = root + "\\" + UUID.randomUUID().toString() + str;
		String filename = uploadPath + "/" + UUID.randomUUID().toString() + str;
		System.out.println(filename);

		 part.write(filename);
	}

}
