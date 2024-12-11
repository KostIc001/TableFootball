package main.java.com.TableFootball.dao;



import main.java.com.TableFootball.config.DatabaseConnection;
import main.java.com.TableFootball.model.Match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchDAO {

    private static final String INSERT_MATCH = "INSERT INTO match(team1_player1, team1_player2, team2_player1, team2_player2,winner_team, score) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_BY_PLAYER_ID ="SELECT matchid, team1_player1, team1_player2, team2_player1, team2_player2 "
            + "FROM Match"
            + "WHERE team1_player1 = ? OR team1_player2 = ? OR team2_player1 = ? OR team2_player2 = ?";

    public static void addMatch(Match match) throws SQLException {

        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATCH)) {
            preparedStatement.setInt(1, match.getCrveni1());
            preparedStatement.setInt(2, match.getCrveni2());
            preparedStatement.setInt(3, match.getPlavi1());
            preparedStatement.setInt(4, match.getPlavi2());
            preparedStatement.setString(5, match.getWinnerTeam().toString());
            preparedStatement.setString(6, match.getScore());
            preparedStatement.executeUpdate();

            System.out.println("Match added successfully");



        }






    }

    public static void selectMatchByPlayerId(Match match) throws SQLException {
        try(Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_PLAYER_ID)) {
            preparedStatement.setInt(1, match.getCrveni1());
            preparedStatement.setInt(2, match.getCrveni2());
            preparedStatement.setInt(3, match.getPlavi1());
            preparedStatement.setInt(4, match.getPlavi2());
            preparedStatement.setString(5, match.getWinnerTeam().toString());
            preparedStatement.setString(6, match.getScore());
            ResultSet resultSet = preparedStatement.executeQuery();


            if(resultSet == null){
                System.out.println("No match found for this player");
            }else {
                System.out.println("Match found for this player");
            }
        }
    }


}
