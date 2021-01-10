
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class YellowCardAction implements CardsActions {
    int score;
    int cardValue = -1;
     YellowCardAction(GameWeekBufferedEditor gwbe){
        CardsActions.gwbe.gameweek = gwbe.gameweek;
    }
    @Override
    public void giveCard(String playerName) {
        score = cardValue;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Yellow Cards: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(YellowCardAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public static void main(String[] args){
     EventPerformer ep = new EventPerformer();
     ep.selectGameWeek("Game Week 1");
     ep.giveYellowCard("Cristiano Ronaldo");
 }  
}
