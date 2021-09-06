package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		ServletContext toReg = getServletContext();
		RequestDispatcher dispatcher = toReg.getRequestDispatcher("/register.html");
		
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		String[] memList = new String[]{"홍길동", "이순신", "세종대왕"};
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
			out.println("<table>");
				out.println("<tr>");
					out.println("<td>아이디</td>");
					out.println("<td>삭제</td>");
					out.println("<td>수정</td>");
				out.println("</tr>");
				for (String uid : memList) {
					out.println("<tr>");
						out.println("<td>"+uid+"</td>");
						out.println("<td><a href=\"UpdateMem.html\">수정</a></td>");
						out.println("<td><a href=\"DeleteMem.html\">삭제</a></td>");
					out.println("</tr>");
				}
			out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}