package main.java.com.TableFootball.model;

public class Match {

    private int matchId;
    private int crveni1;
    private int crveni2;
    private int plavi1;
    private int plavi2;

    private WinnerTeam winnerTeam;
    private String score;

    public Match(int crveni1, int crveni2, int plavi1, int plavi2, WinnerTeam winnerTeam, Object score) {

    }


    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getCrveni1() {
        return crveni1;
    }

    public void setCrveni1(int crveni1) {
        this.crveni1 = crveni1;
    }

    public int getCrveni2() {
        return crveni2;
    }

    public void setCrveni2(int crveni2) {
        this.crveni2 = crveni2;
    }

    public int getPlavi1() {
        return plavi1;
    }

    public void setPlavi1(int plavi1) {
        this.plavi1 = plavi1;
    }

    public int getPlavi2() {
        return plavi2;
    }

    public void setPlavi2(int plavi2) {
        this.plavi2 = plavi2;
    }

    public WinnerTeam getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(WinnerTeam winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Match (int crveni1, int crveni2, int plavi1, int plavi2, WinnerTeam winnerTeam, String score) {
        this.crveni1 = crveni1;
        this.crveni2 = crveni2;
        this.plavi1 = plavi1;
        this.plavi2 = plavi2;
        this.winnerTeam = winnerTeam;
        this.score = score;
    }
}
