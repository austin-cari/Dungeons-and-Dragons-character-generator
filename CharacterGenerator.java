import java.io.*;
import java.util.Scanner;

/**
 * This class is the main class that will generate a random 5e Dungeons and 
 * Dragons character. Current version will print onto console.
 * 
 * If this was to be executed as an executable, this object should be the only
 * public object that is visible and usable to the client. In other words, this
 * object should be the object that the user should be using when using the 
 * character generator.
 * 
 * @author Stargon, DiamondBrook
 * @version 1.00, December 24, 2018
 */
public class CharacterGenerator {

	/**
	 * 
	 * The main method. This method will handle the execution of generating a
	 * random character.
	 * 
	 * @param args The command line arguments.
	 * @throws FileNotFoundException Files used do not exists. Only hit this 
	 * point if the user inputs a non-existing file name.
	 * @throws FileDataException The data in the file does not follow the 
	 * correct format
	 */
	public static void main(String[] args) throws FileNotFoundException, 
			FileDataException {
		
		// Default file names.
		String[] fileNames = {"names.txt", "equipment.txt"};
		
		// Creating a scanner that records input from System.in
		Scanner console = new Scanner(System.in);
		
		// Introduces user to the program and checks for file names.
		introduction(fileNames, console);
		
		NameHolder nameList = new NameHolder(fileNames[0]);
	}
	
	/**
	 * Prints out an introduction and gathers input from the user
	 * when prompted in the console.
	 * 
	 * @param f An array that contains the name of the files used for random 
	 * names and equipment.
	 * @param c A scanner that will be used to read the user's input.
	 */
	private static void introduction(String[] f, Scanner c) {
		System.out.println("This program will generate a random 5e "
				+ "Dungeons and Dragons character." + "\n");
		System.out.println("All names and standard equipment generated are "
				+ "from the default files "
				+ "\n\"names.txt\" and \"equipment.txt\".\n");
		System.out.println("Would you like to keep the defaults? "
				+ "\n0 = no, 1 = yes");
		int response = c.nextInt();
		if(response != 1) {
			System.out.print("Please input the file with the new list "
					+ "of names: ");
			f[0] = c.next();
			System.out.print("Please input the file with the new list "
					+ "of equipment: ");
			f[1] = c.next();
		}
		
	}

}
