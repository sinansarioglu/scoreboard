package models;

import java.util.UUID;

public class Score {
    private UUID id;
    private int homeScore;
    private int awayScore;

    public Score() {
        this.id = UUID.randomUUID();
        this.homeScore = 0;
        this.awayScore = 0;
    }
    public Score(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public UUID getId() {
        return id;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
}
