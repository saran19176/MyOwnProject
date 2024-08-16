package userlogin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import userlogin.DAO.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname = request.getParameter("usname");
		String pass = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		LoginDao dao = new LoginDao();
		
		if(dao.check(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			
			response.sendRedirect("welcome.jsp");
		}else {
			out.println("<font color=red size = 19>Login Failed.........<br>");
			out.println("<a href = login.jsp>Try again!!!</a>");
		}
	}

}
