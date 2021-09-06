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
		String[] memList = new String[]{"ȫ�浿", "�̼���", "�������"};
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
			out.println("<table>");
				out.println("<tr>");
					out.println("<td>���̵�</td>");
					out.println("<td>����</td>");
					out.println("<td>����</td>");
				out.println("</tr>");
				for (String uid : memList) {
					out.println("<tr>");
						out.println("<td>"+uid+"</td>");
						out.println("<td><a href=\"UpdateMem.html\">����</a></td>");
						out.println("<td><a href=\"DeleteMem.html\">����</a></td>");
					out.println("</tr>");
				}
			out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}