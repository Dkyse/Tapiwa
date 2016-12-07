import java.util.*;

public class TextAdventure {

	public Player player;
	public Map<String, Room> m;
	public int turns;
	public int days;
	
	public TextAdventure()  {
		this.m = LoadWorld.loadWorld();
		this.player = new Player("small living room", m);
		this.turns = 0;
		this.days = 1;
	}
	
	
	public void rest()  {
		this.player.rest();
		this.turns += 1;
	}
	
	public void oneturn()  {
		
		this.player.checkWarning();
		this.player.checkCap();
		
		this.turns += 1;
		this.player.oneturn();
		System.out.println("");
		System.out.println("Time of day: [" + (this.turns + 6) + ": 00 ]");
		
		/* the following part is only called when we pass one day */
		if  (this.turns >= 12)  {
			this.turns = 0;
			this.days += 1;
			System.out.println("The night has fallen.");
			System.out.println("You have survived " + (this.days - 1) + " days.");
			System.out.println("");
			System.out.println("Day " + this.days);
			
			Random rand = new Random();
			int  r = rand.nextInt((3 - 0) + 1) + 0;
			if  (r == 0)  {
			System.out.println("Today is sunny. The sky is clear and beyond reach.");
			System.out.println("Sometimes it makes you wonder: are there really Gods up there?");
			System.out.println("If not, who is governing our universe?");
			System.out.println("But alas! Why does this happen to me?");
			}  else  if  (r == 1)  {
				System.out.println("Today is rainy. Rain drops hit the roof, as if a lonely ghost is dancing above your head.");
				System.out.println("\"I don't know,\" you think to yourself, \"if I can get out alive.\"");
				System.out.println("What did I do wrong?");
			}  else  if  (r == 2)  {
				System.out.println("Today is cloudy and cold. It might start raining soon. You feel desperate and hopeless.");
				System.out.println("\"Just get me out of here\", you say, \"I am willing to pay anything.\"");
				System.out.println("But nobody is there to listen.");
			}  else  if  (r == 3)  {
				System.out.println("Today is windy. The wind is moaning outside the window.");
				System.out.println("You feel like the house is almost falling.");
				System.out.println("Trembling, you feel cold.");
			}
		}
	}
	
	
	
	public static void welcomeToTheGame(Scanner in, TextAdventure t)  {
		System.out.println("");
		System.out.println("****WARNING****");
		System.out.println("Graphic Content");
		System.out.println("This game contains content that maybe disturbing and/or offensive to some players and/or viewers.");
		System.out.println("Viewer discretion is strongly advised.");
		System.out.println("Entering the game means you are aware of this warning and wish to continue.");
		System.out.println("[type anything to start the game]");
		in.nextLine();
		System.out.println("You wake up in an unfamiliar room.");
		System.out.println("[hit Enter]");
		in.nextLine();
		System.out.println("You are lying on a cold concrete floor.");
		System.out.println("There is broken glass protruding from your chest.");
		System.out.println("[hit Enter]");
		in.nextLine();
		System.out.println("Noises come from another room.");
		System.out.println("It sounds like people talking.");
		System.out.println("You roughly remember last night you were driving down the freeway,");
		System.out.println("and at about 20:00, you were attacked."); 
		System.out.println("There were eggs thrown on your front window from one side of the road.");
		System.out.println("[hit Enter]");
		in.nextLine();
		System.out.println("The eggs blocked your sight, and you crashed.");
		System.out.println("You don't know who threw the eggs, and why they did that.");
		System.out.println("You passed out immediately.");
		System.out.println("[hit Enter]");
		in.nextLine();
		System.out.println("But when you wake up from the coma this morning, you are locked in this house with several other strangers.");
		System.out.println("There is no way out.");
		System.out.println("[hit Enter]");
		in.nextLine();
		System.out.println("You have four statuses:");
		System.out.println("Health, food, water, and mental state.");
		System.out.println("If any of them drops to 0, you are dead.");
		System.out.println("[hit Enter]");
		in.nextLine();
		System.out.println("Eat, drink, rest, and take pills.");
		System.out.println("Find supplies in the house.");
		System.out.println("Protect yourself, and stay alive.");
		System.out.println("Welcome to the game.");
		System.out.println("[hit Enter]");
		in.nextLine();
		t.player.commands();
		System.out.println("[type command]");
	}
	
	
	
	public static void main(String[] argc)  {
		TextAdventure t = new TextAdventure();
		
		Scanner in = new Scanner(System.in);
		

		welcomeToTheGame(in, t);
		String input = in.nextLine();
		while  (!input.equalsIgnoreCase("suicide"))  {
		
			
		LanguageParser.languageParse(input, t, in);
		
		if  (t.player.checkAlive() == false)  {
			break;
		}
		
		input = in.nextLine();
		}
		
		System.out.println("");
		System.out.println("You are DEAD.");
		
		/* check how you died */
		t.player.checkDeathReason();
		
		System.out.println("Thanks for playing.");
		in.close();

	}
	
	
	
}
