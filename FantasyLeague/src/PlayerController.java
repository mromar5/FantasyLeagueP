
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class PlayerController {
    
    Player player;
    void addPlayer(String name, String nationality, String club, int position, double price) throws IOException{
        player = new Player(name, nationality, club, position, price);
        Database db = new Database();
        db.addPlayer(player);
    }
}
