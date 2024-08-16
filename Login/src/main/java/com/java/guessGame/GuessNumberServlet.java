package com.java.guessGame;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;


public class GuessNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    HttpSession session = request.getSession();
	    
		if(session.getAttribute("randomNum")==null) {
			int randomNum = new Random().nextInt(10)+1;
			session.setAttribute("randomNum", randomNum);
			session.setAttribute("attempts", 0);
		}
		
		int randomNumber = (int)session.getAttribute("randomNum");
		int userGuess = Integer.parseInt(request.getParameter("guess"));
		int attempts = (int)session.getAttribute("attempts");
		
		String message;
		
		if(randomNumber == userGuess) {
			message = "Congratulations! You guessed the correct number in " + (attempts + 1) + " attempts."
					+"Your Score Updated Successfully......";
			
//			int finalAttemptScore = (int) session.getAttribute("attempts");
			
			int finalAttemptScore = attempts+1;
			String loginUserName = (String) session.getAttribute("uname");
			
			String url = "jdbc:mysql://localhost:3306/saran";
			String username = "root";
			String password = "2323";
			
			String sql = "Update login set Score = ? where uname = ?";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, finalAttemptScore);
				ps.setString(2, loginUserName);
				ps.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.removeAttribute("randomNumber");
			session.removeAttribute("attempts");
			
			
		}else if(randomNumber > userGuess) {
			message = "Your number is Lowest... try again!!! ";
			attempts++;
			session.setAttribute("attempts", attempts);
		}else {
			message = "Your number is Higher... Try again!!!!!!";
			attempts++;
			session.setAttribute("attempts", attempts);
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("guess.jsp").forward(request, response);
	}

}
