
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;


public class PenaltyMissed extends PenaltyAction {
    int penaltyValue = -2;
    PenaltyMissed(){};
    PenaltyMissed(int newPenaltyValue){
            this.penaltyValue = newPenaltyValue;
        }
     PenaltyMissed(GameWeekBufferedEditor gwbe, int penaltyValue){
        this.gwbe.gameweek = gwbe.gameweek;
        this.penaltyValue = penaltyValue;
    }
     
     PenaltyMissed(GameWeekBufferedEditor gwbe){
        this.gwbe.gameweek = gwbe.gameweek;
    }
        void missPenalty(String playerName) throws IOException{
            score = penaltyValue;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Missed Penalties: ", 1);
        }
        void missPenalty(String playerName, int penalties) throws IOException{
            score = penaltyValue * penalties;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Missed Penalties ", penalties);
        }
         void setPenaltyValue(int newPenaltyValue){
             this.penaltyValue = newPenaltyValue;
         }
        public static void main(String[] args) throws IOException{
            PenaltyMissed pm = new PenaltyMissed();
            pm.missPenalty("Cristiano Ronaldo");
        }
}
