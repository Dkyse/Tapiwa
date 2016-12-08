

public abstract class Room {

	protected String name;
	protected String n;
	protected String e;
	protected String w;
	protected String s;
	protected itemInventory itemList;
	protected boolean searched;
	protected int human;

	public Room(String name, String e, String s, String w,  String n, itemInventory itemList)  {
		this.name = name;
		this.n = n;
		this.e = e;
		this.w = w;
		this.s = s;
		this.itemList = itemList;
		this.searched = false;
		this.human = -1;
	}

	public String getName()  {
	return this.name;	
	}
	
	public String go(String direction)  {
		if  (direction.equalsIgnoreCase("north"))  {
			return this.n;
		}  else  if  (direction.equalsIgnoreCase("east"))  {
			return this.e;
		}  else  if  (direction.equalsIgnoreCase("west"))  {
			return this.w;
		}  else  if  (direction.equalsIgnoreCase("south"))  {
			return this.s;
		}  else  {
			System.out.println("Cannot recognize this direction. Check your spellings");
			return null;
		}
	}
	
	
	public Item pickup (String name)  {
		
		if (this.searched == true)  {
		/* returnItemAndDelete returns null if the item is not found */
		/* the same behavior is passed here */
		Item i = this.itemList.returnItemAndDelete(name);
		if  (i == null)  {
			
			/* if i is null, the room does not have this item */
			System.out.println("There is no such item in the room.");
			return null;
		}  else  {
			
			return i;
		}
		}  else  {
			
			/* if the player did not search the room first, don't return anything */
			System.out.println("You haven't searched the room yet.");
			return null;
		}
	}
	
	public abstract void lookaround();
	
	public abstract void search();
	
}