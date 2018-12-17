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
	String name, surname, race, gender, pClass, background, alignment;
	
	//stats
	int level;
	
	//maximum health points
	int HP;					//need to properly calculate
	
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
	int[] skillProfs;		//need to implement
	
	//a list that contains all weapons/tools the character is proficient in 
	ArrayList<String>proficencies;	//need to implement
	
	//A list of all the features the character gains from their class
	ArrayList<String> features;	
	
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
	ArrayList<String> inventory;			//need to implement
	ArrayList<String> weapons;				//need to implement
	String armor;							//need to implement
	boolean shield;							//need to implement
	
	//Spells and stuff
	ArrayList<String> firstLevelSpells;		//need to implement
	int firstLevelSpellSlots;				//need to implement
	
	
	//class specific parameters. Null if non applicable
	String fightingStyle;
	String martialArchetype;
	String wizardingSchool;
	String rangerArchetype;
	
	/*
	 * Creates a randomly generated character at level 1.
	 */
	public Character() {
		
		this.getRandomClass();
		this.assignAbilityScores();
		this.setModifiers();
		this.getRandomRace();
		this.getRandomGender();
		this.getRandomName();
		this.computeRest();
		this.getRandomAlignment();
		level = 1;
		HP = 5 * level;
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
		
		if(pClass == "Rogue"){
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
	 * picks a random race for the character object
	 */
	public void getRandomRace() {
		String[] possibleRaces = new String[] {"Human", "Elf", "Dwarf", "Half Orc", "Half Elf"};
		Random rand = new Random();
		int i = rand.nextInt(5);
		race = possibleRaces[i];
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
	 * depending on what class the character is, the rest of the fields will be filled in automatically
	 */
	public void computeRest() {
		if(pClass == "Fighter") {
			this.fighterChanges();
		}
		if(pClass == "Ranger") {
			this.rangerChanges();
		}
		if(pClass == "Wizard") {
			this.wizardChanges();
		}
	}
	
	public void fighterChanges() {
		//TO-DO
	}
	
	public void rangerChanges() {
		//TO-DO
	}
	
	public void wizardChanges() {
		//TO-DO
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
		System.out.println("Name: " + bob.getName() + " " + bob.getSurname());
		System.out.println("Race: " + bob.getRace());
		System.out.println("Class: " + bob.getpClass());
		System.out.println("Gender: " + bob.getGender());
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
		
		}
	
}



