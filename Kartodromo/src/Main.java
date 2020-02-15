import Kartodromo.Kartodromo;
import Connections.Connections;
import java.sql.ResultSet;

public class Main {
    
        private final static String hostname = "localhost";
        private final static int port = 5432;
        private final static String database = "postgres";
        private final static String username = "postgres";
        private final static String password = "postgres";
    
    public static void main(String[] args) throws Exception {

        //Kartodromo aplicativo = new Kartodromo();
        Connections c = new Connections();
        c.connect(hostname, port, database, username, password);
        ResultSet rs = c.receiveFromDataBase("select * from kart",new Object[]{});
        while (rs.next()) { 
            System.out.println(rs.getString("nome"));
        }
        c.disconnect();

    }
}
