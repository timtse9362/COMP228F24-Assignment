package com.example.kinchuentse_comp228lab5;

import java.time.LocalDate;

public class ReportRow {
    private String playerId;
    private String firstName;
    private String lastName;
    private String gameTitle;
    private LocalDate playingDate;
    private int score;

    public ReportRow(String playerId, String firstName, String lastName, String gameTitle, LocalDate playingDate, int score) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gameTitle = gameTitle;
        this.playingDate = playingDate;
        this.score = score;
    }

    public String getPlayerId() { return playerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGameTitle() { return gameTitle; }
    public LocalDate getPlayingDate() { return playingDate; }
    public int getScore() { return score; }
}
