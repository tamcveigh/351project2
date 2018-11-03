import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Tyler McVeigh and Mi'Quel Muldrow
 * @version October 25, 2018 Version 1.0
 */

public class Driver{

    public static void main(String[] args){
    	//Counts the number of numbers from the file
    	File inputFile = new File(args[0]);
        Scanner sc;
        ArrayList<Integer> nums = new ArrayList<Integer>();
		try {
			//Adding all numbers from the file into a list to be 
            //manipulated for the graph
			sc = new Scanner(inputFile);
			while(sc.hasNextInt()) {
				nums.add(sc.nextInt());
			}
			
			//If the amount of numbers is even and there is at least 2 numbers 
            //in the file (since 0%2 = 0)
			if(nums.size()%2 == 0 && nums.size() != 0) {
				Graph g1 = new Graph(nums);
				g1.go();
			}//end if statement
			
			else {
				throw new IllegalArgumentException("Please enter a file with" + 
                " an even amount of numbers");
			}

		} catch (FileNotFoundException e1) {
			System.out.println("Invalid File Location");
			System.exit(1);
		}
        
    }
}
