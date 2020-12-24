import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Squad {
	ArrayList<Player> playerList = new ArrayList<Player>();
        File SquadPlayersFile;
        Squad(){}
        Squad(String path) throws IOException{
            if (!new File(path).isFile()){
                SquadPlayersFile = new File(path);
                SquadPlayersFile.createNewFile();
            }else SquadPlayersFile = new File(path);

        }
}


