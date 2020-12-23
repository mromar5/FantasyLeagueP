/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

/**
 *
 * @author dell
 */
public class Registration {
    
    Database db = new Database();
    Checker checker = new Checker();
    public Registration(){};
    public void register(String email_ , String password_, String firstName_ , String lastName_, String favouriteClub_)
    		throws IOException{
    	if(checker.checkEmail(email_) != true)
    	{
            User user = new User(firstName_, lastName_, email_, password_, favouriteClub_);
            db.addUser(user);
    	}
        else{System.out.println("This email is already taken");}
        
    };
    
    
    
    
}
