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
    File playersFolder = new File(databaseFolder.getAbsolutePath() + File.separator + "Players");
    public Database()
    {
    	if(!databaseFolder.isDirectory()) {databaseFolder.mkdir();}
        if(!usersFolder.isDirectory()){usersFolder.mkdir();}
        if(!leaguesFolder.isDirectory()){leaguesFolder.mkdir();}
        if(!playersFolder.isDirectory()){playersFolder.mkdir();}
    }
    public void addPlayer(Player player) throws IOException{  
          File playerInfo = new File (playersFolder.getAbsolutePath() + File.separator + player.Name + ".txt");
          playerInfo.createNewFile();
          BufferedWriter br = new BufferedWriter(new FileWriter(playerInfo));
          br.append("Name: " + player.Name +"\r\nNationality: " + player.Nationality + "\r\nClub: " + player.Club + "\r\nPosition: " + player.Position + "\r\nPrice: " + player.Price + "\r\nYellow Card: " + player.YellowCard + "\r\nRed Card: " + player.RedCard).flush();
          br.close();
    
    }
    public void addSquadPlayerDatabase(Squad squad, Player player, File SquadPlayersFile) throws IOException{  
          BufferedWriter br = new BufferedWriter(new FileWriter(SquadPlayersFile));
          br.append("Name: " + player.Name +"\r\nNationality: " + player.Nationality + "\r\nClub: " + player.Club + "\r\nPosition: " + player.Position + "\r\nPrice: " + player.Price + "\r\nYellow Card: " + player.YellowCard + "\r\nRed Card: " + player.RedCard).flush();
          br.close();
    
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
