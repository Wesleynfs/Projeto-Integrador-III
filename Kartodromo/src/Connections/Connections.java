package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connections {
    
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void connect(String hostname , int port , String database , String username , String password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + hostname + ":" + port + "/" + database, username, password);
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println("Não conectou no BD! " + e.getMessage());
        }
    }
    
    public static void disconnect() throws SQLException {
        try { 
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected");
            }
        } catch (SQLException e) {
            System.out.println("Falha ao desconectar BD! " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected");
            }
        }
    }
    
    public static boolean executeOnDataBase(String query , Object[] values) {
        try {
            preparedStatement = connection.prepareStatement(query);
            for (int x = 0 ; x < values.length ; x++) {
                preparedStatement.setObject(x, query);
            }
            return (preparedStatement.executeUpdate() > 0);
        } catch (Exception e) {
            return false;
        }
    }
    
    public static ResultSet receiveFromDataBase(String query , Object[] values) {   
        try {
            preparedStatement = connection.prepareStatement(query);
            for (int x = 0 ; x < values.length ; x++) {
                preparedStatement.setObject(x,values[x]);
            }
            return preparedStatement.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
}
