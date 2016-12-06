
public class Bathroom extends Room {



	public Bathroom(String name, String n, String e, String w, String s, itemInventory itemList) {
		super(name, n, e, w, s, itemList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lookaround() {
		
		System.out.println("This room looks like a bathroom.");
		System.out.println("It has a broken toilet, a locked window, and a tub.");
	}
	
	public void search()  {
		this.searched = true;
		System.out.println("You searched the toilet and the tub, and found:");
		this.itemList.print();
	}

}
