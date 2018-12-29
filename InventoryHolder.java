import java.util.*;
import java.io.*;

/**
 * Organizes and stores equipment from a given file. Can be used to generate a
 * random name.
 *
 * @author Stargon, DiamondBrook
 * @version 1.00, December 24, 2018
 */
public class InventoryHolder {
	
	// Tab space/Indent for this code is 4.
	
	// Data structures that will store the individual items in the correct 
	// grouping. To expand what this class can store, add the type of item that
	// you want to add. Adjust the checkSection() to check for the new type of 
	// item.
	// From now on, the type of item (ex: pack, weapon) will be referred as a 
	// tag.
	private Map<String, ArrayList<String>> pack;
	private Map<String, Map<String, ArrayList<String>>> weapon;
	
	public InventoryHolder(String fileName) throws FileNotFoundException,
			FileDataException{
		File f = new File(fileName);
		
		// Check if file exists.
        if(!f.isFile()) {
            throw new FileNotFoundException("File does not exist");
        }
        
        // Initialize class variables
        pack = new HashMap<String, ArrayList<String>>();
        weapon = new HashMap<String, Map<String, ArrayList<String>>>();
        
        // Initialize scanner to scan through the file
        Scanner process = new Scanner(f);
        
        // Process the file to store the data in the file in a usable way
        processing(process);
        
        
	}
	
	/**
	 * Organizes information that is contained in the scanner. The information 
	 * given from the scanner will be from a file. The file must be formatted in
	 * a specific way, or else this method will throw an exception.
	 * 
	 * @param process
	 * @throws FileDataException
	 */
	private void processing(Scanner process) throws FileDataException {
		
		String[] section = {};
		
		// Process the file until there are no more lines left. If the file is
		// formatted/written correctly, then this object will be able to expand
		// and accommodate different types of packs or weapons and store the 
		// specific item in the correct group.
		while(process.hasNext()) {
			
			// Get next line in the file.
			String current = process.nextLine();
			// Checks if current has at least 3 '=', which represents a
            // new section.
            if(current.startsWith("===") && process.hasNext()) {
                
                // Get next line of the file. It should be the title of the
                // section.
                current = process.nextLine();
                
                // The proper title is consists of a string of words separated
                // by spaces. Further details on what the format looks like
                // is in the checkSection method.
                String[] currentSplit = current.split(" ");
                
                // Extract the current section details after checking the line.
                section = checkSection(currentSplit);
                
                // Check the next line for the title section closer.
                current = process.nextLine();
                if(!current.startsWith("---")) {
                    throw new FileDataException("Invalid data format");
                }
            } else if (process.hasNext() && !current.startsWith("#")) {
                // Current line is an item. Add it in the appropriate data map.
                if(section[0].equalsIgnoreCase("Weapon:")) {
                    String t = section[1].toLowerCase();
                    String e = section[2].toLowerCase();
                    System.out.println(current);
                    weapon.get(t).get(e).add(current);
                } else if (section[0].equalsIgnoreCase("Pack:")){
                    String t = section[1].toLowerCase();
                    pack.get(t).add(current);
                }
            }
		}
	}
	
