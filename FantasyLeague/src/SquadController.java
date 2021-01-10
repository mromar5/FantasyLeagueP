
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class SquadController {
    File squadsFolder;
    Squad squad;
    FileLinesMethods linesMethods = new FileLinesMethods();
    SquadController(){};
    SquadController(File squadsFolder){this.squadsFolder = squadsFolder;}
    SquadController(Squad squad){this.squad = squad;}
    //Squad createSquad(){Squad newSquad = new Squad(); squad = newSquad; return newSquad;}
    void createSquad(String squadName) throws IOException{
        File squadFolder = new File(squadsFolder.getAbsolutePath() + File.separator + squadName);
        squadFolder.mkdir();
        Squad newSquad = new Squad(squadsFolder.getAbsolutePath() + File.separator + squadName + File.separator + "Squad List.txt", squadsFolder.getAbsolutePath() + File.separator + squadName + File.separator + "Budget.txt");
    }
    void selectSquad(String squadName) throws IOException{
        if (! new File(squadsFolder.getAbsolutePath() + File.separator + squadName).isDirectory()){
            System.out.println("Squad doesn't exist");
            return;
        }
        else {
            Squad selectedSquad = new Squad(squadsFolder.getAbsolutePath() + File.separator + squadName + File.separator + "Squad List.txt", squadsFolder.getAbsolutePath() + File.separator + squadName + File.separator + "Budget.txt");
            this.squad = selectedSquad;
        }
    }
    public Player selectSquadPlayer(String playerName) throws FileNotFoundException, IOException{
        Database db = new Database();
        File playerFile = new File(db.playersFolder.getAbsolutePath() + File.separator + playerName + ".txt");
        if (!playerFile.isFile()){System.out.println("Player not found"); return null;}
        Scanner input = new Scanner(playerFile);
        int lineCount = 0;
        Player player = new Player();
        while(input.hasNextLine()){
            lineCount++;
           	if (lineCount == 1)
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
        	else if (lineCount == 5)
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
    
    public void removePlayerFromSquad(String playerName, String squadName) throws IOException
    {
    	File squadFolder = new File(squadsFolder.getAbsolutePath() + File.separator + squadName);
    	File squadFile = new File(squadFolder.getAbsolutePath()+ File.separator +"Squad List.txt");
    	File tempFile = new File(squadFolder.getAbsolutePath()+ File.separator +"myTempFile.txt");
    	File budgetFile = new File(squadFolder.getAbsolutePath()+ File.separator +"Budget.txt");
    	File tempBFile = new File(squadFolder.getAbsolutePath()+ File.separator +"tempBudget.txt");
    	Scanner reader=new Scanner(squadFile);
    	Scanner BReader=new Scanner(budgetFile);
    	BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    	BufferedWriter Bwriter = new BufferedWriter(new FileWriter(tempBFile));
    	String currentLine;
    	double budgetchange=0;
    	while(reader.hasNextLine()) {
    		currentLine=reader.nextLine();
    	    if(currentLine.contains("Name: "+playerName))
    	    {
    	    	reader.nextLine();
    	    	reader.nextLine();
    	    	reader.nextLine();
    	    	reader.next();
    	    	budgetchange=Double.parseDouble(reader.next());
    	    	reader.nextLine();
    	    	reader.nextLine();
    	    	reader.nextLine();
    	    	if (reader.hasNextLine())
    	    		currentLine=reader.nextLine();
    	    	else break;
    	    }
    	    writer.write(currentLine + System.getProperty("line.separator"));
    	    writer.flush();
    	}
    	reader.close();
    	writer.close();
    	double budgetval=Double.parseDouble(BReader.next());
    	budgetval+=budgetchange;
    	Bwriter.write(budgetval + System.getProperty("line.separator"));
    	Bwriter.flush();
    	BReader.close();
    	Bwriter.close();
    	squadFile.delete();
    	budgetFile.delete();
    	boolean success = tempFile.renameTo(squadFile);
    	boolean success2 = tempBFile.renameTo(budgetFile);
    }
    public void viewSquad(String squadName) throws FileNotFoundException
    {
    	File squadFolder = new File(squadsFolder.getAbsolutePath() + File.separator + squadName);
    	File squadFile=new File(squadFolder.getAbsoluteFile()+ File.separator + "Squad List.txt");
    	Scanner filescanner=new Scanner(squadFile);
    	while (filescanner.hasNextLine())
    	{
    		String PName=filescanner.nextLine();
    		if (PName.contains("Name:"))
    		{
    			System.out.println("Player name: "+PName.replace("Name: ", ""));
    		}
    	}
    	filescanner.close();
    }
    public void viewSquads() throws FileNotFoundException
    {
    	File squadFolder = new File(squadsFolder.getAbsolutePath());
    	File dirlist[]=squadFolder.listFiles();
    	int ctr=1;
    	for (File x : dirlist)
    	{
    		System.out.println(ctr+"- "+x.getName().replace(".txt", ""));
    		ctr++;
    	}
    }
    public void deleteSquad(String squadName) throws FileNotFoundException
    {
    	File squadFolder = new File(squadsFolder.getAbsolutePath() + File.separator + squadName);
    	for (File x : squadFolder.listFiles())
    	{
    		x.delete();
    	}
    	squadFolder.delete();
    }
    public void getPoints(String squadName,String gameWeek)throws FileNotFoundException
    {
    	Database db = new Database();
    	File squadFolder = new File(squadsFolder.getAbsolutePath() + File.separator + squadName);
    	File squadFile=new File(squadFolder.getAbsoluteFile()+ File.separator + "Squad List.txt");
    	Scanner squadFileScanner=new Scanner(squadFile);
    	File gwFolder = new File(db.databaseFolder+ File.separator + "Game Weeks" + File.separator + gameWeek);
    	File folderlist[]=gwFolder.listFiles();
    	int TotalPoints=0;
    	while (squadFileScanner.hasNext())
    	{
    		int ctr=0;
    		String PName=squadFileScanner.next();
    		if (PName.contentEquals("Name:"))
    		{
    			PName=squadFileScanner.next();
    	    	
    			for (File x:folderlist)
    			{
    				if (PName.contentEquals(x.getName().replace(".txt", "")))
    				{
    					Scanner gwFileScanner=new Scanner(x);
    					gwFileScanner.next();
    					gwFileScanner.next();
    					String pts=gwFileScanner.next();
    					TotalPoints+=parseInt(pts);
    					gwFileScanner.close();
    				}
    			}
    		}
    	}
    	System.out.println("Total points for "+gameWeek+" is "+TotalPoints);
    	squadFileScanner.close();
    	
    }
    public static void main(String[] args) throws IOException{
        SquadController sc = new SquadController(new File("Database" + File.separator + "Users" + File.separator + "mromar4"));
        sc.createSquad("Bateekh");
    }   
}
