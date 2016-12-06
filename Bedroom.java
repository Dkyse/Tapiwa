
public class Bedroom extends Room {



	public Bedroom(String name, String n, String e, String w, String s, itemInventory itemList) {
		super(name, n, e, w, s, itemList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lookaround() {
		
		System.out.println("This room looks like a bedroom.");
		System.out.println("It has a bed, a locked window, and a huge closet.");
	}
	
	public void search()  {
		this.searched = true;
		System.out.println("You searched the closet, and found:");
		this.itemList.print();
	}

}
