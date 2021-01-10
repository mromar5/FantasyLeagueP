
import java.io.File;


public class GameWeekController {
    File GameWeeksFolder;
    File currentGameWeek;
    GameWeekController(){
        GameWeeksFolder = new File("Database" + File.separator + "Game Weeks");
        if(!GameWeeksFolder.isDirectory()){
            GameWeeksFolder.mkdir();
        }
    }
    void addGameWeek(){
        File newGameWeek = new File("Database" + File.separator + "Game Weeks" + File.separator + "Game Week " + (countGameWeeks() + 1));
//        System.out.println(newGameWeek.getAbsolutePath());
        newGameWeek.mkdir();
    }
    void emptyGameWeek(String gameWeekName){
        File targetGameWeek = new File(GameWeeksFolder.getAbsolutePath() + File.separator + gameWeekName);
        targetGameWeek.delete();
        targetGameWeek.mkdir();
    }
    File selectGameWeek(String folderName){
        currentGameWeek = new File(GameWeeksFolder.getAbsolutePath() + File.separator + folderName);
        return currentGameWeek;
    }
    int countGameWeeks(){
        int numberOfFolders = GameWeeksFolder.list().length;
        return numberOfFolders;
    }
    public static void main(String[] args){
//        GameWeekController gameWeek = new GameWeekController();
//        gameWeek.addGameWeek();
//        System.out.println(gameWeek.countGameWeeks());
    }
}
