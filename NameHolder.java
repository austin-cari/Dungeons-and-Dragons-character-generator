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
    
    // Main data structures to store information about the names, surnames,
    // and their associated gender/race assignment.
    private Map<String,Map<String, ArrayList<String>>> names;
    private Map<String, ArrayList<String>> surnames;
    
    /**
    * The Constructor of the class.
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
        
        // Begin processing the file
        processing(process);
    }
    
    /**
    * Organizes information that is contained in the scanner. The information 
    * given from the scanner will be from a file. The file must be formatted in
    * a specific way, or else this method will throw an exception.
    *
    * @param process The scanner of a file being processed.
    * @throws FileDataException Data in file is not formatted properly.
    */
    private void processing(Scanner process) throws FileDataException {
        
        // String array section indicates what section of the file this object
        // is currently processing. Initially set as a null array.
        String[] section = {};
        
        // Loop through the file until there is nothing left to loop through.
        // If the file is written correctly, everything name/surname will be
        // saved in it's associated Gender + Race/Race grouping.
        while(process.hasNext()) {
            
            // Get next line in the file
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
                // Current line is guarantee an entry name/surname. Add it in
                // the appropriate data map.
                if(section[0].equalsIgnoreCase("Names:")) {
                    String g = section[1].toLowerCase();
                    String r = section[2].toLowerCase();
                    names.get(g).get(r).add(current);
                } else {
                    String r = section[1].toLowerCase();
                    surnames.get(r).add(current);
                }
            }
        }
    }
    
    /**
    * Dedicated method that checks if the title in a section separator is
    * correct or not. It will record the title if it isn't already recorded
    * in this object.
    *
    * @param c A String Array containing the elements of what was originally
    * the title.
    * @return A String Array that could be used to identify a name/gender/race
    * or a surname/race.
    * @throws FileDataException The title used in the the file is not formatted
    * correctly.
    */
    private String[] checkSection(String[] c) throws FileDataException{
        /* This is the correct format for the section title:
        *
        * =====================================================================
        * [Names:] [Gender] [Race]
        * ---------------------------------------------------------------------
        * .
        * .
        * .
        *
        *                               or
        *
        * =====================================================================
        * [Surnames:] [Race]
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
        * [Names:] [Gender] [Race]
        * c[0]     c[1]     c[2]
        *
        * [Surnames:] [Race]
        * c[0]        c[1]
        *
        */
        
        // c should never be greater than 3 or less than 2.
        if(c.length > 3 || c.length < 2) {
            throw new FileDataException("Invalid entry of name/surname");
        }
        
        // Checks if first part of the String is "Names:" or "Surnames:"
        String n = c[0];
        if(!n.equalsIgnoreCase("Names:") && !n.equalsIgnoreCase("Surnames:")) {
            throw new FileDataException("Invalid entry of name/surname");
        }
        
        // Check if the number of words matches the expected amount expected
        // from the format.
        if(n.equalsIgnoreCase("Surnames:") && c.length != 2) {
            throw new FileDataException("Invalid entry of surname group");
        } else if (n.equalsIgnoreCase("Names:") && c.length != 3) {
            throw new FileDataException("Invalid entry of name grouping");
        }
        
        // At this point, current String[] c is in the correct format.
        
        // Check if the data structure "names" contains the gender and race of
        // the current section title and adds it into the data if it doesn't
        // exist.
        if(n.equalsIgnoreCase("Names:")){
            String g = c[1].toLowerCase();
            String r = c[2].toLowerCase();
            if(!names.containsKey(g)) {
                // names did not contain the [Gender], add it in.
                names.put(g, new HashMap<String, ArrayList<String>>());
            }
            if(!names.get(g).containsKey(r)) {
                // names did not contain the [Race], add it in
                names.get(g).put(r, new ArrayList<String>());
            }
        } else if (n.equalsIgnoreCase("Surnames:")) {
            String r = c[1].toLowerCase();
            if(!surnames.containsKey(r)) {
                surnames.put(r, new ArrayList<String>());
            }
        }
        
        // Everything in c is legal and accounted for, return c.
        return c;
    }
    
    /**
    *
    * This method will generate a random character base on the information
    * stored in this object.
    *
    * @return A String Array that returns the in the following format:
    * <br>[Name of Character, Gender of Character, Race of Character]
    */
    public String[] generateCharacter() {
        // Initialize a random object to use.
        Random r = new Random();
        
        // This part will randomly choose a gender for a name.
        String gender = "";
        Set<String> genderSet = names.keySet();
        int chosenGender = r.nextInt(genderSet.size());
        Iterator<String> genderIter = genderSet.iterator();
        for(int i = 0; i <= chosenGender; i++) {
            gender = genderIter.next();
        }
        
        // This part will randomly choose a race. The race in the names map
        // should align with the race in the surnames map.
        String race = "";
        Set<String> raceSet = names.get(gender).keySet();
        int chosenRace = r.nextInt(raceSet.size());
        Iterator<String> raceIter = raceSet.iterator();
        for(int i = 0; i <= chosenRace; i++) {
            race = raceIter.next();
        }
        
        // This part will randomly choose a name.
        ArrayList<String> finalName = names.get(gender).get(race);
        int chosenName = r.nextInt(finalName.size());
        String name = finalName.get(chosenName);
        
        // This part will randomly choose a surname.
        ArrayList<String> finalSurname = surnames.get(race);
        int chosenSurname = r.nextInt(finalSurname.size());
        String surname = finalSurname.get(chosenSurname);
        
        // Construct the final name
        String overallName = name + " " + surname;
        
        // Construct the character's identity.
        String[] identity = {overallName, gender, race};
        
        return identity;
    }
}