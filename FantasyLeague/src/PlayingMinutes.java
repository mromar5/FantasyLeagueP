
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PlayingMinutes {
    GameWeekBufferedEditor gwbe;
    PlayingMinutes(GameWeekBufferedEditor gwbe){
        this.gwbe = gwbe;
    }
    void play_60Minutes(String playerName){
        try {
            int score = 1;
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Played Just 60 Minutes: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(PlayingMinutes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void playMoreThan_60Minutes(String playerName){
        try{
            int score = 2; 
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Played More Than 60 Minutes: ", 1);
        } catch(IOException ex){
            Logger.getLogger(PlayingMinutes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        EventPerformer ep = new EventPerformer();
        ep.selectGameWeek("Game Week 1");
        ep.playMoreThan_60Minutes("Bango");
    }
}
