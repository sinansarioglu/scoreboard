package models;

import exceptions.OpponentsMustBeDifferentException;

import java.util.UUID;

public class Match {

    private final UUID id;
    private final Team home;
    private final Team away;
    private final Score score;

    public Match(Team home, Team away) throws OpponentsMustBeDifferentException {
        if(home.equals(away)) {
            throw new OpponentsMustBeDifferentException();
        }
        this.id = UUID.randomUUID();
        this.home = home;
        this.away = away;
        this.score = new Score();
    }

    public UUID getId() {
        return id;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score.setHomeScore(score.getHomeScore());
        this.score.setAwayScore(score.getAwayScore());
    }

    @Override
    public String toString() {
        return home.getName() + " " + score.getHomeScore() + " - " +
                away.getName() + " " + score.getAwayScore();
    }
}
