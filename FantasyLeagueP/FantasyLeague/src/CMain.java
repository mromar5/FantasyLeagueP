/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author dell
 */
public class CMain {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Login logger = new Login();
        Registration reg=new Registration();
        Active currentuser=null;
        String ans=null;
        do 
        {
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
					reg.register(email,password,firstname,lastname,favclub);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	else if (ans.equals("2"))
        	{
        		System.out.println("Enter your email:");
        		String email=scan.nextLine();
        		System.out.println("Enter your password:");
        		String password=scan.nextLine();
        		try {
					currentuser=new Active(logger.login(email, password));
				} catch (IOException e) {
					e.printStackTrace();
				}
        		
        	}
        	else if (ans.equals("3"))
        	{
        		break;
        	}
        	else {System.out.println("Wrong input");}
       	}
        while(true);
       

    }
    
}
