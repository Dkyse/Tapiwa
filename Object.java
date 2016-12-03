
public class Object {

	/* this class represents the objects in the room that we can interact with */
	/* for example: closet, fridge, door, window, etc. */
	private String name;
	private boolean isOpen;
	private boolean couldContainPlayer;
	private boolean hasPlayer;
	private itemInventory inv;
	
	/* constructor */
	public Object(String name, boolean isOpen, 
			boolean couldContainPlayer, boolean doesContainPlayer,
			itemInventory inv)  {
		this.name = name;
		this.isOpen = isOpen;
		this.couldContainPlayer = couldContainPlayer;
		this.hasPlayer = doesContainPlayer;
		this.inv = inv;
	}
	
	public boolean isOpen()  {
		return this.isOpen;
	}
	
	public boolean couldContainPlayer()  {
		return this.couldContainPlayer;
	}
	
	public boolean doesContainPlayer()  {
		return this.hasPlayer;
	}
	
	public void close()  {
		this.isOpen = false;
	}
	
	public void open()  {
		this.isOpen = true;
	}
	
	public void canShelter()  {
		//return 
	}
	
}
