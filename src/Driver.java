import java.io.File;
import java.io.FileNotFoundException;
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
		try {
			sc = new Scanner(inputFile);
			String edgeInput = sc.toString();

			edgeInput = edgeInput.replaceAll("\\s","");

			char[] edgeChars = edgeInput.toCharArray();
                
			
			int[] edgeInt = new int[edgeChars.length];
			for(int i = 0; i < edgeChars.length; i++){
				try{
					edgeInt[i] = (int)edgeChars[i];
				}catch( Exception e){
                        
					System.exit(1);
				}
                        
			}
			Graph g1 = new Graph(edgeInt);
			g1.go();
		} catch (FileNotFoundException e1) {
			System.out.println("Invalid File Location");
			System.exit(1);
		}
        
    }
}
