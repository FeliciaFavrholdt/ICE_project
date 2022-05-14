package towerDefenceGame.io;

import towerDefenceGame.game.GameMenu;
import towerDefenceGame.game.GameSetup;

import java.sql.*;
import java.util.Scanner;

public class DatabaseIO {
    StringBuilder userInput;
    DatabasePassword databasePassword;
    GameMenu gameMenu;
    Scanner scan;
    Connection connection;
    String s;
    String arrowSymbol = "\u2192";

    //CONSTRUCTOR
    public DatabaseIO() {
        this.scan = new Scanner(System.in);
        this.userInput = new StringBuilder();
    }

    //method to create a connection to the SQL workbench
    public void createConnection() {
        databasePassword = new DatabasePassword();

        try {
            connection = DriverManager.getConnection(databasePassword.getJdbcUrl(), databasePassword.getUsername(), databasePassword.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to close a connection to the SQL workbench
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to register a player into the SQL database
    public void registerPlayerToDB() {
        gameMenu = new GameMenu();
        createConnection();
        String error = "There is an error.";
        String playerName = "INSERT INTO PlayerData (name) VALUES (?)";

        try {
            PreparedStatement query = connection.prepareStatement(playerName);
            for (int i = 0; i < 100; i++) {
                System.out.println("Add a player name or press Q to return to the menu");
                s = scan.nextLine();

                if (s.equalsIgnoreCase("q")) {
                    gameMenu.userMenu();
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
        String playerName = "SELECT * FROM PlayerData WHERE name like ?";

        try {
            System.out.println("Search for a name:");
            PreparedStatement query = connection.prepareStatement(playerName);
            s = "%" + scan.nextLine() + "%";
            query.setString(1, s);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id")
                        + " Name: " + rs.getString("name"));
            }
            query.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
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
        gameMenu = new GameMenu();
        String choices = "\n" + arrowSymbol + " Press P to delete a player\n" +
                arrowSymbol + " Press D to delete all data\n" +
                arrowSymbol + " Press Q to return to the menu";

        createConnection();
        System.out.println("\n>> Registered Players <<");
        showAllPlayersFromDB();
        System.out.println(choices);

        userInput.append(scan.nextLine());
        if (userInput.toString().equalsIgnoreCase("P")) {
            deletePlayerFromDB();
        } else if (userInput.toString().equalsIgnoreCase("D")) {
            deleteAllDataFromDB();
        } else if (userInput.toString().equalsIgnoreCase("Q")) {
            gameMenu.userMenu();
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
        gameMenu.userMenu();
    }

    //method to show all players and scores from the SQL database
    public void showLeaderBoard() {
        System.out.println(">> LEADERBOARD <<");
        leaderBoardByScoreDesc();
    }

    //method to delete all data from the SQL database
    public void deleteAllDataFromDB() {
        createConnection();
        String deleteTable = "SELECT * FROM Ice.PlayerData";

        try {
            PreparedStatement query = connection.prepareStatement(deleteTable);
            query.executeQuery();
            deleteTable = "TRUNCATE TABLE Ice.PlayerData";
            PreparedStatement query1 = connection.prepareStatement(deleteTable);
            query1.executeUpdate();
            query1.close();
            System.out.println("You have now deleted all data");
            gameMenu.userMenu();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("not working");
        }
    }

    //method to show all players and add scorepoints to the SQL database
    public void addScorePointsToDB() {
        System.out.println("\n>> Registered Players <<");
        showAllPlayersFromDB();
        System.out.println("\n>> Add/Update a score to a player <<");
        updateScorePoint();
    }

    //method to update scorepoints to a player(on ID)
    public void updateScorePoint() {
        gameMenu = new GameMenu();
        createConnection();
        String updateScorePoints = "UPDATE PlayerData SET scorepoints = ? WHERE id = ?";

        try {
            PreparedStatement query = connection.prepareStatement(updateScorePoints);
            System.out.println(arrowSymbol + " Enter Score:");
            String id = scan.nextLine();
            query.setString(1, id);
            System.out.println(arrowSymbol + " Assign to player ID:");
            String score = scan.nextLine();
            query.setString(2, score);
            query.executeUpdate();
            query.close();
            System.out.println("You have updated a score to player!");
            gameMenu.userMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to sort score in descending order    //FIX THIS TO MAKE IT LOOK BETTER
    public void leaderBoardByScoreDesc() {
        gameMenu = new GameMenu();
        createConnection();
        String sortDesc = "SELECT * FROM PlayerData ORDER BY scorepoints DESC";
        String spaces = "                 ";

        try {
            PreparedStatement query = connection.prepareStatement(sortDesc);
            ResultSet rs = query.executeQuery();
            System.out.print("Name" + spaces + "Scorepoints");
            System.out.println("\n__________________________________________");

            while (rs.next()) {
                System.out.print(rs.getString("name") + spaces + rs.getInt("scorepoints"));
                System.out.println("\n__________________________________________");
            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        gameMenu.userMenu();
    }

       /* fix this if ident works
    public void makeIndent(String name, int scorepoints) {
        String indent = "%-10s%-10d-2s";
        System.out.printf(indent, name, scorepoints);
        System.out.println();
        leaderBoardByScoreDesc();
    }
    */
}