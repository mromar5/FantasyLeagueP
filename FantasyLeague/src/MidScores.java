import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MidScores implements ScoredGoals {
    int score;
    private int goalValue = 5;
    MidScores(GameWeekBufferedEditor gwbe){
        ScoredGoals.gwbe.gameweek = gwbe.gameweek;
    }
   
    @Override
    public void scoreGoal(String playerName) {
        score = goalValue;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", goalValue);
            gwbe.pointsWriter(playerName, "Goals Scored: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(MidScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void scoreGoals(String playerName, int goals) {
        score = goalValue*goals;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Goals Scored: ", goals);
        } catch (IOException ex) {
            Logger.getLogger(MidScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void main(String[] args){
        EventPerformer ep = new EventPerformer();
        ep.selectGameWeek("Game Week 1");
        ep.scoreGoal("Cristiano Ronaldo");
//        MidScores ms = new MidScores();
//        ms.scoreGoal("Cristiano Ronaldo");
    }
}
