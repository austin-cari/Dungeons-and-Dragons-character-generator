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
	
	
	/**
	 * 
	 * @param fileName The file name that will be processed.
	 * @throws FileNotFoundException
	 */
	public NameHolder(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		
		// Check if file exists.
		if(!f.isFile()) {
			throw new FileNotFoundException("File does not exist");
		}
	}

}
