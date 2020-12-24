
import java.io.File;
import java.io.IOException;


public class Active {
	public User CurrentUser;
        public Squad squad;
        public SquadController squadcontroller;
	public Active(User user) throws IOException
	{
		CurrentUser=user;
                squad = new Squad("Database" + File.separator + "Users" + File.separator + CurrentUser.email + File.separator + "Squad List.txt");
                squadcontroller = new SquadController(squad);
	}
}
