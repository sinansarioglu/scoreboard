import models.Match;
import models.Score;
import models.Scoreboard;
import models.Team;

public class Main {
    public static void main(String[] args) throws Exception {
//        Mexico - Canada: 0 - 5
//        Spain - Brazil: 10 – 2
//        Germany - France: 2 – 2
//        Uruguay - Italy: 6 – 6
//        Argentina - Australia: 3 - 1
        Team team1 = new Team("Mexico");
        Team team2 = new Team("Canada");
        Team team3 = new Team("Spain");
        Team team4 = new Team("Brazil");
        Team team5 = new Team("Germany");
        Team team6 = new Team("France");
        Team team7 = new Team("Uruguay");
        Team team8 = new Team("Italy");
        Team team9 = new Team("Argentina");
        Team team10 = new Team("Australia");
        Match match1 = new Match(team1, team2);
        Match match2 = new Match(team3, team4);
        Match match3 = new Match(team5, team6);
        Match match4 = new Match(team7, team8);
        Match match5 = new Match(team9, team10);
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch(match1);
        scoreboard.updateMatchScore(match1.getId(), new Score(0,5));
        scoreboard.startMatch(match2);
        scoreboard.updateMatchScore(match2.getId(), new Score(10,2));
        scoreboard.startMatch(match3);
        scoreboard.updateMatchScore(match3.getId(), new Score(2,2));
        scoreboard.startMatch(match4);
        scoreboard.updateMatchScore(match4.getId(), new Score(6,6));
        scoreboard.startMatch(match5);
        scoreboard.updateMatchScore(match5.getId(), new Score(3,1));

        scoreboard.getSummary().forEach(System.out::println);
        scoreboard.finishMatch(match1.getId());
        System.out.println("******After finishing the match******");
        scoreboard.getSummary().forEach(System.out::println);
    }
}
