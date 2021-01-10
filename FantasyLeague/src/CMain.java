import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CMain {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Login logger = new Login();
        Registration reg=new Registration();
        String ans=null;
        System.out.println("To become a system user use the following credentials: ");
        System.out.println("Use this Email: "+ "admin@admin.com");
        System.out.println("Use this password: " + "admin");
        try {
            reg.register("admin@admin.com", "admin", "Omar", "Ahmed", "Bateekha", "SystemUser");
        } catch (IOException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        do{
            System.out.println("1-Register account");
            System.out.println("2-Login");
            System.out.println("3-Exit");
        	ans=scan.nextLine();
        	if (ans.equals("1"))
        	{
        	     System.out.println("Enter your email");
        	     String email=scan.nextLine();
        	     System.out.println("Enter your password");
        	     String password=scan.nextLine();
        	     System.out.println("Enter your first name");
        	     String firstname=scan.nextLine();
        	     System.out.println("Enter your last name");
        	     String lastname=scan.nextLine();
        	     System.out.println("Enter your favourite club");
        	     String favclub=scan.nextLine();
        	     try {
					reg.register(email,password,firstname,lastname,favclub, "RegularUser");
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	else if (ans.equals("2")){
        		System.out.println("Enter your email:");
        		String email=scan.nextLine();
        		System.out.println("Enter your password:");
        		String password=scan.nextLine();
        		try {
                                        Object tempObj = logger.login(email,password);
                                        String controllerChoice = null;
                                        if (tempObj.getClass().getName().equals("RegularUser")){
                                            RegularUser regularUser = (RegularUser) tempObj;
                                            boolean flag = true;
                                            do{
                                            System.out.println("1- Add player to your squad");
                                      		System.out.println("2- Remove player from your squad");
                                           	System.out.println("3- Create new squad");
                                           	System.out.println("4- Get squad points of certain game week");
                                          	System.out.println("5- View squad by name");
                                        	System.out.println("6- Delete squad");
                                        	System.out.println("7- View all squads");
                                        	System.out.println("8- Back");
                                            		 
                                            controllerChoice = scan.nextLine();
                                            switch (controllerChoice){
                                                case "1": 
                                                		System.out.println("Enter your squad name: ");
                                                		String selectedSquad = scan.nextLine();
                                                		regularUser.squadController.selectSquad(selectedSquad);
                                                        System.out.println("Squad player to be added: ");
                                                        String playerName__ = scan.nextLine();
                                                        regularUser.squadController.addPlayer(regularUser.squadController.selectSquadPlayer(playerName__));
                                                        break;
                                                case "2":
                                                		System.out.println("Enter your squad name: ");
                                                		String selectedSquad2 = scan.nextLine();
                                                		regularUser.squadController.selectSquad(selectedSquad2);
                                                		System.out.println("Squad player to be removed: ");
                                                		String playerName__2 = scan.nextLine();
                                                		regularUser.squadController.removePlayerFromSquad(playerName__2,selectedSquad2);
                                                		break;
                                                case "3": 
                                                	System.out.println("Enter the squad's name:");
                                                	String newSquadName = scan.nextLine();
                                                	regularUser.squadController.createSquad(newSquadName);
                                                	break;
                                                case "4":
                                                	System.out.println("Enter the squad's name:");
                                                	String SName=scan.nextLine();
                                                	System.out.println("Enter the game week:");
                                                	String gameW=scan.nextLine();
                                                	regularUser.squadController.getPoints(SName, gameW);
                                                	break;
                                                case "5":
                                                	System.out.println("Enter the squad's name:");
                                                	String viewedSquad=scan.nextLine();
                                                	regularUser.squadController.viewSquad(viewedSquad);
                                                	break;
                                                case "6":
                                                	System.out.println("Enter the squad's name:");
                                                	String deletedSquad=scan.nextLine();
                                                	regularUser.squadController.deleteSquad(deletedSquad);
                                                	break;
                                                case "7":
                                                	regularUser.squadController.viewSquads();
                                                	break;
                                                case "8":
                                                	flag = false; break;
                                                default: System.out.println("Invalid input"); break;
                                                    
                                            }
                                        }while(flag);
                                            }
                                        else if (tempObj.getClass().getName().equals("SysUser")){
                                            SysUser adminUser = (SysUser) tempObj;
                                            boolean flag = true;
                                            do{
                                            System.out.println("1- Add player to the system\n2- Add a new game week\n"
                                                    + "3- Select a game week\n4- Back");
                                            controllerChoice = scan.nextLine();
                                            switch(controllerChoice){
                                                case "1": 
                                                    System.out.println("Enter player's name: ");
                                                    String playerName = scan.nextLine();
                                                    System.out.println("Enter player's nationality: ");
                                                    String playerNationality = scan.nextLine();
                                                    System.out.println("Enter player's club: ");
                                                    String playerClub = scan.nextLine();
                                                    System.out.println("Enter player's position(1,2,3,4): ");
                                                    int playerPosition = scan.nextInt();
                                                    System.out.println("Enter player's price: ");
                                                    double playerPrice = scan.nextDouble();
                                                    scan.nextLine();
                                                    adminUser.pc.addPlayer(playerName, playerNationality, playerClub, playerPosition, playerPrice);
                                                    break;
                                                case "2": 
                                                          adminUser.eventPerformer.addGameWeek();
                                                          break;
                                                case "3":
                                                		System.out.println("Enter the game week to be selected:");
                                                        String selectedGameWeek = scan.nextLine();
                                                        adminUser.eventPerformer.selectGameWeek(selectedGameWeek);
                                                        boolean actionFlag = true;
                                                    	do{
                                                        System.out.println("Select an action");
                                                        System.out.println("1- Score Goal");
                                                        System.out.println("2- Goal Assist");
                                                        System.out.println("3- Concede a goal");
                                                        System.out.println("4- Clean Sheet");
                                                        System.out.println("5- MVP");
                                                        System.out.println("6- Give a yellow card");
                                                        System.out.println("7- Give a red card");
                                                        System.out.println("8- Save a shot");
                                                        System.out.println("9- Score own goal");
                                                        System.out.println("10- Save a penalty");
                                                        System.out.println("11- Miss a penalty");
                                                        System.out.println("12- Play 60 minutes");
                                                        System.out.println("13- Play more than 60 minutes");
                                                        System.out.println("0-  Back");
                                                        String actionsScan = scan.nextLine();
                                                        String actionPlayerName;
                                                        switch(actionsScan){
                                                            case "1": 
                                                                System.out.println("Enter Player name");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.scoreGoal(actionPlayerName);
                                                                break;
                                                            case "2":
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.assistGoal(actionPlayerName);
                                                                break;
                                                            case "3": System.out.println("Enter Player Name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.concedeGoals(actionPlayerName);
                                                                break;
                                                            case "4": 
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.DoCleanSheet(actionPlayerName);
                                                                break;
                                                            case "5": 
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                System.out.println("Enter player bonus: ");
                                                                int bonus = scan.nextInt(); scan.nextLine();
                                                                adminUser.eventPerformer.rewardMVP(actionPlayerName, bonus);
                                                                break;
                                                            case "6": 
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.giveYellowCard(actionPlayerName);
                                                                break;
                                                            case "7":
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.giveRedCard(actionPlayerName);
                                                                break;
                                                            case "8": 
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.saveShots(actionPlayerName);
                                                                break;
                                                            case "9":
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.ScoreOwnGoal(actionPlayerName);
                                                                break;
                                                            case "10": 
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.savePenalty(actionPlayerName);
                                                                break;
                                                            case "11":
                                                                System.out.println("Enter Player name: ");
                                                                actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.missPenalty(actionPlayerName);
                                                                break;
                                                            case "12":
                                                            	System.out.println("Enter Player name: ");
                                                            	actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.play_60Minutes(actionPlayerName);
                                                            	break;
                                                            case "13":
                                                            	System.out.println("Enter Player name: ");
                                                            	actionPlayerName = scan.nextLine();
                                                                adminUser.eventPerformer.playMoreThan_60Minutes(actionPlayerName);
                                                            	break;
                                                            case "0": 
                                                                actionFlag = false;break;
                                                            default: System.out.println("Invalid input");break;
                                                                
                                                        }
                                                        }
                                                        while(actionFlag);
                                                        break;
                                                case "4": flag = false; break;
                                                default: System.out.println("Invalid input");break;
                                            }
                                            }while(flag);
                                            }
                                        else{
                                            System.out.println("Error"); break;
                                        }
} catch (IOException e) {
					e.printStackTrace();
				}}        	
        	else if (ans.equals("3")){
        		break;
        	}
        	else {System.out.println("Wrong input");}
        }while(true);
}
}