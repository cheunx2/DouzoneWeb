package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		String[] memList = new String[]{"홍길동", "이순신", "세종대왕"};
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
			out.println("<table border='1' width='300'>");
				out.println("<tr bgcolor=#FFE333>");
					out.println("<td>아이디</td>");
					out.println("<td>삭제</td>");
					out.println("<td>수정</td>");
				out.println("</tr>");
				for (String uid : memList) {
					out.println("<tr>");
						out.println("<td>"+uid+"</td>");
						out.println("<td><a href='update?uid="+uid+"'>수정</a></td>");
						out.println("<td><a href='delete?uid="+uid+"'>삭제</a></td>");
					out.println("</tr>");
				}
			out.println("</table>");
			out.println("<a href='index.html'>Home</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
