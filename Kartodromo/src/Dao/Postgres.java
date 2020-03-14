package Dao;

import Model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Postgres {

    private static Connection c;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private Database database;

    public Postgres() {
        database = new Database();
    }

    public String connect() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://" + database.getHostname() +
                    ":" + database.getPort() +
                    "/" + database.getName()
                    , database.getUsername(),
                    database.getPassword());
            return "Conectado!";
        } catch (Exception e) {
            return "Erro ao conectar!";
        }
    }

    public boolean Execute(String sql, Object[] valores) {
        try {

            ps = c.prepareStatement(sql);

            for (int i = 0; i < valores.length; i++) {
                ps.setObject(i + 1, valores[i]);
            }

            // Testa se conseguiu manipular o banco//

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            return false;
        }
    }

    public ResultSet Read(String sql, Object[] valores) throws Exception {

        ps = c.prepareStatement(sql);

        for (int i = 0; i < valores.length; i++) {
            ps.setObject(i + 1, valores[i]);
        }

        return ps.executeQuery();

    }

    public String disconnect() {
        try {
            if (c != null) {
                c.close();
            }
            return "Desconectado!";
        } catch (SQLException e) {
            return "Falha ao desconectar o BD! " + e.getMessage();
        } finally {
            if (c != null) {
                c = null;
                return "Desconectado!";
            }
        }
    }

}