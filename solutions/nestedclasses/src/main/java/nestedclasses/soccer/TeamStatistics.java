package nestedclasses.soccer;

public class TeamStatistics {

    private String teamName;
    private int played;
    private int won;
    private int tied;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

    public TeamStatistics(String teamName) {
        this.teamName = teamName;
        this.played = 0;
        this.won = 0;
        this.tied = 0;
        this.lost = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.points = 0;
    }

    public void played(int plusGoalsFor, int plusGoalsAgainst) {
        this.played++;
        if (plusGoalsFor > plusGoalsAgainst) {
            this.won++;
        }
        else if (plusGoalsAgainst > plusGoalsFor) {
            this.lost++;
        }
        else {
            this.tied++;
        }
        this.goalsFor += plusGoalsFor;
        this.goalsAgainst += plusGoalsAgainst;
        this.points = this.won * 3 + this.tied;
    }

    @Override
    public String toString() {
        return teamName + " " + played + " " + won + " " + tied + " " + lost
                + " " + goalsFor + " - " + goalsAgainst + ", " + points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamStatistics that = (TeamStatistics) o;

        return teamName.equals(that.teamName);
    }

    @Override
    public int hashCode() {
        return teamName.hashCode();
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getTied() {
        return tied;
    }

    public int getLost() {
        return lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getPoints() {
        return points;
    }
}

