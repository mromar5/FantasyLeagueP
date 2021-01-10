
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EventPerformer {
    CardsActions cardsActions;
    CleanSheet cleanSheet;
    GoalAssists goalAssists;
    ScoredGoals scoredGoals;
    MVP mvp;
    BonusPoints bonusPoints;
    PlayerFactory playerFactory;
    GameWeekController gameWeek;
    GameWeekBufferedEditor gameWeekBufferedEditor;
    SavedShots savedShots;
    GoalsConceded goalsConceded;
    PlayingMinutes playingMinutes;
    PenaltyAction penaltyAction;
    EventPerformer(){
    playerFactory = new PlayerFactory();
    goalAssists = new GoalAssists();
    gameWeek = new GameWeekController();
    gameWeekBufferedEditor = new GameWeekBufferedEditor(gameWeek);
    penaltyAction=new PenaltyAction();
    };
    EventPerformer(String playerName){
        playerFactory = new PlayerFactory();
        cleanSheet = playerFactory.createPlayerCleanSheet(playerName);
        scoredGoals = playerFactory.createPlayerScore(playerName);
        goalAssists = new GoalAssists();
        gameWeek = new GameWeekController();
        gameWeekBufferedEditor = new GameWeekBufferedEditor(gameWeek);
    }
    void scoreGoal(String playerName){
        scoredGoals = playerFactory.createPlayerScore(playerName);
        scoredGoals.scoreGoal(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void scoreGoals(String playerName, int goals){
        scoredGoals = playerFactory.createPlayerScore(playerName);
        scoredGoals.scoreGoals(playerName, goals);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void assistGoal(String playerName){
        goalAssists.assistedGoal(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void assistGoal(String playerName, int goals){
        goalAssists.assistGoal(playerName, goals);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void DoCleanSheet(String playerName){
        cleanSheet = playerFactory.createPlayerCleanSheet(playerName);
        cleanSheet.cleanSheet(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void giveRedCard(String playerName){
        cardsActions = new RedCardAction(gameWeekBufferedEditor);
        cardsActions.giveCard(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void giveYellowCard(String playerName){
        cardsActions = new YellowCardAction(gameWeekBufferedEditor);
        cardsActions.giveCard(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void addBonusPoints(String playerName, int points){
        bonusPoints = new BonusPoints(gameWeekBufferedEditor);
        bonusPoints.addBonus(playerName, points);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void rewardMVP(String playerName, int bonus){
        mvp = new MVP(gameWeekBufferedEditor);
        mvp.rewardMVP(playerName, bonus);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void saveShots(String playerName){
        try {
            savedShots = new SavedShots(gameWeekBufferedEditor);
            savedShots.saveShot(playerName);
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void saveShots(String playerName, int times){
        try {
            savedShots = new SavedShots(gameWeekBufferedEditor);
            savedShots.saveShots(playerName, times);
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void concedeGoals(String playerName){
        try {
            goalsConceded = playerFactory.createConcededGoals(playerName);
            if (goalsConceded == null){
                System.out.println("Player isn't a GK nor a DEF");
                return;
            }
            goalsConceded.concedeGoals(playerName);
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void concedeGoals(String playerName, int times){
        try {
            goalsConceded = playerFactory.createConcededGoals(playerName);
            if (goalsConceded == null){
                System.out.println("Player isn't a GK nor a DEF");
                return;
            }
            goalsConceded.concedeGoals(playerName, times);
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void play_60Minutes(String playerName){
        try{
            playingMinutes = new PlayingMinutes(gameWeekBufferedEditor);
            playingMinutes.play_60Minutes(playerName);
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex){
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void playMoreThan_60Minutes(String playerName){
        try {
            playingMinutes = new PlayingMinutes(gameWeekBufferedEditor);
            playingMinutes.playMoreThan_60Minutes(playerName);
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void ScoreOwnGoal(String playerName){
        try {
            scoredGoals = new OwnGoal(gameWeekBufferedEditor);
            scoredGoals.scoreGoal(playerName);
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void ScoreOwnGoals(String playerName, int goals){
        try {
            scoredGoals = new OwnGoal(gameWeekBufferedEditor);
            scoredGoals.scoreGoals(playerName, goals);
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void savePenalty(String playerName){
        try {
            PenaltySaved penaltySaved = new PenaltySaved(penaltyAction.gwbe);
            penaltySaved.savePenalty(playerName);
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void missPenalty(String playerName){
        try{
            PenaltyMissed penaltyMissed = new PenaltyMissed(penaltyAction.gwbe);
            penaltyMissed.missPenalty(playerName);
        } catch (IOException ex){
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void addGameWeek(){
        gameWeek.addGameWeek();
    }
    void selectGameWeek(String folderName){
        gameWeek.selectGameWeek(folderName);
        gameWeekBufferedEditor.gameweek = gameWeek;
        playerFactory.setGameWeekBufferedEditor(gameWeekBufferedEditor);
        penaltyAction.gwbe.gameweek = gameWeek;
    }
    void emptyGameWeek(String folderName){
        gameWeek.emptyGameWeek(folderName);
    } 
    void countGameWeeks(){
        gameWeek.countGameWeeks();
    }
}
