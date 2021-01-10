import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Squad {
	ArrayList<Player> playerList = new ArrayList<Player>();
        double squadBudget;
        File squadsFolder;
        File SquadPlayersFile;
        File SquadBudget;
        Squad(){}
        Squad(String squadsFolderPath){
            if (!new File(squadsFolderPath).isDirectory()){
                squadsFolder = new File(squadsFolderPath);
                squadsFolder.mkdir();
            }
            else {
                squadsFolder = new File(squadsFolderPath);
            }
        }
        Squad(String squadListPath, String budgetPath) throws IOException{
            if (!new File(squadListPath).isFile()){
                SquadPlayersFile = new File(squadListPath);
                SquadPlayersFile.createNewFile();
                
            }else SquadPlayersFile = new File(squadListPath);
            if (!new File(budgetPath).isFile()){
                SquadBudget = new File(budgetPath);
                SquadBudget.createNewFile();
                squadBudget = 100;
                BufferedWriter br = new BufferedWriter(new FileWriter(budgetPath));
                br.append("100.0").flush();
                br.close();
            }
            else {
                SquadBudget = new File(budgetPath);
                Scanner scan = new Scanner(SquadBudget);
                squadBudget = scan.nextDouble();
                scan.close();
                
            }

        }
}


