package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegServlet() {
        super();
        System.out.println("������ ��");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		String uid = request.getParameter("uid");
		System.out.println(uid);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(uid.length() > 0) {
			out.println(uid+"��, ���������� ���ԵǾ����ϴ�.");
			out.println("<br/>");
			out.println("<a href='index.html'>Home</a>");
		}else {
			out.println("���̵� 1���� �̻� �Է����ֽʽÿ�");
			out.println("<br/>");
			out.println("<a href='insert.html'>����â���� ���ư���</a>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
