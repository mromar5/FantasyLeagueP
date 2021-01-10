
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoalsConcededGK implements GoalsConceded {
    int goalValue = -1;
     GoalsConcededGK(GameWeekBufferedEditor gwbe){
        GoalsConceded.gwbe.gameweek = gwbe.gameweek;
    }
    @Override
    public void concedeGoals(String playerName) {
        int score = goalValue;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Conceded Goals: ", 2);
        } catch (IOException ex) {
            Logger.getLogger(GoalsConcededGK.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void concedeGoals(String playerName, int times) {
        int score = goalValue * times;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Conceded Goals: ", times * 2);
        } catch (IOException ex) {
            Logger.getLogger(GoalsConcededGK.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void main(String[] args){
        EventPerformer ep = new EventPerformer();
        ep.selectGameWeek("Game Week 1");
        ep.concedeGoals("Bango");
    }
    
}
