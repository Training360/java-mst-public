package nestedclasses.soccer;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChampionshipTest {

    @Test
    public void addGame() {

        Championship championship = new Championship();
        championship.addGame(new Championship.GameResult("Real", "Barcelona", 2, 2));
        championship.addGame(new Championship.GameResult("Atletico", "Valencia", 0, 2));
        championship.addGame(new Championship.GameResult("Real", "Atletico", 1, 0));
        championship.addGame(new Championship.GameResult("Valencia", "Barcelona", 1, 2));

        List<TeamStatistics> teamStatistics = championship.getLeagueTable();
        assertThat(teamStatistics.contains(new TeamStatistics("Real")), equalTo(true));
        assertThat(teamStatistics.contains(new TeamStatistics("Barcelona")), equalTo(true));
        assertThat(teamStatistics.contains(new TeamStatistics("Atletico")), equalTo(true));
        assertThat(teamStatistics.contains(new TeamStatistics("Valencia")), equalTo(true));

        int index = teamStatistics.indexOf(new TeamStatistics("Valencia"));
        TeamStatistics valencia = teamStatistics.get(index);
        assertThat(valencia.getPlayed(), equalTo(2));
        assertThat(valencia.getWon(), equalTo(1));
        assertThat(valencia.getLost(), equalTo(1));
        assertThat(valencia.getTied(), equalTo(0));
        assertThat(valencia.getGoalsFor(), equalTo(3));
        assertThat(valencia.getGoalsAgainst(), equalTo(2));
        assertThat(valencia.getPoints(), equalTo(3));
    }

}