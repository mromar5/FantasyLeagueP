
public interface ScoredGoals {
    GameWeekBufferedEditor gwbe = new GameWeekBufferedEditor();
    void scoreGoals(String playerName, int goals);
    void scoreGoal(String playerName);
}
