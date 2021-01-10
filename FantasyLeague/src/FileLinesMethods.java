import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileLinesMethods {
    //Compares given name(Player's name) with player name in fileSystem/User FileSystem
    boolean lineNameSkipper_Comparer(String obj, File file) throws FileNotFoundException{
            Scanner scan = new Scanner(file); int line = 0; int lineTarget = 1;
            while(scan.hasNextLine()){
                line++;
                if (line == lineTarget){
                    String name = scan.skip(Pattern.compile(".+ ")).nextLine();
                    if (obj.equals(name)){
                       // System.out.println("NameMethod lineCount: " + name);
                        return true;
                    }lineTarget+=7;
                }else scan.nextLine();
    }
            return false;
    };
    //Calculates squad's total cost
    double linePriceSkipper_Calculator(File file) throws FileNotFoundException{
        Scanner scan = new Scanner(file);
        int lineTarget = 5; int line = 0; double totalCost = 0;
        ArrayList<Double> price = new ArrayList<Double>();
            lineTarget = 5; int i=0;
                while(scan.hasNextLine()){
                    line++;
                    if (line == lineTarget){
                        price.add(scan.skip(Pattern.compile(".+: ")).nextDouble());scan.nextLine();
                        totalCost+= price.get(i);
//                        System.out.println("Total cost in if: " + totalCost);
                        lineTarget+=6; i++;
                    }
                    scan.nextLine();
                }
                return totalCost;
    }
    //Counts the number of occurrences of a specific club
    int lineClubSkipper_Counter(String club, File file) throws FileNotFoundException{
        Scanner scan = new Scanner(file);
        int clubCounter = 0;
        int line = 0; 
        int lineTarget = 3;
        while(scan.hasNextLine()){
            line++;
            if (line == lineTarget){ 
                String clubScanner = scan.skip(Pattern.compile(".+: ")).nextLine();
//                System.out.println("Club scanner: " + clubScanner);
                if(club.equals(clubScanner)){
//                    System.out.println("Club Scanner in IF: " + clubScanner);
                    clubCounter++;
//                    System.out.println("Club counter in :" + clubCounter);
                }
                lineTarget+=7;
            }else scan.nextLine();
        }
//        System.out.println("Club counter: " + clubCounter);
        return clubCounter;
    }
    //Counts number of lines to calculate number of Players in a file(Squad or System)
    int filePlayers_Counter(File file) throws FileNotFoundException{
        Scanner scan = new Scanner(file);
        int lineCounter = 0;
        while(scan.hasNextLine()){lineCounter++;scan.nextLine();}
        return (lineCounter/7); //returns number of players
    }
    int[] linePositionsSkipper_Counter(File file) throws FileNotFoundException{
             Scanner scan = new Scanner(file);
             ArrayList<Integer> positions = new ArrayList<Integer>(); int lineTarget = 3; int line = 0; 
             int i = 0; int gkCounter = 0; int defCounter = 0; int attCounter = 0; int midCounter = 0;
             while(scan.hasNextLine()){
                 if (line == lineTarget){
                     positions.add(i, scan.skip(Pattern.compile(".+: ")).nextInt());
                     if (positions.get(i) == 1){
                         gkCounter++;}
                     else if(positions.get(i) == 2)
                     {defCounter++;
                     }
                     else if(positions.get(i) == 3)
                     {
                         midCounter++;
                     }
                     else if(positions.get(i) == 4)
                     {
                         attCounter++;
                     }
                     i++; lineTarget+=7;
                 }
                 line++;
                 scan.nextLine();
             }
              int[] positionsCounterArray = {gkCounter, defCounter, midCounter, attCounter};
                      return positionsCounterArray;
    }
    /*
    boolean lineSkipper(Object obj, String type, File file) throws FileNotFoundException{
        Scanner scan = new Scanner(file); int line = 0; int lineCount = 7;
        switch(type){
            case "1": String name = scan.skip(Pattern.compile(".+: ")).nextLine(); line++;
            while(scan.hasNextLine()){
                if (line == lineCount){
                    if (obj == name){
                        return false;
                    }else lineCount+=7;
                }
                line++;
                
            }
            case "2": ArrayList<Double> price = new ArrayList<Double>();
            lineCount = 5; int i=0;
                while(scan.hasNextLine()){
                    if (line == lineCount){
                        price.add(scan.skip(Pattern.compile(".+: ")).nextDouble());
                        lineCount+=7; i++;
                    }
                    scan.nextLine();
                    line++;
                }
            case "3": ArrayList<Integer> positions = new ArrayList<Integer>(); lineCount = 4; 
             i = 0; int gkCounter = 0; int defCounter = 0; int attCounter = 0; int midCounter = 0;
             while(scan.hasNextLine()){
                 if (line == lineCount){
                     positions.add(i, scan.skip(Pattern.compile(".+: ")).nextInt());
                     if (positions.get(i) == 1){ gkCounter++;}else if(positions.get(i) == 2){defCounter++;}else if(positions.get(i) == 3){midCounter++;}else if(positions.get(i) == 4){attCounter++;}
                     i++; lineCount+=7;
                 }
                 scan.nextLine();
             }
        }              
        
    }*/
}
