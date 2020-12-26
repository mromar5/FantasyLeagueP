
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SquadController {
    Squad squad;
    FileLinesMethods linesMethods = new FileLinesMethods();
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
//                        System.out.println(player.Name);
        	}
                else if(lineCount==2)
                        {
        		player.Nationality=input.skip(Pattern.compile(".+: ")).nextLine();
//                        System.out.println(player.Nationality);
        	}
        	else if (lineCount == 3)
        	{
        		player.Club=input.skip(Pattern.compile(".+: ")).nextLine();
//                        System.out.println(player.Club);
        	}
        	else if (lineCount == 4)
        	{
        		player.Position=input.skip(Pattern.compile(".+: ")).nextInt();
                        input.nextLine();
//                        System.out.println(player.Position);
        	}
        	else if (lineCount==5)
        	{
        		player.Price = input.skip(Pattern.compile(".+: ")).nextDouble();
                        input.nextLine();
//                        System.out.println(player.Price);
        	}
                else if (lineCount==6){
                        player.YellowCard = input.skip(Pattern.compile(".+: ")).nextBoolean();
                        input.nextLine();
//                        System.out.println(player.YellowCard);
                }
        	
                else if (lineCount==7){
                        player.RedCard = input.skip(Pattern.compile(".+: ")).nextBoolean();
//                        System.out.println(player.RedCard);
                }
                
                else{System.out.println("Invalid input!"); return null;}
        }
        return player;
    }
    public void addPlayer(Player player) throws IOException{
        if (player == null){System.out.println("Invalid player"); return;}
        if (squad.playerList.size() < 15){
            if (linesMethods.lineNameSkipper_Comparer(player.Name, squad.SquadPlayersFile) == true){System.out.println("Player already exists in your squad");return;}
//            if ((linesMethods.linePriceSkipper_Calculator(squad.SquadPlayersFile) - player.Price) < 0){System.out.println("Overbudget");return;}
            if ((squad.squadBudget - player.Price) < 0){System.out.println("Overbudget");return;}
            if (3 < linesMethods.lineClubSkipper_Counter(player.Club, squad.SquadPlayersFile)){
                    System.out.println("You can't have more than 3 players from a single team");
                    return;
            }
            switch(player.Position){
                case 1: 
                    if (2 < linesMethods.linePositionsSkipper_Counter(squad.SquadPlayersFile)[0]+1){
                        System.out.println("You can't have more than 2 GKs");
                return;
                    } else break;
                case 2:
                    if (5 < linesMethods.linePositionsSkipper_Counter(squad.SquadPlayersFile)[1]+1){System.out.println("You can't have more than 5 Defs");
                    return;
                    } else break;
                case 3: 
                    if (5 < linesMethods.linePositionsSkipper_Counter(squad.SquadPlayersFile)[2]+1){System.out.println("You can't have more than 5 Mids");return;
                    } else break;
                case 4:
                    if (3 < linesMethods.linePositionsSkipper_Counter(squad.SquadPlayersFile)[3]+1){
                        System.out.println("You can't have more than 3 FWDs");
//                    System.out.println("fwdCounter: "+linesMethods.linePositionsSkipper_Counter(squad.SquadPlayersFile)[3]);
//                    System.out.println("midCounter: "+linesMethods.linePositionsSkipper_Counter(squad.SquadPlayersFile)[2]);
//                    System.out.println("defCounter: "+linesMethods.linePositionsSkipper_Counter(squad.SquadPlayersFile)[1]);
//                    System.out.println("gkCounter: "+linesMethods.linePositionsSkipper_Counter(squad.SquadPlayersFile)[0]);
//                    System.out.println("Player position: " + player.Position);
                    return;
                    }else break;
        } squad.playerList.add(player);
            Database database = new Database();
            database.addSquadPlayerDatabase(squad, player, squad.SquadPlayersFile);
        }
        else if (squad.playerList.size() >= 15){
        System.out.println("Squad can't exceed 15 players");
        }
    }
    
}
