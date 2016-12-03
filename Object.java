
public class Object {

	/* this class represents the objects in the room that we can interact with */
	/* for example: closet, fridge, door, window, etc. */
	private String name;
	private boolean isOpen;
	private boolean couldContainPlayer;
	private boolean hasNoPlayer;
	/* if this object contains a player, record playerName */
	private String playerName;
	private itemInventory inv;
	
	
	/* constructor */
	public Object(String name, 
			boolean isOpen, 
			boolean couldContainPlayer, 
			boolean hasNoPlayer, 
			String playerName,
			itemInventory inv)  {
		this.name = name;
		this.isOpen = isOpen;
		this.couldContainPlayer = couldContainPlayer;
		this.hasNoPlayer = hasNoPlayer;
		this.inv = inv;
	}
	
	
	public boolean isOpen()  {
		return this.isOpen;
	}
	
	
	public boolean couldContainPlayer()  {
		return this.couldContainPlayer;
	}
	
	
	public boolean hasNoPlayer()  {
		return this.hasNoPlayer;
	}
	
	
	public void close()  {
		this.isOpen = false;
	}
	
	
	public void open()  {
		this.isOpen = true;
	}
	
	
	public boolean canShelter()  {
		return this.couldContainPlayer && this.hasNoPlayer;
	}
	
	
	public void shelterIn()  {
		
		/* check if this object is ready to shelter */
		if  (this.canShelter())  {
			this.hasNoPlayer = false;
		}
	}
	
	
	public boolean contains(Item item)  {
		return this.inv.contains(item);
	}
	
	
	/**
	 * takes an item from the object
	 * @param item
	 */
	public void pickItem(Item item)  {
		if (this.contains(item))  {
			this.inv.consumes(item);
		}
	}
	
	
	/**
	 * put an item to the closet
	 * @param item
	 */
	public void putItem(Item item)  {
		this.inv.add(item);
	}
	
}
