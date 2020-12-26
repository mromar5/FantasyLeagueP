import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Squad {
	ArrayList<Player> playerList = new ArrayList<Player>();
        double squadBudget;
        File SquadPlayersFile;
        File SquadBudget;
        Squad(){}
        Squad(String path, String budgetPath) throws IOException{
            if (!new File(path).isFile()){
                SquadPlayersFile = new File(path);
                SquadPlayersFile.createNewFile();
                
            }else SquadPlayersFile = new File(path);
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


