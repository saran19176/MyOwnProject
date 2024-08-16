package com.java.signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String suName = request.getParameter("suname");
		String suPassword = request.getParameter("supassword");
		
		PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/saran";
		String username = "root";
		String password = "2323";
		
		String sql = "Insert Into login (uname, password) Values (?, ?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, suName);
			ps.setString(2, suPassword);
			
			int rowAffected = ps.executeUpdate();
			
			if(rowAffected>0) {
				response.sendRedirect("successSignup.jsp");
			}
			else {
				out.println("<font color=red size = 19>Signup Failed.........<br>");
				out.println("<a href = signup.jsp>Try again!!!</a>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
