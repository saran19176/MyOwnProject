package com.java.leaderBoard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class LeaderBoardServlet
 */
public class LeaderBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<PlayerScore> leaderBoard = fetchDataFromDatabase();
		request.setAttribute("leaderBoard", leaderBoard);
		request.getRequestDispatcher("leaderBoard.jsp").forward(request, response);
	}
	
	public List<PlayerScore> fetchDataFromDatabase(){
		List<PlayerScore> leaderBoard = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/saran";
		String username = "root";
		String password = "2323";
		String sql = "Select uname, Score from login ORDER BY Score ASC";
		
		try (Connection connection = DriverManager.getConnection(url, username, password);
	             PreparedStatement statement = connection.prepareStatement(sql);
	             ResultSet resultSet = statement.executeQuery()) {
	            
	            while (resultSet.next()) {
	                String uname = resultSet.getString("uname");
	                int score = resultSet.getInt("score");
	                leaderBoard.add(new PlayerScore(uname, score));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle database errors
	        }
	        return leaderBoard;
		
	}


}
