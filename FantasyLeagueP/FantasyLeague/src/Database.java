/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author dell
 */
public class Database {
    
    File databaseFolder = new File("Database");
    File usersFolder = new File(databaseFolder.getAbsolutePath() + File.separator + "Users");
    File leaguesFolder = new File(databaseFolder.getAbsolutePath() + File.separator + "Leagues");
    public Database()
    {
    	if(!databaseFolder.isDirectory()) {databaseFolder.mkdir();}
        if(!usersFolder.isDirectory()){usersFolder.mkdir();}
        if(!leaguesFolder.isDirectory()){leaguesFolder.mkdir();}
    }
    
    public void addLeague(){};
    public void removeLeague(){};
    public void addUser(User user) throws IOException{
        
        File userInfoFolder = new File (usersFolder.getAbsolutePath() + File.separator + user.getEmail());
        userInfoFolder.mkdir();
        File userFile = new File(userInfoFolder.getAbsolutePath() + File.separator + "INFO.txt");
        userFile.createNewFile();
        BufferedWriter br = new BufferedWriter(new FileWriter(userFile));
        br.append("Email: " + user.getEmail() +"\r\nPassword: " + user.getPassword() + "\r\nFirst Name: " + user.getFirstName() + "\r\nLast Name: " + user.getLastName() + "\r\nFavourite Club: " + user.getFavouriteClub()).flush();
        br.close();
    };
    public void removeUser(User user){
       
        File userFile = new File(usersFolder.getAbsolutePath() + user.getEmail());
        userFile.delete();
                }
    
    
}
