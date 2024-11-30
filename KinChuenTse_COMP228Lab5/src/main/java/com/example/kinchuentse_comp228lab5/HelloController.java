package com.example.kinchuentse_comp228lab5;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

public class HelloController {
    @FXML
    private TextField playerIdField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField provinceField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField gameIdField;
    @FXML
    private TextField gameTitleField;
    @FXML
    private TextField scoreField;
    @FXML
    private TextField reportPlayerIdField;
    @FXML
    private TableView<ReportRow> reportTable;
    @FXML
    private TableColumn<ReportRow, String> playerIdColumn;
    @FXML
    private TableColumn<ReportRow, String> firstNameColumn;
    @FXML
    private TableColumn<ReportRow, String> lastNameColumn;
    @FXML
    private TableColumn<ReportRow, String> gameTitleColumn;
    @FXML
    private TableColumn<ReportRow, String> playingDateColumn;
    @FXML
    private TableColumn<ReportRow, Integer> scoreColumn;

    private static final String URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD"; // db connection outside school
    //private static final String URL = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD"; // db connection in school
    private static final String USER = "COMP228_F24_soh_28";
    private static final String PASSWORD = "new_password";

    @FXML
    private void insertPlayerAndGame() { //The function to insert all the player and game information into the database
        String playerId = playerIdField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String postalCode = postalCodeField.getText();
        String province = provinceField.getText();
        String phoneNumber = phoneNumberField.getText();
        String gameId = gameIdField.getText();
        String gameTitle = gameTitleField.getText();
        int score = 0;
        if (!scoreField.getText().trim().isEmpty()) {
            score = Integer.parseInt(scoreField.getText());
        }

        try { //Exception handling to check if there is any empty text field
            if (playerId.isEmpty()) {
                throw new IllegalArgumentException("Player ID cannot be empty");
            }
            if (firstName.isEmpty()) {
                throw new IllegalArgumentException("First name cannot be empty");
            }
            if (lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be empty");
            }
            if (address.isEmpty()) {
                throw new IllegalArgumentException("Address cannot be empty");
            }
            if (postalCode.isEmpty()) {
                throw new IllegalArgumentException("Postal Code cannot be empty");
            }
            if (province.isEmpty()) {
                throw new IllegalArgumentException("Province cannot be empty");
            }
            if (phoneNumber.isEmpty()) {
                throw new IllegalArgumentException("Phone Number cannot be empty");
            }
            if (gameId.isEmpty()) {
                throw new IllegalArgumentException("Game ID be empty");
            }
            if (gameTitle.isEmpty()) {
                throw new IllegalArgumentException("Game title cannot be empty");
            }
            if (scoreField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Game score cannot be empty");
            }

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) { //Exception handling to check if the table exists. If the table does not exist, the program will create the table.
                // Check if the Player table exists, create it if not
                if (!tableExists(conn, "Kin_Chuen_Tse_player")) {
                    createPlayerTable(conn);
                    System.out.println("Player table created successfully.");
                }

                // Check if the Game table exists, create it if not
                if (!tableExists(conn, "Kin_Chuen_Tse_game")) {
                    createGameTable(conn);
                    System.out.println("Game table created successfully.");
                }

                // Check if the PlayerAndGame table exists, create it if not
                if (!tableExists(conn, "Kin_Chuen_Tse_player_and_game")) {
                    createPlayerAndGameTable(conn);
                    System.out.println("PlayerAndGame table created successfully.");
                }

                // Insert player data using prepared statement
                String insertPlayerSQL = "INSERT INTO Kin_Chuen_Tse_player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement playerStmt = conn.prepareStatement(insertPlayerSQL);
                playerStmt.setString(1, playerId);
                playerStmt.setString(2, firstName);
                playerStmt.setString(3, lastName);
                playerStmt.setString(4, address);
                playerStmt.setString(5, postalCode);
                playerStmt.setString(6, province);
                playerStmt.setString(7, phoneNumber);
                playerStmt.executeUpdate();


                // Insert game data using prepared statement
                String insertGameSQL = "INSERT INTO Kin_Chuen_Tse_game (game_id, game_title) VALUES (?, ?)";
                PreparedStatement gameStmt = conn.prepareStatement(insertGameSQL);
                gameStmt.setString(1, gameId);
                gameStmt.setString(2, gameTitle);
                gameStmt.executeUpdate();


                // Insert playerandgame data using prepared statement
                String insertPlayerGameSQL = "INSERT INTO Kin_Chuen_Tse_player_and_game (player_game_id, player_id, game_id, playing_date, score) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement playerGameStmt = conn.prepareStatement(insertPlayerGameSQL);
                playerGameStmt.setString(1, UUID.randomUUID().toString());
                playerGameStmt.setString(2, playerId);
                playerGameStmt.setString(3, gameId);
                playerGameStmt.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                playerGameStmt.setInt(5, score); // Default score
                playerGameStmt.executeUpdate();

                System.out.println("Player and game inserted successfully.");
            } catch (
                    SQLException e) { //This will show error message when there is error when inserting data to the tables
                System.err.println("Error inserting data: " + e.getMessage());
            }
        }
        catch(IllegalArgumentException e){ //This will show error message if there is any empty field
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void updatePlayer() { //Function to update the existing user information
        String playerId = playerIdField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String postalCode = postalCodeField.getText();
        String province = provinceField.getText();
        String phoneNumber = phoneNumberField.getText();

        try { //Exception handling to check if there is empty player information field
            if (playerId.isEmpty()) {
                throw new IllegalArgumentException("Player ID cannot be empty");
            }
            if (firstName.isEmpty()) {
                throw new IllegalArgumentException("First name cannot be empty");
            }
            if (lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be empty");
            }
            if (address.isEmpty()) {
                throw new IllegalArgumentException("Address cannot be empty");
            }
            if (postalCode.isEmpty()) {
                throw new IllegalArgumentException("Postal Code cannot be empty");
            }
            if (province.isEmpty()) {
                throw new IllegalArgumentException("Province cannot be empty");
            }
            if (phoneNumber.isEmpty()) {
                throw new IllegalArgumentException("Phone Number cannot be empty");
            }

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {//Exception handling to check if is database connection issue

                // Update player data
                String updatePlayerSQL = "UPDATE Kin_Chuen_Tse_player SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ? WHERE player_id = ?";
                PreparedStatement playerStmt = conn.prepareStatement(updatePlayerSQL); //Prepared statement to update player information
                playerStmt.setString(1, firstName);
                playerStmt.setString(2, lastName);
                playerStmt.setString(3, address);
                playerStmt.setString(4, postalCode);
                playerStmt.setString(5, province);
                playerStmt.setString(6, phoneNumber);
                playerStmt.setString(7, playerId);
                int rowsAffected = playerStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Player updated successfully.");
                } else {
                    System.out.println("No player found with ID: " + playerId);
                }

            } catch (SQLException e) { //Will show error message when there is error when updating player information
                System.err.println("Error updating player: " + e.getMessage());
            }
        }
        catch(IllegalArgumentException e){ //Will show error message when there is database connection issue
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    private void checkTableExists() { //Function to call the tableExists() function to check if the tables exist
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) { //Exception handling to check if is database connection issue
            // Check if the Player table exists
            if (!tableExists(conn, "Kin_Chuen_Tse_player")) {
                createPlayerTable(conn);
                System.out.println("Player table created successfully.");
            } else {
                System.out.println("Player table already exists.");
            }

            // Check if the Game table exists
            if (!tableExists(conn, "Kin_Chuen_Tse_game")) {
                createGameTable(conn);
                System.out.println("Game table created successfully.");
            } else {
                System.out.println("Game table already exists.");
            }

            // Check if the PlayerAndGame table exists
            if (!tableExists(conn, "Kin_Chuen_Tse_player_and_game")) {
                createPlayerAndGameTable(conn);
                System.out.println("PlayerAndGame table created successfully.");
            } else {
                System.out.println("PlayerAndGame table already exists.");
            }
        } catch (SQLException e) { //Will show error message when there is database connection issue
            System.err.println("Error checking or creating tables: " + e.getMessage());
        }
    }

    private boolean tableExists(Connection conn, String tableName) throws SQLException { //Function to check if the tables exist
        String query = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, tableName.toUpperCase());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1) > 0;
        }
        return false;
    }

    private void createPlayerTable(Connection conn) throws SQLException { //Function to create the Player table
        String createPlayerTableSQL = "CREATE TABLE Kin_Chuen_Tse_player (" +
                "player_id VARCHAR2(36) PRIMARY KEY, " +
                "first_name VARCHAR2(50) NOT NULL, " +
                "last_name VARCHAR2(50) NOT NULL, " +
                "address VARCHAR2(100) NOT NULL, " +
                "postal_code VARCHAR2(10) NOT NULL, " +
                "province VARCHAR2(50) NOT NULL, " +
                "phone_number VARCHAR2(20) NOT NULL" +
                ")";
        PreparedStatement statement = conn.prepareStatement(createPlayerTableSQL);
        statement.executeUpdate();
    }

    private void createGameTable(Connection conn) throws SQLException { //Function to create the Game table
        String createGameTableSQL = "CREATE TABLE Kin_Chuen_Tse_game (" +
                "game_id VARCHAR2(36) PRIMARY KEY, " +
                "game_title VARCHAR2(100) NOT NULL" +
                ")";
        PreparedStatement statement = conn.prepareStatement(createGameTableSQL);
        statement.executeUpdate();
    }

    private void createPlayerAndGameTable(Connection conn) throws SQLException { //Function to create the PlayerAndGame table
        String createPlayerAndGameTableSQL = "CREATE TABLE Kin_Chuen_Tse_player_and_game (" +
                "player_game_id VARCHAR2(36) PRIMARY KEY, " +
                "player_id VARCHAR2(36) NOT NULL, " +
                "game_id VARCHAR2(36) NOT NULL, " +
                "playing_date DATE NOT NULL, " +
                "score INTEGER NOT NULL, " +
                "FOREIGN KEY (player_id) REFERENCES Kin_Chuen_Tse_player(player_id), " +
                "FOREIGN KEY (game_id) REFERENCES Kin_Chuen_Tse_game(game_id)" +
                ")";
        PreparedStatement statement = conn.prepareStatement(createPlayerAndGameTableSQL);
        statement.executeUpdate();
    }

    @FXML
    private void displayReport() { //Function to display the play and game information according to the player id
        String playerId = reportPlayerIdField.getText();
        ObservableList<ReportRow> reportData = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) { //Exception handling to check if is database connection issue
            String query = "SELECT p.player_id, p.first_name, p.last_name, g.game_title, pg.playing_date, pg.score " +
                    "FROM Kin_Chuen_Tse_player p " +
                    "JOIN Kin_Chuen_Tse_player_and_game pg ON p.player_id = pg.player_id " +
                    "JOIN Kin_Chuen_Tse_game g ON pg.game_id = g.game_id " +
                    "WHERE p.player_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, playerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reportData.add(new ReportRow(
                        resultSet.getString("player_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("game_title"),
                        resultSet.getDate("playing_date").toLocalDate(),
                        resultSet.getInt("score")
                ));
            }

            playerIdColumn.setCellValueFactory(new PropertyValueFactory<>("playerId"));
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            gameTitleColumn.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
            playingDateColumn.setCellValueFactory(new PropertyValueFactory<>("playingDate"));
            scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

            reportTable.setItems(reportData);
        } catch (SQLException e) { //Will show error message when there is database connection issue
            System.err.println("Error displaying report: " + e.getMessage());
        }
    }
}


