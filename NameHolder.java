import java.util.*;
import java.io.*;

/**
 * Organizes and stores names from a given file. Can be used to generate a
 * random name.
 *
 * @author Stargon, DiamondBrook
 * @version 1.00, December 24, 2018
 */
public class NameHolder {

    Map<String,Map<String, ArrayList<String>>> names;
    Map<String, ArrayList<String>> surnames;

	/**
	 *
	 * @param fileName The file name that will be processed.
	 * @throws FileNotFoundException File that was passed did not exist.
	 * @throws FileDataException  Data in the file is not formatted correctly.
	 */
	public NameHolder(String fileName) throws FileNotFoundException, 
			FileDataException {
		File f = new File(fileName);
		
		// Check if file exists.
		if(!f.isFile()) {
			throw new FileNotFoundException("File does not exist");
		}
		
		// Initialize data structures
		names = new HashMap<String, Map<String, ArrayList<String>>>();
		surnames = new HashMap<String, ArrayList<String>>();
		Scanner process = new Scanner(f);
		processing(process);
	}

    public void processing(Scanner process) throws FileDataException {
        boolean newSection = false;
        boolean titleSection = false;
        boolean subSection = false;
        while(process.hasNext()) {
            String current = process.nextLine();
            System.out.println(current);
        }
    }
}
