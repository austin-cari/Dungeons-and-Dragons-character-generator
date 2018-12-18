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
	int profBonus;			//need to implement
	
	//armor class
	int AC;					//need to implement
	
	//size of the character
	String size;			//need to implement
	
	//speed per round. Typically 25 or 30
	int speed;				//need to implement
	
	//passive wisdom
	int passiveWis;			//need to implement
	
	// an array of 0s and 1s. 1 if they possess the skill, 0 if they don't
	int[] skillProfs = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};		//need to implement
	
	//a list that contains all weapons/tools the character is proficient in 
	ArrayList<String>proficencies = new ArrayList<String>();	//need to implement
	
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
	
	//equipment
	ArrayList<String> inventory = new ArrayList<String>();			//need to implement
	ArrayList<String> weapons = new ArrayList<String>();				//need to implement
	String armor;							//need to implement
	boolean shield;							//need to implement
	int[] currency = {0,0,0};				//currency[0] = copper coins, currency [1] = silver coins, etc...
	
	//Spells and stuff
	ArrayList<String> firstLevelSpells = new ArrayList<String>();		//need to implement
	int firstLevelSpellSlots;				//need to implement
	
	
	//class specific archetypes. Null if non applicable
	String fightingStyle;
	String martialArchetype;
	String wizardingSchool;
	String rangerArchetype;
	
	//languages known and how many you know
	int langAmount;
	ArrayList<String> languagesKnown = new ArrayList<String>();
	
	/*
	 * Creates a randomly generated character at level 1.
	 */
	public Character() {
		
		title = "";
		level = 1;
		profBonus = 2;
		this.getRandomClass();
		this.assignAbilityScores();
		this.setModifiers();
		this.getRandomRace();
		this.getRandomGender();
		this.getRandomName();
		this.computeHP();
		this.getRandomBackground();
		this.getRandomAlignment();
		
	}
	
	public void getEquipment() {
		String[] burglarsPack = {"Backpack", "bag of 1000 ball bearings", "10 feet of string", "bell", "candle 5x", "crowbar", "hammer", "pitons 10x", 
								"hooded lantern", "flask of oil 2x", "daily ration 5x", "tinderbox", "waterskin", "50 ft of rope"};
		String[] diplomatsPack = {"small chest", "scroll case 2x", "set of fine clothes", "ink bottle", "ink pen", "lamp", "Flask of oil 2x", "sheet of paper 5x",
								"perfume vial", "sealing wax", "soap"};
		String[] dungeoneersPack = {"Backpack", "crowbar", "hammer", "pitons 10x", "torches 10x", "tinderbox", "daily ration 10x", "waterskin", "50 ft of rope"};
		String[] entertainersPack = {"Backpack", "bedroll", "costume 2x", "candle 5x", "daily ration 5x", "waterskin", "Disguise kit"};
		String[] explorersPack = {"Backpack", "bedroll", "mess kit", "tinderbox", "torch 10x", "daily ration 10x", "waterskin", "50 ft of rope"};
		String[] priestsPack = {"Backpack", "blanket", "candle 10x", "tinderbox", "alms box", "block of incense 2x", "censer", "vestments", "daily ration 2x",
								"waterskin"};
		String[] scholarsPack = {"Backpack", "book of lore", "ink bottle", "ink pen", "sheet of paper 10x", "small bag of sand", "small knife"};
		
		Random rand = new Random();
		
		if(pClass == "Barbarian") {
			
		}
		if(pClass == "Bard") {
			
		}
		if(pClass == "Cleric") {
			
		}
		if(pClass == "Druid") {
			
		}
		if(pClass == "Fighter") {
			
		}
		if(pClass == "Monk") {
			
		}
		if(pClass == "Paladin") {
			
		}
		if(pClass == "Ranger") {
			
		}
		if(pClass == "Rogue") {
			
		}
		if(pClass == "Sorcerer") {
			
		}
		if(pClass == "Warlock") {
			
		}
		if(pClass == "Wizard") {
			
		}
	}

	/*
	 * Gives the character a random background based on their class and applies the correct proficiencies, equipment and gold
	 */
	public void getRandomBackground() {
		Random rand = new Random();
		
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
		
		//Now apply changes based on background picked
		
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
			title = getRandomTitle();							//fill out array in static method
		}
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
		ArrayList<Integer> abilityScores = new ArrayList<Integer>();
		for(int n = 0; n < 6; n++) {
			abilityScores.add(0);
		}
		for(int n = 0; n < 6; n++){
			Random rand = new Random();
			int roll1 = 1 + rand.nextInt(6);
			int roll2 = 1 + rand.nextInt(6);
			int roll3 = 1 + rand.nextInt(6);
			int roll4 = 1 + rand.nextInt(6);
		
			ArrayList<Integer> numList = new ArrayList<Integer>();
			numList.add(roll1);
			numList.add(roll2);
			numList.add(roll3);
			numList.add(roll4);
			
			for(int i = 0; i < 4; i++){
				while(numList.get(i) <= 1) {
					int newRoll = 1 + rand.nextInt(5);
					numList.set(i, newRoll);
				}
			}
			int minIndex = numList.indexOf(Collections.min(numList));
			numList.remove(minIndex);
			

			for(int i = 0; i < 3; i++){
				int interimScore = abilityScores.get(n) + numList.get(i); 
				abilityScores.set(n, interimScore);
			}
		}
		
		//After rolling your 6 stats, will put your best two into the most important ability scores eg. Barbarian needs con and str to be the highest
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
	 */
	public void setModifiers() {
		int[] abilityScores = new int[] {strength, dexterity, constitution, intelligence, wisdom, charisma};
		int[] abilityModifiers = new int[] {STRmod, DEXmod, CONmod, INTmod, WISmod, CHRmod};
		
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
		
		STRmod = abilityModifiers[0];
		DEXmod = abilityModifiers[1];
		CONmod = abilityModifiers[2];
		INTmod = abilityModifiers[3];
		WISmod = abilityModifiers[4];
		CHRmod = abilityModifiers[5];
	}
	
	/*
	 * picks a random race for the character object and adjusts ability scores, sets speed and size
	 */
	public void getRandomRace() {
		String[] possibleRaces = new String[] {"Human", "Elf", "Dwarf", "Half Orc", "Half Elf"};
		Random rand = new Random();
		int i = rand.nextInt(5);
		race = possibleRaces[i];
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
			skillProfs[7] = 1;	//intimidation
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
	 * Evil characters are just all around less common so will be less highly selected
	 */
	public void getRandomAlignment() {
		Random rand = new Random();
		int choice  = 1 + rand.nextInt(100);
		if(choice > 0 && choice < 16) {
			alignment = "Lawful Good";
		}
		if(choice > 15 && choice < 26) {
			alignment = "Neutral Good";
		}
		if(choice > 25 && choice < 41) {
			alignment = "Chaotic Good";
		}
		if(choice > 40 && choice < 56) {
			alignment = "Lawful Neutral";
		}
		if(choice > 56 && choice < 66) {
			alignment = "True Neutral";
		}
		if(choice > 65 && choice < 81) {
			alignment = "Chaotic Neutral";
		}
		if(choice > 80 && choice < 91) {
			alignment = "Lawful Evil";
		}
		if(choice > 90 && choice < 99) {
			alignment = "Neutral Evil";
		}
		if(choice == 99 || choice == 100) {
			alignment = "Chaotic Evil";
		}
	}
	
	/*
	 * picks a random class for the character
	 */
	public void getRandomClass() {
		String[] possibleClasses = new String[] {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin"," Rogue", "Ranger", "Sorcerer", "Warlock", "Wizard"};
		Random rand = new Random();
		int chosenClass = rand.nextInt(12);
		pClass = possibleClasses[chosenClass];
	}
	
	/*
	 * Fills out the features ArrayList for a level 1 character
	 */
	public void computeFeatures() {
		if(pClass == "Fighter") {
			
		}
		if(pClass == "Ranger") {
			
		}
		if(pClass == "Wizard") {
			
		}
	}

	/********************************************
	 ************  Helper functions	*************			
	 *******************************************/
	
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
		return null;
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




