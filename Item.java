
public class Item {

	/**
	 * Examples of name: tomato, pistol, coke, etc.
	 * Examples of category: liquid(0), food(1),  medicine(2), tool(3), weapon(4).
	 * Examples of effect: 1, 10, 32, etc.
	 * The effect field indicates, for example, 
	 * how many points of hunger do we decrease
	 * if the player consumes this item. 
	 */
	private String name;
	private int category;
	private int effect;
	
	/* constructor */
	
	public Item(String name, int category, int effect)  {
		this.name = name;
		this.category = category;
		this.effect = effect;
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
	
}
