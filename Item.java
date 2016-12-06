public class Item {

	/**
	 * Examples of name: tomato, apple.
	 * Examples of category: liquid(0), food(1),  medicine(2), tool(3), weapon(4).
	 * Examples of effect: 1, 10, 32, etc.
	 * The effect field indicates, for example, 
	 * how many points of hunger do we decrease
	 * if the player consumes this item. 
	 */
	protected String name;
	protected int category;
	protected int effect;

	/* constructor */

	public Item(String name, int category, int effect)  {
		this.name = name;
		this.category = category;
		this.effect = effect;
	}

	/* takes an input string, and checks if the string is the item's name */
	public boolean isItem(String name)  {
		return this.name.equalsIgnoreCase(name);
	}

	public String getName()  {
		return this.name;
	}

	public int getCategory()  {
		return this.category;
	}

	public int getEffect()  {
		return this.effect;
	}

	/* when the user input "look at <item name>", invoke this function
	* if this function is confusing to you, take a look at the "returnItemDontDelete()" 
	 * function in the itemInventory.java
	 */
	public static void lookat(Item item)  {

		/* if the input is null */
		if  (item.equals(null))  {
			System.out.println("There is no such item in your bag, you cannot look at it.");
		}  else  {

			if (item.category == 0)  {
				System.out.println("This is just an ordinay " + item.name);
				System.out.println("You can try drink it.");
			}  else  if  (item.category == 1)  {
				System.out.println("This is just an ordinay " +item.name);
				System.out.println("You can try eat it.");
			}  else  if  (item.category == 2)  {
				System.out.println("This is just an ordinay " + item.name);
				System.out.println("You can try eat it.");
				System.out.println("It might heal you.");
			}  else  if  (item.category == 3)  {
				System.out.println("This is just an ordinay " + item.name);
				System.out.println("You can save it for later.");
			}  else  if  (item.category == 4)  {
				System.out.println("This is just an ordinay " + item.name);
				System.out.println("It might be able to protect you.");
			}
		}
	}
}