import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedCardAction implements CardsActions {
    int score;
    int cardValue = -3;
     RedCardAction(GameWeekBufferedEditor gwbe){
        CardsActions.gwbe.gameweek = gwbe.gameweek;
    }
    @Override
    public void giveCard(String playerName) {
        score = cardValue;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Red Cards: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(RedCardAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void main(String[] args){
    EventPerformer ep = new EventPerformer();
    ep.selectGameWeek("Game Week 1");
    ep.giveRedCard("Cristiano Ronaldo");
}   
}
