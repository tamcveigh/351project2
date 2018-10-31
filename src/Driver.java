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
    	System.out.println("Hello");
        Scanner sc;
        ArrayList<Integer> nums = new ArrayList<Integer>();
		try {
			sc = new Scanner(inputFile);
			while(sc.hasNextInt()) {
				nums.add(sc.nextInt());
			}
			
			Graph g1 = new Graph(nums);
			g1.findSourceDest();

			//g1.go();
		} catch (FileNotFoundException e1) {
			System.out.println("Invalid File Location");
			System.exit(1);
		}
        
    }
}
