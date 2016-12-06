

//each room contains four other rooms that are n, s, e, w.
//each room contains an object list.

//method: 
//look around


public abstract class Room {

	protected String name;
	protected String n;
	protected String e;
	protected String w;
	protected String s;
	protected itemInventory itemList;
	protected boolean searched;

	public Room(String name, String e, String s, String w,  String n, itemInventory itemList)  {
		this.name = name;
		this.n = n;
		this.e = e;
		this.w = w;
		this.s = s;
		this.itemList = itemList;
		this.searched = false;
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
	
//	
//	/* this method returns the room at the corresponding direction */
//	public Room go(String direction)  {
//
//		/* check input */
//		if (direction.equalsIgnoreCase("north")  ||  
//				direction.equalsIgnoreCase("west")  ||
//				direction.equalsIgnoreCase("east")  ||
//				direction.equalsIgnoreCase("south"))  {
//
//			/* if input is valid, assign value */
//			Room ret = null;
//			switch (direction) {
//			case "north":  ret = this.n;
//			break;
//			case "east":  ret = this.e;
//			break;
//			case "south":  ret = this.s;
//			break;
//			case "west":  ret = this.w;
//			break;
//			default: ret = null;
//			break;
//			}
//
//			/* if the new assigned room is null, it means we have no doors at that direction */
//			if  (ret.equals(null))  {
//				System.out.println("You cannot go this direction. There is a wall");
//				return this;
//			}  else  {
//				
//				/* otherwise, enter the new room */
//				System.out.println("You have entered a " + ret.getName());
//				return ret;
//			}
//			
//			/* if the input is invalid */
//		}  else  {
//			System.out.println("Cannot recognize direction. Please check spelling");
//			return this;
//		}
//	}  /* end of go function */
	
	public Item pickup (String name)  {
		
		if (this.searched == true)  {
		/* returnItemAndDelete returns null if the item is not found */
		/* the same behavior is passed here */
		Item i = this.itemList.returnItemAndDelete(name);
		if  (i.equals(null))  {
			
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
