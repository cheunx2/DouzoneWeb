package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.setContentType("text/html; charset = UTF-8");
		String uid = request.getParameter("uid");
		System.out.println(uid);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
			out.println(uid+"님, 정보가 삭제 되었습니다.");
			out.println("<a href='list'>목록으로</a>");
			out.println("<a href='index.html'>Home</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
