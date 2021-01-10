
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OwnGoal implements ScoredGoals {
    int goalValue = -2;
    OwnGoal(GameWeekBufferedEditor gwbe){
        ScoredGoals.gwbe.gameweek = gwbe.gameweek;
    }
    @Override
    public void scoreGoals(String playerName, int goals) {
        try {
            int score = goals * goalValue;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Own Goals: ", goals);
        } catch (IOException ex) {
            Logger.getLogger(OwnGoal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void scoreGoal(String playerName) {
        try{
            int score = goalValue;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Own Goals: ", 1);
        } catch (IOException ex){
            Logger.getLogger(OwnGoal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
