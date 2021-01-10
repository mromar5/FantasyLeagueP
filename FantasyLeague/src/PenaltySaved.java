
import java.io.IOException;


public class PenaltySaved extends PenaltyAction {
    int penaltyValue = 5;    
    PenaltySaved(){};
    PenaltySaved(int newPenaltyValue){
            this.penaltyValue = newPenaltyValue;
        }
     PenaltySaved(GameWeekBufferedEditor gwbe, int newPenaltyValue){
         this.gwbe.gameweek = gwbe.gameweek;
         this.penaltyValue = newPenaltyValue;
     }
     PenaltySaved(GameWeekBufferedEditor gwbe){
        this.gwbe.gameweek = gwbe.gameweek;
    }
        void savePenalty(String playerName) throws IOException{
            score = penaltyValue;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Saved Penalties: ", 1);
        }
        void savePenalty(String playerName, int penalties) throws IOException{
            score = penaltyValue * penalties;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Saved Penalties: ", penalties);
        }
  public static void main(String[] args) throws IOException{
      PenaltySaved ps = new PenaltySaved();
      ps.savePenalty("Cristiano Ronaldo");
  }

}

