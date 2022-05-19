package towerDefenceGame.io;

public class DatabasePassword {
    private final String JdbcUrl;
    private final String username;
    private final String password;

    // CONSTRUCTOR
    public DatabasePassword() {
        this.JdbcUrl = "jdbc:mysql://127.0.0.1:3306/Ice?" + "autoReconnect=true&useSSL=false";
        this.username = "root";
        this.password = "LangeBananer74";
        //this.password = "Lampen04aug";
    }

    public String getJdbcUrl() {
        return this.JdbcUrl;
    }

    // Getter to get the username
    public String getUsername() {
        return this.username;
    }

    // Getter to get the password
    public String getPassword() {
        return this.password;
    }
}
