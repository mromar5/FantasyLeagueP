import java.io.IOException;

public class Registration {
    
    Database db = new Database();
    Checker checker = new Checker();
    public Registration(){};
    public void register(String email_ , String password_, String firstName_ , String lastName_, String favouriteClub_, String type)
    		throws IOException{
    	if(checker.checkEmail(email_) != true)
    	{
            User user = new User(firstName_, lastName_, email_, password_, favouriteClub_, type);
            db.addUser(user);
    	}
        else{System.out.println("This email is already taken");}
        
    };
    
    
    
    
}
