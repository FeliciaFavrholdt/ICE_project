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
    String id;
    String dbName;

    //constructor
    public DatabaseIO(Player player) {
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
            for (int i = 0; i < 100; i++) {
                System.out.println("Add a player name or press Q to return to the menu");
                s = scan.nextLine();

                if (s.equalsIgnoreCase("q")) {
                    System.out.println("need method here to go back to menu");
                    break;
                }
                query.setString(1, s);
                query.executeUpdate();
            }
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
                dbName = rs.getString("name");
                id = rs.getString("id");

                System.out.println("ID: " + id + " Name: " + dbName);
            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userInputOnID();
        closeConnection();
    }

    //method to ...
    public void userInputOnID() {
        createConnection();
        String choosePlayer = "SELECT name from PlayerData WHERE id like ?";

        try {
            System.out.println("Choose a player by entering player id");
            PreparedStatement query = connection.prepareStatement(choosePlayer);
            int id = scan.nextInt();
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public void ShowAllPlayersAndDeleteFromDB() {
        String choices = "\n" +
                arrow + " Press P to delete a player\n" +
                arrow + " Press D to delete all data\n" +
                arrow + " Press Q to return to the menu";

        createConnection();
        System.out.println("\n>> Registered Players <<");
        showAllPlayersFromDB();
        System.out.println(choices);

        String userInput = scan.nextLine();

        if (userInput.equalsIgnoreCase("P")) {
            deletePlayerFromDB();
        } else if (userInput.equalsIgnoreCase("D")) {
            deleteAllDataFromDB();
        } else if (userInput.equalsIgnoreCase("Q")) {
            System.out.println("put method here to return to the menu");
        }
        scan.close();
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
            query.close();
            System.out.println("You have deleted a player");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to show all players and scores from the SQL database
    public void showLeaderBoard() {
        System.out.println(">> LEADERBOARD <<");
        leaderBoardByScoreDesc();
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

    //method to update scorepoints to a player(on ID)
    private void updateScorePoint() {
        createConnection();
        String updateScorePoints = "UPDATE PlayerData SET scorepoints = ? WHERE id = ?";

        try {
            PreparedStatement query = connection.prepareStatement(updateScorePoints);
            System.out.println(arrow + " Enter Score:");
            String id = scan.nextLine();
            query.setString(1, id);
            System.out.println(arrow + " Assign to player ID:");
            String score = scan.nextLine();
            query.setString(2, score);
            query.executeUpdate();
            query.close();
            System.out.println("You have updated a score to player!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to sort score in descending order
    public void leaderBoardByScoreDesc() {
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