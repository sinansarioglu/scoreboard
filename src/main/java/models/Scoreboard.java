package models;

import exceptions.MatchAlreadyStartedException;
import exceptions.MatchDoesNotExistException;
import exceptions.TeamPlaysMatchException;

import java.util.*;
import java.util.stream.Collectors;

public class Scoreboard {
    private final UUID id;
    private static Map<UUID, Match> matches;

    public Scoreboard() {
        this.id = UUID.randomUUID();
        this.matches = new LinkedHashMap<>();
    }

    public void startMatch(Match match) throws MatchAlreadyStartedException, TeamPlaysMatchException {
        if(match == null) {
            throw new NullPointerException();
        } else if(matches.containsKey(match.getId())) {
            throw new MatchAlreadyStartedException();
        }
        checkLiveMatches(match);
        matches.put(match.getId(), match);
    }

    public void updateMatchScore(UUID id, Score score) throws MatchDoesNotExistException {
        if(id == null) {
            throw new NullPointerException();
        } else if(!matches.containsKey(id)) {
            throw new MatchDoesNotExistException(id);
        }
        Match match = matches.get(id);
        match.setScore(score);
    }

    public void finishMatch(UUID id) throws MatchDoesNotExistException {
        if(!matches.containsKey(id)) {
            throw new MatchDoesNotExistException(id);
        }
        matches.remove(id);
    }

    public List<Match> getSummary() {
        List<Match> liveMatches = new ArrayList<>(matches.values());
        return liveMatches.stream().sorted((m1,m2) -> {
            if(m1.getScore().getHomeScore() + m1.getScore().getAwayScore() >=
                m2.getScore().getHomeScore() + m2.getScore().getAwayScore()) {
                return -1;
            } else {
                return 1;
            }
        }).collect(Collectors.toList());
    }

    private void checkLiveMatches(Match match) throws TeamPlaysMatchException {
        if(checkTeamPlaysMatch(match.getHome())) {
            throw new TeamPlaysMatchException(match.getHome().getName());
        } else if(checkTeamPlaysMatch(match.getAway())) {
            throw new TeamPlaysMatchException(match.getAway().getName());
        }
    }

    private boolean checkTeamPlaysMatch(Team team) {
        List<Match> liveMatches = new ArrayList<>(matches.values());
        long foundMatchCount = liveMatches.stream()
                .filter(match -> match.getHome().equals(team) || match.getAway().equals(team))
                .count();
        return foundMatchCount > 0 ? true : false;
    }
}
