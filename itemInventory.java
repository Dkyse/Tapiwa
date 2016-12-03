import java.util.*;

public class itemInventory {

	/* this inventory contains items */

	/* This field is a list of maps.
	 * Each map corresponds to a list of items in the same category.
	 * the first map is a liquid map.
	 * the second is a food map.
	 * medicine map.
	 * tool map.
	 * weapon map.
	 */

	/* this array has only 5 elements */
	private ArrayList<Map<Item, Integer>>  categoryList;

	/* this number may not exceed 10 */
	private int numberOfItems;


	/* constructor #1 */
	public itemInventory()  {
		this.categoryList = new ArrayList<Map<Item, Integer>>();

		/* initialize the array with five maps */
		for (int i = 0; i < 5; i++)  {
			this.categoryList.add(new HashMap<Item, Integer>());
		}

		this.numberOfItems = 0;
	}


	/* constructor #2 */
	public itemInventory(Item item)  {
		this.categoryList = new ArrayList<Map<Item, Integer>>();

		/* initialize the array with five maps */
		for (int i = 0; i < 5; i++)  {
			this.categoryList.add(new HashMap<Item, Integer>());
		}

		/* put the item to the corresponding position */
		this.categoryList.get(item.getCategory()).put(item, (Integer)1);

		this.numberOfItems = 1;
	}


	public boolean isFull()  {
		return this.numberOfItems <= 10;
	}


	/* this method add an item to the inventory */
	public void add(Item item)  {

		/* if the inventory is not full */
		if (!this.isFull())  {
			
			/* increase number of items */
			this.numberOfItems++;

			/* stores the category of the item in cate */
			int cate = item.getCategory();

			/* get the map that the item belongs to */
			Map<Item, Integer> m = this.categoryList.get(cate);

			/* check to see if the item already exists in the map */
			if  (m.containsKey(item))  {

				/* if the item is not new, add the quantity of the item in the map */
				m.put(item, m.get(item) + 1);

			}  else  {

				/* if the item is new, add the item */
				m.put(item, 1);
			}
		}
	}


	/**
	 * Checks if the inventory contains an item. 
	 * @param item
	 * @return
	 */
	public boolean contains(Item item)  {
		/* stores the category of the item in cate */
		int cate = item.getCategory();

		/* checks corresponding map */
		return this.categoryList.get(cate).containsKey(item);
	}


	/**
	 * This method removes the item off the inventory.
	 * @param item
	 */
	public void removes(Item item)  {
		/* only remove the item if the inventory contains it */
		if (this.contains(item))  {

			/* stores the category of the item in cate */
			int cate = item.getCategory();
			
			/* decrease number of items */
			this.numberOfItems = 
					this.numberOfItems - this.categoryList.get(cate).get(item);

			/* remove the item from corresponding map */
			this.categoryList.get(cate).remove(item);
		}
	}


	/**
	 * This method consumes one item off the inventory.
	 * The quantity of the item decreses by 1.
	 * @param item
	 */
	public void consumes(Item item)  {
		/* only remove the item if the inventory contains it */
		if (this.contains(item))  {

			/* stores the category of the item in cate */
			int cate = item.getCategory();

			/* get the map that contains the item */
			Map<Item, Integer> m = this.categoryList.get(cate);

			/* reduce the quantity of the item in the map */
			m.put(item, m.get(item) - 1);
			
			/* decrement total number of items */
			this.numberOfItems = 
					this.numberOfItems - 1;

			/* after reducing the quantity, check to see if the quantity is 0 */
			if (m.get(item) == 0)  {
				this.removes(item);
			}
		}
	}


	/**
	 * This method takes a map and its category.
	 * It prints the map to the console.
	 * @param m
	 * @param category
	 */
	public void print(Map<Item, Integer> m, int category)  {

		/* check valid category */
		if  (category < 0 || category > 4)  {
			throw new IllegalArgumentException("The input category is not valid");
		}

		/* check if the map is empty. If yes, no need to print anything */
		if  (m.size() != 0)  {

			/* stores the category name in a string */
			String cate = "";
			if (category == 0)  {
				cate = "Liquid";
			}
			if (category == 1)  {
				cate = "Food";
			}
			if (category == 2)  {
				cate = "Medicine";
			}
			if (category == 3)  {
				cate = "Tool";
			}
			if (category == 4)  {
				cate = "Weapon";
			}  /* finish storing category name */

			/* start printing the map */
			System.out.println(cate + ":");

			/* traverse the map */
			Iterator<Map.Entry<Item, Integer>> itor = m.entrySet().iterator();
			while (itor.hasNext()) {
				Map.Entry<Item, Integer> pair = (Map.Entry<Item, Integer>)itor.next();
				System.out.println(pair.getKey().getName() + "---" + pair.getValue());
			}

			/* finish printing the map */
		}
	}


	/**
	 * The following method prints the whole category.
	 */
	public void print()  {
		for (int i = 0; i < this.categoryList.size(); i++)  {
			this.print(this.categoryList.get(i), i);
		}
	}


	//	public static void main(String[] args)  {
	//		Item i1 = new Item("pistol", 4, 64);
	//		Item i2 = new Item("pills", 2, 13);
	//		Item i3 = new Item("tomatos", 1, 7);
	//		Item i4 = new Item("keys", 3, -1);
	//		itemInventory inv = new itemInventory();
	//		inv.add(i1);
	//		inv.add(i2);
	//		inv.add(i2);
	//		inv.add(i2);
	//		inv.add(i2);
	//		inv.add(i3);
	//		inv.add(i3);
	//		inv.add(i3);
	//		inv.consumes(i4);
	//		inv.consumes(i2);
	//		inv.print();
	//	}

}
