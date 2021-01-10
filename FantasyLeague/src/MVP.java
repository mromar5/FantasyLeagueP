
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MVP{
    int score;
    GameWeekBufferedEditor gwbe = new GameWeekBufferedEditor();
    BonusPoints bp = new BonusPoints(gwbe);
     MVP(GameWeekBufferedEditor gwbe){
        this.gwbe.gameweek = gwbe.gameweek;
    }
    /*
    Player selectMVP(String playerName){
        Player player = new Player();
        return player;
    }
    void rewardMVP(Player player, int playerPoints, int bonus){
        score = bp.addBonus(playerPoints, bonus);
    }*/
    void rewardMVP(String playerName, int bonus){
        score = bp.addBonus(bonus);
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "MVP: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(MVP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args){
    EventPerformer ep = new EventPerformer();
    ep.selectGameWeek("Game Week 1");
    ep.rewardMVP("Cristiano Ronaldo", 3);
}
}
