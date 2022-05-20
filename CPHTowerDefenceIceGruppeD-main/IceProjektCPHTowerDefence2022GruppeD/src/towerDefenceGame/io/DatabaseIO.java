package towerDefenceGame.io;

import towerDefenceGame.Player;
import java.sql.*;
import java.util.Scanner;

public class DatabaseIO {

    // OBJECTS OF CLASSES
    private DatabasePassword databasePassword;
    private Scanner scan;
    private Connection connection;
    private Player tmpPlayer;

    // STRINGS
    private String s;
    private String arrow = "\u2192";

    // PRIMITIVE DATA FIELDS
    private int id;

    // CONSTRUCTOR
    public DatabaseIO() {
        this.scan = new Scanner(System.in);
    }

    // Method to create a connection to the SQL workbench
    private void createConnection() {
        databasePassword = new DatabasePassword(); // creating a new DatabasePassword object

        try {
            connection = DriverManager.getConnection(databasePassword.getJdbcUrl(), databasePassword.getUsername(), databasePassword.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close a connection to the SQL workbench
    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) { // wrapped in a try catch to handle the otherwise thrown SQLException that would prevent us from running our program
            e.printStackTrace();
        }
    }

    // Method to register a player into the SQL database
    public void registerPlayerToDB() {
        createConnection();
        String error = "There is an error.";
        String insertNameInto = "INSERT INTO PlayerData (name) VALUES (?)";

        try {
            PreparedStatement query = connection.prepareStatement(insertNameInto);
            System.out.println("Add a player name:");
            s = scan.nextLine();
            query.setString(1, s);
            query.executeUpdate();
            System.out.println("You added player: " + s);
            query.close();
        } catch (SQLException e) {
            System.out.println(error);
            e.printStackTrace();
        }
        closeConnection();
    }

    // Method to search for a player in the SQL database
    public void searchForPlayerFromDB() {
        createConnection();
        String selectAllIfName = "SELECT * FROM PlayerData WHERE name like ?"; //selects all data from the database table with the name similar to the variable ?

        try {
            System.out.println("Search for all added players:");
            PreparedStatement query = connection.prepareStatement(selectAllIfName);
            s = "%" + scan.nextLine() + "%"; //
            query.setString(1, s);// the string names 's' here is what the ? variable is referencing
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                    System.out.println("ID: " + rs.getString("id") + " Name: " + rs.getString("name"));
            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    // Method to choose a player id - takes the input ( the id ) and connects it to the player name
    public Player userInputOnID() {
        createConnection();
        String choosePlayer = "SELECT name from PlayerData WHERE id like ?";  //this here saves the SQLcode to be executed in the database into a string.

        try {
            System.out.println("Choose a player by entering player id");
            PreparedStatement query = connection.prepareStatement(choosePlayer); // establishes a connection to  database and selects the string containing the SQLCode.
            id = scan.nextInt();
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();// this here then executes the SQLCODE after the above connection is established.

            while (rs.next()) {
                System.out.println("You have chosen the player: " + rs.getString("Name"));
                tmpPlayer = new Player(rs.getString("name"),id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpPlayer;
    }

    // Method to show all registered players from the SQL database
    public void showAllPlayersFromDB() {
        createConnection();
        String showAllData = "SELECT * FROM PlayerData"; // saves a statement that selects all data from a table named Playerdata into a string for later use.

        try {
            PreparedStatement query = connection.prepareStatement(showAllData);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id")
                        + "     Name: " + rs.getString("name"));
            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    // Method to run the show all players and delete player methods
    public void deleteFromDB() {
        String choices = "\n" +
                arrow + " Press P to delete a player\n" +
                arrow + " Press D to delete all data\n" +
                arrow + " Press Q to return to the main menu";

        createConnection();
        System.out.println("\n>> Registered Players <<");
        showAllPlayersFromDB();
        System.out.println(choices);

        String userInput = scan.nextLine();

        if (userInput.equalsIgnoreCase("P")) {
            deletePlayerFromDB();
        } else if (userInput.equalsIgnoreCase("D")) {
            deleteAllDataFromDB();
        }
        closeConnection();
    }

    // Method to delete a player from the SQL database
    public void deletePlayerFromDB() {
        createConnection();
        String deletePlayer = "DELETE FROM PlayerData WHERE id = ?"; //removes specific data which is similar to variable '?' from database table named playerdata

        try {
            PreparedStatement query = connection.prepareStatement(deletePlayer);
            System.out.println("Enter the id of the player you want to delete:");
            s = scan.nextLine();
            query.setString(1, s);
            query.executeUpdate();
            System.out.println("Succes! Player was deleted.");
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    // Method to show all players and scores from the SQL database
    public void showLeaderBoard() {
        System.out.println(">> LEADERBOARD <<");
        sortLeaderBoardDesc();
    }

    // Method to delete all data from the SQL database
    private void deleteAllDataFromDB() {
        createConnection();
        String deleteTable = "SELECT * FROM Ice.PlayerData";

        try {
            PreparedStatement queryOne = connection.prepareStatement(deleteTable);
            queryOne.executeQuery();
            deleteTable = "TRUNCATE TABLE Ice.PlayerData";
            PreparedStatement queryTwo = connection.prepareStatement(deleteTable);
            queryTwo.executeUpdate();
            queryTwo.close();
            System.out.println("You have now deleted all data");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the score from the SQL database
    public int getCurrentDBScore(Player player){
        int dbScore = 0;
        String currentScore = "SELECT scorepoints FROM PlayerData WHERE id = ?";

        try {
            PreparedStatement query = connection.prepareStatement(currentScore);
            query.setInt(1,player.getId());
            ResultSet rs = query.executeQuery();
            while (rs.next()){
                dbScore = rs.getInt("scorepoints");
            }
            query.close();
        } catch (SQLException w){
            w.printStackTrace();
        }
        return dbScore;
    }

    // Method to update scorepoints to a player(on ID) - updates if the new score is higher than the one saved
    public void updateScorePoint(Player player) {
        createConnection();
        String updateScorePoints = "UPDATE PlayerData SET scorepoints = ? WHERE id = ?";

        if (player.getScore() > getCurrentDBScore(player)) {
            try {
                PreparedStatement query = connection.prepareStatement(updateScorePoints);
                query.setInt(1, player.getScore());
                query.setInt(2, player.getId());
                query.executeUpdate();
                query.close();
                System.out.println("You have updated a score to player!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Your new score was not higher than your last.");
        }
    }

    // Method to sort score in descending order
    public void sortLeaderBoardDesc() {
        createConnection();
        String sortScoreDesc = "SELECT * FROM PlayerData ORDER BY scorepoints DESC";

        try {
            PreparedStatement query = connection.prepareStatement(sortScoreDesc);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                System.out.println("Player: " + rs.getString("name") + "     " +
                        "Highest Score: " + rs.getInt("scorepoints"));
            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}