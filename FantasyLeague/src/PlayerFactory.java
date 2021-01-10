
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PlayerFactory {
    GameWeekBufferedEditor gwbe = new GameWeekBufferedEditor();
    String positionParser(String playerName){
        BufferedReader br = null;
        try {
            File playerFile = new File("Database" + File.separator + "Players" + File.separator +
                  playerName + ".txt");
            br = new BufferedReader(new FileReader(playerFile));
            String textReader;
            while ((textReader =  br.readLine()) != null){
                if (textReader.contains("Position: ")){
                    textReader = textReader.replace("Position: ", "");
                    break;
                }
            }   return textReader;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlayerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(PlayerFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    CleanSheet  createPlayerCleanSheet(String playerName){
        String textReader = positionParser(playerName);
        CleanSheet cs = null;
        switch(textReader){
            case "1": cs = new GKCleanSheet(gwbe);
                      break;
            case "2": cs = new DEFCleanSheet(gwbe);
                      break;
            case "3": cs = new MidCleanSheet(gwbe);
                      break; 
        }
        return cs;
    }
    ScoredGoals createPlayerScore(String playerName){
           String textReader = positionParser(playerName);
           ScoredGoals sg = null;
           switch (textReader){
               case "1": sg = new GKScores(gwbe);
                         break;
               case "2":
                          sg = new DEFScores(gwbe);
                          break;
               case "3": 
                          sg = new MidScores(gwbe);
                          break;
               case "4": 
                          sg = new AttScores(gwbe);
                          break;
           }
        return sg; 
    }
    GoalsConceded createConcededGoals(String playerName){
        String textReader = positionParser(playerName);
        GoalsConceded gc = null;
        switch (textReader){
            case "1": gc = new GoalsConcededGK(gwbe); break;
            case "2": gc = new GoalsConcededDEF(gwbe); break;
            default: gc = null; break;
        }
        return gc;
    }
    void setGameWeekBufferedEditor(GameWeekBufferedEditor gwbe){
        this.gwbe = gwbe;
    }
    
    
}
