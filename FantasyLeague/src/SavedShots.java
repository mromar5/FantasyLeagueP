
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SavedShots {
    GameWeekBufferedEditor gwbe = new GameWeekBufferedEditor();
    int savedShotsValue = 1;
    SavedShots(GameWeekBufferedEditor gwbe){
        this.gwbe = gwbe;
    }
    void saveShot(String playerName){
        try {
            int score = savedShotsValue;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Shots saved: ", 3);
        } catch (IOException ex) {
            Logger.getLogger(SavedShots.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void saveShots(String playerName, int times){
        try{
            int score = savedShotsValue * times;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Shots saved: ", 3 * times);
        }
        catch(IOException ex){
            Logger.getLogger(SavedShots.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        
    }
}
