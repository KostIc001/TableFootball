package main.java.com.TableFootball.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static volatile  DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection () {

        try {
            if (connection == null || connection.isClosed())
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Football", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnection getInstance(){
        if(instance == null){
            synchronized(DatabaseConnection.class){
                if(instance == null){
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
                }

public  Connection getConnection() {
        return connection;
}







    }





