package main.java.com.TableFootball.dao;

import main.java.com.TableFootball.config.DatabaseConnection;
import main.java.com.TableFootball.model.Player;


import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    private static final String INSERT_PLAYER = "INSERT INTO players(name, is_active) VALUES (?,?)";
    private static final String SELECT_ALL_PLAYERS = "SELECT * FROM players";
    private static final String SELECT_PLAYER = "SELECT * FROM players WHERE name = ?";
    private static final String TOGGLE_PLAYER = "UPDATE players SET is_active = NOT is_active WHERE name = ?";
    private static final String DELETE_PLAYER = "DELETE FROM players WHERE name = ?";
    private static final String UPDATE_PLAYER_NAME = "UPDATE players SET name = ? WHERE name = ?";


    public static void addPlayer(Player player) throws SQLException {


    try(Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYER)) {

        preparedStatement.setString(1, player.getName());
        preparedStatement.setBoolean(2, player.isIs_active());
        preparedStatement.executeUpdate();

        System.out.println("Player added successfully: " + player.getName());
        System.out.println("Player name: " + player.getName() + " is active: " + player.isIs_active());

    }


    }

    public static void togglePlayerStatus(String name) throws SQLException {

        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(TOGGLE_PLAYER)){

            stmt.setString(1, name);
            int rowAffected = stmt.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Player: " + name + " not found!");
            } else {
                System.out.println("Player status updated successfully");
                Player player = getPlayerByName(name);

                if (player.isIs_active()) {
                    System.out.println(name + " is active!");
                } else {
                    System.out.println(name + " is not active!");
                }

            }
        }
  }

    public static List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();

        try(Connection conection = DatabaseConnection.getInstance().getConnection();
            Statement statement = conection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PLAYERS)) {

            while(resultSet.next()) {
                Player player = new Player(
                        resultSet.getInt("playerid"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("is_active")
                );
                players.add(player);
                System.out.println(player.getId() +" Fatched player: " + player.getName() + " is active: " + player.isIs_active());
            }
            return players;
        }

    }

    public static Player getPlayerByName (String name) throws SQLException {

        try(Connection conection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(SELECT_PLAYER)){
            preparedStatement.setString(1, name);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return new Player(
                            resultSet.getInt("playerid"),
                            resultSet.getString("name"),
                            resultSet.getBoolean("is_active")
                    );
                }else {
                    throw new SQLException("Player: " + name + " not found!");
                }
            }
        }
    }

    public static void deletePlayer(String name) throws SQLException {
        try(Connection conection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(DELETE_PLAYER)){
            preparedStatement.setString(1, name);
            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected == 0) {
                throw new SQLException("Player: " + name + " not found!");
            } else {
                System.out.println("Player deleted successfully: " + name);
            }
        }
    }

    public static void updatePlayer(String name, String newName) throws SQLException {
        try(Connection conection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(UPDATE_PLAYER_NAME)){
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, name);
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Player: " + name + " not found!");
            } else {
                System.out.println("Player old name: " + name + "updated successfully, new name: " + newName);
            }

        }
    }

}
