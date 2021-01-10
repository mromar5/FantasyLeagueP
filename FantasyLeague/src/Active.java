
import java.io.File;
import java.io.IOException;


public class Active {
	public User currentUser;
        public Squad squad;
        public SquadController squadController;
	public Active(User user) throws IOException
	{
                  currentUser=user;
//                squad = new Squad("Database" + File.separator + "Users" + File.separator + CurrentUser.email + File.separator + "Squad List.txt");
//                squad = new Squad("Database" + File.separator + "Users" + File.separator + CurrentUser.email + File.separator + "Squad List.txt","Database" + File.separator + "Users" + File.separator + CurrentUser.email + File.separator + "Budget.txt");
                  squadController = new SquadController(new File("Database" + File.separator + "Users" + File.separator + currentUser.email + File.separator + "Squads"));
//                squadcontroller = new SquadController(squad);
	}
}
