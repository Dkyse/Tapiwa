
public class Livingroom extends Room {



	public Livingroom(String name, String e, String s, String w, String n, itemInventory itemList) {
		super(name, e, s, w, n, itemList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lookaround() {
		
		System.out.println("This room looks like a living room.");
		System.out.println("You use to sing songs in your living room.");
		System.out.println("You wish to sing now, but you shouldn't.");
		System.out.println("There are predators here.");
		System.out.println("WATCH OUT");
		
	}
	
	public void search()  {
		this.searched = true;
		System.out.println("You searched the room, and found:");
		this.itemList.print();
	}

}
