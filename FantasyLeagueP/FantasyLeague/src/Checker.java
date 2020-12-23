/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author dell
 */
public class Checker {
    
    File usersFolder = new File("Database" + File.separator + "Users");
    
    public boolean checkEmail(String email){
    
        if (new File(usersFolder.getAbsolutePath(),email).isDirectory()){
            return true;
        }
        else return false;
    }
    public boolean checkPassword(String email, String password) throws FileNotFoundException, IOException{
	    BufferedReader br = new BufferedReader(new FileReader(usersFolder.getAbsolutePath() + File.separator + email + File.separator + "INFO.txt"));
	    br.readLine(); //Skips one line (which is the first one)
	    String st = br.readLine();
	    br.close();
	    if (st.contentEquals("Password: " + password)){
	        return true;
	    }
	    else return false;
	    }
    
    }
   
