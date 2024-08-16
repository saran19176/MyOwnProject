package userlogin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LeaderDao {
	public int updateLeaderBoard(int attempts, String uname) {
		String url = "jdbc:mysql://localhost:3306/saran";
		String userName = "root";
		String password = "2323";
		String sql = "UPDATE login Set Score = ? Where uname = ?";
		String sql1 = "Select uname,Score from login where Score > 0";
		
		try {
			Class.forName("com.jdbc.cj.mysql.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement st = con.prepareStatement(sql);
			PreparedStatement st1 = con.prepareStatement(sql1);
			
			st.setInt(1, Integer.valueOf(attempts)); 
	        st.setString(2, uname);
	        
	        ResultSet rs = st.executeQuery();
	        ResultSet rs1 = st1.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return attempts;
		
	}
}
