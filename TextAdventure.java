import java.util.*;

public class TextAdventure {

	public Player player;
	public Map<String, Room> m;
	public int turns;
	public int days;
	
	public TextAdventure()  {
		this.m = LoadWorld.loadWorld();
		this.player = new Player("bedroom", m);
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
			System.out.println("You have survived " + this.days + " days.");
			System.out.println("");
			System.out.println("Day " + this.days);
			
			Random rand = new Random();
			int  r = rand.nextInt((3 - 0) + 1) + 0;
			if  (r == 0)  {
			System.out.println("Today is sunny. The sky is clear and beyond reach.");
			System.out.println("Sometimes it makes you wonder: are there really big Gods up there?");
			System.out.println("But alas! Why does this happen me?");
			}  else  if  (r == 1)  {
				System.out.println("Today is rainy. Rain drops hit the roof, as if a lonely ghost is dancing above your head.");
			}  else  if  (r == 2)  {
				System.out.println("Today is cloudy and cold. It might start raining soon. You feel desperate.");
			}  else  if  (r == 3)  {
				System.out.println("Today is windy. The wind is moaning outside the window.");
				System.out.println("You feel like the house is almost falling.");
			}
		}
	}
	
	
	
	public static void welcomeToTheGame(Scanner in, TextAdventure t)  {
		System.out.println("You wake up in an unfamiliar room.");
		System.out.println("[type anything]");
		in.nextLine();
		System.out.println("You are lying on a cold concrete floor.");
		System.out.println("There are broken glasses under your chest.");
		System.out.println("[type anything]");
		in.nextLine();
		System.out.println("Noises come from another room.");
		System.out.println("It sounds like people talking.");
		System.out.println("You roughly remember that last night you were driving down the freeway,");
		System.out.println("and at about 20:00, you were attacked."); 
		System.out.println("There were eggs thrown on your front window from one side of the road.");
		System.out.println("[type anything]");
		in.nextLine();
		System.out.println("The eggs blocked your sight, and you crushed.");
		System.out.println("You don't know who threw the eggs, and why did they do that.");
		System.out.println("You passed out immediately.");
		System.out.println("[type anything]");
		in.nextLine();
		System.out.println("But when you wake up from the coma this morning, you are locked in this house with several other strangers.");
		System.out.println("There is no way out.");
		System.out.println("[type anything]");
		in.nextLine();
		System.out.println("You have four status:");
		System.out.println("Health, food, water, and mental state.");
		System.out.println("If any of them drops to 0, you are dead.");
		System.out.println("Eat, drink, rest, and take pills.");
		System.out.println("[type anything]");
		in.nextLine();
		System.out.println("Find supplies in the house.");
		System.out.println("Protect yourself, and stay alive.");
		System.out.println("Welcome to the game.");
		System.out.println("[type anything]");
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
		
			
		LanguageParser.languageParse(input, t);
		
		if  (t.player.checkAlive() == false)  {
			break;
		}
		
		input = in.nextLine();
		}
		
		System.out.println("");
		System.out.println("You are DEAD.");
		
		/* check how you died */
		t.player.checkDeathReason();
		
		System.out.println("Thanks for playing");
		in.close();
		
		
		
//		
//		
//		t.player.status(); //check
//		t.player.oneturn();
//		
//		t.player.go("north", t.m);  //check
//		t.player.oneturn();
//		
//		t.player.go("east", t.m);  //check
//		t.player.oneturn();
//		
//		t.player.go("soef", t.m); //check
//		t.player.oneturn();
//		
//		t.player.lookaround();  //check
//		t.player.oneturn();
//		
//		t.player.search(); //check
//		t.player.oneturn();
//		
//		t.player.pickup("garbage");
//		t.player.oneturn();
//		
//		t.player.search();
//		t.player.oneturn();
//		
//		t.player.consume("GARBAGE");
//		t.player.oneturn();
//		
//		t.player.consume("water");
//		t.player.oneturn();
//		
//		t.player.status();
//		t.player.oneturn();
//		
//		t.player.discard("paper");
//		t.player.oneturn();
//		
//		t.player.search();
//		t.player.oneturn();
//		
//		t.player.pickup("bottle of water");
//		t.player.oneturn();
//		
//		t.player.status();
//		t.player.oneturn();
		
	}
	
	
	
}
