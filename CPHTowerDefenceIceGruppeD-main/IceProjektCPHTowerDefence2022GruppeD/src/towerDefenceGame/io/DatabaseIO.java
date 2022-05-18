package towerDefenceGame.io;

import towerDefenceGame.Player;

import java.sql.*;
import java.util.Scanner;

public class DatabaseIO {
    String input;
    DatabasePassword databasePassword;
    Scanner scan;
    Connection connection;
    String s;
    String arrow = "\u2192";
    Player tmpPlayer;
    int id;

    //constructor
    public DatabaseIO() {
        this.scan = new Scanner(System.in);
        this.input = scan.nextLine();
    }

    //method to create a connection to the SQL workbench
    private void createConnection() {
        databasePassword = new DatabasePassword();

        try {
            connection = DriverManager.getConnection(databasePassword.getJdbcUrl(), databasePassword.getUsername(), databasePassword.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to close a connection to the SQL workbench
    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to register a player into the SQL database
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
            query.close();
        } catch (SQLException e) {
            System.out.println(error);
            e.printStackTrace();
        }
        closeConnection();
    }

    //method to search for a player in the SQL database
    public void searchForPlayerFromDB() {
        createConnection();
        String selectAllIfName = "SELECT * FROM PlayerData WHERE name like ?";

        try {
            System.out.println("Search for a player:");
            PreparedStatement query = connection.prepareStatement(selectAllIfName);
            s = "%" + scan.nextLine() + "%";
            query.setString(1, s);
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

    //method to choose a player id
    public Player userInputOnID() {
        createConnection();
        String choosePlayer = "SELECT name from PlayerData WHERE id like ?";

        try {
            System.out.println("Choose a player by entering player id");
            PreparedStatement query = connection.prepareStatement(choosePlayer);
            id = scan.nextInt();
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                System.out.println("You have chosen the player: " + rs.getString("Name"));
                tmpPlayer = new Player(rs.getString("name"),id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpPlayer;
    }

    //method to show all registered players from the SQL database
    public void showAllPlayersFromDB() {
        createConnection();
        String showAllData = "SELECT * FROM PlayerData";

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

    //method to run the show all players and delete player methods
    public void deleteFromDB() {
        String choices = "\n" +
                arrow + " Press P to delete a player\n" +
                arrow + " Press D to delete all data";

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

    //method to delete a player from the SQL database
    public void deletePlayerFromDB() {
        createConnection();
        String deletePlayer = "DELETE FROM PlayerData WHERE id = ?";

        try {
            PreparedStatement query = connection.prepareStatement(deletePlayer);
            System.out.println("Enter the id of the player you want to delete:");
            s = scan.nextLine();
            query.setString(1, s);
            query.executeUpdate();
            System.out.println("You have deleted a player");
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    //method to show all players and scores from the SQL database
    public void showLeaderBoard() {
        System.out.println(">> LEADERBOARD <<");
        sortLeaderBoardDesc();
    }

    //method to delete all data from the SQL database
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

    //method to update scorepoints to a player(on ID)
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

    //method to sort score in descending order
    public void sortLeaderBoardDesc() {
        createConnection();
        String sortScoreDesc = "SELECT * FROM PlayerData ORDER BY scorepoints DESC";

        try {
            PreparedStatement query = connection.prepareStatement(sortScoreDesc);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") + "     " +
                        "Scorepoints: " + rs.getInt("scorepoints"));
            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}