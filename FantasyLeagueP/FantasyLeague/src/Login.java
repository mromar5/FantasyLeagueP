 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
/**
 *
 * @author dell
 */
public class Login {
    
    String email;
    String password;
    File file = new File("Database" + File.separator + "Users");
    Checker checker = new Checker();
    
    public User login(String email_, String password_) throws IOException{
        if (checker.checkEmail(email_) == true) {email = email_;}
        else{System.out.println("Invalid email");return null;}
        if (checker.checkPassword(email_, password_) == true){password=password_;}
        else{System.out.println("Invalid password");return null;}
        Scanner input=new Scanner(new File(file.getAbsolutePath() + File.separator + email_ + File.separator + "INFO.txt"));
        String email = null, password = null, firstName = null, lastName = null, favClub= null; 
        int lineCount = 0;
        while(input.hasNextLine()){
            lineCount++;
           	if (lineCount==1)
        	{   
        		email=input.skip(Pattern.compile(".+: ")).nextLine();
                       // System.out.println(email);
        	}
                else if(lineCount==2)
                        {
        		password=input.skip(Pattern.compile(".+: ")).nextLine();
                        //System.out.println(password);
        	}
        	else if (lineCount == 3)
        	{
        		firstName=input.skip(Pattern.compile(".+: ")).nextLine();
                        //System.out.println(firstName);
        	}
        	else if (lineCount == 4)
        	{
        		lastName=input.skip(Pattern.compile(".+: ")).nextLine();
                        //System.out.println(lastName);
        	}
        	else if (lineCount==5)
        	{
        		favClub=input.skip(Pattern.compile(".+: ")).nextLine();
                        //System.out.println(favClub);
        	}
                else{System.out.println("Invalid inputs!");}
        }
        User CurrentUser = new User(firstName,lastName,email,password,favClub);
        return CurrentUser;
    }
    
    
    
}
