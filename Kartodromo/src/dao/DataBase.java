package kartodromo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

    private static Connection c;
    private static PreparedStatement ps;
    private static ResultSet rs;

    String hostname = "localhost";
    int port = 5432;
    String database = "postgres";
    String username = "postgres";
    String password = "postgres";

    public boolean connect() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://" + hostname + ":" + port + "/" + database, username, password);
            return true;
        } catch (Exception e) {
            return false;
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

    public void disconnect() {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            System.out.println("Falha ao desconectar o BD! " + e.getMessage());
        } finally {
            if (c != null) {
                c = null;
            }
        }
    }

}