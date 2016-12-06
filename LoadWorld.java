import java.util.*;


public class LoadWorld {

	/* this function returns a map that has all the rooms initialized in a game */
	public static Map<String, Room> loadWorld()  {
		Map<String, Room> m = new HashMap<String, Room>();

		/* initializing living room 1 */
		itemInventory liv1inv = new itemInventory();
		Item pill = new Item("pill", 2, 4);
		Item apple = new Item("apple", 1, 23);
		Item bottle_of_water = new Item("bottle-of-water", 0, 35);
		Item coke = new Item("coke", 0, 14);
		Item tomato = new Item("tomato", 1, 20);
		
		liv1inv.add(apple);
		liv1inv.add(pill);
		liv1inv.add(pill);
		liv1inv.add(coke);
		liv1inv.add(tomato);
		liv1inv.add(bottle_of_water);
		m.put("bedroom", new Bedroom("bedroom", "bathroom", "wall", "wall", "wall", 
				liv1inv));

		itemInventory bathroomInv = new itemInventory();
		bathroomInv.add(new Item("garbage", 3, 20));
		bathroomInv.add(new Item("pistol", 4, 10));
		bathroomInv.add(new Item("bottle-of-water", 0, 35));
		m.put("bathroom", new Bathroom("bathroom", "wall", "wall", "bedroom", "wall", 
				bathroomInv));
		
		return m;
	}

}
