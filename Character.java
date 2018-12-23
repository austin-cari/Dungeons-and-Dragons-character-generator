import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * Author: Austin Cari
 * Date: 12/7/18
 * Description: Randomly generates a 5e Dungeons and Dragons character. Prints character information to console
 */
public class Character {
	
	//basic info
	String name, surname, race, gender, pClass, background, alignment, title;
	
	//stats
	int level;
	
	//maximum health points
	int HP;					
	
	//Proficiency bonus
	int profBonus;			
	
	//armor class
	int AC;					//need to implement
	
	//size of the character
	String size;			
	
	//speed per round. Typically 25 or 30
	int speed;				
	
	//passive wisdom
	int passiveWis;			
	
	// an array of 0s and 1s. 1 if they possess the skill, 0 if they don't
	int[] skillProfs = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};		
	
	//a list that contains all weapons/tools the character is proficient in 
	ArrayList<String>proficiencies = new ArrayList<String>();	
	
	//A list of all the features the character gains from their class
	ArrayList<String> features = new ArrayList<String>();	
	
	//ability scores
	int strength;					
	int dexterity;
	int constitution;
	int intelligence;
	int wisdom;
	int charisma;
	
	//ability score modifiers
	int STRmod;
	int DEXmod;
	int CONmod;
	int INTmod;
	int WISmod;
	int CHRmod;
	
	//An array to track which two ability scores you are proficient in 
	int[] abilitySavingThrows = {0,0,0,0,0,0};
	
	//equipment
	ArrayList<String> inventory = new ArrayList<String>();			
	ArrayList<String> weapons = new ArrayList<String>();				
	String armor;							
	boolean shield;							
	int[] currency = {0,0,0};				//currency[0] = copper coins, currency [1] = silver coins, etc...
	
	//Spells and stuff
	ArrayList<String> firstLevelSpells = new ArrayList<String>();		//need to implement
	int firstLevelSpellSlots;											//need to implement
	
	
	//class specific archetypes. Null if non applicable
	String clericDomain;
	String fightingStyle;
	String favoredEnemy;
	String sorcerousOrigin;
	String otherworldyPatron;
	//languages known and how many you know
	int langAmount;
	ArrayList<String> languagesKnown = new ArrayList<String>();
	
	/*
	 * Creates a randomly generated character at level 1.
	 */
	public Character() {
			
		//set any class/background-specific parameters to empty strings;
		this.clericDomain = "";
		this.fightingStyle = "";
		this.favoredEnemy = "";
		this.sorcerousOrigin = "";
		this.otherworldyPatron = "";
		title = "";
		
		//we only create level one characters. All level 1 characters have + proficiency bonus
		level = 1;
		profBonus = 2;
		
		
		this.getRandomClass();
		this.assignAbilityScores();
		this.setModifiers();
		this.getRandomRace();
		this.getRandomGender();
		this.getRandomName();
		this.getRandomBackground();
		this.getRandomAlignment();
		
	}

	/*
	 * Gives the character a random background that can be easily tied to their class. For instance, a Paladin is more likely to be a Folk Hero than a Criminal.
	 * A Bard is more likely to be an entertainer than a Wizard. This function picks a random background, and then gives the character whatever benfitis come with it,
	 * in the form of extra equipment, gold and profs.
	 */
	public void getRandomBackground() {
		Random rand = new Random();
		
		//Step 1: Based on your class, pick a random background that is thematic to your character.
		
		if(pClass == "Barbarian") {
			String[] potentialBackground = {"Criminal", "Folk Hero", "Hermit", "Outlander", "Soldier"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Bard") {
			String[] potentialBackground = {"Charlatan", "Criminal", "Entertainer", "Guild Artisan", "Folk Hero", "Noble", "Sailor"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Cleric") {
			String[] potentialBackground = {"Acolyte", "Folk Hero", "Guild Artisan", "Hermit", "Noble", "Sage"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Druid") {
			String[] potentialBackground = {"Hermit", "Outlander", "Sage"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Fighter") {
			String[] potentialBackground = {"Criminal", "Folk Hero", "Hermit", "Noble", "Outlander", "Sailor", "Soldier", "Urchin"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Monk") {
			String[] potentialBackground = {"Acolyte", "Hermit", "Sage"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Paladin") {
			String[] potentialBackground = {"Acolyte", "Folk Hero", "Noble", "Soldier"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Ranger") {
			String[] potentialBackground = {"Criminal", "Hermit", "Outlander", "Sailor", "Soldier", "Urchin"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Rogue") {
			String[] potentialBackground = {"Charlatan", "Criminal", "Entertainer", "Hermit", "Noble", "Sailor", "Soldier", "Urchin"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Sorcerer") {
			String[] potentialBackground = {"Acolyte", "Hermit", "Noble", "Outlander", "Sage"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Warlock") {
			String[] potentialBackground = {"Acolyte", "Charlatan", "Criminal", "Hermit", "Noble", "Sage", "Urchin"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		if(pClass == "Wizard") {
			String[] potentialBackground = {"Charlatan", "Folk Hero", "Guild Artisan", "Hermit", "Noble", "Sage", "Urchin"};
			int choice = rand.nextInt(potentialBackground.length);
			background = potentialBackground[choice];
		}
		
		//Step 2: Give the character whatever benefits come with the chosen background. 
		//NOTE: There is one aspect of the background feature missing. Each background has a special field associated with it that I have not coded in yet.
		//For instance, the criminal background has a feature in the PHB 129 called specialty, with an 8 cell table listing certain types of crime. Blackmailer, burglar, 
		//enforcer, highway robber, pickpocket, and so on. It adds another layer of personality to the character. Adding a specific skill even within a background that makes
		//character feel fleshed out. Each background has a field like this. Entertainer has a specialty routine, Guild Artisans have trading/crafting specialties, and so 
		//forth. I think the best way to store this information is in a global var named String backgroundSpecialty (or something like that) that stores a value from the tables
		//in the PHB. A good example of what I am talking about is under the if statement when your background is a Charlatan. Notice how I use a Random object to choose
		//an item to add to my inventory based on conOfChoice. 
		
		if(background == "Acolyte") {
			features.add("Shelter of the Faithful(PHB 127)");
			skillProfs[6] = 1;	//insight
			skillProfs[14] = 1;	//religion
			inventory.add("Holy symbol");
			inventory.add("prayer book");
			inventory.add("bundle of vestments");
			inventory.add("set of common clothes");
			currency[2] = currency[2] + 15;
			langAmount = langAmount + 2;
		}
		if(background == "Charlatan") {
			features.add("False Identity(PHB 128)");
			skillProfs[4] = 1;	//deception
			skillProfs[15] = 1;	//sleight of hand
			inventory.add("a set of fine clothes");
			inventory.add("Disguise kit");
			int conOfChoice = rand.nextInt(3);
			if(conOfChoice == 0) {
				inventory.add("stoppered bottles filled with colored liquid");
			}
			if(conOfChoice == 1) {
				inventory.add("set of weighted dice");
			}
			if(conOfChoice == 2) {
				inventory.add("deck of marked cards");
			}
			if(conOfChoice == 3) {
				inventory.add("signet ring of an imaginary duke");
			}
			currency[2] = currency[2] + 15;
		}
		if(background == "Criminal") {
			features.add("Criminal Contract(PHB 129)");
			skillProfs[4] = 1;	//deception
			skillProfs[16] = 1; //stealth
			inventory.add("crowbar");
			inventory.add("set of dark common clothes with hood");
			currency[2] = currency[2] + 15;
		}
		if(background == "Entertainer") {
			features.add("By Popular Demand(PHB 130)");
			skillProfs[0] = 1;	//acrobatics
			skillProfs[12] = 1;	//performance
			inventory.add(getRandomInstrument());
			currency[2] = currency[2] + 15;
		}
		if(background == "Folk Hero") {
			features.add("Rustic Hospitality(PHB 131)");
			skillProfs[1] = 1; 	//animal Handling
			skillProfs[17] = 1; //survival
			inventory.add(getRandomArtisanTool());
			inventory.add("shovel");
			inventory.add("iron pot");
			inventory.add("set of common clothes");
			currency[2] = currency[2] + 10;
		}
		if(background == "Guild Artisan") {
			features.add("Guild Membership(PHB 133)");
			skillProfs[6] = 1;	//insight
			skillProfs[13] = 1; //persuasion
			inventory.add(getRandomArtisanTool());
			inventory.add("letter of introduction from guild");
			inventory.add("set of traveler's clothes");
			currency[2] = currency[2] + 15;
		}
		if(background == "Hermit") {
			features.add("Discover (PHB 134)");
			skillProfs[9] = 1;	//medicine
			skillProfs[14] = 1; //religion
			inventory.add("scroll case stuffed with notes");
			inventory.add("winter blanket");
			inventory.add("set of common clothes");
			currency[2] = currency[2] + 5;
		}
		if(background == "Noble") {
			features.add("Position of Privelege(PHB 135)");
			skillProfs[5] = 1;	//history
			skillProfs[13] = 1;	//persuasion
			inventory.add("set of fine clothes");
			inventory.add("signet ring");
			inventory.add("scroll of pedigree");
			currency[2] = currency[2] + 25;
			title = getRandomTitle();							//This method gives the player a random title, which is set to "" in the constructor. Only
		}														//Nobles have titles.
		if(background == "Outlander") {
			features.add("Wanderer(PHB 136)");
			skillProfs[3] = 1;	//athletics
			skillProfs[17] = 1;	//survival
			inventory.add("staff");
			inventory.add("hunting trap");
			inventory.add("animal trophy");
			inventory.add("set of traveler's clothes");
			currency[2] = currency[2] + 10;
		}
		if(background == "Sage") {
			features.add("Researcher(PHB 138)");
			skillProfs[2] = 1;	//arcana
			skillProfs[5] = 1;	//history
			inventory.add("bottle of black ink");
			inventory.add("quill");
			inventory.add("small knife");
			inventory.add("letter from a dead colleague posing a question you have not been able to answer");
			inventory.add("set of common clothes");
			currency[2] = currency[2] + 10;
		}
		if(background == "Sailor") {
			features.add("Ship's Passage(PHB 139)");
			skillProfs[3] = 1;	//athletics
			skillProfs[11] = 1;	//perception
			inventory.add("belaying pin");
			inventory.add("50 ft of silk rope");
			inventory.add(getRandomTrinket());
			inventory.add("set of common clothes");
			currency[2] = currency[2] + 10;
		}
		if(background == "Soldier") {
			features.add("Military Rank(PHB 140)");
			skillProfs[3] = 1;	//athletics
			skillProfs[7] = 1;	//intimidation
			inventory.add("rank insignia");
			inventory.add(getRandomTrinket());
			inventory.add("set of bone dice");
			inventory.add("set of common clothes");
			currency[2] = currency[2] + 10;
		}
		if(background == "Urchin") {
			features.add("City Secrets(PHB 141)");
			skillProfs[15] = 1;	//sleight of hand
			skillProfs[16] = 1;	//stealth
			inventory.add("small knife");
			inventory.add("map of the city you grew up in");
			inventory.add("pet mouse");
			inventory.add("token to remember your parents by");
			inventory.add("set of common clothes");
			currency[2] = currency[2] + 10;
		}
	}

	public void computeHP() {
		if(pClass == "Barbarian") {
			HP = 12 + CONmod;
		}
		if(pClass == "Fighter" || pClass == "Paladin" || pClass == "Ranger") {
			HP = 10 + CONmod;
		}
		if(pClass == "Bard" || pClass == "Cleric" || pClass == "Druid" || pClass == "Monk" || pClass == "Rogue" || pClass == "Warlock") {
			HP = 8 + CONmod;
		}
		if(pClass == "Sorcerer" || pClass == "Wizard") {
			HP = 6 + CONmod;
		}
		
	}

	/*
	 * When called, creates four randomly generated ability scores by rolling 4 dice, rerolling all 1's, and adding up the three highest scores.
	 * Will then assign two highest values to the appropriate scores based on class requirements. For example, Fighters will assign their two highest
	 * scores into strength and constitution.
	 */
	public void assignAbilityScores() {
		ArrayList<Integer> abilityScores = new ArrayList<Integer>();	//Init an array to store your rolled values.
		for(int n = 0; n < 6; n++) {									//run 6 times for 6 rolls.
			abilityScores.add(0);										//add 6 elements to the array
		}
		for(int n = 0; n < 6; n++){
			Random rand = new Random();
			int roll1 = 1 + rand.nextInt(6);							//Roll 4 dice with a range of 1-6. Store them in roll1-4
			int roll2 = 1 + rand.nextInt(6);
			int roll3 = 1 + rand.nextInt(6);
			int roll4 = 1 + rand.nextInt(6);
			
			ArrayList<Integer> numList = new ArrayList<Integer>();		//Add the four rolls to the same collection so they can be compared.
			numList.add(roll1);
			numList.add(roll2);
			numList.add(roll3);
			numList.add(roll4);
			
			for(int i = 0; i < 4; i++){									//This for statement looks to see if any of the elements is a 1. If it is a 1, reroll that 
				while(numList.get(i) <= 1) {							//dice until it is not a 1. This makes sure that awful rolls don't ruin an entire character
					int newRoll = 1 + rand.nextInt(5);					//and make ability stores slightly more consistent
					numList.set(i, newRoll);
				}
			}
			int minIndex = numList.indexOf(Collections.min(numList));	//remove the lowest value. We are only adding the top 3.
			numList.remove(minIndex);
			

			for(int i = 0; i < 3; i++){										//Add up the remaining 3 values. Now store that value in the Nth element of abilityScores
				int interimScore = abilityScores.get(n) + numList.get(i); 
				abilityScores.set(n, interimScore);
			}
		}
		
		//After having rolled your 6 stats, you will place the two highest numbers into your two most important scores. Each class has two classes that they are
		//proficient in regarding saving throws. These two scores also define the class and need to be the highest to support the mechanics of the class. For example, 
		//Barbarians need high strength to wield heavy weapons and survive damage. Wizards need high intelligence to cast spells. The remaining four scores are assigned
		//randomly to add variety to the characters generated. 
		if(pClass == "Barbarian"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			strength = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			constitution = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			dexterity = abilityScores.get(0);
			intelligence = abilityScores.get(1);
			wisdom = abilityScores.get(2);
			charisma = abilityScores.get(3);	
			}
		
		if(pClass == "Bard"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			charisma = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			dexterity = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			strength = abilityScores.get(0);
			intelligence = abilityScores.get(1);
			wisdom = abilityScores.get(2);
			constitution = abilityScores.get(3);	
			}
		
		if(pClass == "Cleric"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			wisdom = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			charisma = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			dexterity = abilityScores.get(0);
			intelligence = abilityScores.get(1);
			strength = abilityScores.get(2);
			constitution = abilityScores.get(3);	
			}
		
		if(pClass == "Druid"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			intelligence = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			wisdom = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			dexterity = abilityScores.get(0);
			strength = abilityScores.get(1);
			constitution = abilityScores.get(2);
			charisma = abilityScores.get(3);	
			}
		
		if(pClass == "Fighter"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			strength = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			constitution = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			dexterity = abilityScores.get(0);
			intelligence = abilityScores.get(1);
			wisdom = abilityScores.get(2);
			charisma = abilityScores.get(3);	
			}
		
		if(pClass == "Monk"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			strength = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			dexterity = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			constitution = abilityScores.get(0);
			intelligence = abilityScores.get(1);
			wisdom = abilityScores.get(2);
			charisma = abilityScores.get(3);	
			}
		
		if(pClass == "Paladin"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			wisdom = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			charisma = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			dexterity = abilityScores.get(0);
			intelligence = abilityScores.get(1);
			strength = abilityScores.get(2);
			constitution = abilityScores.get(3);	
			}
		
		if(pClass == "Ranger"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			dexterity = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			wisdom = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			strength = abilityScores.get(0);
			intelligence = abilityScores.get(1);
			constitution = abilityScores.get(2);
			charisma = abilityScores.get(3);	
			}
		
		if(pClass == "Rogue"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			dexterity = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			intelligence = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			strength = abilityScores.get(0);
			constitution = abilityScores.get(1);
			wisdom = abilityScores.get(2);
			charisma = abilityScores.get(3);	
			}
		
		if(pClass == "Sorcerer"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			constitution = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			charisma = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			strength = abilityScores.get(0);
			dexterity = abilityScores.get(1);
			wisdom = abilityScores.get(2);
			intelligence = abilityScores.get(3);	
			}
		
		if(pClass == "Warlock"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			wisdom = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			charisma = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			dexterity = abilityScores.get(0);
			intelligence = abilityScores.get(1);
			strength = abilityScores.get(2);
			constitution = abilityScores.get(3);	
			}
		
		if(pClass == "Wizard"){
			int index = abilityScores.indexOf(Collections.max(abilityScores));
			intelligence = abilityScores.get(index);
			abilityScores.remove(index);

			int nIndex = abilityScores.indexOf(Collections.max(abilityScores));
			wisdom = abilityScores.get(nIndex);
			abilityScores.remove(nIndex);
			
			dexterity = abilityScores.get(0);
			strength = abilityScores.get(1);
			constitution = abilityScores.get(2);
			charisma = abilityScores.get(3);	
			}
		}
	
	/*
	 * Calculates the modifiers for each ability score. Affects how well you perform skills that correspond to the appropriate ability.
	 * These skills are stored in alphabetical order in the Array skillProfs. For instance, skillProfs[0] = Acrobatics, skillProf[1] = Animal Handling, and so forth.
	 * Look for the remaining skills on the 5e character sheet. How well you perform each of these skills is affected by your ability score modifiers. For instance, 
	 * if you have to make a persuasion check DC 25, you would roll a D20 and add your ability modifier that corresponds with that skill. A persuasion check uses Charisma.
	 * So, that means if your charisma score is a 16, you can add +3 to your roll to complete the check. 
	 */
	public void setModifiers() {
		//Create easy reference to ability scores
		int[] abilityScores = new int[] {strength, dexterity, constitution, intelligence, wisdom, charisma};
		//create an array of 6 empty values
		int[] abilityModifiers = new int[] {0,0,0,0,0,0};
		
		for(int n = 0; n < 6; n++) {
			int score = abilityScores[n];		//Create a reference to the ability score outside the array
			if (score == 8 || score == 9) {		//Score of 8-9 creates a mod of -1
				abilityModifiers[n] = -1;
			}
			if (score == 10 || score == 11) {	//Score of 10-11 creates a mod of +0
				abilityModifiers[n] = 0;
			}
			if (score == 12 || score == 13) {	//Score of 12-13 creates a mod of +1
				abilityModifiers[n] = 1;
			}
			if (score == 14 || score == 15) {	//Score of 14-15 creates a mod of +2
				abilityModifiers[n] = 2;
			}
			if (score == 16 || score == 17) {	//Score of 16-17 creates a mod of +3
				abilityModifiers[n] = 3;
			}
			if (score == 18 || score == 19) {	//Score of 18-19 creates a mod of +4
				abilityModifiers[n] = 4;
			}
		}
		//store the results from the array in the same order as abilityScores
		STRmod = abilityModifiers[0];
		DEXmod = abilityModifiers[1];
		CONmod = abilityModifiers[2];
		INTmod = abilityModifiers[3];
		WISmod = abilityModifiers[4];
		CHRmod = abilityModifiers[5];
	}
	
	/*
	 * Picks a random race for your character from the 5 current options. After you select a race, add any given features, languages, and ability score bonuses that
	 * come with that race. Also set the size and speed value, which is derived from the race of the player. 
	 * NOTE: There is currently no option to employ the variant feature in the human class, which instead of getting +1 to all ability scores, to choose an extra 
	 * feat at level 1. This should be implemented. 
	 */
	public void getRandomRace() {
		
		//The string of current races that can be chosen.
		String[] possibleRaces = new String[] {"Human", "Elf", "Dwarf", "Half Orc", "Half Elf"};
		Random rand = new Random();
		int i = rand.nextInt(5);
		race = possibleRaces[i];
		
		//Based on what race you chose, gain bonus features, languages, and ability score improvements.
		if(race == "Dwarf") {
			size = "Medium";
			strength = strength + 2;
			speed = 25;
			languagesKnown.add("Dwarvish");
			languagesKnown.add("Common");
			langAmount = langAmount + 2;
		}
		
		if(race == "Elf") {
			size = "Medium";
			intelligence++;
			speed = 30;
			languagesKnown.add("Elvish");
			languagesKnown.add("Common");
			langAmount = langAmount + 2;
		}
		
		if(race == "Half Orc") {
			features.add("Darkvision");
			features.add("Relentless Endurance(PHB 41)");
			features.add("Savage Attacks(PHB 41)");
			size = "Medium";
			strength = strength + 2;
			constitution++;
			speed = 30;
			languagesKnown.add("Common");
			languagesKnown.add("Orcish");
			langAmount = langAmount + 2;
			skillProfs[7] = 1;	//Gain proficiency in intimidation
		}
		
		if(race == "Human") {
			strength++;
			constitution++;
			dexterity++;
			intelligence++;
			wisdom++;
			charisma++;
			size = "Medium";
			speed = 30;
			languagesKnown.add("Common");
			langAmount = langAmount + 2;
		}
		
		if(race == "Half Elf") {
			features.add("Fey Ancestry(PHB 39)");
			size = "Medium";
			speed = 30;
			languagesKnown.add("Common");
			languagesKnown.add("Elvish");
			langAmount = langAmount + 3;
			gainProficiencyInRandomSkill();
			gainProficiencyInRandomSkill();
		}
	}
	
	/*
	 * picks a random name for the character, subject to race and gender. Surnames are genderless.
	 * NOTE: At the beginning of the function call, you initialize each different array for all possibilities of gender and race. Maybe placing the arrays inside each 
	 * if statement would help increase performance since you won't have to call each giant array of names that you won't end up using anyways.
	 */
	public void getRandomName() {
		String[] maleHumanNames = new String[] {"Axel", "Ander", "Adam", "Bernard", "Bertram", "Chen", "Diggery", "Dante", "Evendur", "Francis", "Gilbert",
												"Grim", "Henry", "Homer", "Igor", "Jiang", "Jaques", "Kane", "Leonard", "Lukas", "Luther", "Meliodas", "Mark",
												"Murray", "Norman", "Nicholas", "Otto", "Otis", "Phillipe", "Percival", "Peter", "Quincy", "Ralph", "Robert",
												"Rudolph", "Simon", "Sigma", "Silas", "Toby", "Thomas", "Tobias", "Uther", "Ulric", "Valentine", "Velen",
												"Wally", "William", "Willhelm", "Wolfgang", "Xavier", "Xander", "Yusef", "Zackary", "Zashier"};
		
		String[] femaleHumanNames = new String[] {"Aubrey", "Agatha", "Annie", "Bertrude", "Bertha", "Beatrice", "Claudia", "Caitlyn", "Calipsa", "Denny", 
												  "Daisy", "Dorthy", "Evelynn", "Elenore", "Elizabeth", "Eva", "Faith", "Getrude", "Gina", "Gensis", "Haspen",
												  "Helen", "Helena", "Isabelle", "Ivanka", "Izumu", "Jackie", "Jasmine", "Jade", "Kathy", "Kathrine", "Kara",
												  "Laney", "Laquisha", "Lucia", "Mary", "Michelle", "Matilda", "Nya", "Nikki", "Natasha", "Nyoki", "Natsuki",
												  "Olga", "Ora", "Olma", "Pauline", "Penny", "Pandora", "Quinn", "Rachel", "Ronda", "Ren", "Sokara", "Saki",
												  "Simiko", "Tabatha", "Tammy", "Tara", "Ursala", "Usagai", "Valentine", "Valora", "Valerie", "Wilma", "Winnie",
												  "Willow", "Xena", "Yuriko", "Yuri", "Yolanda", "Yona", "Zelda", "Zamora"};
		
		String[] humanSurnames = new String[] {"Amblecrown", "Brienn", "Cyress", "Davis", "Edwards", "Flores", "Griffin", "Hilton", "Ivanwood", "Jassan", "Khalid",
												"Moore", "Murnythera", "Mostana", "Nemestek", "Osyris", "Orion", "Pashar", "Perez", "Quill", "Richardson", 
												"Rodriguez", "Shin", "Smith", "Thompson", "Ulmonika", "Van", "Willhelm", "Walker", "Yursof", "Zephyr"};
		
		String[] maleDwarfNames = new String[] {"Nordak", "Olunt", "Kildrak", "Duergraf", "Adrik", "Baern", "Brottor", "Bruenor", "Fargrim", "Harberk", "Doran",
												"Travok", "Orsik", "Flint", "Rurik", "Thorin", "Ulfgar", "Vondal"};
		
		String[] femaleDwarfNames = new String[] {"Amber", "Artin", "Audhild", "Dagnal", "Eldeth", "Finellen", "Gunndola", "Gurdis", "Helja", "Kathra", "Ilde",
												  "Kristryd", "Mardred", "Riswynn", "Torbera", "Vistra", "Sylveria"};
		
		String[] dwarfSurnames = new String[] {"Balderk", "Battlehammer", "Brawnanvil", "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Ironfist", "Loderr", 
												"Lutgehr", "Rumnaheim", "Torunn", "Ungart"};
		
		String[] maleElfNames = new String[] {"Adran", "Aramil", "Austrin" , "Erevan" , "Fivin" , "Galinndan", "Gennal" , "Halimath", "Hiimo", "Immeral", "Korfel",
												"Lamlis", "Quarion", "Rolen", "Theren", "Theriatis", "Uthemar", "Tezoth", "Kaelthrimar", "Ardyn"};

		String[] femaleElfNames = new String[] {"Arara", "Amastrianna", "Antinua", "Birel", "Caelynn", "Chaedi", "Dara", "Drusilia", "Elama", "Enna", "Hatae",
												"Lelenia", "Keyleth", "Feyrre", "Melthrissa", "Aryana"};
		
		String[] elfSurnames = new String[] {"Amakiir", "Caerdnel", "Casilltenirra", "Cithreth", "Mystralath", "Ofandrus", "Ostoroth","Othronus", 
											"Qualianthri", "Sylvaranth", "Raethran", "Liadon", "Lathalas", "Brightmoon", "Stargazer", "Moonbright", "Featherfall",
											"Silverweaver", "Moonlight", "Duskbreaker", "Shinebright", "Sunfury", "Featherdash", "Bladedancer", "Shadowspinner"};
		
		Random rand = new Random();
		
		//If you are a human
		if(race == "Human" || race == "Half Orc") {
			int bound = humanSurnames.length;				//Creates a variable that will make sure to pick a name within array bounds
			int i = rand.nextInt(bound);					//picks a random name
			surname = humanSurnames[i];						//initializes your surname
			if(gender == "Male") {							//If male, picks a male name
				int bound2 = maleHumanNames.length;			//makes sure to pick within bounds of array
				int i2 = rand.nextInt(bound2);				//picks a random name
				name = maleHumanNames[i2];					//initializes your name
			}
			else {											//Female human
				int bound3 = femaleHumanNames.length;
				int i3 = rand.nextInt(bound3);
				name = femaleHumanNames[i3];
			}	
		}
		if(race == "Elf") {									//Elves
			int bound = elfSurnames.length;
			int i = rand.nextInt(bound);
			surname = elfSurnames[i];
			if(gender == "Male") {							//Male elves
				int bound2 = maleElfNames.length;
				int i2 = rand.nextInt(bound2);
				name = maleElfNames[i2];
			}
			else {											//Female Elves
				int bound3 = femaleElfNames.length;
				int i3 = rand.nextInt(bound3);
				name = femaleElfNames[i3];
			}	
		}
		if(race == "Dwarf") {								//Dwarves
			int bound = dwarfSurnames.length;
			int i = rand.nextInt(bound);
			surname = dwarfSurnames[i];
			if(gender == "Male") {							//Male dwarves
				int bound2 = maleDwarfNames.length;
				int i2 = rand.nextInt(bound2);
				name = maleDwarfNames[i2];
			}
			else {											//Female dwarves
				int bound3 = femaleDwarfNames.length;
				int i3 = rand.nextInt(bound3);
				name = femaleDwarfNames[i3];
			}	
		}
		if(race == "Half Elf") {								//Have to do extra work to combine the elf and human arrays for each possibility
			int i = humanSurnames.length;
			int n = elfSurnames.length;
			String[] possible = new String[n + i];
			for(int g = 0; g < humanSurnames.length; g++) {
				possible[g] = humanSurnames[g];
			}
			for(int h = 0; h < elfSurnames.length; h++) {
				possible[h + i] = elfSurnames[h];
			}
			int choice = rand.nextInt(possible.length);
			surname = possible[choice];
			if(gender == "Male") {
				int i2 = maleHumanNames.length;
				int n2 = maleElfNames.length;
				String[] possible2 = new String[n2 + i2];
				for(int g = 0; g < maleHumanNames.length; g++) {
					possible2[g] = maleHumanNames[g];
				}
				for(int h = 0; h < maleElfNames.length; h++) {
					possible2[h + i2] = maleElfNames[h];
				}
				int choice2 = rand.nextInt(possible2.length);
				name = possible2[choice2];
			}
			if(gender == "Female") {
				int i3 = femaleHumanNames.length;
				int n3 = femaleElfNames.length;
				String[] possible3 = new String[n3 + i3];
				for(int g = 0; g < femaleHumanNames.length; g++) {
					possible3[g] = femaleHumanNames[g];
				}
				for(int h = 0; h < femaleElfNames.length; h++) {
					possible3[h + i3] = femaleElfNames[h];
				}
				int choice3 = rand.nextInt(possible3.length);
				name = possible3[choice3];
			}
		}
	}
		
	/*
	 * Picks a random gender
	 */
	public void getRandomGender() {
		Random rand = new Random();
		int i = rand.nextInt(1);
		if(i == 0) {
			gender = "Male";
		}
		else {
			gender = "Female";
		}
	}
	
	/*
	 * Alignments that are good have a higher representation because of the innate nature of DnD PCs. 
	 * It is hard for a DnD party to get along and work together if characters are at odds with each when making tough decisions. So, this function chooses characters
	 * with more often than not good alignments because those are the types of people that players want to play. Chaotic good and Lawful Neutral has the highest 
	 * Percentage chance at 20%, with Lawful Good and Neutral Good at 15%.
	 */
	public void getRandomAlignment() {
		Random rand = new Random();
		int choice  = 1 + rand.nextInt(100);	//pick a number between 1 and 100. Like rolling a D100
		if(choice > 0 && choice < 16) {			//1-15
			alignment = "Lawful Good";
		}
		if(choice > 15 && choice < 31) {		//16-30
			alignment = "Neutral Good";
		}
		if(choice > 30 && choice < 51) {		//31-50
			alignment = "Chaotic Good";
		}
		if(choice > 50 && choice < 71) {		//51-70
			alignment = "Lawful Neutral";
		}
		if(choice > 70 && choice < 81) {		//71-80
			alignment = "True Neutral";
		}	
		if(choice > 80 && choice < 91) {		//81-90
			alignment = "Chaotic Neutral";
		}
		if(choice > 90 && choice < 96) {		//91-95
			alignment = "Lawful Evil";
		}
		if(choice > 95 && choice < 99) {		//96-98
			alignment = "Neutral Evil";
		}
		if(choice == 99 || choice == 100) {		//99-100
			alignment = "Chaotic Evil";
		}
	}
	
	/*
	 * Picks a random class for the character. This function should contain all the features that are given to a character when they choose their class. 
	 * NOTE: Currently there is nowhere in this program that adds any class-specific features to the character. This should be the function where we add that stuff 
	 * to the characterObject. I will write a sample part of the code for the Fighter class, and will need help adding the rest. 
	 * SUPER IMPORTANT NOTE: This program makes LEVEL 1 CHARACTERS FOR NOW. HOWEVER, it would be extremely helpful to write code that can be flexible and work by testing
	 * what level the character is and adding extra features based on level. I will do my best to show what I am talking about in the example code
	 */
	public void getRandomClass() {
		String[] possibleClasses = new String[] {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin"," Rogue", "Ranger", "Sorcerer", "Warlock", "Wizard"};
		Random rand = new Random();
		int chosenClass = rand.nextInt(12);
		pClass = possibleClasses[chosenClass];
		
		//EXAMPLE CODE
		if(pClass == "Fighter") {
			if(level > 0) {
				this.computeHP();						//Compute the HP now 
				proficiencies.add("Light Armor");		//Add all weapon, armor and tool proficiencies to the ArrayList proficiencies.
				proficiencies.add("Medium Armor");		//Please remember that these types of proficiencies are different than skill proficiencies
				proficiencies.add("Heavy Armor");
				proficiencies.add("Shields");
				proficiencies.add("Simple Weapons");
				proficiencies.add("Martial Weapons");
			
				abilitySavingThrows[0] = 1;				//Proficient in strength and constitution saving throws
				abilitySavingThrows[2] = 1;				
			
				//Gain two random skills among Acrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, and Survival.
				int[] possibleSkills = {0, 1, 3, 5, 6, 7, 11, 17};
				int choice1 = rand.nextInt(8);			//See explanation for skillProfs if confused why these numbers were chosen for possibleSkills. these are the indices
				int choice2 = rand.nextInt(8);			//of the skills listed in the above comment in the skillProfs array
				while(choice1 == choice2) {				//If choices are the same skill, choose again till choices are different
					choice2 = rand.nextInt(8);
				}
					skillProfs[choice1] = 1;				//Assign those skills
				skillProfs[choice2] = 1;
			
				//Now, give your character equipment based on the PHB starting gear per the class
			
				//Chain mail or leather armor, longbow and 20 arrows. 
				int equipementChoice1 = rand.nextInt(2);
				if (equipementChoice1 == 0) {
					armor = "Chain Mail";
				}
				else {
					armor = "Leather armor";
					weapons.add("Longbow");
					inventory.add("Arrows 20x");
				}
				
				//a martial weapon and a shield or two martial weapons
				int equipmentChoice2 = rand.nextInt(2);
				if(equipmentChoice2 == 0) {
					weapons.add(getRandomMeleeMartialWeapon());
					shield = true;
				}
				else {
					weapons.add(getRandomMeleeMartialWeapon());
					weapons.add(getRandomMeleeMartialWeapon());
				}
				
				//a light crossbow and 20 bolts or two handaxes
				int equipmentChoice3 = rand.nextInt(2);
				if(equipmentChoice3 == 0) {
					weapons.add("Light Crossbow");
					inventory.add("Bolts 20x");
				}
				else {
					weapons.add("Handaxe");
					weapons.add("Handaxe");
				}
				
				//a dungeoneer's pack or an adventurer's pack
				int equipmentChoice4 = rand.nextInt(2);
				if(equipmentChoice4 == 0) {
					gainDungeoneersPack();
				}
				else {
					gainExplorersPack();
				}
				
				//At level 1, fighters choose a fighting style that defines the type of combat they excel in. Choose a random fighting style
				String[] possibleFightingStyles = {"Archery", "Defense", "Dueling", "Great Weapon Fighting", "Protection", "Two Weapon Fighting"};
				int styleChoice = rand.nextInt(6);
				fightingStyle = possibleFightingStyles[styleChoice];
				
				//Also gain the feature second wind at level 1
				features.add("Second Wind(PHB 72)");
			}
		}
	}
	

	/********************************************
	 ************  Helper functions	*************			
	 *******************************************/
	//When a feature is invoked enough times, it becomes more convenient to create a separate method for it and call it whenever it is needed. Many of the classes gain
	//a random weapon when they start, so it is more consistent to create the method once rather than hard code it in the main method. These are what those functions
	//are. The names are self-explanatory and should be pretty straightforward.  
	
	private static String getRandomInstrument() {
		String[] possibleInstruments = {"Bagpipes", "Drum", "Dulcimer", "Flute", "Lute", "Lyre", "Horn", "Pan Flute", "Shawm", "Viol"};
		Random rand = new Random();
		int choice = rand.nextInt(possibleInstruments.length);
		return possibleInstruments[choice];
	}
	
	private static String getRandomArtisanTool() {
		String[] possibleTools = {"set of Alchemist's supplies", "set of Brewer's supplies", "set of Calligrapher's supplies", "set of Carpenter's tools", "set of Cartographer's tools", 
								"set of Cobbler's tools", "set of Cook's utensils", "set of Glassblower's tools", "set of Jeweler's tools", "set of Leatherworker's tools", " set of Mason's tools", 
								"set of Painter's supplies", "set of Potter's tools", "set of Smith's tools", "set of Tinker's tools", "set of Weaver's tools", "set of Woodcarver's tools"};
		Random rand = new Random();
		int choice = rand.nextInt(possibleTools.length);
		return possibleTools[choice];
	}
	
	private static String getRandomMeleeMartialWeapon() {
		String[] meleeMartialWeapons = {"Battleaxe", "Flail", "Glaive", "Greataxe", "Greatsword", "Halbred", "Lance", "Longsword", "Maul", "Morningstar",
				"Pike", "Rapier", "Scimitar", "Shortsword", "Trident", "War pick", "Warhammer", "Whip"};
		Random rand = new Random();
		int choice = rand.nextInt(meleeMartialWeapons.length);
		return meleeMartialWeapons[choice];
	}
	
	private static String getRandomMeleeSimpleWeapon() {
		String[] meleeSimpleWeapons = {"Club", "Dagger", "Greatclub", "Handaxe", "Javelin", "Light Hammer", "Mace", "Quarterstaff", "Sickle", "Spear"};
		Random rand = new Random();
		int choice = rand.nextInt(meleeSimpleWeapons.length);
		return meleeSimpleWeapons[choice];
	}
	
	private static String getRandomRangedMartialWeapon() {
		String[] rangedMartialWeapons = {"Blowgun", "Hand crossbow", "Heavy Crossbow", "Longbow", "Net"};
		Random rand = new Random();
		int choice = rand.nextInt(rangedMartialWeapons.length);
		return rangedMartialWeapons[choice];
	}
	
	private static String getRandomRangedSimpleWeapon() {
		String[] rangedSimpleWeapons = {"Light crossbow", "Dart gun", "Shortbow", "Sling"};
		Random rand = new Random();
		int choice = rand.nextInt(rangedSimpleWeapons.length);
		return rangedSimpleWeapons[choice];
	}
	
	private static String getRandomTitle() {
		String[] possibleTitle = {"The Noble", "The Mighty", "The Slayer", "The Benevolent", "The Almighty", "The Eternal", "The Lightlord"};
		Random rand = new Random();
		int choice = rand.nextInt(possibleTitle.length);
		return possibleTitle[choice];
	}
	
	private static String getRandomTrinket() {
		//TO-DO 
		//Table found in PHB 160 - 161
	}
	
	private void gainProficiencyInRandomSkill() {
		Random rand = new Random();
		int choice = rand.nextInt(18);
		if(skillProfs[choice] == 1) {
			int choice2 = rand.nextInt(18);
			skillProfs[choice2] = 1;
		}
		skillProfs[choice] = 1;
	}
	
	private void gainDungeoneersPack() {
		String[] dungeoneersPack = {"backpack", "crowbar", "hammer", "pitons 10x", "torches 10x", "tinderbox", "daily ration 10x", "waterskin", "50 ft of rope"};
		for(int n = 0; n < dungeoneersPack.length; n++) {
			inventory.add(dungeoneersPack[n]);
		}
	}
	
	private void gainBurglarsPack() {
		String[] burglarsPack = {"backpack", "bag of 1000 ball bearings", "10 feet of string", "bell", "candle 5x", "crowbar", "hammer", "pitons 10x", 
				"hooded lantern", "flask of oil 2x", "daily ration 5x", "tinderbox", "waterskin", "50 ft of rope"};
		for(int n = 0; n < burglarsPack.length; n++) {
			inventory.add(burglarsPack[n]);
		}
	}
	
	private void gainDiplomatsPack() {
		String[] diplomatsPack = {"small chest", "scroll case 2x", "set of fine clothes", "ink bottle", "ink pen", "lamp", "Flask of oil 2x", "sheet of paper 5x",
				"perfume vial", "sealing wax", "soap"};
		for(int n = 0; n < diplomatsPack.length; n++) {
			inventory.add(diplomatsPack[n]);
		}
	}
	
	private void gainEntertainersPack() {
		String[] entertainersPack = {"backpack", "bedroll", "costume 2x", "candle 5x", "daily ration 5x", "waterskin", "Disguise kit"};
		for(int n = 0; n < entertainersPack.length; n++) {
			inventory.add(entertainersPack[n]);
		}
	}
	
	private void gainExplorersPack() {
		String[] explorersPack = {"backpack", "bedroll", "mess kit", "tinderbox", "torch 10x", "daily ration 10x", "waterskin", "50 ft of rope"};
		for(int n = 0; n < explorersPack.length; n++) {
			inventory.add(explorersPack[n]);
		}
	}
	
	private void gainPriestsPack() {
		String[] priestsPack = {"Backpack", "blanket", "candle 10x", "tinderbox", "alms box", "block of incense 2x", "censer", "vestments", "daily ration 2x",
		"waterskin"};
		for(int n = 0; n < priestsPack.length; n++) {
			inventory.add(priestsPack[n]);
		}
	}
	
	private void gainScholarsPack() {
		String[] scholarsPack = {"Backpack", "book of lore", "ink bottle", "ink pen", "sheet of paper 10x", "small bag of sand", "small knife"};
		for(int n = 0; n < scholarsPack.length; n++) {
			inventory.add(scholarsPack[n]);
		}
	}
	/********************************************
	 ************ 	Get functions	*************			
	 *******************************************/
	
	public String getName() {
		return name;
	}
	
	public String getpClass() {
		return pClass;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getRace() {
		return race;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getAlignment() {
		return alignment;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getDexterity() {
		return dexterity;
	}
	
	public int getConstitution() {
		return constitution;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getWisdom() {
		return wisdom;
	}
	
	public int getCharisma() {
		return charisma;
	}
	
	/********************************************
	 ************ 	Main function	*************			
	 *******************************************/
	
	public static void main(String[] args) {

		Character bob = new Character();
		
		System.out.println("Character defining traits:");
		System.out.println("---------------------------------------");
		System.out.println("Name: " + bob.getName() + " " + bob.getSurname() + " " + bob.title);
		System.out.println("Race: " + bob.getRace());
		System.out.println("Class: " + bob.getpClass());
		System.out.println("Gender: " + bob.getGender());
		System.out.println("Background: " + bob.background);
		System.out.println("Alignment: " + bob.getAlignment() + "\n");
		System.out.println("Character Stats:");
		System.out.println("---------------------------------------");
		System.out.println("Level: " + bob.getLevel());
		System.out.println("HP: " + bob.getHP());
		System.out.println("Strength: " + bob.getStrength());
		System.out.println("Dexterity: " + bob.getDexterity());
		System.out.println("Constitution: " + bob.getConstitution());
		System.out.println("Intelligence: " + bob.getIntelligence());
		System.out.println("Wisdom: " + bob.getWisdom());
		System.out.println("Charisma: " + bob.getCharisma() + "\n");
		System.out.println("---------------------------------------");
		System.out.print("Equipment: ");
		for(int n = 0; n < bob.inventory.size(); n++) {
			if(n == bob.inventory.size() - 1) {
				System.out.print("a " + bob.inventory.get(n) + ".");
			}
			else {
			System.out.print("a " + bob.inventory.get(n) + ", ");
			}
		}
		System.out.println("");
		System.out.print("Money: " + bob.currency[0] + " copper coins, " + bob.currency[1] + " silver coins, " + bob.currency[2] + " gold coins.");
		}
	}




