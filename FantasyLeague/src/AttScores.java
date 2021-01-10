
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AttScores implements ScoredGoals {
    int score;
    int goalValue = 4;
    AttScores(GameWeekBufferedEditor gwbe){
        ScoredGoals.gwbe.gameweek = gwbe.gameweek;
    }
    @Override
    public void scoreGoals(String playerName, int goals) {
        score = goalValue * goals;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Goals Scored: ", goals);
        } catch (IOException ex) {
            Logger.getLogger(MidScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void scoreGoal(String playerName) {
          score = goalValue;
          try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Goals Scored: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(MidScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        EventPerformer ep = new EventPerformer();
        ep.selectGameWeek("Game Week 1");
        ep.scoreGoal("Bango");
//        GameWeekController gm = new GameWeekController();
//        gm.selectGameWeek("Game Week 1");
//        GameWeekBufferedEditor gwbe = new GameWeekBufferedEditor(gm);
//        AttScores as = new AttScores(gwbe);
//        as.scoreGoal("Cristiano Ronaldo");
    }
}
