import Kartodromo.Kartodromo;
import Connections.Connections;
import java.sql.ResultSet;

public class Main {
    
    public static void main(String[] args) {
        
        String hostname = "localhost";
        int port = 5432;
        String database = "postgres";
        String username = "postgres";
        String password = "postgres";

        try {
            
            //Kartodromo aplicativo = new Kartodromo();
            Connections c = new Connections();
            c.connect(hostname, port, database, username, password);
            ResultSet rs = c.receiveFromDataBase("select * from kart",new Object[]{});
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }
            c.disconnect();
            
        } catch (Exception e) {
            
        }
        
    }
}