	/**
	 * 
	 * Checks if the current section title is formatted correctly. If all 
	 * the checks are passed, it will check if the section tag already exists or
	 * not. If it doesn't, this method will record the new tag.
	 * 
	 * @param c A String Array containing the elements of what was originally
	 * the title.
	 * @return A String Array that could be used to identify a tag
	 * @throws FileDataException The title used in the the file is not formatted
	 * correctly.
	 */
	private String[] checkSection(String[] c) throws FileDataException{
		/* This is the correct format for the section title:
        *
        * =====================================================================
        * [Weapon:] [Type] [Experience]
        * ---------------------------------------------------------------------
        * .
        * .
        * .
        *
        *                               or
        *
        * =====================================================================
        * [Pack:] [Type]
        * ---------------------------------------------------------------------
        * .
        * .
        * .
        *
        * If the file does not follow this exact format, a FileDataException
        * will be thrown.
        *
        * The [...] in the example above are each inside a separate index in
        * the String[] c array.
        * 
        * Generally (where x = number of qualifiers):
        * [Tag:] [Qualifier 1] [Qualifier 2] ... [Qualifier x]
        * c[0]   c[1]          c[2]          ... c[x]
        * 
        * Specifically (from version 1.00)...
        *
        * [Weapon:] [Type] [Experience]
        * c[0]      c[1]   c[2]
        *
        * [Pack:] [Type]
        * c[0]    c[1]
        * 
        * Max amount of qualifiers = 2, Minimum amount of qualifiers = 1
        * ...or 1 < x < 2.
        * 
        * From now on, when x is used, x is referred as the max amount of 
        * qualifiers. 
        *
        */
        
        // c should never be greater than x + 1 or less than 2 (Tag + Qualifier)
        if(c.length > 3 || c.length < 2) {
            throw new FileDataException("Invalid entry of a item type");
        }
        
        // Checks if first part of the String contains a tag name.
        String n = c[0];
        if(!n.equalsIgnoreCase("Pack:") && !n.equalsIgnoreCase("Weapon:")) {
            throw new FileDataException("Invalid entry of a item type");
        }
        
        // Check if the number of words matches the expected amount expected
        // from the format.
        if(n.equalsIgnoreCase("Pack:") && c.length != 2) {
            throw new FileDataException("Invalid entry of pack grouping");
        } else if (n.equalsIgnoreCase("Weapon:") && c.length != 3) {
            throw new FileDataException("Invalid entry of weapon grouping");
        }
        
        // At this point, current String[] c is in the correct format.
        
        // Check if the data structure of the associated tag if the qualifier
        // for the item exists and adds it into the data if it doesn't
        // exist.
        if(n.equalsIgnoreCase("Weapon:")){
            String t = c[1].toLowerCase();
            String e = c[2].toLowerCase();
            if(!weapon.containsKey(t)) {
                // names did not contain the [Type], add it in.
                weapon.put(t, new HashMap<String, ArrayList<String>>());
            }
            if(!weapon.get(t).containsKey(e)) {
                // names did not contain the [Experience], add it in
                weapon.get(t).put(e, new ArrayList<String>());
            }
        } else if (n.equalsIgnoreCase("Pack:")) {
            String t = c[1].toLowerCase();
            if(!pack.containsKey(t)) {
                pack.put(t, new ArrayList<String>());
            }
        }
        
        // Everything in c is legal and accounted for, return c.
        return c;
	}
	
	/**
	 * 
	 * Takes a given pack type and returns a list of items of that associated 
	 * pack type.
	 * 
	 * @param packType Name of the pack type desired. Expects that the pack type
	 * asked was already recorded in this data structure already. String can be 
	 * case-insensitive.
	 * @return All items that are associated with the pack type in an array.
	 */
	public String[] generatePack(String packType) {
		
		// Making the input case-insensitive.
		String packTypeInsensitive = packType.toLowerCase();
		
		// Initialize String array to contain the array
		String[] finalPack = new String[pack.get(packTypeInsensitive).size()];
		
		// Save the items found in this object to the finalPack array
		for(int i = 0; i < pack.get(packTypeInsensitive).size(); i++) {
			finalPack[i] = pack.get(packTypeInsensitive).get(i);
		}
		return finalPack;
	}

	/**
	 * 
	 * Randomly generate a weapon given a weapon type. For example, a weapon 
	 * type would be "Ranged Simple". Ideally, it should follow the weapon type
	 * specified in the equipment.txt
	 * 
	 * @param weaponType Type of weapon that the user wants in one string, 
	 * separated by spaces.
	 * @return Return a random weapon that is associated witht the random type.
	 */
	public String generateRandomWeapon(String weaponType) {
		
		// Split the string to [Type] and [Experience]. Also making 
		// the weaponType string case-insensitive.
		String[] type = weaponType.toLowerCase().split(" ");
		
		// Find the list associated with the  [Type] and [Experience] in the 
		// object.
		ArrayList<String> weaponTypeList = weapon.get(type[0]).get(type[1]);
		
		// Initiate random object.
		Random r = new Random();
		
		// Randomly select a random object.
		return weaponTypeList.get(r.nextInt(weaponTypeList.size()));
		
	}
}
