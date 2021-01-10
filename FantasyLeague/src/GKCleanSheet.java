
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GKCleanSheet implements CleanSheet {
    protected int score;
    protected int cleanSheetValue = 4;
     GKCleanSheet(GameWeekBufferedEditor gwbe){
        CleanSheet.gwbe.gameweek = gwbe.gameweek;
    }
    @Override
    public void cleanSheet(String playerName) {
        score = cleanSheetValue;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Clean Sheets: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(GKCleanSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void main(String[] args){
    EventPerformer ep = new EventPerformer();
    ep.selectGameWeek("Game Week 1");
    ep.scoreGoal("Ronaldo");
}
    
}
