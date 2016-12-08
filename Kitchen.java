
public class Kitchen extends Room {



	public Kitchen(String name, String e, String s, String w, String n, itemInventory itemList) {
		super(name, e, s, w, n, itemList);
		this.human = 100;
		}

	@Override
	public void lookaround() {
		
		System.out.println("This room looks like a kitchen.");
		System.out.println("There is a dead cat in the microwave, scorched.");
		System.out.println("\"Lucky him, \"" + "you think to yourself, "
				+ "\"he does not have to go through what you are going through.\"");
		
	}
	
	public void search()  {
		this.searched = true;
		System.out.println("You searched the room, and found:");
		this.itemList.print();
		
		if  (this.human >= 0)  {
			System.out.println("A girl is sitting by the dinner table");
			System.out.println("\"I microwaved a cat\", she says, \"sorry, I was so hungry.\"");
		}
	}

}
