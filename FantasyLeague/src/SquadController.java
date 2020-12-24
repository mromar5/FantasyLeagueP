
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class SquadController {
    Squad squad;
    SquadController(){};
    SquadController(Squad squad){this.squad = squad;}
    //Squad createSquad(){Squad newSquad = new Squad(); squad = newSquad; return newSquad;}
    public Player selectSquadPlayer(String playerName) throws FileNotFoundException, IOException{
        Database db = new Database();
        File playerFile = new File(db.playersFolder.getAbsolutePath() + File.separator + playerName + ".txt");
        if (!playerFile.isFile()){System.out.println("Player not found"); return null;}
        Scanner input = new Scanner(playerFile);
        int lineCount = 0;
        Player player = new Player();
        while(input.hasNextLine()){
            lineCount++;
           	if (lineCount==1)
        	{   
        		player.Name=input.skip(Pattern.compile(".+: ")).nextLine();
                        System.out.println(player.Name);
        	}
                else if(lineCount==2)
                        {
        		player.Nationality=input.skip(Pattern.compile(".+: ")).nextLine();
                        System.out.println(player.Nationality);
        	}
        	else if (lineCount == 3)
        	{
        		player.Club=input.skip(Pattern.compile(".+: ")).nextLine();
                        System.out.println(player.Club);
        	}
        	else if (lineCount == 4)
        	{
        		player.Position=input.skip(Pattern.compile(".+: ")).nextInt();
                        input.nextLine();
                        System.out.println(player.Position);
        	}
        	else if (lineCount==5)
        	{
        		player.Price = input.skip(Pattern.compile(".+: ")).nextDouble();
                        input.nextLine();
                        System.out.println(player.Price);
        	}
                else if (lineCount==6){
                        player.YellowCard = input.skip(Pattern.compile(".+: ")).nextBoolean();
                        input.nextLine();
                        System.out.println(player.YellowCard);
                }
        	
                else if (lineCount==7){
                        player.RedCard = input.skip(Pattern.compile(".+: ")).nextBoolean();
                        System.out.println(player.RedCard);
                }
                
                else{System.out.println("Invalid inputs!"); return null;}
        }
        return player;
    }
    public void addPlayer(Player player) throws IOException{
        if (squad.playerList.size() <= 15){
            squad.playerList.add(player);
            Database database = new Database();
            database.addSquadPlayerDatabase(squad, player, squad.SquadPlayersFile);
        }
        else if (squad.playerList.size() > 15){
        System.out.println("Squad can't exceed 15 players");
        }
    }
    
}
