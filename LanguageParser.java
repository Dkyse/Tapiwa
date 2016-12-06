
public class LanguageParser {

	
	public static void languageParse(String c, TextAdventure t)  {
		
		String[] in = c.split(" ");
		
		if  (in.length == 1
				&& in[0].equalsIgnoreCase("rest") )  {
			t.player.rest();
			t.oneturn();
			
		}  else  if  (in.length == 2
				&& in[0].equalsIgnoreCase("go") )  {
			t.player.go(in[1], t.m);
			t.oneturn();
			
		}  else  if  (in.length == 2 
				&& in[0].equalsIgnoreCase("consume") )  {
			t.player.consume(in[1]);
			t.oneturn();
			
		}  else  if  (in.length == 3
				&& in[0].equalsIgnoreCase("pick") 
				&& in[1].equalsIgnoreCase("up"))  {
			t.player.pickup(in[2]);
			t.oneturn();
			
		}  else  if  (in.length == 3
				&& in[0].equalsIgnoreCase("item") 
				&&  in[1].equalsIgnoreCase("info"))  {
			t.player.itemInfo(in[2]);
			t.oneturn();
			
		}  else  if  (in.length == 2
				&& in[0].equalsIgnoreCase("look")
				&& in[1].equalsIgnoreCase("around"))  {
			t.player.lookaround();
			t.oneturn();
			
		}  else  if  (in.length == 2 && in[0].equalsIgnoreCase("discard"))  {
			t.player.discard(in[1]);
			t.oneturn();
			
		}  else  if  (in.length == 2
				&& in[1].equalsIgnoreCase("room") 
				&& in[0].equalsIgnoreCase("search") )  {
			t.player.search();
			t.oneturn();
			
		}  else  if  (in.length == 1 && in[0].equalsIgnoreCase("status"))  {
			t.player.status();
			t.oneturn();
			
		}  else  if  (in.length == 2 
				&& in[0].equalsIgnoreCase("command") 
				&& in[1].equalsIgnoreCase("menu")) {
			t.player.commands();
			t.oneturn();
			
		}  else  if  (in.length == 1 
				&& in[0].equalsIgnoreCase("bag")) {
			t.player.bag();
			t.oneturn();
			
		}  else  if  (in.length == 3 
				&& in[0].equalsIgnoreCase("where")
				&& in[1].equalsIgnoreCase("am")
				&& in[2].equalsIgnoreCase("i")) {
			t.player.location();
			t.oneturn();
			
		}  else  {
			System.out.println("Invalid input. Type in <command menu> for instructions");
			t.oneturn();
		}
		
	}
	
	
}
