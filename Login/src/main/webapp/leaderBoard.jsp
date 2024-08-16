<!DOCTYPE html>
<%@page import="com.java.leaderBoard.PlayerScore"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
    <title>Leaderboard</title>
</head>
<body>

<div align="center">
   <h2>Leaderboard</h2>
    <table border="1">
        <tr>
            <th>Rank</th>
            <th>Username</th>
            <th>Score</th>
        </tr>
        <% 
            // Assuming "leaderboard" is an ArrayList<Player> in your servlet
            ArrayList<PlayerScore> leaderboard = (ArrayList<PlayerScore>)request.getAttribute("leaderBoard");
            if (leaderboard != null) {
                for (int i = 0; i < leaderboard.size(); i++) {
                    PlayerScore player = leaderboard.get(i);
        %>
        <tr>
            <td><%= i + 1 %></td>
            <td><%= player.getUname() %></td>
            <td><%= player.getScore() %></td>
        </tr>
        <% 
                }
            }
        %>
    </table>
</div>
    
</body>
</html>
