package main.java.com.TableFootball.service;



import main.java.com.TableFootball.dao.PlayerDAO;
import main.java.com.TableFootball.model.Match;
import main.java.com.TableFootball.model.Player;
import main.java.com.TableFootball.model.WinnerTeam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchService {

    public Match createMatch() throws SQLException {

        //Uzmi sve igrace
        List <Player> allPlayers = PlayerDAO.getAllPlayers();
        System.out.println("Total players in database: " + allPlayers.size());

        //Uzmi sve aktivne igrace
        List <Player> activePlayers = new ArrayList<>();

        for(Player player : allPlayers){
            if(player.isIs_active()){
                activePlayers.add(player);
            }
        }

        if(activePlayers.size() < 4){
            throw new IllegalArgumentException("Couldn't find enough players for table football match!");
        }

        //Izgenerisi random igrace
        Collections.shuffle(activePlayers);

        for (Player player : activePlayers) {
            System.out.println(player.getId() + " - " + player.getName());
        }


        //Kreiraj timove
        int crveni1 = activePlayers.get(0).getId();
        int crveni2 = activePlayers.get(1).getId();
        int plavi1 = activePlayers.get(2).getId();
        int plavi2 = activePlayers.get(3).getId();

        System.out.println("Crveni1: " + crveni1);
        System.out.println("Crveni2: " + crveni2);
        System.out.println("Plavi1: " + plavi1);
        System.out.println("Plavi2: " + plavi2);

        //kreiranje objekta mec
        Match match = new Match(crveni1, crveni2, plavi1, plavi2, WinnerTeam.Crveni,  null);

        //Informacije o mecu
        System.out.println("Match created!");
        System.out.println("Red team: "+ crveni1 +", " + crveni2);
        System.out.println("Blue team: " + plavi1 + ", " + plavi2);


        return match;
    }

    public void updateMatchResult(Match match,String score, String winnerTeam)  {

        match.setScore(score);
        match.setWinnerTeam(WinnerTeam.valueOf(winnerTeam));

        System.out.println("Match updated!");
        System.out.println("Winner team: "+ match.getWinnerTeam());
        System.out.println("Final score: "+ match.getScore());


    }


}
