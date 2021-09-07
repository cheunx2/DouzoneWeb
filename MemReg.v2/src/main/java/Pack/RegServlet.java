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
        System.out.println("생성자 콜");
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
			out.println(uid+"님, 성공적으로 가입되었습니다.");
			out.println("<br/>");
			out.println("<a href='index.html'>Home</a>");
		}else {
			out.println("아이디를 1글자 이상 입력해주십시오");
			out.println("<br/>");
			out.println("<a href='insert.html'>가입창으로 돌아가기</a>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
