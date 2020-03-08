package Model;

public class Database {

    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;

    public Database() {
        hostname = "localhost";
        port = 5432;
        database = "kartodromo";
        username = "postgres";
        password = "postgres";
    }

    public Database(String hostname,int port,String databaseName,String username,String password) {
        this.hostname = hostname;
        this.port = port;
        this.database = databaseName;
        this.username = username;
        this.password = password;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
