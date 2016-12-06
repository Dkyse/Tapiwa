import java.util.HashMap;
import java.util.Map;

public class TextAdventure {

	public Player player;
	public Map<String, Room> m;
	public int turns;
	
	public TextAdventure()  {
		Map<String, Room> m = new HashMap<String, Room>();
		
		itemInventory bedroomInv = new itemInventory();
		bedroomInv.add(new Item("tomato", 1, 20));
		bedroomInv.add(new Item("pill", 2, 10));
		bedroomInv.add(new Item("bottle of water", 0, 35));
		bedroomInv.add(new Item("tomato", 1, 20));
		bedroomInv.add(new Item("pistol", 4, 60));
		m.put("bedroom", new Bedroom("bedroom", "bathroom", "wall", "wall", "wall", 
			bedroomInv));
		
		itemInventory bathroomInv = new itemInventory();
		bathroomInv.add(new Item("garbage", 3, 20));
		bathroomInv.add(new Item("pistol", 4, 10));
		bathroomInv.add(new Item("bottle of water", 0, 35));
		m.put("bathroom", new Bathroom("bathroom", "wall", "wall", "bedroom", "wall", 
				bathroomInv));
		
		this.m = m;
		this.player = new Player("bedroom", m);
		this.turns = 0;
	}
	
	public static void main(String[] argc)  {
		TextAdventure t = new TextAdventure();
		
		t.player.status(); //check
		t.player.oneturn();
		
		t.player.go("north", t.m);  //check
		t.player.oneturn();
		
		t.player.go("east", t.m);  //check
		t.player.oneturn();
		
		t.player.go("soef", t.m); //check
		t.player.oneturn();
		
		t.player.lookaround();  //check
		t.player.oneturn();
		
		t.player.search(); //check
		t.player.oneturn();
		
		t.player.pickup("garbage");
		t.player.oneturn();
		
		t.player.search();
		t.player.oneturn();
		
		t.player.consume("GARBAGE");
		t.player.oneturn();
		
		t.player.consume("water");
		t.player.oneturn();
		
		t.player.status();
		t.player.oneturn();
		
		t.player.discard("paper");
		t.player.oneturn();
		
		t.player.search();
		t.player.oneturn();
		
		t.player.pickup("bottle of water");
		t.player.oneturn();
		
		t.player.status();
		t.player.oneturn();
		
	}
	
	
	
}
