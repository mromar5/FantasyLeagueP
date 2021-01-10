import java.io.IOException;

public class PlayerController {
    Database db = new Database();
    public void addPlayer(String name, String nationality, String club, int position, double price) throws IOException{
        Player player = new Player(name, nationality, club, position, price);
        db.addPlayer(player);
    }
    public void viewPlayers(){
        db.viewPlayers();
    }
}
